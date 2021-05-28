package com.example.demo.security;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SecurityControler {

    @GetMapping("/error")
    public String error(){
        return "error";
    }
}
