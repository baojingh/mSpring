package com.bd.mspring.tinyioc.io;

import java.net.URL;

/**
 * @Author: baojing.he
 * @Date: 2021-03-31 22:32
 * @Description:
 */
public class ResourceLoader {
    public Resource getResource(String location) {
        URL resource = this.getClass().getClassLoader().getResource(location);
        UrlResource urlResource = new UrlResource(resource);
        return urlResource;
    }
}
