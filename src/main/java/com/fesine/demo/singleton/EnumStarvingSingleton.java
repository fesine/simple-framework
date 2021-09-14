package com.fesine.demo.singleton;

/**
 * @description: 类描述
 * @author: fesine
 * @createTime:2021/9/14
 * @update:修改内容
 * @author: fesine
 * @updateTime:2021/9/14
 */
public class EnumStarvingSingleton {
    private EnumStarvingSingleton(){}

    public static EnumStarvingSingleton getInstance(){
        return ContainerHolder.HOLDER.instance;
    }

    private enum ContainerHolder {
        HOLDER;
        private EnumStarvingSingleton instance;
        ContainerHolder(){
            instance = new EnumStarvingSingleton();
        }
    }
}
