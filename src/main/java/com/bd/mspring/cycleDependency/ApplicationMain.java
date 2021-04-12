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
    private static Map<String, BeanDefinition> beanDefinitionMap = new ConcurrentHashMap<>();


    public static void loadBeanDefinition() {
        RootBeanDefinition aBeanDefinition = new RootBeanDefinition(InstanceA.class);
        RootBeanDefinition bBeanDefinition = new RootBeanDefinition(InstanceB.class);
        beanDefinitionMap.put("instanceA", aBeanDefinition);
        beanDefinitionMap.put("instanceA", bBeanDefinition);
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
         * 1. 实例化bean对象
         */
        RootBeanDefinition beanDefinition = (RootBeanDefinition)beanDefinitionMap.get(beanName);
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

        Field[] declaredFields = beanClass.getDeclaredFields();
        for (Field declaredField: declaredFields) {
            // 判断每一个属性是否有@Autowired注解
            Autowired annotation = declaredField.getAnnotation(Autowired.class);
            if (annotation != null) {
                // 设置这个属性是可访问的
                declaredField.setAccessible(true);
                // 那么这个时候还要构建这个属性的bean.
                /*
                 * 获取属性的名字
                 * 真实情况, spring这里会判断, 是根据名字, 还是类型, 还是构造函数来获取类.
                 * 我们这里模拟, 所以简单一些, 直接根据名字获取.
                 */
                String name = declaredField.getName();

                /**
                 * 这样, 在这里我们就拿到了 instanceB 的 bean
                 */
                Object fileObject = getBean(name);

                // 为属性设置类型
                try {
                    declaredField.set(instanceBean, fileObject);
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
        Object instanceA = getBean("instanceA");
    }


}
