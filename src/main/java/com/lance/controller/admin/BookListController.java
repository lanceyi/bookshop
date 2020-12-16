package com.lance.controller.admin;

import com.lance.dto.BookListDto;
import com.lance.entity.BookEntity;
import com.lance.entity.BookListEntity;
import com.lance.entity.BookSortEntity;
import com.lance.service.impl.BookListServiceImpl;
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
 * @date 2020/12/16 15:49
 */
@Controller("adminBookList")
@RequestMapping("/admin")
public class BookListController {
    @Resource
    private BookListServiceImpl bookListService;

    /**上传地址*/
    @Value("${file.path}")
    private  String filePath;


    /**
     * 按文件名获取后缀名的方法
     * @param filename 文件名
     * @return 后缀名
     */
    private String getSuffix(String filename){
        return filename.substring(filename.lastIndexOf("."));
    }


    @GetMapping("/bookLists")
    public String list(Model model){
        List<BookListDto> bookLists = bookListService.selectAll();
        model.addAttribute("bookLists",bookLists);
        return "admin/bookList/list";
    }

    /**
     * 去编辑页面
     * @param bookListId
     * @param model
     * @return book/add
     */
    @GetMapping("/bookList/{bookListId}")
    public String toEditPage(@PathVariable("bookListId") Integer bookListId, Model model){
        model.addAttribute("bookList",bookListService.selectByPrimaryKey(bookListId));
        return "admin/bookList/add";
    }

    /**
     * 修改图书
     * @param bookListEntity
     * @return redirect:/books
     */
    @PutMapping("/bookList")
    public String updateBook(@RequestParam("file") MultipartFile file, BookListEntity bookListEntity){
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
            bookListEntity.setImgUrl("/images/rotPhoto/"+newName);
        }
        bookListService.updateByPrimaryKeySelective(bookListEntity);
        return "redirect:/admin/bookLists";
    }

    /**
     * 删除我的图书
     * @param bookListId
     * @return redirect:/admin/bookLists
     */
    @DeleteMapping("/bookList/{bookListId}")
    public String deleteBook(@PathVariable("bookListId") Integer bookListId){
        bookListService.deleteByPrimaryKey(bookListId);
        return "redirect:/admin/bookLists";
    }
}
