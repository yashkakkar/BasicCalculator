package com.yashkakkar.calculator;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.TextView;

/**
 * Created by Yash Kakkar on 07-12-2016.
 */

public class CustomTextView extends TextView{

    public static final String ANDROID_SCHEMA = "http://schemas.android.com/apk/res/android";



    public CustomTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        applyCustomFont(context, attrs);
    }

    public CustomTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        applyCustomFont(context, attrs);
    }

    private void applyCustomFont(Context context, AttributeSet attrs) {
        int textStyle = attrs.getAttributeIntValue(ANDROID_SCHEMA, "textStyle", Typeface.NORMAL);

        Typeface customFont = selectTypeface(context, textStyle);
        setTypeface(customFont);
    }

    private Typeface selectTypeface(Context context, int textStyle) {
    /*
    * information about the TextView textStyle:
    * http://developer.android.com/reference/android/R.styleable.html#TextView_textStyle
    */
        switch (textStyle) {
            case Typeface.BOLD: // bold
                return FontCache.getTypeface(context, "Quicksand-Bold.ttf");

            case Typeface.ITALIC: // italic
                return FontCache.getTypeface(context, "Quicksand-Light.ttf");

            case Typeface.BOLD_ITALIC: // bold italic
                return FontCache.getTypeface(context, "Quicksand-Light.ttf");

            case Typeface.NORMAL: // regular
            default:
                return FontCache.getTypeface(context, "Quicksand-Regular.ttf");
        }
    }
}
