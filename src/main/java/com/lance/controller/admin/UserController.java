package com.lance.controller.admin;

import com.lance.entity.UserEntity;
import com.lance.service.impl.UserServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author lance
 */
@Controller
@RequestMapping("/admin")
public class UserController {
    @Resource
    private UserServiceImpl userService;

    /**
     * 用户列表
     * @param model
     * @return user/list
     */
    @GetMapping("/users")
    public String list(Model model){
        List<UserEntity> users = userService.selectAll();
        model.addAttribute("users",users);
        return "admin/user/list";
    }

    /**
     *去到添加页面
     * @return user/add
     */
    @GetMapping("/user")
    public String toAddPage(){

        return "admin/user/add";
    }

    /**
     * 添加用户
     * @return redirect:/users
     */
    @PostMapping("/user")
    public String addUser(UserEntity userEntity){
        userService.insert(userEntity);
        return "redirect:/admin/users";
    }

    /**
     * 去修改页面
     * @param userId
     * @param model
     * @return user/add
     */
    @GetMapping("/user/{userId}")
    public String toEditPage(@PathVariable("userId") Integer userId,Model model){
        UserEntity user = userService.selectByPrimaryKey(userId);
        model.addAttribute("user",user);
        System.out.println(user);
        return "admin/user/add";
    }

    /**
     * 修改用户
     * @param userEntity
     * @return redirect:/users
     */
    @PutMapping("/user")
    public String updateUser(UserEntity userEntity){
        userService.updateByPrimaryKeySelective(userEntity);
        return "redirect:/admin/users";
    }

    /**
     * 删除用户
     * @param userId
     * @return redirect:/users
     */
    @DeleteMapping("/user/{userId}")
    public String deleteUser(@PathVariable("userId") Integer userId){
        userService.deleteByPrimaryKey(userId);
        return "redirect:/admin/users";
    }
}
