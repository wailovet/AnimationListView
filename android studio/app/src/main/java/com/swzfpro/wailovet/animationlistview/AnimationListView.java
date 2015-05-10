package com.swzfpro.wailovet.animationlistview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.AbsListView;
import android.widget.ListView;

/**
 * Created by wailovet on 15/4/11.
 */
public class AnimationListView extends ListView {
    private AnimationListView mThis = this;
    public AnimationListView(Context context) {
        super(context);
        init();
    }

    public AnimationListView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public AnimationListView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);


    }



    private long mDurationMillis=500;
    public void setDuration(long durationMillis){
        mDurationMillis = durationMillis;
    }


    private AnimationType mAnimationType = AnimationType.BOTTOMTOTOP;

    public void setAnimationType(AnimationType mAnimationType) {
        this.mAnimationType = mAnimationType;
    }

    enum AnimationType{

        FADEIN,

        LEFTTORIGHT,

        BOTTOMTOTOP
    }
    private void init() {

        post(new Runnable() {

            @Override
            public void run() {

                setOnScrollListener(new OnScrollListener() {

                    @Override
                    public void onScrollStateChanged(AbsListView view, int scrollState) {
                    }

                    private int maxVisibleItem = 0;

                    @Override
                    public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {

                        if (maxVisibleItem >= firstVisibleItem + visibleItemCount - 1) {
                            return;
                        }
                        maxVisibleItem = firstVisibleItem + visibleItemCount - 1;
                        try {

                            View v = mThis.getChildAt(visibleItemCount - 1);

                            Animation animation;
                            switch (mAnimationType){
                                case FADEIN:
                                    animation = new AlphaAnimation(0, 1);
                                    break;
                                case LEFTTORIGHT:
                                    animation = new TranslateAnimation(-mThis.getWidth(), 0, 0, 0);
                                    break;
                                default:
                                    animation = new TranslateAnimation(0, 0, v.getHeight(), 0);
                                    break;
                            }

                            animation.setDuration(mDurationMillis);//设置动画持续时间

                            v.setAnimation(animation);

                        } catch (Exception e) {

                        }
                    }
                });
            }
        });


    }
}
