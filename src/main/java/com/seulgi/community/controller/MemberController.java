package com.seulgi.community.controller;

import com.seulgi.community.DTO.UserReqDto;
import com.seulgi.community.DTO.UserResDto;
import com.seulgi.community.comm.ProjectVersion;
import com.seulgi.community.service.MemberService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping(MemberController.URL.BASE)
public class MemberController {

    public static class URL {
        public static final String BASE = ProjectVersion.VERSION + "/member";
    }

    private final MemberService memberService;

    @PostMapping("/signIn")
    public UserResDto.SingIn signIn(HttpServletRequest request, @RequestBody UserReqDto.SingIn req) {
        try {
            return memberService.signIn(req);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @DeleteMapping("/signOut")
    public Object signOut(HttpServletRequest request, @RequestBody UserReqDto.SingOut req) {
        try {
            return memberService.signOut(req);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }


}
