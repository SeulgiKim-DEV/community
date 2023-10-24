package com.seulgi.community.DTO;


import com.seulgi.community.entity.Member;
import lombok.*;

public class UserModel {

    /// Request
    @ToString
    @Getter
    @Builder
    @AllArgsConstructor
    public static class logInRequest {
        private String logInId;
        private String password;

        public static logInRequest info (String logInId, String password) {
            return new logInRequest (logInId, password);
        }
    }

    @ToString
    @Getter
    @Builder
    @AllArgsConstructor
    public static class logOutRequest {
        private Long memberId;

        public static logOutRequest info (Long memberId) {
            return new logOutRequest (memberId);
        }
    }

    @ToString
    @Getter
    @Builder
    @AllArgsConstructor
    public static class signUpRequest {
        private String logInId;
        private String password;
        private String checkPassword;
        private String email;
        private String phoneNumber;
        private String userName;
        private boolean resign;

        public static signUpRequest info(String logInId, String password, String checkPassword
                                        , String email, String phoneNumber, String userName) {
            return new signUpRequest(logInId, password, checkPassword, email, phoneNumber, userName, false);
        }
    }

    @ToString
    @Getter
    @Builder
    @AllArgsConstructor
    public static class resignRequest {
        private Long memberId;

        public static resignRequest info (Long memberId) {
            return new resignRequest(memberId);
        }
    }

    @ToString
    @Getter
    @Builder
    @AllArgsConstructor
    public static class helpAccountRequest {
        private String logInId;
        private String password;
        private String email;
        private String phoneNumber;

        public static helpAccountRequest info (String logInId, String password, String email, String phoneNumber) {
            return new helpAccountRequest(logInId, password, email, phoneNumber);
        }
    }

    @ToString
    @Getter
    @Builder
    @AllArgsConstructor
    public static class changePasswordRequest {
        private Long memberId;
        private String logInId;
        private String password;
        private String checkPassword;
        private String email;

        public static changePasswordRequest info (Long memberId, String logInId, String password, String checkPassword, String email) {
            return new changePasswordRequest(memberId, logInId, password, checkPassword, email);
        }
    }

    @ToString
    @Getter
    @Builder
    @AllArgsConstructor
    public static class modifyMemberInfoRequest {
        private String userName;
        private String phoneNumber;

        public static modifyMemberInfoRequest info (String userName, String phoneNumber) {
            return new modifyMemberInfoRequest(userName, phoneNumber);
        }
    }





    //Response
    @ToString
    @Getter
    @Builder
    @AllArgsConstructor
    public static class logInResponse {
        private Long memberId;
        private String logInId;
        private String email;
        private String phoneNumber;
        private int level;
        private int point;
        private String grade;
        private String status;

        public static logInResponse create(Member member) {
            return new logInResponse(member.getId(), member.getLogInId(), member.getEmail(), member.getPhoneNumber()
                        , member.getLevel(), member.getPoint(), member.getGrade(), member.getStatus());
        }
    }

    @ToString
    @Getter
    @Builder
    @AllArgsConstructor
    public static class signUpResponse {
        private Long memberId;
        private String logInId;

        public static signUpResponse info(Member member) {
            return new signUpResponse(member.getId(), member.getLogInId());
        }
    }

    @ToString
    @Getter
    @Builder
    @AllArgsConstructor
    public static class helpAccountResponse {
        private Long memberId;
        private String logInId;

        public static helpAccountResponse change(Member member) {
            return new helpAccountResponse(member.getId(), member.getLogInId());
        }
    }

    @ToString
    @Getter
    @Builder
    @AllArgsConstructor
    public static class searchMemberResponse {
        private String logInId;
        private String email;
        private String phoneNumber;
        private int level;
        private int point;
        private String grade;
        private String status;

        public static searchMemberResponse info(Member member) {
            return new searchMemberResponse(member.getLogInId(), member.getEmail(), member.getPhoneNumber()
                    , member.getLevel(), member.getPoint(), member.getGrade(), member.getStatus());
        }
    }


}
