package com.gsd.animatorpath;

/**
 * Created by GSD on 2017/2/6.
 * QQ:461842166
 * GitHub:Shengdi-Gu
 */

public class PathPoint {
    public static final int MOVE = 0;
    public static final int LINE = 1;
    public static final int CURVE = 2;
    public static final int CIRCLE = 3;
    public static final int RECTANGLE = 4;
    int mOperation;
    float mX, mY;
    float X1, Y1;
    float X2, Y2;


    private PathPoint(int operation, float x, float y) {
        mOperation = operation;
        mX = x;
        mY = y;
    }

    private PathPoint(int operation, float X1, float Y1, float X2, float Y2, float eX, float eY) {
        mOperation = operation;
        this.mX = eX;
        this.mY = eY;
        this.X1 = X1;
        this.Y1 = Y1;
        this.X2 = X2;
        this.Y2 = Y2;
    }

    public static PathPoint moveTo(float x, float y) {
        return new PathPoint(MOVE, x, y);
    }

    public static PathPoint lineTo(float x, float y) {
        return new PathPoint(LINE, x, y);
    }

    public static PathPoint curveTo(float X1, float Y1, float X2, float Y2, float eX, float eY) {
        return new PathPoint(CURVE, X1, Y1, X2, Y2, eX, eY);
    }

}
