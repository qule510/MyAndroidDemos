package com.qule.study.model;

import android.app.Activity;
import android.os.Bundle;


/**
 * @author qule
 * @version V1.0.0
 * @Description 跳转Activity的实体，
 * @date 2017-01-26 17:32
 */
public class JumpActivityModel {


    /**
     * 名称，用于列表展示
     */
    public String name;

    public Class<? extends Activity> clazz;

    public Bundle bundle;


    public JumpActivityModel(String name, Class<? extends Activity> clazz, Bundle bundle) {
        this.name = name;
        this.clazz = clazz;
        this.bundle = bundle;
    }

    public JumpActivityModel(String name, Class<? extends Activity> clazz) {
        this.name = name;
        this.clazz = clazz;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Class<? extends Activity> getClazz() {
        return clazz;
    }

    public void setClazz(Class<? extends Activity> clazz) {
        this.clazz = clazz;
    }

    public Bundle getBundle() {
        return bundle;
    }

    public void setBundle(Bundle bundle) {
        this.bundle = bundle;
    }

    @Override
    public String toString() {
        return "JumpActivityModel{" +
                "name='" + name + '\'' +
                ", clazz=" + clazz +
                ", bundle=" + bundle +
                '}';
    }
}
