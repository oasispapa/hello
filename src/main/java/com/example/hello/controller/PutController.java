package com.example.hello.controller;

import com.example.hello.dto.PostRequestDto;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/puttest")
public class PutController {

    @PutMapping("/put1")
    public void put1(@RequestBody PostRequestDto dto) {
        System.out.println(dto);
    }
    @PutMapping("/put2/{userId}")
    public void put2(@RequestBody PostRequestDto dto, @PathVariable(name="userId") Long id) {
        System.out.println(dto);
    }
}
