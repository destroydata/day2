package com.naver.user.controller;


import com.naver.user.service.TodoService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MainController {
    private final TodoService todoService;

    public MainController(TodoService todoService) {
        this.todoService = todoService;
    }

    @GetMapping("/main")
    public ModelAndView showMain(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/todos/main");
//         투두 리스트 가져다 줘야하고
        modelAndView.addObject("todolist", todoService.findAll());
        return modelAndView;
    }
}
