package com.emplate.model.customViews

import android.content.Context
import android.graphics.Typeface
import android.util.AttributeSet

import android.widget.TextView

class SFUIRegularTextView : TextView {
    constructor(context: Context?, attrs: AttributeSet?, defStyle: Int) : super(
        context,
        attrs,
        defStyle
    ) {
        init()
    }

    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs) {
        init()
    }

    constructor(context: Context?) : super(context) {
        init()
    }

    private fun init() {
        if (!isInEditMode) {
            val tf = Typeface.createFromAsset(context.assets, "SFUIText-Regular.ttf")
            typeface = tf
        }
    }
}