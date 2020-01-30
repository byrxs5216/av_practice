//
// Created by 徐生 on 2020-01-27.
//
#include <jni.h>
#include <string>
#include <android/native_window.h>
#include <android/native_window_jni.h>
#include "CameraPreviewController.h"

#ifndef AVEDITOR_CAMERAPREVIEWHANDLER_H
#define AVEDITOR_CAMERAPREVIEWHANDLER_H


#endif //AVEDITOR_CAMERAPREVIEWHANDLER_H

extern "C" JNIEXPORT void JNICALL
Java_com_example_aveditor_recorder_camera_CameraPreviewHandler_initEGLContext
        (JNIEnv *, jobject, jobject, jint, jint, jint);

extern "C" JNIEXPORT void JNICALL
Java_com_example_aveditor_recorder_camera_CameraPreviewHandler_createWindowSurface
        (JNIEnv *, jobject, jobject);
