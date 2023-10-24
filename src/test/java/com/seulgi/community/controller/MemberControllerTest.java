package com.seulgi.community.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.seulgi.community.CommunityApplication;
import com.seulgi.community.DTO.UserModel;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;

import java.net.URI;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@ContextConfiguration(classes = CommunityApplication.class)
class MemberControllerTest {

    private final ObjectMapper objectMapper;
    @Autowired
    private MockMvc mvc;

    @Autowired
    public MemberControllerTest(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    @Test
    void login() throws Exception {
        URI uri = URI.create(MemberController.BASE_URL + "/login");

        UserModel.logInRequest req = UserModel.logInRequest.builder()
                .logInId("ddd")
                .password("qwe").build();

        var mvcResult = mvc.perform(
                                     get(uri)
                                    .content(objectMapper.writeValueAsBytes(req))
        ).andDo(print()).andExpect(status().isOk()).andReturn();

    }

    @Test
    void logOut() {
    }

    @Test
    @Rollback(value = false)
    @Transactional
    void signIn() throws Exception {
        URI uri = URI.create(MemberController.BASE_URL + "/signUp");

        UserModel.signUpRequest req = UserModel.signUpRequest.builder()
                .logInId("sgkim")
                .password("qwe123")
                .checkPassword("qwe123")
                .email("serena.sg.kim@gmail.com")
                .phoneNumber("01055557888")
                .userName("김슬기테스트용")
                .build();

        var mvcResult = mvc.perform(
                post(uri)
                        //.header(HttpHeaders.AUTHORIZATION)
                        .contentType(MediaType.APPLICATION_JSON_VALUE)
                        .content(objectMapper.writeValueAsBytes(req))
        ).andDo(print()).andExpect(status().isOk()).andReturn();

    }
}