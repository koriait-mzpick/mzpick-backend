package com.koreait.mzpick_backend.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/")
public class MainController {

    @GetMapping("")
    public String main(){
        return "Mz Pick Backend(spring) Server on...";
    }
}
