package com.example.hello.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CalRes {

    private int result;
    private Body response;

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Body {
        private String resultCode = "OK";
    }
}
