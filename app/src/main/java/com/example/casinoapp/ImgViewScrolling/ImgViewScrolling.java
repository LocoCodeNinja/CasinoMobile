package com.example.casinoapp.ImgViewScrolling;

import android.animation.Animator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import android.widget.ImageView;

import androidx.annotation.Nullable;

import com.example.casinoapp.R;

public class ImgViewScrolling extends FrameLayout {

    private static int ANIMATION_DURATION = 150;
    ImageView current_img, next_img;
    int last_result = 0, old_value = 0;

    IEventEnd eventEnd;

    public void setEventEnd(IEventEnd eventEnd) {
        this.eventEnd = eventEnd;
    }

    public ImgViewScrolling(Context context) {
        super(context);
        init(context);
    }

    public ImgViewScrolling(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(R.layout.img_view_scrolling,this);
        current_img = getRootView().findViewById(R.id.current_img);
        next_img = getRootView().findViewById(R.id.next_img);

        next_img.setTranslationY(getHeight());
    }

    public void setRandomValue(int image, int rotate_count){
        current_img.animate().translationY(-getHeight()).setDuration(ANIMATION_DURATION).start();
        next_img.setTranslationY(next_img.getHeight());
        next_img.animate().translationY(0).setDuration(ANIMATION_DURATION).setListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animator) {

            }

            @Override
            public void onAnimationEnd(Animator animator) {
                setImage(current_img, old_value%6);
                current_img.setTranslationY(0);
                if (old_value != rotate_count){

                    setRandomValue(image, rotate_count);
                    old_value++;
                }
                else{
                    last_result = 0;
                    old_value = 0;
                    setImage(next_img, image);
                    eventEnd.eventEnd(image%6, rotate_count);
                }
            }

            @Override
            public void onAnimationCancel(Animator animator) {

            }

            @Override
            public void onAnimationRepeat(Animator animator) {

            }
        });
    }

    private void setImage(ImageView view, int value) {
        if (value == Util.BAR){
            view.setImageResource(R.drawable.bar_done);
        }
        if (value == Util.SEVEN){
            view.setImageResource(R.drawable.seven_done);
        }
        if (value == Util.ORANGE){
            view.setImageResource(R.drawable.orange_done);
        }
        if (value == Util.LEMON){
            view.setImageResource(R.drawable.lemon_done);
        }
        if (value == Util.TRIPLE){
            view.setImageResource(R.drawable.triple_done);
        }
        if (value == Util.GRAPE){
            view.setImageResource(R.drawable.grape_done);
        }

        view.setTag(value);
        last_result = value;
    }

    public int getValue(){
        return Integer.parseInt(next_img.getTag().toString());
    }
}
