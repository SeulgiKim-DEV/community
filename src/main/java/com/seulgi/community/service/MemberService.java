package com.seulgi.community.service;

import com.seulgi.community.DTO.UserModel;
import com.seulgi.community.entity.Member;
import com.seulgi.community.entity.MemberAccessHistory;
import com.seulgi.community.repository.MemberAccessHistoryRepository;
import com.seulgi.community.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MemberService {
    private final MemberRepository memberRepository;
    private final MemberAccessHistoryRepository memberAccessHistoryRepository;

    public UserModel.logInResponse logIn(UserModel.logInRequest req) {
        Member member = memberRepository.findByLogInIdAndPassword(
                        req.getLogInId(),
                        req.getPassword()
                ).orElseThrow(()-> new RuntimeException("아이디(로그인 전용 아이디) 또는 비밀번호를 잘못 입력했습니다.\n" + "입력하신 내용을 다시 확인해주세요."));

        MemberAccessHistory.builder()
                            .member(member)
                            .accessTime(LocalDateTime.now())
                            .build();

        return UserModel.logInResponse.create(member);
    }

    public Object logOut(UserModel.logOutRequest req) {
       // Member member = memberRepository.findById(req.getMemberId()).orElseThrow(()-> new RuntimeException("회원 정보를 확인해주세요."));
        return null;
    }

    public UserModel.signUpResponse signUp(UserModel.signUpRequest req) {
        if (!req.getPassword().equals(req.getCheckPassword())){
            throw new RuntimeException("비밀번호를 확인해 주세요.");
        }
        Member member = Member.builder()
                .loginId(req.getLogInId())
                .password(req.getPassword())
                .email(req.getEmail())
                .phoneNumber(req.getPhoneNumber())
                .userName(req.getUserName())
        .build();
        return UserModel.signUpResponse.info(member);
    }

    public UserModel.helpAccountResponse helpAccount(UserModel.helpAccountRequest req) {
        Member searchMember = memberRepository.findByLogInIdAndResign(req.getLogInId(), false).orElseThrow(()-> new RuntimeException("회원 정보를 확인해주세요."));
        return UserModel.helpAccountResponse.builder()
                .memberId(searchMember.getId())
                .logInId(searchMember.getLogInId())
                .build();
    }

    public void changePassword(UserModel.changePasswordRequest req) {
        if (!req.getPassword().equals(req.getCheckPassword())){
            throw new RuntimeException("비밀번호를 확인해 주세요.");
        }
        Member searchMember = memberRepository.findById(req.getMemberId()).orElseThrow(()-> new RuntimeException("회원 정보를 확인해주세요."));
        searchMember.changePassword(req.getMemberId(),req.getPassword());
    }

    public void resign (UserModel.resignRequest req) {
        Member searchMember = memberRepository.findById(req.getMemberId()).orElseThrow(()-> new RuntimeException("회원 정보를 확인해주세요."));
        searchMember.resignMember();
    }

    public UserModel.searchMemberResponse searchMember (String logInId) {
        List<Member> resultMember = memberRepository.findByLogInId(logInId);
       // return UserModel.searchMemberResponse.info(resultMember);
        return null;
    }

    public void modifyMemberInfo (@RequestBody UserModel.modifyMemberInfoRequest req, @PathVariable String logInId) {
        Member searchMember = memberRepository.findByLogInIdAndResign(logInId, false).orElseThrow(()-> new RuntimeException("회원 정보를 확인해주세요."));
        searchMember.updatedMemberInfo(req.getUserName(), req.getPhoneNumber());
    }

}
