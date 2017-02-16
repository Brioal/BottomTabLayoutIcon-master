package com.brioal.bottomtab;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RadioGroup;

import java.util.List;


public class BottomTabLayout extends LinearLayout {
    private List<TabEntity> mList;
    private OnTabSelectedListener mListener;
    private int mTextColorNormal = Color.BLACK;
    private int mTextColorSelected = Color.GREEN;


    public BottomTabLayout(Context context) {
        this(context, null);
    }

    public BottomTabLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }


    public void setListener(OnTabSelectedListener listener) {
        mListener = listener;
    }

    public void setTextColorNormal(int textColorNormal) {
        mTextColorNormal = textColorNormal;
    }

    public void setTextColorSelected(int textColorSelected) {
        mTextColorSelected = textColorSelected;
    }

    public void init() {
        setOrientation(HORIZONTAL);
        setPadding(5, 5, 5, 0);
    }

    public void setList(List<TabEntity> list) {
        mList = list;
        for (int i = 0; i < mList.size(); i++) {
            final BottomTab tab = new BottomTab(getContext());
            final TabEntity entity = mList.get(i);
            tab.setColorNormal(mTextColorNormal);
            tab.setColorSelect(mTextColorSelected);
            tab.setDrawableNormal(getContext().getResources().getDrawable(entity.getIconNormal()));
            tab.setDrawableSelected(getContext().getResources().getDrawable(entity.getIconSelected()));
            tab.setText(entity.getTitle());
            tab.setId(Integer.valueOf(i));
            tab.setLayoutParams(new RadioGroup.LayoutParams(RadioGroup.LayoutParams.WRAP_CONTENT, RadioGroup.LayoutParams.MATCH_PARENT, 1));
            tab.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (mListener != null) {
                        mListener.onSelected(v.getId());
                    }
                    for (int j = 0; j < getChildCount(); j++) {
                        if (getChildAt(j).getId() == v.getId()) {
                            getChildAt(j).setSelected(true);
                        } else {
                            getChildAt(j).setSelected(false);
                        }
                    }
                }
            });
            if (i == 0) {
                tab.setSelected(true);
            }
            addView(tab);
        }
    }
}
