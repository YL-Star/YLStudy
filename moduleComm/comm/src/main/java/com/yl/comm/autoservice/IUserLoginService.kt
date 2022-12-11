package com.yl.comm.autoservice

/**
 * @date: $ $
 * @author: yanglei
 * @description
 *
 */
interface IUserLoginService {
    /**
     * 是否登录
     */
    fun isLogged():Boolean
    fun login()
}