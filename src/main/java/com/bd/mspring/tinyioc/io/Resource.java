package com.bd.mspring.tinyioc.io;

import java.io.IOException;
import java.io.InputStream;

/**
 * @Author: baojing.he
 * @Date: 2021-03-31 22:31
 * @Description:
 */
public interface Resource {
    InputStream getInputStream() throws IOException;
}
