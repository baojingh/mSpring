package com.bd.mspring.tinyioc.xml;

import com.bd.mspring.tinyioc.AbstractBeanDefinitionReader;
import com.bd.mspring.tinyioc.io.ResourceLoader;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.InputStream;

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
    }

}
