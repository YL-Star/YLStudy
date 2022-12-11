package com.yl.arouter_api;

import com.yl.annotation.arouter.ARouterBean;

import java.util.Map;

/**
 * @date: $ $
 * @author: yanglei
 * @description
 */
public interface IARouterPath {
    Map<String, ARouterBean> getPathMap();
}
