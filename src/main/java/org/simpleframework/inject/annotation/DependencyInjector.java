package org.simpleframework.inject.annotation;

import lombok.extern.slf4j.Slf4j;
import org.simpleframework.core.BeanContainer;
import org.simpleframework.util.ClassUtil;
import org.simpleframework.util.ValidationUtil;

import java.lang.reflect.Field;
import java.util.Set;

/**
 * @description: 类描述
 * @author: fesine
 * @createTime:2021/9/15
 * @update:修改内容
 * @author: fesine
 * @updateTime:2021/9/15
 */
@Slf4j
public class DependencyInjector {

    private BeanContainer beanContainer;

    public DependencyInjector() {
        beanContainer = BeanContainer.getInstance();
    }

    /**
     * 执行Ioc
     */
    public void doIoc() {
        if (ValidationUtil.isEmpty(beanContainer.getClasses())) {
            log.warn("empty classSet in beanContainer.");
            return;
        }
        //1.遍历bean容器中所有的class对象
        for (Class<?> clazz : beanContainer.getClasses()) {
            //2.遍历clazz所有的成员变量
            Field[] fields = clazz.getDeclaredFields();
            if (ValidationUtil.isEmpty(fields)) {
                continue;
            }
            for (Field field : fields) {
                //3.遍历所有的field，找出被标记为@Autowired注解的成员变量
                if (field.isAnnotationPresent(Autowired.class)) {
                    Autowired autowired = field.getAnnotation(Autowired.class);
                    //4.获取成员变量的类型
                    Class<?> fieldClass = field.getType();
                    //5.获取这些成员变量的类型在容器中的实例
                    Object fieldValue = getFieldInstance(fieldClass, autowired.value());
                    if (fieldValue == null) {
                        throw new RuntimeException("unable to inject relevant type, target " +
                                "fieldClass is:" + fieldClass.getName());
                    } else {
                        //6.通过反射将成员变量实例注入到成员变量所在类的实例里
                        Object targetBean = beanContainer.getBean(clazz);
                        ClassUtil.setFieldValue(field, targetBean, fieldValue, true);

                    }
                }
            }
        }
    }


    /**
     * 根据成员变量类名获取类实例
     *
     * @param fieldClass
     * @return
     */
    private Object getFieldInstance(Class<?> fieldClass, String annotationValue) {
        Object fieldValue = beanContainer.getBean(fieldClass);
        //如果存在实例，直接返回
        if (fieldValue != null) {
            return fieldValue;
        } else {
            Class<?> implementClass = getImplementedClass(fieldClass, annotationValue);
            if (implementClass != null) {
                return beanContainer.getBean(implementClass);
            } else {
                return null;
            }
        }
    }

    private Class<?> getImplementedClass(Class<?> fieldClass, String annotationValue) {
        //如果不存在，则通过父类或接口查询实例对象
        Set<Class<?>> classSet = beanContainer.getClassesBySuper(fieldClass);
        if (!ValidationUtil.isEmpty(classSet)) {
            if (ValidationUtil.isEmpty(annotationValue)) {
                if (classSet.size() == 1) {
                    return classSet.iterator().next();
                } else {
                    throw new RuntimeException("multiple implemented classes for "
                            + fieldClass.getName()
                            + ", please set @Autowired's value to pick one.");
                }
            } else {
                //如果有多个实例，则需要通过value匹配
                for (Class<?> clazz : classSet) {
                    if (clazz.getSimpleName().equals(annotationValue)) {
                        return clazz;
                    }
                }
            }
        }
        return null;
    }
}
