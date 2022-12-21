package com.example.hello.controller;

import com.example.hello.component.Calculator;
import com.example.hello.dto.CalReq;
import com.example.hello.dto.CalRes;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/calculator")
@RequiredArgsConstructor
public class CalculatorApiController {

    private final Calculator calculator;

    @GetMapping("/sum")
    public int sum(@RequestParam int x, @RequestParam int y) {
        return calculator.sum(x, y);
    }

    @PostMapping("/minus")
    public CalRes minus(@RequestBody CalReq req) {
        int result = calculator.minus(req.getX(), req.getY());
        CalRes res = new CalRes();
        res.setResult(result);
        res.setResponse(new CalRes.Body());
        return res;
    }
}
