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

        public static signUpRequest info(String logInId, String password, String checkPassword
                                        , String email, String phoneNumber, String userName) {
            return new signUpRequest(logInId, password, checkPassword, email, phoneNumber, userName);
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
    public static class changePassword {
        private Long memberId;
        private String logInId;
        private String password;
        private String checkPassword;
        private String email;
        private String phoneNumber;

        public static changePassword info (Long memberId, String logInId, String password, String checkPassword,String email, String phoneNumber) {
            return new changePassword(memberId, logInId, password, checkPassword, email, phoneNumber);
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
    public static class signInResponse {
        private Long memberId;
        private String logInId;

        public static signInResponse info(Member member) {
            return new signInResponse(member.getId(), member.getLogInId());
        }

    }


}
