package com.example.shoppingmall.member;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class MemberService {

    MemberRepository memberRepository;

    public String join(Member member) {
        return memberRepository.save(member);
    }

    public boolean checkDuplicateId(String userId) {
        Member existMember
            = memberRepository.findByUserId(userId);

        if (existMember == null)
            return false;
        else
            return true;
    }

    public void makeConnection() {
        memberRepository.makeConnection();
    }

    public Member getMemberByUserId(String userId) {
        return memberRepository.getMemberByUserId(userId);
    }
}
