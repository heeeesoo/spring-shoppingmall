package com.example.shoppingmall.member;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
public class LoginRequestDto {
    @JsonProperty("user_id")
    private String userId;
    private String pw;
}
