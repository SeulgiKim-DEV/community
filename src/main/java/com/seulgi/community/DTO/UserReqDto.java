package com.seulgi.community.DTO;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

public class UserReqDto {
    private UserReqDto() { }

    @ToString
    @Getter
    @NoArgsConstructor
    public static class SingIn {
        private String logInId;
        private String password;

        public SingIn(String logInId, String password) {
            this.logInId = logInId;
            this.password = password;
        }
    }

    @ToString
    @Getter
    @NoArgsConstructor
    public static class SingOut {
        private Long memberId;

        public SingOut(Long memberId) {
            this.memberId = memberId;
        }
    }

    @ToString
    @Getter
    @NoArgsConstructor
    public static class SingUp {
        private String logInId;
        private String password;
        private String checkPassword;
        private String email;
        private String phoneNumber;
        private String userName;

        public SingUp(String logInId, String password,String checkPassword, String email,String phoneNumber, String userName) {
            this.logInId = logInId;
            this.password = password;
            this.checkPassword = checkPassword;
            this.email = email;
            this.phoneNumber = phoneNumber;
            this.userName = userName;
        }
    }

    @ToString
    @Getter
    @NoArgsConstructor
    public static class resign {
        private Long memberId;

        public resign(Long memberId) {
            this.memberId = memberId;
        }
    }

    @ToString
    @Getter
    @NoArgsConstructor
    public static class changePassword {
        private Long memberId;
        private String logInId;
        private String password;
        private String checkPassword;
        private String email;
        private String phoneNumber;

        public changePassword(Long memberId, String logInId, String password, String checkPassword,String email, String phoneNumber) {
            this.memberId = memberId;
            this.logInId = logInId;
            this.password = password;
            this.checkPassword = checkPassword;
            this.email = email;
            this.phoneNumber = phoneNumber;
        }
    }

}
