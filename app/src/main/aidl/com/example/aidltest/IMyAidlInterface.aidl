// IMyAidlInterface.aidl
package com.example.aidltest;

// Declare any non-default types here with import statements

import com.example.aidltest.Student;

interface IMyAidlInterface {
    /**
     * Demonstrates some basic types that you can use as parameters
     * and return values in AIDL.
     */
    void basicTypes(int anInt, long aLong, boolean aBoolean, float aFloat,
            double aDouble, String aString);
    Student getStudent();
}
