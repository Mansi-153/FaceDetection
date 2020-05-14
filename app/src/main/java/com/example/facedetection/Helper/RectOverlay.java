package com.example.facedetection.Helper;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;

public class RectOverlay extends GraphicOverlay.Graphic {
    private int mRectColor = Color.GREEN;
    private float strokeWidth = Float.parseFloat("4");
    private Paint mRectPaint;
    private GraphicOverlay graphicOverlay;
    private Rect rect;
    public RectOverlay(GraphicOverlay overlay, Rect rect) {
        super(overlay);
        mRectPaint = new Paint();
        mRectPaint.setColor(mRectColor);
        mRectPaint.setStyle(Paint.Style.STROKE);
        mRectPaint.setStrokeWidth(strokeWidth);

        this.graphicOverlay = overlay;
        this.rect=rect;

        postInvalidate();
    }

    @Override
    public void draw(Canvas canvas) {
        RectF rectF = new RectF(rect);
        rectF.left = translateX(rectF.left);
        rectF.right = translateX(rectF.right);
        rectF.bottom = translateX(rectF.bottom);
        rectF.top = translateX(rectF.top);

        canvas.drawRect(rectF , mRectPaint);

    }
}
