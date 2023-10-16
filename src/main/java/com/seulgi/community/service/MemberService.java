package com.seulgi.community.service;

import com.seulgi.community.DTO.UserReqDto;
import com.seulgi.community.DTO.UserResDto;
import com.seulgi.community.entity.Member;
import com.seulgi.community.entity.MemberAccessHistory;
import com.seulgi.community.repository.MemberAccessHistoryRepository;
import com.seulgi.community.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class MemberService {
    private final MemberRepository memberRepository;
    private final MemberAccessHistoryRepository memberAccessHistoryRepository;

    public UserResDto.SingIn signIn(UserReqDto.SingIn Req) {
        Member member = memberRepository.findByLogInIdAndPassword(Req.getLogInId(), Req.getPassword())
                .orElseThrow(()-> new RuntimeException("아이디(로그인 전용 아이디) 또는 비밀번호를 잘못 입력했습니다.\n" + "입력하신 내용을 다시 확인해주세요."));
        UserResDto.SingIn res = new UserResDto.SingIn(member.getId(), member.getLogInId(), member.getEmail(),
                                member.getPhoneNumber(), member.getLevel(), member.getPoint(), member.getGrade(), member.getStatus());
        return res;
    }

    public Object signOut(UserReqDto.SingOut Req) {
        Member member = memberRepository.findById(Req.getMemberId()).orElseThrow(()-> new RuntimeException("회원 정보를 확인해주세요."));
        return MemberAccessHistory.builder()
                .member(member)
                .accessTime(LocalDateTime.now())
                .build();
    }



}
