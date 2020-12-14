package com.lance.controller.admin;

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
import java.io.File;
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

    /**上传地址*/
    @Value("${file.path}")
    private  String filePath;

    /**
     * 图书列表
     * @param model
     * @return book/list
     */
    @GetMapping("/admin/books")
    public String list(Model model){
        List<BookDto> books = bookService.selectAll();
        model.addAttribute("books",books);
        return "admin/book/list";
    }
    /**
     *去到添加页面
     * @return book/add
     */
    @GetMapping("/admin/book")
    public String toAddPage(Model model){
        List<BookSortEntity> bookSorts = bookSortService.selectAll();
        model.addAttribute("bookSorts",bookSorts);
        return "admin/book/add";
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
    @PostMapping("/admin/book")
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
        return "redirect:/admin/books";
    }

    /**
     * 去编辑页面
     * @param bookId
     * @param model
     * @return book/add
     */
    @GetMapping("/admin/book/{bookId}")
    public String toEditPage(@PathVariable("bookId") Integer bookId, Model model){
        model.addAttribute("bookSorts",bookSortService.selectAll());
        if (!StringUtils.isEmpty(String.valueOf(bookId))) {
            model.addAttribute("book",bookService.selectByPrimaryKey(bookId));
        }
        return "admin/book/add";
    }

    /**
     * 修改图书
     * @param bookEntity
     * @return redirect:/books
     */
    @PutMapping("/admin/book")
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
        return "redirect:/admin/books";
    }

    /**
     * 删除图书
     * @param bookId
     * @return redirect:/books
     */
    @DeleteMapping("/admin/book/{bookId}")
    public String deleteBook(@PathVariable("bookId") Integer bookId){
        bookService.deleteByPrimaryKey(bookId);
        return "redirect:/admin/books";
    }

    @PostMapping("/admin/sbook")
    public String findByConcat(String text,Model model){
        List<BookDto> books = bookService.findByConcat(text);
        model.addAttribute("books",books);
        return "admin/book/list";
    }
}
