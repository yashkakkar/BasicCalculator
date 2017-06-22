package com.yashkakkar.calculator;

import android.content.Context;
import android.graphics.Typeface;

import java.lang.reflect.Field;

/**
 * Created by Yash Kakkar on 07-12-2016.
 */

public class ReplaceFont {
    public static void replaceDefaultFont(Context context, String  nameOfFontBeingReplaced, String nameOfTheFontInAssets){
        Typeface customFontTypeface = Typeface.createFromAsset(context.getAssets(), nameOfTheFontInAssets);
        replaceFont(nameOfFontBeingReplaced,customFontTypeface);
    }
    public static void replaceFont(String nameOfFontBeingReplaced, Typeface customFontTypeFace){
        try {
            Field myField = Typeface.class.getDeclaredField(nameOfFontBeingReplaced);
            myField.setAccessible(true);
            myField.set(null,customFontTypeFace);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
    }
}
