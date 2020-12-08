package com.lance.controller.admin;

import com.lance.service.impl.BookServiceImpl;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;

/**
 * @author lance
 * @version 1.0
 * @date 2020/12/8 20:19
 */
@Controller
@Log4j2
public class BookController {
    @Resource
    private BookServiceImpl bookService;
    
}
