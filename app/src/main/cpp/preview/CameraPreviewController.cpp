//
// Created by 徐生 on 2020-01-27.
//

#define LOG_TAG "CameraPreviewController"
#include "CameraPreviewController.h"

void CameraPreviewController::initEGLContext(ANativeWindow *aNativeWindow, JavaVM *g_jvm, jobject obj,
                                          int screenWidth, int screenHeight, int cameraFaceId) {
    LOGI("create egl thread");
    this->aNativeWindow = aNativeWindow;
    this->g_jvm = g_jvm;
    this->screenWidth = screenWidth;
    this->screenHeight = screenHeight;
    this->cameraFacingId = cameraFaceId;

}

CameraPreviewController::CameraPreviewController() {

}

CameraPreviewController::~CameraPreviewController() {

}
