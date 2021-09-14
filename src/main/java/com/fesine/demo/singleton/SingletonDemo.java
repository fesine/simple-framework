package com.fesine.demo.singleton;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * @description: 类描述
 * @author: fesine
 * @createTime:2021/9/14
 * @update:修改内容
 * @author: fesine
 * @updateTime:2021/9/14
 */
public class SingletonDemo {

    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        System.out.println(EnumStarvingSingleton.getInstance());
        Class clazz = EnumStarvingSingleton.class;
        Constructor constructor = clazz.getDeclaredConstructor();
        constructor.setAccessible(true);
        EnumStarvingSingleton enumStarvingSingleton = (EnumStarvingSingleton) constructor.newInstance();
        System.out.println(enumStarvingSingleton.getInstance());
    }
}
