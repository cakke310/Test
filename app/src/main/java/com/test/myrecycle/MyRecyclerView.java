package com.test.myrecycle;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.OnScrollListener;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by hank on 2016/7/3.
 */
public class MyRecyclerView extends RecyclerView  {
    public MyRecyclerView(Context context, AttributeSet attrs) {
        super(context,attrs);
        this.addOnScrollListener(new OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
            }

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                View newView = getChildAt(0);
                if(mItemScrollChangeListener!=null){
                    if(newView!=null&& newView!= mCurrentView){
                        mCurrentView = newView;
                        mItemScrollChangeListener.onChange(mCurrentView,getChildPosition(mCurrentView));
                    }
                }
            }
        });
    }




    private View mCurrentView;

    public interface OnItemScrollChangeListener{
        void onChange(View view, int position);
    }

    private OnItemScrollChangeListener mItemScrollChangeListener;

    public void setOnItemScrollChangeListener(OnItemScrollChangeListener mItemScrollChangeListener){
        this.mItemScrollChangeListener = mItemScrollChangeListener;
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        super.onLayout(changed, l, t, r, b);
        mCurrentView = getChildAt(0);
        if(mItemScrollChangeListener!=null){
            mItemScrollChangeListener.onChange(mCurrentView,getChildPosition(mCurrentView));
        }
    }



    @Override
    public void onScrolled(int dx, int dy) {
        View newView = getChildAt(0);
        if(mItemScrollChangeListener!=null){
            if(newView!=null&& newView!= mCurrentView){
                mCurrentView = newView;
                mItemScrollChangeListener.onChange(mCurrentView,getChildPosition(mCurrentView));
            }
        }
    }
}
