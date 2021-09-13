package org.simpleframework.util;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Set;

/**
 * @description: 类描述
 * @author: fesine
 * @createTime:2021/9/14
 * @update:修改内容
 * @author: fesine
 * @updateTime:2021/9/14
 */
public class ClassUtilTest {

    @Test
    @DisplayName("提取目录类方法：extractPackageClassTest")
    public void extractPackageClassTest(){
        Set<Class<?>> classSet = ClassUtil.extractPackageClass("com.fesine.entity");
        System.out.println(classSet);
        Assertions.assertEquals(4,classSet.size());
    }
}
