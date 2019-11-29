//
// Created by micah on 19-11-29.
//

#include "jni.h"

#ifdef __cplusplus
extern "C" {
#endif

JNIEXPORT void JNICALL Java_com_example_aidltest_JniTest_hello
        (JNIEnv *, jclass) {

}

JNIEXPORT jstring JNICALL
Java_com_example_aidltest_JniTest_getString(JNIEnv *env, jclass clazz) {
    return env->NewStringUTF("Hello, world");
}

#ifdef __cplusplus
}
#endif