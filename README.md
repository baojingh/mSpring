[toc]

# mSpring

# 1. IOC
## 1.1 Bean创建与获取
1. `BeanFactory`是Bean的顶级接口，用于注册bean，获取bean。
- `getBean()` 根据bean名称，获取bean对象
- `registerBeanDefinition()` 将bean名称以及bean对应的bean元数据注册到map中。`BeanDefinition`定义bean的属性信息。
2. `AbstractBeanFactory`是抽象类，实现`BeanFactory`接口。
- beanDefinitionMap存放<beanName, BeanDefinition>信息。
- beanDefinitionNames列表存放beanName列表。
3. `AutowiredCapableBeanFactory`实现beanFactory接口，具体创建bean
- 根据beanDefinition中的beanClass创建bean对象
- 为bean装配属性，如果属性是BeanReference类型，就使用getBean获取到具体的bean，再装配到bean中。

### 1.1.1 Bean循环依赖问题
具体可以参看这篇文章：`https://blog.csdn.net/hebaojing/article/details/115586064`



1. 使用lazy机制，当使用bean的时候再创建，就


## 1.2 Bean属性
BeanDefinition对象包括：
- bean，真正的bean对象
- beanClassName，是一个全路径的名称，基于此名称可以反射出其对应的对象
- beanClass，class对象。使用beanClassName可以得到此class对象，通过class对象可以得到bean实例
- propertyValues，bean对应的属性信息。包括其引用的其他bean

## 1.3 Bean配置信息
- `BeanDefinitionReader`接口，根据具体的xml文件加载对应的bean
- `AbstractBeanDefinitionReader`中的registry保存<beanName,beanDefinition>信息，beanDefinition当前只有beanClassName以及属性信息
- `XmlBeanDefinitionReader`具体的实现类，实现从xml文件加载bean的过程


## 1.4 context封装BeanFactory，Resource，BeanDefinition，根据xml地址获取bean
- ApplicationContext标记接口，继承BeanFactory
- `AbstractApplicationContext`，使用registry保存<beanName, beanDefinition>，获取bean。根据xml注册bean
- `ClassPathXmlApplicationContext`，具体实现急在bean的子类。使用实现类`AutowiredCapableBeanFactory`实现bean的创建。`refresh()`实现对xml的读取，注册bean。

# 2. AOP



