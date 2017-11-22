package com.example.caijinzhu.mobilesafeguard;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.TextView;

/**
 * Created by caijinzhu on 2017/11/22.
 */

public class MFocusTextView extends TextView {
    public MFocusTextView(Context context) {
        super(context);
    }

    public MFocusTextView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public MFocusTextView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    /** 默认获取焦点 */
    @Override
    public boolean isFocused() {
        return true;
    }
}

