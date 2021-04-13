package com.bd.mspring.cycleDependency;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;

import java.lang.reflect.Field;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Author: baojing.he
 * @Date: 2021-04-12 21:44
 * @Description:
 */
public class ApplicationMain {


    private static Map<String, Object> singleObjects = new ConcurrentHashMap<>();


    private static Map<String, BeanDefinition> beanDefinitionMap = new ConcurrentHashMap<>();


    public static void loadBeanDefinition() {
        RootBeanDefinition aBeanDefinition = new RootBeanDefinition(InstanceA.class);
        RootBeanDefinition bBeanDefinition = new RootBeanDefinition(InstanceB.class);
        beanDefinitionMap.put("instanceA", aBeanDefinition);
        beanDefinitionMap.put("instanceB", bBeanDefinition);
    }

    /**
     * 根据beanName获取bean
     *
     * @param beanName
     * @return
     * @throws Exception
     */
    public static Object getBean(String beanName) {

        /**
         * 该对象已经存在于缓存中，直接返回
         */
        Object obj = singleObjects.get(beanName);
        if (obj != null) {
            return obj;
        }

        /**
         * 1. 实例化bean对象
         */
        RootBeanDefinition beanDefinition = (RootBeanDefinition) beanDefinitionMap.get(beanName);
        Class beanClass = beanDefinition.getBeanClass();
        Object instanceBean = null;
        try {
            instanceBean = beanClass.newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        singleObjects.put(beanName, instanceBean);



        Field[] fields = beanClass.getDeclaredFields();
        for (Field declaredField : fields) {
            Autowired annotation = declaredField.getAnnotation(Autowired.class);
            if (annotation != null) {
                declaredField.setAccessible(true);
                String name = declaredField.getName();
                Object bean = getBean(name);
                try {
                    declaredField.set(instanceBean, bean);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        /**
         * 第三步: 初始化
         * 初始化就是设置类的init-method.这个可以设置也可以不设置. 我们这里就不设置了
         */
        return instanceBean;

    }


    public static void main(String[] args) {
        loadBeanDefinition();
        InstanceA instanceA = (InstanceA) getBean("instanceA");
        instanceA.say();
    }


}
