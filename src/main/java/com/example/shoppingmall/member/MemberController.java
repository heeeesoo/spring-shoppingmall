package com.example.shoppingmall.member;

import com.example.shoppingmall.utils.ApiUtils;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static com.example.shoppingmall.member.Member.fromDtoToEntity;
import static com.example.shoppingmall.utils.ApiUtils.error;
import static com.example.shoppingmall.utils.ApiUtils.success;

@Slf4j
@AllArgsConstructor
@RestController
public class MemberController {

    MemberService memberService;

    @GetMapping("/datasource")
    public void makeConnection() {
        memberService.makeConnection();
    }


//    @PostMapping("/join/res/en") // Before
//    public ResponseEntity<String> joinByResponseEntity(@RequestBody Member member) {
//        log.info(member.toString());
//
//        if(isDuplicateId(member))
//            return new ResponseEntity<>(null, HttpStatus.CONFLICT);
//
//        String userId = memberService.join(member);
//        return new ResponseEntity<>(userId, HttpStatus.OK);
//    }

    @PostMapping("/join/api/result") // After
    public ApiUtils.ApiResult<String> joinByApiResult(@RequestBody MemberDto memberDto) {

        if (isDuplicateId(memberDto))
            return error("아이디 중복", HttpStatus.CONFLICT);

        Member requestMember =
//                new Member(memberDto);
                memberDto.convertToEntity();
        // fromDtoToEntity(memberDto);
        String userId = memberService.join(requestMember);
        return success(userId);
    }

//    @GetMapping("/users/{userId}")
//    public ApiUtils.ApiResult<Member> findUserByUserId(@PathVariable String userId) {
//        Member findMember = memberService.memberRepository.findById(userId);
//        return success(findMember);
//    }

    @PostMapping("/login")
    public ApiUtils.ApiResult<String> login(@RequestBody LoginRequestDto loginRequestDto) {
        System.out.println("userId - " + loginRequestDto.getUserId());
        Member findMemberByUserId = memberService.getMemberByUserId(loginRequestDto.getUserId());
        if(loginRequestDto.getPw().equals(findMemberByUserId.getPw())){
            return success("login success");
        }
        return error("login error",HttpStatus.BAD_REQUEST);
    }

    private boolean isDuplicateId(MemberDto memberDto) {
        return memberService.checkDuplicateId(memberDto.getUserId());
    }
}
