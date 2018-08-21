package com.example.admin.myimageloader;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;

import android.support.v4.view.ViewPager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;


/**
 * Created by 黄伟杰 on 2018/8/20.
 */
public class MyItemDecoration extends RecyclerView.ItemDecoration {

    private Paint mPaint;

    private Paint mOverPaint;

    public MyItemDecoration() {
        mPaint = new Paint();
        mPaint.setColor(Color.BLUE);
        mPaint.setAntiAlias(true);

        mOverPaint = new Paint();
        mOverPaint.setColor(Color.YELLOW);
        mOverPaint.setAntiAlias(true);
        mOverPaint.setAlpha(100);
    }

    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        outRect.set(0, 0, 0, 1);
    }

    @Override
    public void onDrawOver(Canvas c, RecyclerView parent, RecyclerView.State state) {
        ViewGroup view = (ViewGroup) parent.getLayoutManager().findViewByPosition(0);
        if (view == null) {
            return;
        }


        final int left = (int) view.getX();
        final int right = left + view.getWidth();
        final int top = (int) view.getY();
        final int bottom = top + view.getHeight();

        c.drawRect(left, top, right, bottom, mOverPaint);
    }

    @Override
    public void onDraw(Canvas c, RecyclerView parent, RecyclerView.State state) {

        int childCount = parent.getChildCount();

        final int left = parent.getPaddingLeft();
        final int right = parent.getWidth() - parent.getPaddingRight();

        for (int i = 0; i < childCount; i++) {
            //让最后一个item没有底部分割线。
            if (i == childCount - 1) {
                break;
            }
            View view = parent.getChildAt(i);
            final RecyclerView.LayoutParams params = (RecyclerView.LayoutParams) view.getLayoutParams();
            final int top = view.getBottom() + params.bottomMargin + Math.round(view.getTranslationY());
            final int bottom = top + 1;
            c.drawRect(left, top, right, bottom, mPaint);
        }
    }
}
