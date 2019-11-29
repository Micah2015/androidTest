LOCAL_PATH := $(call my-dir)
include $(CLEAR_VARS)

CPP_PATH := $(LOCAL_PATH)/src/main/jni/

LOCAL_CPPFLAGS 	:= -std=c++11
LOCAL_MODULE    := hello
LOCAL_SRC_FILES := $(CPP_PATH)/hello.cpp
LOCAL_LDLIBS		:= -llog

include $(BUILD_SHARED_LIBRARY)
