package com.lance.controller;

import com.lance.entity.UserEntity;
import com.lance.service.impl.UserServiceImpl;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.thymeleaf.util.StringUtils;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * @author lance
 */
@Controller
@Log4j2
public class UserLoginController {
    @Resource
    private UserServiceImpl userService;
    public static String ok = "ok";
    public static String admin = "admin";

    @PostMapping(value = "/login")
    public String login (@RequestParam("username") String username,
                         @RequestParam("password") String password, Model model, HttpSession session) {
        if (!StringUtils.isEmpty(username)) {
            Map<String, Object> resultMap = userService.login(username,password);
            if((Boolean)resultMap.get(ok)){
                session.setAttribute("loginUser",resultMap.get("loginUser"));
                session.setAttribute("userEntity",resultMap.get("userEntity"));
                log.info("user login success 添加用户到 session");
                if ((Boolean)resultMap.get(admin)){
                    session.setAttribute("loginAdmin",admin);
                return "redirect:/admin.html";
                }
                return "redirect:/main.html";
            }else {
                session.invalidate();
                model.addAttribute("msg",resultMap.get("error"));
                return "login";
            }
            }
        return "login";
    }
    @GetMapping("/signOut")
    public String signOut(HttpSession session){
        session.invalidate();
        return "login";
    }
}
