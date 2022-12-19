package com.example.hello.controller;

import com.example.hello.dto.UserRequest;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/gettest")
public class GetApiController {

    @GetMapping("/hello")
    public String getHello() {
        return "get Hello";
    }

    @GetMapping("/path-variable/{name}")
    public  String pathVariable(@PathVariable String name) {
        System.out.println("PathVariable: " + name);
        return name;
    }

    @GetMapping("/query-param")
    public String queryParam(@RequestParam Map<String, String> queryParam) {
        StringBuilder sb = new StringBuilder();
        queryParam.entrySet().forEach(entry -> {
           System.out.println(entry.getKey());
           System.out.println(entry.getValue());
           System.out.println("\n");
           sb.append(entry.getKey() + " = " + entry.getValue() + "\n");
        });
        return sb.toString();
    }

    @GetMapping("/query-param2")
    public String queryParam2(@RequestParam String name, @RequestParam String email, @RequestParam int age) {
        return name + " " + email + " " + age;
    }

    @GetMapping("/query-param3")
    public String queryParam3(UserRequest userRequest) {
        System.out.println(userRequest.getName());
        System.out.println(userRequest.getEmail());
        System.out.println(userRequest.getAge());
        return userRequest.toString();
    }
}
