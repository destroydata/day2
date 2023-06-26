package com.naver.user.controller;

import com.naver.user.domain.dto.User;
import com.naver.user.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/user")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/login")
    public String getLoginPage(){
        return "/user/login";
    }
    @GetMapping("/signup")
    public String getSignup(){
        return "/user/signup";
    }
    @PostMapping("/login")
    public ModelAndView postLogin(HttpServletRequest res
            , @RequestParam("id") String id
            , @RequestParam("pw") String pw
            , @RequestParam(value = "idSave", required = false) Boolean idSave
            , @ModelAttribute User user
            , ModelAndView mav
            , HttpSession session
          ){
        if(idSave==null) idSave = false;
        if(userService.login(id, pw)){
            session.setAttribute("id", id);
            mav.setViewName("redirect:/main");
        }else {
            mav.setViewName("redirect:/user/login");
            if(idSave)
                mav.addObject("id",id);
        }

        return mav;
    }

    @PostMapping("/signup")
    public ModelAndView signup(HttpServletRequest res
            , @RequestParam("id") String id
            , @RequestParam("pw") String pw
            , @RequestParam("name") String name
            , ModelAndView mav
    ){
        if(userService.signup(id, pw, name)){
            mav.setViewName("redirect:/user/login");
        }else {
            mav.setViewName("redirect:/user/signup");
        }
        return mav;
    }

}
