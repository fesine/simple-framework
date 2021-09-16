package org.simpleframework.inject;

import com.fesine.controller.frontend.MainPageController;
import com.fesine.service.combine.impl.HeadLineShopCategoryCombineServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.simpleframework.core.BeanContainer;
import org.simpleframework.inject.annotation.DependencyInjector;

/**
 * @description: 类描述
 * @author: fesine
 * @createTime:2021/9/16
 * @update:修改内容
 * @author: fesine
 * @updateTime:2021/9/16
 */
public class DependencyInjectorTest {

    @Test
    @DisplayName("依赖注入doIoc")
    public void doIocTest(){
        BeanContainer beanContainer = BeanContainer.getInstance();
        beanContainer.loadBeans("com.fesine");
        Assertions.assertEquals(true, beanContainer.isLoaded());
        MainPageController mainPageController =
                (MainPageController) beanContainer.getBean(MainPageController.class);
        Assertions.assertEquals(true, mainPageController instanceof MainPageController);
        Assertions.assertEquals(null, mainPageController.getHeadLineShopCategoryCombineService());
        new DependencyInjector().doIoc();
        Assertions.assertNotEquals(null, mainPageController.getHeadLineShopCategoryCombineService());
        Assertions.assertEquals(true, mainPageController.getHeadLineShopCategoryCombineService() instanceof HeadLineShopCategoryCombineServiceImpl);
    }
}
