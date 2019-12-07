package com.emplate.ui.posts;

import android.content.Context;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.LiveDataReactiveStreams;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;

import com.emplate.BuildConfig;
import com.emplate.R;
import com.emplate.model.Post;
import com.emplate.model.Resource;
import com.emplate.network.posts.PostsApi;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.inject.Inject;

import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;

public class PostsViewModel extends ViewModel {

    private final PostsApi mainApi;
    private final Context context;

    private Throwable throwable;

    private MediatorLiveData<Resource<List<Post>>> posts;

    @Inject
    public PostsViewModel(Context context, PostsApi mainApi) {
        this.mainApi = mainApi;
        this.context = context;
    }

    public LiveData<Resource<List<Post>>> observePosts() {
        if (posts == null) {
            posts = new MediatorLiveData<>();
            posts.setValue(Resource.loading((List<Post>) null));
            final LiveData<Resource<List<Post>>> source = LiveDataReactiveStreams.fromPublisher(
                    mainApi.getPosts(BuildConfig.POST_INCLUDE_QUERY)
                            .onErrorReturn(new Function<Throwable, List<Post>>() {
                                @Override
                                public List<Post> apply(Throwable throwable) {
                                    PostsViewModel.this.throwable = throwable;
                                    return new ArrayList<>();
                                }
                            })
                            .map(new Function<List<Post>, Resource<List<Post>>>() {
                                @Override
                                public Resource<List<Post>> apply(List<Post> posts) {
                                    if (posts.size() > 0) {
                                        return Resource.success(posts);
                                    } else {
                                        if (throwable != null)
                                            return Resource.error(Objects.requireNonNull(throwable.getMessage()),
                                                    null);
                                        else
                                            return Resource.error(context.getString(R.string.empty_posts),
                                                    null);
                                    }
                                }
                            })
                            .subscribeOn(Schedulers.io())
            );
            posts.addSource(source, new Observer<Resource<List<Post>>>() {
                @Override
                public void onChanged(Resource<List<Post>> listResource) {
                    posts.setValue(listResource);
                    posts.removeSource(source);
                }
            });
        }
        return posts;
    }

    @Override
    protected void onCleared() {
        posts = null;
        super.onCleared();
    }
}