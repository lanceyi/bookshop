package com.lance.controller.admin;

import com.lance.entity.BookSortEntity;
import com.lance.service.impl.BookSortServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author lance
 */
@Controller
public class BookSortController {
    @Resource
    private BookSortServiceImpl bookSortService;

    /**
     * 分类列表
     * @param model
     * @return bookSort/list
     */
    @GetMapping("/bookSorts")
    public String list(Model model){
        List<BookSortEntity> bookSorts = bookSortService.selectAll();
        model.addAttribute("bookSorts",bookSorts);
        return "bookSort/list";
    }

    /**
     * 去到添加页面
     * @return bookSort/add
     */
    @GetMapping("bookSort")
    public String toAddPage(){
        return "bookSort/add";
    }

    /**
     * 添加分类
     * @param bookSortEntity
     * @return "redirect:/bookSorts"
     */
    @PostMapping("/bookSort")
    public String addBookSort(BookSortEntity bookSortEntity){
        bookSortService.insert(bookSortEntity);
        return "redirect:/bookSorts";
    }

    /**
     * 去修改页面
     * @param bookSortId
     * @param model
     * @return bookSort/add
     */
    @GetMapping("/bookSort/{bookSortId}")
    public String toEditPage(@PathVariable("bookSortId") Integer bookSortId,Model model){
        model.addAttribute("bookSort",bookSortService.selectByPrimaryKey(bookSortId));
        return "bookSort/add";
    }

    /**
     * 修改分类
     * @param bookSortEntity
     * @return redirect:/bookSorts
     */
    @PutMapping("/bookSort")
    public  String updateBookSort(BookSortEntity bookSortEntity){
    bookSortService.updateByPrimaryKeySelective(bookSortEntity);
    return "redirect:/bookSorts";
    }

    /**
     * 删除分类
     * @param bookSortId
     * @return
     */
    @DeleteMapping("/bookSort/{bookSortId}")
    public String deleteBookSort(@PathVariable("bookSortId") Integer bookSortId){
        bookSortService.deleteByPrimaryKey(bookSortId);
        return "redirect:/bookSorts";
    }
}
