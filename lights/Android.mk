LOCAL_PATH := $(call my-dir)

include $(CLEAR_VARS)

LOCAL_MODULE := android.hardware.lights-service.xiaomi_mt6895"
LOCAL_MODULE_TAGS  := optional

LOCAL_MODULE_PATH := $(TARGET_OUT_PRODUCT)/vendor_overlay/$(PRODUCT_TARGET_VNDK_VERSION)/bin
LOCAL_MODULE_RELATIVE_PATH := hw
LOCAL_MODULE_STEM := android.hardware.lights-service.mediatek

LOCAL_SRC_FILES := \
    main.cpp \
    Lights.cpp

LOCAL_SHARED_LIBRARIES := \
    libbinder_ndk \
    libbase \
    android.hardware.light-V1-ndk_platform

include $(BUILD_EXECUTABLE) 