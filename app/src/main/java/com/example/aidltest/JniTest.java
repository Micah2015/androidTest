package com.example.aidltest;

public class JniTest {
    static {
        System.loadLibrary("hello");
    }
    public static native void hello();
    public static native String getString();
}
