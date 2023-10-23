package com.seulgi.community.service;

import com.seulgi.community.DTO.UserModel;
import com.seulgi.community.entity.Member;
import com.seulgi.community.entity.MemberAccessHistory;
import com.seulgi.community.repository.MemberAccessHistoryRepository;
import com.seulgi.community.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class MemberService {
    private final MemberRepository memberRepository;
    private final MemberAccessHistoryRepository memberAccessHistoryRepository;

    public UserModel.logInResponse logIn(UserModel.logInRequest Req){
        Member member = memberRepository.findByLogInIdAndPassword(
                        Req.getLogInId(),
                        Req.getPassword()
                ).orElseThrow(()-> new RuntimeException("아이디(로그인 전용 아이디) 또는 비밀번호를 잘못 입력했습니다.\n" + "입력하신 내용을 다시 확인해주세요."));

        MemberAccessHistory.builder()
                            .member(member)
                            .accessTime(LocalDateTime.now())
                            .build();

        return UserModel.logInResponse.create(member);
    }

    public Object logOut(UserModel.logOutRequest Req) {
       // Member member = memberRepository.findById(Req.getMemberId()).orElseThrow(()-> new RuntimeException("회원 정보를 확인해주세요."));
        return null;
    }

    public UserModel.signInResponse signIn(UserModel.signUpRequest Req){
        if (!Req.getPassword().equals(Req.getCheckPassword())){
            throw new RuntimeException("비밀번호를 확인해 주세요.");
        }
        Member member = Member.builder()
                .loginId(Req.getLogInId())
                .password(Req.getPassword())
                .email(Req.getEmail())
                .phoneNumber(Req.getPhoneNumber())
                .userName(Req.getUserName())
        .build();
        return UserModel.signInResponse.info(member);
    }



}
