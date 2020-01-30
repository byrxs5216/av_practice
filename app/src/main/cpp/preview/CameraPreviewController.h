//
// Created by 徐生 on 2020-01-27.
//
#include <unistd.h>
#include <pthread.h>
#include <android/native_window.h>
#include <android/native_window_jni.h>
#include <EGL/egl.h>
#include <EGL/eglext.h>
#include <CommonUtils.h>
#ifndef AVEDITOR_CAMERAPREVIEWHANDLER_H
#define AVEDITOR_CAMERAPREVIEWHANDLER_H

class CameraPreviewController {

public:
    CameraPreviewController();

    virtual ~CameraPreviewController();

    void initEGLContext(ANativeWindow* aNativeWindow, JavaVM* g_jvm, jobject obj,
            int screenWidth, int screenHeight, int cameraFaceId);


protected:
    ANativeWindow* aNativeWindow;
    JavaVM *g_jvm;
    jobject obj;
    int screenWidth;
    int screenHeight;
    int cameraFacingId;

};


#endif //AVEDITOR_CAMERAPREVIEWHANDLER_H
