package com.bd.mspring.tinyioc.io;

import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

/**
 * @Author: baojing.he
 * @Date: 2021-04-01 22:26
 * @Description:
 */
public class ResourceLoaderTest {

    @Test
    public void testGetResource() throws IOException {
        ResourceLoader resourceLoader = new ResourceLoader();
        Resource resource = resourceLoader.getResource("tinyioc.xml");
        InputStream inputStream = resource.getInputStream();
        Assert.assertNotNull(inputStream);
    }
}
