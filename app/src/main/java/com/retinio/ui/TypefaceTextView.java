package com.retinio.ui;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.support.v4.util.LruCache;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.TextView;

import com.retinio.R;

/**
 * Created by naman on 30/06/15.
 */
public class TypefaceTextView extends TextView {

    private static LruCache<String, Typeface> sTypefaceCache =
            new LruCache<String, Typeface>(12);

    public TypefaceTextView(Context context, AttributeSet attrs) {
        super(context, attrs);

        TypedArray a = context.getTheme().obtainStyledAttributes(attrs,
                R.styleable.TypefaceTextView, 0, 0);

        try {
            String typefaceName = a.getString(
                    R.styleable.TypefaceTextView_typeface);

            if (!isInEditMode()) {
                Typeface typeface;
                if (!TextUtils.isEmpty(typefaceName)) {
                    typeface = sTypefaceCache.get(typefaceName);

                    if (typeface == null) {
                        typeface = Typeface.createFromAsset(context.getAssets(),
                                String.format("%s.otf", typefaceName));

                        sTypefaceCache.put(typefaceName, typeface);
                    }

                } else {
                    typeface = sTypefaceCache.get("Typo_Round_Regular_Demo");

                    if (typeface == null) {
                        typeface = Typeface.createFromAsset(context.getAssets(),
                                String.format("%s.otf", "Typo_Round_Regular_Demo"));

                        sTypefaceCache.put("Typo_Round_Regular_Demo", typeface);
                    }
                }

                setTypeface(typeface);

                setPaintFlags(getPaintFlags() | Paint.SUBPIXEL_TEXT_FLAG);
            }
        } finally {
            a.recycle();
        }
    }
}