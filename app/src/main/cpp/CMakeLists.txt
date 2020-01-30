# For more information about using CMake with Android Studio, read the
# documentation: https://d.android.com/studio/projects/add-native-code.html

# Sets the minimum version of CMake required to build the native library.

cmake_minimum_required(VERSION 3.4.1)

set(JNI_PATH ${CMAKE_SOURCE_DIR}/jni)
set(CAMERA_PREVIEW_PATH ${CMAKE_SOURCE_DIR}/preview)
set(COMMON_UTIL_PATH ${CMAKE_SOURCE_DIR}/common/util)
set(FFMPEG_LIBS_DIR ${CMAKE_SOURCE_DIR}/ffmpeg/libs)
set(FFMPEG_INCLUDE_DIR ${CMAKE_SOURCE_DIR}/ffmpeg/include)
set(COMMON_MESSAGE_QUEUE ${CMAKE_SOURCE_DIR}/common/message_queue)

include_directories(${JNI_PATH})
include_directories(${CAMERA_PREVIEW_PATH})
include_directories(${COMMON_UTIL_PATH})
include_directories(${COMMON_MESSAGE_QUEUE})

file(GLOB FILE_LISTS_JNI "${JNI_PATH}/*.cpp")
file(GLOB FILE_LISTS_PREVIEW "${CAMERA_PREVIEW_PATH}/*.cpp")
file(GLOB FILE_LISTS_COMMON_UTIL "${COMMON_UTIL_PATH}}/*.cpp")
file(GLOB FILE_LISTS_MESSAGE_QUEUE "${COMMON_MESSAGE_QUEUE}}/*.cpp")

# Creates and names a library, sets it as either STATIC
# or SHARED, and provides the relative paths to its source code.
# You can define multiple libraries, and CMake builds them for you.
# Gradle automatically packages shared libraries with your APK.

add_library(aveditor SHARED
        ${FILE_LISTS_JNI}
        ${FILE_LISTS_PREVIEW}
        ${FILE_LISTS_COMMON_UTIL}
        ${FILE_LISTS_MESSAGE_QUEUE}
        )
add_library(avutil
        SHARED
        IMPORTED )
set_target_properties(avutil
        PROPERTIES IMPORTED_LOCATION
        ${FFMPEG_LIBS_DIR}/${ANDROID_ABI}/libavutil.so )

add_library(swresample
        SHARED
        IMPORTED )
set_target_properties(swresample
        PROPERTIES IMPORTED_LOCATION
        ${FFMPEG_LIBS_DIR}/${ANDROID_ABI}/libswresample.so )

add_library(swscale
        SHARED
        IMPORTED )
set_target_properties(swscale
        PROPERTIES IMPORTED_LOCATION
        ${FFMPEG_LIBS_DIR}/${ANDROID_ABI}/libswscale.so )

add_library(avcodec
        SHARED
        IMPORTED )
set_target_properties(avcodec
        PROPERTIES IMPORTED_LOCATION
        ${FFMPEG_LIBS_DIR}/${ANDROID_ABI}/libavcodec.so )

add_library(avformat
        SHARED
        IMPORTED )
set_target_properties(avformat
        PROPERTIES IMPORTED_LOCATION
        ${FFMPEG_LIBS_DIR}/${ANDROID_ABI}/libavformat.so )

add_library(avfilter
        SHARED
        IMPORTED )
set_target_properties(avfilter
        PROPERTIES IMPORTED_LOCATION
        ${FFMPEG_LIBS_DIR}/${ANDROID_ABI}/libavfilter.so )

add_library(avdevice
        SHARED
        IMPORTED )
set_target_properties(avdevice
        PROPERTIES IMPORTED_LOCATION
        ${FFMPEG_LIBS_DIR}/${ANDROID_ABI}/libavdevice.so )

include_directories(${FFMPEG_INCLUDE_DIR})
# Searches for a specified prebuilt library and stores the path as a
# variable. Because CMake includes system libraries in the search path by
# default, you only need to specify the name of the public NDK library
# you want to add. CMake verifies that the library exists before
# completing its build.

find_library( # Sets the name of the path variable.
        log-lib

        # Specifies the name of the NDK library that
        # you want CMake to locate.
        log)

# Specifies libraries CMake should link to your target library. You
# can link multiple libraries, such as libraries you define in this
# build script, prebuilt third-party libraries, or system libraries.

target_link_libraries(aveditor
        # 引入系统的动态库
        log
        android
        GLESv2
        EGL
        z
        OpenSLES
        #引入ffmpeg
        avutil
        swresample
        swscale
        avcodec
        avformat
        avfilter
        avdevice
        ${log-lib})