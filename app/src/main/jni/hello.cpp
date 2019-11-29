//
// Created by micah on 19-11-29.
//

#include "jni.h"

#include <string>

#include "jni_test.h"

#ifdef __cplusplus
extern "C" {
#endif

JNIEXPORT void JNICALL Java_com_example_aidltest_JniTest_hello
        (JNIEnv *, jclass) {

}

JNIEXPORT jstring JNICALL
Java_com_example_aidltest_JniTest_getString(JNIEnv *env, jclass clazz) {
    std::string s = jni_test().getRandom();
    return env->NewStringUTF(s.data());
//    return env->NewStringUTF("Hello, world");
}

#ifdef __cplusplus
}
#endif