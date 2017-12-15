//
// Created by caijinzhu on 2017/12/15.
//



#include "com_joinf_www_updateapkdemo_JNIUtils.h"
JNIEXPORT jstring JNICALL Java_com_joinf_www_updateapkdemo_JNIUtils_getHelLo
  (JNIEnv *env, jobject obj){

  return env->NewStringUTF("Hello World");
  }