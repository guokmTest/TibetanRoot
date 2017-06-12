package com.guokm.tibetanroot.cviews;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Build;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by Administrator on 2017/6/9.
 */

/**
 * 首先重写所有的构造方法，在其中加入init初始化
 */
public class Zidingyifirst extends View {
    private Paint mCirclePaint;//画笔
    private int mCircleRadius=50;//半径
    public Zidingyifirst(Context context) {
        super(context);
        init();
    }

    public Zidingyifirst(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public Zidingyifirst(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public Zidingyifirst(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init();
    }
    private void init(){
        //初始化画笔
        //新建一支画笔，并且初始化之
        Paint mPaint=new Paint(Paint.ANTI_ALIAS_FLAG);
        mPaint.setAntiAlias(true);//抗锯齿
        mPaint.setDither(true);//防抖动
        mPaint.setStyle(Paint.Style.FILL);//设置填充方式，实心矩阵
        mPaint.setColor(Color.BLUE);//画笔颜色
        mCirclePaint=mPaint;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        float cx=getWidth()>>1;//类似于getWidth/2...酱紫写更加洋气
        float cy=getHeight()>>1;
        float[] xy={cx,cy};
        canvas.drawCircle(xy[0], xy[1], mCircleRadius, mCirclePaint);//画圆方法，出入坐标X,Y，半径，画笔
        canvas.drawLine(0,0,getWidth(),getHeight(),mCirclePaint);//画直线
        canvas.drawLine(0,getHeight(),getWidth(),0,mCirclePaint);//画直线,最左上角是（0,0），右上角（0，getWidth()）,左下角(0,getHeight())，右下角(getWidth,getHeight)
    }
}
