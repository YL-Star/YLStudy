package com.yl.arouter_api;

import java.util.Map;

/**
 * @date: $ $
 * @author: yanglei
 * @description
 */
public interface IARouterGroup {
    Map<String, Class<? extends IARouterPath>> getGroupMap();
}
