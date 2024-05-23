package com.example.shoppingmall.member;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class MemberService {

    MemberRepository memberRepository;

    @Autowired
    private MemberJPARepository memberJPARepository;

    @Transactional
    public String join(Member member) {
//        memberRepository.save(member);
        memberJPARepository.save(member);

        Member resultMember = memberJPARepository.findByUserId(member.getUserId())
                .orElseThrow(() -> new IllegalArgumentException("member doesn't exist"));

//        String userId = memberRepository
//                .findByUserId(member.getUserId())
//                .getUserId();
//
//        System.out.println("예외처리를 해도 트랜잭션은 마무리 될까요?");

        return resultMember.getUserId();
    }

    public boolean checkDuplicateId(String userId) {
//        Member existMember
//            = memberRepository.findByUserId(userId);

        Member existMember = memberJPARepository.findByUserId(userId)
                .orElseThrow(() -> new IllegalArgumentException("member doesn't exist"));

        if (existMember == null)
            return false;
        else
            return true;
    }
}
