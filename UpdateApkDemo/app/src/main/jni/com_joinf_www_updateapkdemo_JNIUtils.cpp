//
// Created by caijinzhu on 2017/12/15.
//


#include "com_joinf_www_updateapkdemo_JNIUtils.h"


/* 方法名构成:
 * Java_ + 包名 + 类名 + 方法名
 *
 * ojb  : 调用这个方法的实例 ,就是java中的this
 * env :
 * */

JNIEXPORT jstring JNICALL Java_com_joinf_www_updateapkdemo_JNIUtils_getHelLo(JNIEnv *env, jobject obj){
    return env->NewStringUTF("Hello World~~~");
  }