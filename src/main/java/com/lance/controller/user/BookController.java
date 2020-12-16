package com.lance.controller.user;

import com.lance.dto.BookDto;
import com.lance.entity.BookEntity;
import com.lance.entity.BookSortEntity;
import com.lance.service.impl.BookServiceImpl;
import com.lance.service.impl.BookSortServiceImpl;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.thymeleaf.util.StringUtils;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.util.List;

/**
 * @author lance
 * @version 1.0
 * @date 2020/12/14 17:39
 */
@Controller("userBook")
@RequestMapping("/user")
public class BookController {
    @Resource
    private BookServiceImpl bookService;
    @Resource
    private BookSortServiceImpl bookSortService;

    /**上传地址*/
    @Value("${file.path}")
    private  String filePath;

    /**
     * 图书列表
     * @param model
     * @return book/list
     */
    @GetMapping("/books")
    public String list(Model model){
        List<BookDto> books = bookService.selectAll();
        model.addAttribute("books",books);
        return "user/book/list";
    }

    /**
     * 图书列表
     * @param model
     * @return myBook/list
     */
    @GetMapping("/myBooks")
    public String MyBooksList(@RequestParam(value = "userId",required=false) Integer userId, Model model){
        List<BookDto> books = bookService.selectAllByPrimaryKey(userId);
        model.addAttribute("books",books);
        return "user/myBook/list";
    }


    /**
     *去到添加页面
     * @return book/add
     */
    @GetMapping("/book")
    public String toAddPage(Model model){
        List<BookSortEntity> bookSorts = bookSortService.selectAll();
        model.addAttribute("bookSorts",bookSorts);
        return "user/myBook/add";
    }

    /**
     * 按文件名获取后缀名的方法
     * @param filename 文件名
     * @return 后缀名
     */
    private String getSuffix(String filename){
        return filename.substring(filename.lastIndexOf("."));
    }

    /**
     * 添加书籍
     * @return redirect:/books
     */
    @PostMapping("/book")
    public String addBook(@RequestParam("file") MultipartFile file, BookEntity bookEntity){
        //上传缩略图图片
        if(file!=null&&!file.getOriginalFilename().equals("")) {
            String oldName = file.getOriginalFilename();
            //获取上传文件原文件名
            String suffix = getSuffix(oldName);
            //获取原文件的后缀名
            String newName = System.currentTimeMillis() + suffix;
            //创建新文件名
            String path = filePath + "rotPhoto/";
            // 定义上传文件保存路径
            File filepath = new File(path, newName);
            //创建新文件
            if (!filepath.getParentFile().exists()) {
                filepath.getParentFile().mkdirs();
            }
            try {
                file.transferTo(new File(path + File.separator + newName));
                //把上传文件file的内容写到saveFile中
                System.out.println("缩略图图片上传成功！");
            } catch (Exception e) {
                e.printStackTrace();
            }
            bookEntity.setImgUrl("/images/rotPhoto/"+newName);
        }
        bookService.insert(bookEntity);
        return "redirect:/user/books";
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
        return "user/myBook/add";
    }
    /**
     * 修改图书
     * @param bookEntity
     * @return redirect:/books
     */
    @PutMapping("/book")
    public String updateBook(@RequestParam("file") MultipartFile file,BookEntity bookEntity){
        if(file!=null&&!file.getOriginalFilename().equals("")) {
            String oldName = file.getOriginalFilename();
            //获取上传文件原文件名
            String suffix = getSuffix(oldName);
            //获取原文件的后缀名
            String newName = System.currentTimeMillis() + suffix;
            //创建新文件名
            String path = filePath + "rotPhoto/";
            // 定义上传文件保存路径
            File filepath = new File(path, newName);
            //创建新文件
            if (!filepath.getParentFile().exists()) {
                filepath.getParentFile().mkdirs();
            }
            try {
                file.transferTo(new File(path + File.separator + newName));
                //把上传文件file的内容写到saveFile中
                System.out.println("缩略图图片上传成功！");
            } catch (Exception e) {
                e.printStackTrace();
            }
            bookEntity.setImgUrl("/images/rotPhoto/"+newName);
        }
        bookService.updateByPrimaryKeySelective(bookEntity);
        return "redirect:/user/books";
    }

    /**
     * 删除图书
     * @param bookId
     * @return redirect:/books
     */
    @DeleteMapping("/book")
    public String deleteBook(@RequestParam(value = "bookId",required = false) Integer bookId,Model model){
        bookService.deleteByPrimaryKey(bookId);
        return "redirect:/user/myBooks";
    }

    @PostMapping("/sbook")
    public String findByConcat(String text,Model model){
        List<BookDto> books = bookService.findByConcat(text);
        model.addAttribute("books",books);
        return "user/book/list";
    }
}
