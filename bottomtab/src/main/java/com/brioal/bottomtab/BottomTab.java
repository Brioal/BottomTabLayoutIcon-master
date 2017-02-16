package com.brioal.bottomtab;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.RadioButton;

/**
 * 按钮组件
 * Created by Brioal on 2016/8/18.
 */

public class BottomTab extends RadioButton {
    private int mHeight; // 按钮高度
    private int mIconHeight; //Icon高度
    private Drawable mDrawableNormal;
    private Drawable mDrawableSelected;
    private int mColorSelect; //选中颜色
    private int mColorNormal; //选中颜色
    private int mTextSize; //文字大小
    private String mText; //文字
    private Paint mPaint;

    private int mNews = 0;


    public BottomTab(Context context) {
        this(context, null);
    }

    public BottomTab(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }


    //设置文字大小
    public void setTextSize(int textSize) {
        mTextSize = (int) SizeUtil.Dp2Px(getContext(), textSize);
    }

    //设置未读消息
    public void setNews(int news) {
        this.mNews = news;
        invalidate();
    }


    public void setColorNormal(int colorNormal) {
        mColorNormal = colorNormal;
    }

    public void setColorSelect(int colorSelect) {
        mColorSelect = colorSelect;
    }

    public void setDrawableNormal(Drawable drawableNormal) {
        mDrawableNormal = drawableNormal;
    }

    public void setDrawableSelected(Drawable drawableSelected) {
        mDrawableSelected = drawableSelected;
    }

    //设置文字
    public void setText(String text) {
        this.mText = text;
    }


    private void init() {
        setBackgroundColor(Color.TRANSPARENT);
        mTextSize = (int) SizeUtil.Dp2Px(getContext(), 11);

        mColorSelect = getResources().getColor(R.color.selected);
        mColorNormal = getResources().getColor(R.color.normal);


        mText = "按钮";
        mDrawableNormal = getResources().getDrawable(R.drawable.ic_launcher);
        mDrawableSelected = getResources().getDrawable(R.drawable.ic_launcher);

        mPaint = new Paint();
        mPaint.setAntiAlias(true);
        mPaint.setDither(true);

    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int widthSize = MeasureSpec.getSize(widthMeasureSpec);
        int heightSize = MeasureSpec.getSize(heightMeasureSpec);
        mHeight = (int) Math.min(heightSize, SizeUtil.Dp2Px(getContext(), 50));
        setMeasuredDimension(widthSize, mHeight);
    }


    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        mIconHeight = mHeight * 3 / 6;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        //绘制Icon
        canvas.save();
        canvas.translate(getWidth() / 2, mIconHeight / 2);
        int r = mIconHeight / 2;
        Drawable drawable = null;
        if (isSelected()) {
            drawable = mDrawableSelected;
        } else {
            drawable = mDrawableNormal;
        }
        drawable.setBounds(-r, -r + 7, r, r + 7);
        drawable.draw(canvas);
        canvas.restore();
        canvas.save();
        //绘制未读消息
        if (mNews != 0) {
            canvas.translate(getWidth() / 2 + r, mIconHeight / 2 - 5);
            mPaint.setColor(Color.RED);
            canvas.drawCircle(0, 0, r * 2 / 3, mPaint);
            String text = mNews + "";
            mPaint.setTextSize(SizeUtil.Dp2Px(getContext(), 10));
            Rect bound = new Rect();
            mPaint.getTextBounds(text, 0, text.length(), bound);
            mPaint.setColor(Color.WHITE);
            canvas.drawText(text, -(bound.right - bound.left) / 2, -(bound.bottom + bound.top) / 2, mPaint);
        }
        canvas.restore();

        //绘制文字
        if (isSelected()) {
            mPaint.setColor(mColorSelect);
        } else {
            mPaint.setColor(mColorNormal);
        }

        mPaint.setTextSize(mTextSize);
        canvas.save();
        canvas.translate(getWidth() / 2, mIconHeight + (getHeight() - mIconHeight) / 2);
        Rect bound = new Rect();
        mPaint.getTextBounds(mText, 0, mText.length(), bound);
        canvas.drawText(mText, -(bound.right - bound.left) / 2, -(bound.bottom + bound.top) / 2, mPaint);
        canvas.restore();


    }
}
