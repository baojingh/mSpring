[toc]

# mSpring

# 1. IOC
## 1.1 Bean创建与获取
1. `BeanFactory`是Bean的顶级接口，用于注册bean，获取bean。
- `getBean()` 根据bean名称，获取bean对象
- `registerBeanDefinition()` 将bean名称以及bean对应的bean元数据注册到map中。`BeanDefinition`定义bean的属性信息。
2. `AbstractBeanFactory`是抽象类，实现`BeanFactory`接口。
- beanDefinitionMap存放<beanName, BeanDefinition>信息。
- beanDefinitionNames列表存放beanName。


### 1.1.10 Bean循环依赖问题


## 1.2 Bean属性
- BeanDefinition 

## 1.3 Bean配置信息






# 2. AOP



