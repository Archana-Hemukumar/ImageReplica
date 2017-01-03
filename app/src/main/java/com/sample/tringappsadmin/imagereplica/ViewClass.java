package com.sample.tringappsadmin.imagereplica;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.text.InputType;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;



/**
 * Created by tringappsadmin on 15/12/16.
 */

public class ViewClass extends LinearLayout {


    int icon = -1;
    String hint = null;
    int inputType;


    public ViewClass(Context context) {
        super(context);
        init();
    }

    public ViewClass(Context context, AttributeSet attrs) {
        super(context, attrs);
     TypedArray a = getContext().obtainStyledAttributes(attrs,R.styleable.ViewClass,0,0);
        try {

            hint = a.getString(R.styleable.ViewClass_userhint);
            icon = a.getResourceId(R.styleable.ViewClass_icon,R.drawable.image_replica_usericon);

            inputType = a.getInt(R.styleable.ViewClass_android_inputType, EditorInfo.TYPE_NULL);
        }
        finally {
        }
       init();

    }



    public ViewClass(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();

    }

    private void init() {
        LayoutInflater.from(getContext()).inflate(R.layout.custom_edittext,this);

    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        EditText userEditText = (EditText) findViewById(R.id.et1);
        ImageView imageView = (ImageView) findViewById(R.id.iconid);

        if((icon != -1)&&(hint != null) ) {
            userEditText.setHint(hint);
            imageView.setImageResource(icon);

            if (inputType != EditorInfo.TYPE_NULL){
                userEditText.setInputType(inputType);

            }

        }
    }

}
