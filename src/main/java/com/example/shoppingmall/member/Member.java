package com.example.shoppingmall.member;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
//@AllArgsConstructor
public class Member {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int id;

    private String userId;
    private String pw;
    private String name;

    private String email;
    private String contact;

    public Member( String userId, String pw, String name, String email, String contact) {
        this.userId = userId;
        this.pw = pw;
        this.name = name;
        this.email = email;
        this.contact = contact;
    }

    public Member() {
        // Default constructor
    }
    public static Member fromDtoToEntity(MemberDto memberDto) {
        return new Member(
//                memberDto.getId(),
                memberDto.getUserId(),
                memberDto.getPw(),
                memberDto.getName(),
                memberDto.getEmail(),
                memberDto.getContact()
        );
    }

    @Override
    public String toString() {
        return "Member{" +
                "userId='" + userId + '\'' +
                ", pw='" + pw + '\'' +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", contact='" + contact + '\'' +
                '}';
    }
}
