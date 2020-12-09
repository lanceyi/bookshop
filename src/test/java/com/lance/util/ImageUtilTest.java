package com.lance.util;

import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author lance
 * @version 1.0
 * @date 2020/12/9 17:20
 */
class ImageUtilTest {

    @Test
    void generateDirectoryThumbnail () throws IOException {
        String path = "D:\\javaEE\\booksystem\\src\\main\\resources\\templates\\images\\rotPhoto";
        ImageUtil.generateDirectoryThumbnail(path);

    }
}