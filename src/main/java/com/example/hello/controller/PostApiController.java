package com.example.hello.controller;

import com.example.hello.dto.PostRequestDto;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api/posttest")
public class PostApiController {

    @PostMapping("/post1")
    public void post1(@RequestBody Map<String, Object> requestData) {
        requestData.forEach((key, val) -> {
            System.out.println("key: " + key);
            System.out.println("val: " + val);
        });
    }

    @PostMapping("/post2")
    public void post2(@RequestBody PostRequestDto requestData) {
        System.out.println(requestData.toString());
        System.out.println("한글!");
    }



}
