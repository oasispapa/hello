package com.example.hello.controller;

import com.example.hello.annotation.Decode;
import com.example.hello.annotation.Timer;
import com.example.hello.dto.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Slf4j
@RestController
@RequestMapping("/api")
public class ApiController {

    @PostMapping("/filtertest")
    public User filterTest(@RequestBody User user){
        return user;
    }

    @PostMapping("/user1")
    public ResponseEntity user(@Valid @RequestBody User user, BindingResult bindingResult) {
        // System.out.println(user);
        if (bindingResult.hasErrors()) {
            StringBuilder sb = new StringBuilder();
            bindingResult.getAllErrors().forEach(objectError -> {
                FieldError field = (FieldError) objectError;
                String msg = objectError.getDefaultMessage();
                //System.out.println("Field : " + field.getField());
                //System.out.println("Msg : " + msg);
                sb.append("field : " + field.getField());
                sb.append("message : " + msg);
            });
            return ResponseEntity.badRequest().body(sb.toString());
        } else {
            return ResponseEntity.ok(user);
        }
    }
    @GetMapping("/exception/500")
    public int getException(@RequestParam(required = false) String name, @RequestParam(required = false) Integer age) {
        int a = age + 10;
        return a;
    }

    @PostMapping("/exception/400")
    public User postException(@Valid @RequestBody User user) {
        int a = user.getAge();
        return user;
    }

    @GetMapping("/get/{id}")
    public String get(@PathVariable Long id, @RequestParam String name) {
        //System.out.println("ID : " + id);
        //System.out.println("name : " + name);
        return id + " " + name;
    }

    @PostMapping("/post")
    public User post(@RequestBody User user) {
        //System.out.println("user : " + user);
        return user;
    }

    @Timer
    @DeleteMapping("/delete")
    public void delete() throws InterruptedException {

        Thread.sleep(1000*2);
    }

    @Decode
    @PutMapping("/put")
    public User put(@RequestBody User user) {
        //System.out.println("user : " + user);
        return user;
    }
}
