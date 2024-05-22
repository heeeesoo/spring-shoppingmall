package com.example.shoppingmall.member;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class MemberDto {

    // MemberRequestDto(id 없음), MemberResponseDto(id 있음)
    // SignUpReqDto, SignUpResDto
    // LoginReqDto, LoginResDto

    private int id;
    private String userId;
    private String pw;
    private String name;
    private String email;
    private String contact;

    public Member convertToEntity() {
        return new Member(userId, pw, name, email, contact);
//        return new Member(id, userId, pw, name, email, contact);
    }
}
