package com.bd.mspring.tinyioc.xml;

import com.bd.mspring.tinyioc.AbstractBeanDefinitionReader;
import com.bd.mspring.tinyioc.BeanDefinition;
import com.bd.mspring.tinyioc.PropertyValue;
import com.bd.mspring.tinyioc.io.ResourceLoader;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.InputStream;
import java.util.Map;

/**
 * @Author: baojing.he
 * @Date: 2021-03-30 22:58
 * @Description:
 */
public class XmlBeanDefinitionReader extends AbstractBeanDefinitionReader {
    protected XmlBeanDefinitionReader(ResourceLoader resourceLoader) {
        super(resourceLoader);
    }

    @Override
    public void loadBeanDefinitions(String location) throws Exception {
        InputStream inputStream = getResourceLoader().getResource(location).getInputStream();

    }

    protected void doLoadBeanDefinitions(InputStream inputStream) throws Exception {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder documentBuilder = factory.newDocumentBuilder();
        Document document = documentBuilder.parse(inputStream);
        registerBeanDefinition(document);

    }

    public void registerBeanDefinition(Document document) {
        Element root = document.getDocumentElement();
        parseBeanDefinitions(root);

    }

    protected void parseBeanDefinitions(Element root) {
        NodeList childNodes = root.getChildNodes();
        for (int i = 0; i < childNodes.getLength(); i++) {
            Node node = childNodes.item(i);
            if (node instanceof Element) {
                Element ele = (Element) node;
                processBeanDefinition(ele);
            }
        }
    }

    private void processBeanDefinition(Element ele) {
        String name = ele.getAttribute("name");
        String className = ele.getAttribute("class");
        BeanDefinition beanDefinition = new BeanDefinition();
        processProperty(ele, beanDefinition);
        beanDefinition.setBeanClassName(className);
        Map<String, BeanDefinition> registry = getRegistry();
        registry.put(name, beanDefinition);
    }

    private void processProperty(Element ele, BeanDefinition beanDefinition) {
        NodeList propertyNode = ele.getElementsByTagName("property");
        for (int i = 0; i < propertyNode.getLength(); i++) {
            Node item = propertyNode.item(i);
            if (item instanceof Element) {
                Element propertyEle = (Element) item;
                String name = propertyEle.getAttribute("name");
                String value = propertyEle.getAttribute("value");
                beanDefinition.getPropertyValues().addPropertyValue(new PropertyValue(name, value));
            }

        }
    }

}
























