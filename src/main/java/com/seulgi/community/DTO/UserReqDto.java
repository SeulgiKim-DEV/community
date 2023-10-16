package com.seulgi.community.DTO;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

public class userDto {
    private userDto() { }

    @ToString
    @Getter
    @NoArgsConstructor
    public static class SingIn {
        private String logInId;
        private String password;

        public In(String logInId, String password) {
            this.logInId = logInId;
            this.password = password;
        }
    }

    @ToString
    @Getter
    @NoArgsConstructor
    public static class SingOut {
        private Long memberId;

        public Out(Long memberId) {
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

        public Up(String logInId, String password,String checkPassword, String email,String phoneNumber, String userName) {
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

}
