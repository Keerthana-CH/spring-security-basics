package com.yt.javabrains.springsecuritybasics.resources;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class ResourceEx {

    @GetMapping
    public String getWelcomePage(){
        return "Welcome";
    }
}
