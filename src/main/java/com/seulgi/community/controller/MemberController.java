package com.seulgi.community.controller;

import com.seulgi.community.DTO.UserModel;
import com.seulgi.community.comm.ProjectVersion;
import com.seulgi.community.service.MemberService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping(MemberController.BASE_URL)
public class MemberController {

    public static final String BASE_URL = ProjectVersion.VERSION + "/member";

    private final MemberService memberService;

    @PostMapping("/login")
    public UserModel.logInResponse login(HttpServletRequest request, @RequestBody UserModel.logInRequest req){
        return memberService.logIn(req);
    }

    @DeleteMapping("/logOut")
    public Object logOut(HttpServletRequest request, @RequestBody UserModel.logOutRequest req) {
        return memberService.logOut(req);
    }

    @PostMapping("/signIn")
    public UserModel.signInResponse signIn (HttpServletRequest request, @RequestBody UserModel.signUpRequest req) {
        return memberService.signIn(req);
    }


}
