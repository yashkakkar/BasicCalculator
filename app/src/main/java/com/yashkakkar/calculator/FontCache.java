package com.yashkakkar.calculator;

import android.content.Context;
import android.graphics.Typeface;

import java.util.HashMap;

/**
 * Created by Yash Kakkar on 07-12-2016.
 */

public class FontCache {

    private static HashMap<String, Typeface> fontCache = new HashMap<>();

    public static Typeface getTypeface(Context context, String fontname) {
        Typeface typeface = fontCache.get(fontname);
        if (typeface == null) {
            try {
                typeface = Typeface.createFromAsset(context.getAssets(), fontname);
            } catch (Exception e) {
                return null;
            }

            fontCache.put(fontname, typeface);
        }
        return typeface;
    }
}
