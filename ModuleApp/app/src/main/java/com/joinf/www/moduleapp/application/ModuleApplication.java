package com.joinf.www.moduleapp.application;

import android.app.Application;

/**
 * Created by caijinzhu on 2017/12/20.
 * 1. 整个应用的入口
 * 2. 初始化工作
 * 3. 为整个应用的其他模块提供上下文环境
 */

public class ModuleApplication extends Application {

    private static ModuleApplication mApplication = null;

    @Override
    public void onCreate() {
        super.onCreate();
        mApplication = this;
    }

    public static ModuleApplication getInstance(){
        return mApplication;
    }

}
