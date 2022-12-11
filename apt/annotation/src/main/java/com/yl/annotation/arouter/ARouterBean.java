package com.yl.annotation.arouter;

import javax.lang.model.element.Element;

/**
 * @date: $ $
 * @author: yanglei
 * @description
 */
public class ARouterBean {
    // 为了以后的发展
    public enum TypeEnum {
        ACTIVITY,
        CALL
    }

    private TypeEnum typeEnum; // 枚举类型：Activity
    private Element element; // 类节点 JavaPoet学习的时候，可以拿到很多的信息
    private Class myClass; // 被注解的 Class对象 例如： MainActivity.class  Main2Activity.class
    private String path; // 路由地址  例如：/app/MainActivity
    private String group; // 路由组  例如：app  order  personal

    public ARouterBean(TypeEnum typeEnum, Class myClass, String path, String group) {
        this.typeEnum = typeEnum;
        this.element = element;
        this.myClass = myClass;
        this.path = path;
        this.group = group;
    }

    public TypeEnum getTypeEnum() {
        return typeEnum;
    }

    public void setTypeEnum(TypeEnum typeEnum) {
        this.typeEnum = typeEnum;
    }

    public Element getElement() {
        return element;
    }

    public void setElement(Element element) {
        this.element = element;
    }

    public Class<?> getMyClass() {
        return myClass;
    }

    public void setMyClass(Class<?> myClass) {
        this.myClass = myClass;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }
}
