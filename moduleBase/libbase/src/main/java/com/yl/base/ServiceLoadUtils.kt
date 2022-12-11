package com.yl.base

import java.util.*
import kotlin.reflect.KClass

/**
 * @date: $ $
 * @author: yanglei
 * @description
 *
 */
object ServiceLoadUtils {

    fun <S> load(service: Class<S>): S {
        return ServiceLoader.load(service).iterator().next()
    }

}