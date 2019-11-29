//
// Created by micah on 19-11-29.
//

#ifndef AIDLTEST_JNI_TEST_H
#define AIDLTEST_JNI_TEST_H

#include <string>

class jni_test {
public:
    static std::string getRandom() {
        return "jni-test";
    }
};


#endif //AIDLTEST_JNI_TEST_H
