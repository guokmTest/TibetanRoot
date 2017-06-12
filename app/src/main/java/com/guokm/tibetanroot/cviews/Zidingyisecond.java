package com.guokm.tibetanroot.cviews;


import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Picture;
import android.os.Build;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by Administrator on 2017/6/10.
 */

public class Zidingyisecond extends View {
    Paint guokmPaint;

    public Zidingyisecond(Context context) {
        super(context);
        init();
    }

    public Zidingyisecond(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public Zidingyisecond(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public Zidingyisecond(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init();
    }

    /**
     * 初始化画笔
     */
    private void init() {
        Paint mPaint=new Paint(Paint.ANTI_ALIAS_FLAG);
        mPaint.setAntiAlias(true);
        mPaint.setDither(true);
        mPaint.setStyle(Paint.Style.FILL);
        mPaint.setColor(Color.BLACK);
        guokmPaint=mPaint;

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawText("aaa",getWidth()/2,getHeight()/2,guokmPaint);
    }
}
