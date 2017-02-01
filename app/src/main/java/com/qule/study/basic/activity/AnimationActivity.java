package com.qule.study.basic.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Switch;

import com.qule.study.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class AnimationActivity extends Activity {

    @BindView(R.id.image_cat)
    ImageView mImageCat;
    @BindView(R.id.button_translate)
    Button mButtonTranslate;
    @BindView(R.id.button_rotate)
    Button mButtonRotate;
    @BindView(R.id.button_alph)
    Button mButtonAlph;
    @BindView(R.id.button_scale)
    Button mButtonScale;
    @BindView(R.id.button_animation_set)
    Button mButtonAnimationSet;
    @BindView(R.id.switcher)
    Switch mSwitcher;
    @BindView(R.id.radio_interpolator)
    RadioGroup mRadioInterpolator;


//    Interpolator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animation);
        ButterKnife.bind(this);
//        mSwitcher.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
//            @Override
//            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
//                if (isChecked) {
//
//                }
//            }
//        });
//        mRadioInterpolator
        for (int i = 0; i < 5; i++) {
            RadioButton tempButton = new RadioButton(this);
            tempButton.setText("按钮 " + i);
            mRadioInterpolator.addView(tempButton, LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        }

    }

    //AlphaAnimation(float fromAlpha, float toAlpha)
    AlphaAnimation mAlphaAnimation = new AlphaAnimation(0.0F, 1.0F);
    //RotateAnimation(float fromDegrees, float toDegrees, int pivotXType, float pivotXValue,int pivotYType, float pivotYValue)
    RotateAnimation mRotateAnimation = new RotateAnimation(0.0f, +359.0f,
            Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);

    //ScaleAnimation(float fromX, float toX, float fromY, float toY, int pivotXType, float pivotXValue, int pivotYType, float pivotYValue)
    ScaleAnimation mScaleAnimation = new ScaleAnimation(0.0f, 1.4f, 0.0f, 1.4f,
            Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);

    //TranslateAnimation(float fromXDelta, float toXDelta, float fromYDelta, float toYDelta)
    TranslateAnimation mTranslateAnimation = new TranslateAnimation(30.0f, 100.0f, 30.0f, 200.0f);


    @OnClick({R.id.button_alph, R.id.button_rotate, R.id.button_scale, R.id.button_translate, R.id.button_animation_set})
    public void onClick(View view) {
        int viewId = view.getId();


//        Animation animation = mImageCat.getAnimation();
//        if (animation != null) {
//            animation.cancel();
//            animation = null;
//        }
        Animation animation = null;
        if (mSwitcher.isChecked()) {
            //XML
            switch (viewId) {
                case R.id.button_alph:
                    animation = AnimationUtils.loadAnimation(this, R.anim.test_alpha_anim);
                    break;
                case R.id.button_rotate:
                    animation = AnimationUtils.loadAnimation(this, R.anim.test_rotate_anim);
                    break;
                case R.id.button_translate:
                    animation = AnimationUtils.loadAnimation(this, R.anim.test_translate_anim);
                    break;
                case R.id.button_scale:
                    animation = AnimationUtils.loadAnimation(this, R.anim.test_scale_anim);
                    break;
                case R.id.button_animation_set:
                    animation = AnimationUtils.loadAnimation(this, R.anim.test_set_anim);
                    break;
                default:
                    break;
            }

            mImageCat.startAnimation(animation);

        } else {
//代码生成动画
            switch (viewId) {
                case R.id.button_alph:
                    animation = mAlphaAnimation;
                    break;
                case R.id.button_rotate:
                    animation = mRotateAnimation;
                    break;
                case R.id.button_scale:
                    animation = mScaleAnimation;
                    break;
                case R.id.button_translate:
                    animation = mTranslateAnimation;
                    break;
                case R.id.button_animation_set:
                    AnimationSet animationSet = new AnimationSet(true);
                    animationSet.addAnimation(mAlphaAnimation);
                    animationSet.addAnimation(mRotateAnimation);
                    animationSet.addAnimation(mScaleAnimation);
                    animationSet.addAnimation(mTranslateAnimation);
                    animation = animationSet;

                    break;
                default:
                    break;
            }

            if (animation != null) {
                animation.setDuration(2000);
                animation.setStartOffset(0);
                animation.setFillEnabled(false);
                animation.setFillBefore(true);
                animation.setFillAfter(false);
                animation.setRepeatCount(0);
                animation.setRepeatMode(Animation.RESTART);
                animation.setZAdjustment(Animation.ZORDER_NORMAL);
                animation.setBackgroundColor(0);
                animation.setDetachWallpaper(false);
//              设置插值器方式1： 使用Interpolator实现类设置插值器
                animation.setInterpolator(new AccelerateDecelerateInterpolator());
                //设置插值器方式2：使用XML配置 设置插值器
//            animation.setInterpolator(context, resID);
                mImageCat.startAnimation(animation);
            }
        }
    }


}
