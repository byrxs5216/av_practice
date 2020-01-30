//
// Created by 徐生 on 2020-01-27.
//

#include "CameraPreviewInterface.h"
static CameraPreviewController* previewController = 0;

JNIEXPORT void JNICALL
Java_com_example_aveditor_recorder_camera_CameraPreviewHandler_initEGLContext(JNIEnv *env, jobject obj, jobject surface, jint screenWidth, jint screenHeight,
                                                                                  jint cameraFacingId) {
    previewController = new CameraPreviewController();

}

JNIEXPORT void JNICALL
Java_com_example_aveditor_recorder_camera_CameraPreviewHandler_createWindowSurface(JNIEnv *env, jobject obj, jobject surface) {



}
