package com.qule.study.util;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.widget.Toast;

/**
 * @author qule
 * @version V1.0.0
 * @Description 应用常用方法，主线程Handler。普通activity跳转。常用toast显示.
 * @date 2017-01-26 22:40
 */
public class AppUtil {

    public static Handler MAIN_HANDLER = new Handler(Looper.getMainLooper());

    public static final void jump2Activity(Context context, Class<? extends Activity> clazz) {
        context.startActivity(new Intent(context, clazz));
    }



    public static final void jump2Activity(Context context, Class<? extends Activity> clazz, Bundle bundle) {
        if (bundle==null){
            jump2Activity(context,clazz);
            return;
        }

        Intent intent = new Intent(context, clazz);
        if (Build.VERSION.SDK_INT > 16) {
            context.startActivity(intent, bundle);
        } else {
            intent.putExtras(bundle);
            context.startActivity(new Intent(context, clazz));
        }
    }

    public static final void toastShort(Context context,CharSequence text){
        Toast.makeText(context,text,Toast.LENGTH_SHORT).show();;
    }
    public static final void toastLong(Context context,CharSequence text){
        Toast.makeText(context,text,Toast.LENGTH_LONG).show();
    }
}
