package com.lance.controller.admin;

import com.lance.dto.BookDto;
import com.lance.entity.BookEntity;
import com.lance.entity.BookSortEntity;
import com.lance.service.impl.BookServiceImpl;
import com.lance.service.impl.BookSortServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.thymeleaf.util.StringUtils;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author lance
 * @version 1.0
 * @date 2020/12/9 1:43
 */
@Controller
public class BookController {
    @Resource
    private BookServiceImpl bookService;
    @Resource
    private BookSortServiceImpl bookSortService;

    /**
     * 图书列表
     * @param model
     * @return book/list
     */
    @GetMapping("/books")
    public String list(Model model){
        List<BookDto> books = bookService.selectAll();
        model.addAttribute("books",books);
        return "book/list";
    }
    /**
     *去到添加页面
     * @return book/add
     */
    @GetMapping("/book")
    public String toAddPage(Model model){
        List<BookSortEntity> bookSorts = bookSortService.selectAll();
        model.addAttribute("bookSorts",bookSorts);
        return "book/add";
    }

    /**
     * 添加书籍
     * @return redirect:/books
     */
    @PostMapping("/book")
    public String addBook(BookEntity bookEntity){
        bookService.insert(bookEntity);
        return "redirect:/books";
    }

    /**
     * 去编辑页面
     * @param bookId
     * @param model
     * @return book/add
     */
    @GetMapping("/book/{bookId}")
    public String toEditPage(@PathVariable("bookId") Integer bookId, Model model){
        model.addAttribute("bookSorts",bookSortService.selectAll());
        if (!StringUtils.isEmpty(String.valueOf(bookId))) {
            model.addAttribute("book",bookService.selectByPrimaryKey(bookId));
        }
        return "book/add";
    }

    /**
     * 修改图书
     * @param bookEntity
     * @return redirect:/books
     */
    @PutMapping("/book")
    public String updateBook(BookEntity bookEntity){
        bookService.updateByPrimaryKeySelective(bookEntity);
        return "redirect:/books";
    }

    /**
     * 删除图书
     * @param bookId
     * @return redirect:/books
     */
    @DeleteMapping("/book/{bookId}")
    public String deleteBook(@PathVariable("bookId") Integer bookId){
        bookService.deleteByPrimaryKey(bookId);
        return "redirect:/books";
    }
}
