package com.example.dockersampler;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {


    @GetMapping("/hello")
    public String helloEmpty() {
        return "Hello";
    }

    @GetMapping("/hello3")
    public String helloEmpty2() {
        return "Hello3";
    }

    @GetMapping("/hello/{param}")
    public String hello(@PathVariable String param ) {
        return "Hello: " + param.toUpperCase();
    }

    @GetMapping("/hello2")
    public String hello2(@RequestParam(name = "name") String name ) {
        return "Hello: " + name.toUpperCase();
    }

}