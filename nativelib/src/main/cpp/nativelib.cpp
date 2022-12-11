#include <jni.h>
#include <string>

extern "C" JNIEXPORT jstring JNICALL
Java_com_yl_nativelib_NativeLib_stringFromJNI(
        JNIEnv* env,
        jobject /* this */) {
    std::string hello = "Hello from C++";
    return env->NewStringUTF(hello.c_str());
}

extern "C"
JNIEXPORT jstring JNICALL
Java_com_yl_nativelib_NativeLib_getString(JNIEnv *env, jobject thiz) {
    env->AllocObject()

}

extern "C"
JNIEXPORT jstring JNICALL
Java_com_yl_nativelib_NativeLib_setM(JNIEnv *env, jobject thiz, jstring s, jint i) {


}