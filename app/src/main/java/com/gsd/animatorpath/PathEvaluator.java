package com.gsd.animatorpath;

import android.animation.TypeEvaluator;

/**
 * Created by GSD on 2017/2/6.
 * QQ:461842166
 * GitHub:Shengdi-Gu
 */

public class PathEvaluator implements TypeEvaluator<PathPoint> {

    private float x;
    private float y;

    @Override
    public PathPoint evaluate(float fraction, PathPoint startValue, PathPoint endValue) {
        switch (endValue.mOperation) {
            case PathPoint.MOVE:
                x = endValue.mX;
                y = endValue.mY;
                break;
            case PathPoint.LINE:
                x = startValue.mX + (endValue.mX - startValue.mX) * fraction;
                y = startValue.mY + (endValue.mY - startValue.mY) * fraction;
                break;
            case PathPoint.CURVE:
                float t = 1 - fraction;
                x = t * t * t * startValue.mX + 3 * fraction * t * t * endValue.X1 + 3 * endValue.X2 * fraction * fraction * t + fraction * fraction * fraction * endValue.mX;
                y = t * t * t * startValue.mY + 3 * fraction * t * t * endValue.Y1 + 3 * endValue.Y2 * fraction * fraction * t + fraction * fraction * fraction * endValue.mY;
                break;
        }
        return PathPoint.moveTo(x, y);
    }
}
