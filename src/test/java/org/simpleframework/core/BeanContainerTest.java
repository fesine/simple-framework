package org.simpleframework.core;

import com.fesine.service.combine.HeadLineShopCategoryCombineService;
import org.junit.jupiter.api.*;
import org.simpleframework.core.annotation.Controller;

import java.util.Set;

/**
 * @description: 类描述
 * @author: fesine
 * @createTime:2021/9/14
 * @update:修改内容
 * @author: fesine
 * @updateTime:2021/9/14
 */
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class BeanContainerTest {

    private static BeanContainer beanContainer;

    @BeforeAll
    static void init(){
        beanContainer = BeanContainer.getInstance();
    }

    @Order(1)
    @DisplayName("加载目标类及其实例到BeanContainer:loadBeansTest")
    @Test
    public void loadBeansTest(){
        Assertions.assertEquals(false, beanContainer.isLoaded());
        beanContainer.loadBeans("com.fesine");
        Assertions.assertEquals(6, beanContainer.size());
        Assertions.assertEquals(true, beanContainer.isLoaded());
    }

    @Order(2)
    @DisplayName("根据注解标记从BeanContainer获取class类:getClassesByAnnotationTest")
    @Test
    public void getClassesByAnnotationTest(){
        Set<Class<?>> classSet = beanContainer.getClassesByAnnotation(Controller.class);
        Assertions.assertEquals(3, classSet.size());
    }

    @Order(3)
    @DisplayName("根据父类或接口从BeanContainer获取class类:getClassesBySuperTest")
    @Test
    public void getClassesBySuperTest(){
        Set<Class<?>> classSet = beanContainer.getClassesBySuper(HeadLineShopCategoryCombineService.class);
        Assertions.assertEquals(1, classSet.size());
    }

}
