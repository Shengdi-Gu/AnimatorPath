package com.gsd.animatorpath;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.view.View;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by GSD on 2017/2/6.
 * QQ:461842166
 * GitHub:Shengdi-Gu
 */

public class AnimatorPath {
    private List<PathPoint> mPoints = new ArrayList<>();
    private View mView;
    private ObjectAnimator animator;

    public void moveTo(float x, float y) {
        mPoints.add(PathPoint.moveTo(x, y));
    }

    public void lineTo(float x, float y) {
        mPoints.add(PathPoint.lineTo(x, y));
    }

    public void curveTo(float X1, float Y1, float X2, float Y2, float eX, float eY) {
        mPoints.add(PathPoint.curveTo(X1, Y1, X2, Y2, eX, eY));
    }

    public Collection<PathPoint> getPoints() {
        return mPoints;
    }

    public AnimatorPath(View mView) {
        this.mView = mView;
    }

    public void setFraction(PathPoint pathPoint) {
        mView.setTranslationX(pathPoint.mX);
        mView.setTranslationY(pathPoint.mY);
    }

    public Animator getAnimator() {
        if (mPoints.size() < 2) {
            mPoints.add( PathPoint.moveTo(0, 0));
        }
        animator = ObjectAnimator.ofObject(this, "fraction", new PathEvaluator(), mPoints.toArray());
        return animator;
    }
}
