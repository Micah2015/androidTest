// IMyAidlInterface.aidl
package com.example.libtestsrv;

// Declare any non-default types here with import statements
import com.example.libtestsrv.Person;

interface IMySrvInterface {
    Person getOne();
}
