package org.zerock.boardex.controller;

import lombok.Getter;
import lombok.extern.log4j.Log4j2;
import org.springframework.mock.web.MockAsyncContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/todo")
@Log4j2
public class TodoController {
    @RequestMapping("/list")
    public void list(Model model){
        log.info("todo 리스트");
    }

    @GetMapping("/register")
    public void registerGET(){
        log.info("GET todo register..........");
    }

}
