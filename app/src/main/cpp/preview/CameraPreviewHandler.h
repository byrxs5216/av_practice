//
// Created by 徐生 on 2020-01-30.
//
#include "../common/message_queue/handler.h"

#ifndef AVEDITOR_CAMERAPREVIEWHANDLER_H
#define AVEDITOR_CAMERAPREVIEWHANDLER_H


class CameraPreviewHandler : public Handler{

private:
    CameraPreviewHandler *cameraPreviewHandler;

public:
    CameraPreviewHandler(CameraPreviewHandler *cameraPreviewHandler, MessageQueue *mQueue)
         :Handler(mQueue) {

    }

};


#endif //AVEDITOR_CAMERAPREVIEWHANDLER_H
