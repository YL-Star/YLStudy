package com.yl.study.annotation;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;

import java.lang.reflect.Field;

import static java.util.Arrays.copyOf;

/**
 *
 * @date: $ $
 * @author: yanglei
 * @description
 */
public class InjectUtils {

    public static void parseIntentParams(Activity activity) {
        Intent intent = activity.getIntent();
        Bundle extras = intent.getExtras();
        if (extras == null) {
            return;
        }
        Class<? extends Activity> activityClass = activity.getClass();
        Field[] fields = activityClass.getDeclaredFields();
        for (Field field : fields) {
            if (field.isAnnotationPresent(IntentParam.class)) {
                IntentParam intentParam = field.getAnnotation(IntentParam.class);
                if (intentParam == null) {
                    return;
                }
                //如果没有定义key，就用默认的属性名称。
                String key = TextUtils.isEmpty(intentParam.key()) ? field.getName() : intentParam.key();
                if (extras.containsKey(key)) {
                    Object obj = extras.get(key);

                    // 1.如果是Parcelable类型的值。
                    Class<?> componentType = field.getType().getComponentType();
                    if (field.getType().isArray() && Parcelable.class.isAssignableFrom(componentType)) {
                        Object[] objects = (Object[]) obj;
                        obj = copyOf(objects,objects.length,(Class<? extends Object[]>) field.getType());
                    }

                    //允许修改私有属性。
                    field.setAccessible(true);

                    // 其他类型
                    try {
                        //如果是静态属性，不需要传实体类，传class类也行。
                        field.set(activity,obj);
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}
