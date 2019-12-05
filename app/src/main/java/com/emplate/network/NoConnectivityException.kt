package com.emplate.network

import android.content.Context
import com.emplate.R
import java.io.IOException


class NoConnectivityException(val mContext: Context) : IOException() {
    override val message: String?
        get() = mContext.getString(R.string.no_internet_connection)
}