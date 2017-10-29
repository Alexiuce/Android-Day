//
// Created by Alexcai on 2017/10/29.
//

#include "com_example_alexcai_javacdemo_JNIHelper.h"

JNIEXPORT jstring JNICALL Java_com_example_alexcai_javacdemo_JNIHelper_stringFromC(JNIEnv *env, jclass obj){

     return (*env)->NewStringUTF("Hello World!");
       }

