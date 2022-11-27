package com.yl.study.aidl.client;

import com.yl.study.IMyAidlInterface;

/**
 * @date: $ $
 * @author: yanglei
 * @description
 */
public interface ICallback {
    void onSuccess(IMyAidlInterface iMyAidlInterface);
    void onFailed();
}
