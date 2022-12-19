package com.example.hello.dto;

import com.example.hello.annotation.YearMonth;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @NotBlank
    private String id;
    private String name;
    @Max(value = 90)
    @NotNull
    private Integer age;
    private String pw;
    @Email
    private String email;
    @Pattern(regexp = "^\\d{2,3}-\\d{3,4}-\\d{4}$", message = "핸드폰 번호의 양식과 맞지 않습니다. XXX-XXX(X)-XXXX")
    private String phoneNumber;

    @YearMonth
    private String reqYearMonth; //yyyyMM


    /*@AssertTrue(message = "연월 (yyyyMM) 의 형식에 맞지 않습니다. ")
    public boolean isReqYearMonthValidation() {
        try {
            LocalDate localDate = LocalDate.parse(getReqYearMonth() + "01", DateTimeFormatter.ofPattern("yyyyMMdd"));
        } catch (Exception e) {
            return false;
        }
        return true;
    }*/


}
