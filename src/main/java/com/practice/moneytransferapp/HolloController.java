package com.practice.moneytransferapp;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HolloController {

    @GetMapping("/")
    public String sayHello(){
        return "Hello from my local pratice";
    }

    @GetMapping("/{name}")
    public String sayHello(@PathVariable String name){
        return "Hello " + name + "!";
    }
}
