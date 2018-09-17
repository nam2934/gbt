package com.example.namjin_jeong.gbt;

import android.content.Context;
import android.view.Gravity;
import android.view.ViewGroup;
import android.widget.TextView;

public class PostTextView extends android.support.v7.widget.AppCompatTextView {
    private Context context;


    public PostTextView(Context context){
        super(context);
        this.setBackgroundResource(R.drawable.round_textview);
        this.setGravity(Gravity.CENTER);
        this.setPadding(8,8,8,8);
        this.context = context;
    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        ViewGroup.MarginLayoutParams margins = ViewGroup.MarginLayoutParams.class.cast(getLayoutParams());
        int margin = 16;
        margins.topMargin = margin;
        margins.bottomMargin = margin;
        setLayoutParams(margins);
    };


}
