package com.example.hello.controller;

import com.example.hello.dto.Req;
import com.example.hello.dto.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/server")
@Slf4j
public class ServerApiController {

    @GetMapping("/hello")
    public User hello(@RequestParam String name) {
        User user = new User();
        user.setName(name);
        user.setAge(15);
        return user;
    }

    @PostMapping("/user/{userId}/name/{userName}")
    public Req<User> post(
                     @RequestBody Req<User> req,
                     @PathVariable int userId,
                     @PathVariable String userName,
                     @RequestHeader("x-authorization") String authorization,
                     @RequestHeader("custom-header") String customHeader
    ) {
        log.info("client req : {}", req);
        log.info("userId : {}", userId);
        log.info("userName : {}", userName);
        log.info("authorization : {}", authorization);
        log.info("customHeader : {}", customHeader);
        Req<User> response = new Req<>();
        response.setHeader(req.getHeader());
        response.setResponseBody(req.getResponseBody());

        return response;
    }

}
