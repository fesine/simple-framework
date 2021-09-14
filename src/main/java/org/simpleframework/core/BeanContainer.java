package org.simpleframework.core;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.simpleframework.core.annotation.Component;
import org.simpleframework.core.annotation.Controller;
import org.simpleframework.core.annotation.Repository;
import org.simpleframework.core.annotation.Service;
import org.simpleframework.util.ClassUtil;
import org.simpleframework.util.ValidationUtil;

import java.lang.annotation.Annotation;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @description: 类描述
 * @author: fesine
 * @createTime:2021/9/14
 * @update:修改内容
 * @author: fesine
 * @updateTime:2021/9/14
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Slf4j
public class BeanContainer {

    /**
     * 1、存放所有被配置标记的目标对象的Map
     */
    private final Map<Class<?>, Object> beanMap = new ConcurrentHashMap<>();

    /**
     * 2、加载bean的注解列表
     */
    private static final List<Class<? extends Annotation>> BEAN_ANNOTATION =
            Arrays.asList(Controller.class, Service.class, Repository.class, Component.class);


    /**
     * 容器是否已经加载过bean
     */
    private boolean loaded = false;

    /**
     * 是否已经加载过bean
     * @return 是否已加载
     */
    public boolean isLoaded(){
        return loaded;
    }

    /**
     * Bean实例数量
     * @return
     */
    public int size(){
        return beanMap.size();
    }

    /**
     * 获取bean容器实例
     * @return BeanContainer
     */
    public static BeanContainer getInstance(){
        return ContainerHolder.HOLDER.instance;
    }


    private enum ContainerHolder{
        HOLDER;
        private BeanContainer instance;
        ContainerHolder(){
            instance = new BeanContainer();
        }
    }

    /**
     * 3、扫描加载所有bean
     * @param basePackage
     */
    public synchronized void loadBeans(String basePackage){
        //判断bean是否已经加载过
        if (isLoaded()) {
            log.warn("BeanContainer has bean loaded.");
            return;
        }
        Set<Class<?>> classSet = ClassUtil.extractPackageClass(basePackage);
        if (ValidationUtil.isEmpty(classSet)) {
            log.warn("extract nothing from packageName={}", basePackage);
            return;
        }
        //遍历
        for (Class<?> clazz : classSet) {
            for (Class<? extends Annotation> annotation : BEAN_ANNOTATION) {
                //如果类上面标记了自定义的注解
                if (clazz.isAnnotationPresent(annotation)) {
                    //将目标类本身作为key，目标类的实例作为value，放入到beanMap中
                    beanMap.put(clazz, ClassUtil.newInstance(clazz, true));
                }
            }
        }
        loaded = true;

    }
}
