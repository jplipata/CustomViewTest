package com.lipata.customviewtest20151104;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

/**
 * Created by jlipata on 10/15/15.
 *
 * MyView uses 3 params via the `initialize()` method, the x,y coordinates plus wind speed/direction
 * data.  The x,y coordinates are used for the center of the compass, and the `if` statement block
 * in `onDraw()` determines how to draw the compass's needle by checking for N,S,E,W characters in
 * the `direction` string.
 *
 */
public class MyView extends View {

    int mCenterX;
    int mCenterY;
    String mDirection;

    public MyView(Context context){
        super(context);
    }

    public MyView(Context context, AttributeSet attrs){
        super(context, attrs);
    }


    public MyView(Context context, AttributeSet attrs, int defaultStyle){
        super(context, attrs, defaultStyle);
    }

//    @Override
//    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
//        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
//
////        if (MeasureSpec.getMode(heightMeasureSpec) == MeasureSpec.EXACTLY)
////            mHeight = heightMeasureSpec;
//
//
//        setMeasuredDimension(mWidth, mHeight);
//    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        int compassFaceRadius = 100;
        int needleLengthOffset = 35;
        int needleLength = compassFaceRadius - needleLengthOffset;
        int boarder = 15;
        Paint paint = new Paint();
        paint.setFlags(Paint.ANTI_ALIAS_FLAG);

        // Draw boarder
        paint.setColor(Color.BLUE);
        canvas.drawCircle(mCenterX, mCenterY, compassFaceRadius+boarder, paint);

        // Draw inner compass face
        paint.setColor(Color.WHITE);
        canvas.drawCircle(mCenterX, mCenterY, compassFaceRadius, paint);

        // Draw Needle

        int xOffset = 0;
        int yOffset = 0;

        // Determine end-point of needle based on direction param
        if  (mDirection.contains("N")) {
            yOffset = -needleLength;
        }
        if (mDirection.contains("E")) {
            xOffset = needleLength;
        }
        if (mDirection.contains("S")) {
            yOffset = needleLength;
        }
        if (mDirection.contains("W")) {
            xOffset = -needleLength;
        }

        Log.v("Offset", Integer.toString(xOffset)+", "+Integer.toString(yOffset));

        paint.setColor(Color.BLACK);
        paint.setStrokeWidth(10);
        canvas.drawLine(mCenterX,mCenterY,mCenterX+xOffset,mCenterY+yOffset, paint);

    }

    // Question -- would it be better to get these data via the constructor?
    protected void initialize(int x, int y, String direction){
        mCenterX = x;
        mCenterY = y;
        mDirection = direction;
        Log.d("MyView", x + ", " + "y " + direction);
    }
}
