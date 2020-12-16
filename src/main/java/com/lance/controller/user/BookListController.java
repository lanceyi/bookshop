package com.lance.controller.user;

import com.lance.dto.BookDto;
import com.lance.dto.BookListDto;
import com.lance.entity.BookListEntity;
import com.lance.entity.UserEntity;
import com.lance.service.impl.BookListServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

/**
 * @author lance
 * @version 1.0
 * @date 2020/12/16 17:36
 */
@Controller("userBookList")
@RequestMapping("/user")
public class BookListController {
    @Resource
    private BookListServiceImpl bookListService;


    /**
     * 图书列表
     * @param model
     * @return myBook/list
     */
    @GetMapping("/myBookLists")
    public String MyBooksList(@RequestParam(value = "userId",required=false) Integer userId,Model model){
        List<BookListDto> bookLists = bookListService.selectAllByPrimaryKey(userId);
        model.addAttribute("bookLists",bookLists);
        return "user/myBookList/list";
    }

    @DeleteMapping("/bookList")
    public String BorrowBook(@RequestParam( value = "bookId",required=false)int bookId,@RequestParam( value = "imgUrl",required=false)String imgUrl, HttpSession session){
        UserEntity userEntity = (UserEntity)session.getAttribute("userEntity");
        bookListService.insert(new BookListEntity(userEntity.getUserId(),bookId,imgUrl));
        return "user/myBookList/list";
    }

}
