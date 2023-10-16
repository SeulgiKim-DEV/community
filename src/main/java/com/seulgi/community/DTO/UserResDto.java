package com.seulgi.community.DTO;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

public class UserResDto {
    private UserResDto() { }

    @ToString
    @Getter
    @NoArgsConstructor
    public static class SingIn {
        private Long memberId;
        private String logInId;
        private String email;
        private String phoneNumber;
        private int level;
        private int point;
        private String grade;
        private String status;

        public SingIn(Long memberId, String logInId, String email, String phoneNumber, int level, int point, String grade, String status) {
            this.memberId = memberId;
            this.logInId = logInId;
            this.email = email;
            this.phoneNumber = phoneNumber;
            this.level = level;
            this.point = point;
            this.grade = grade;
            this.status = status;
        }
    }

    @ToString
    @Getter
    @NoArgsConstructor
    public static class changePassword {
        private Long memberId;
        private String logInId;
        private String email;
        private String phoneNumber;
        private int level;
        private int point;
        private String grade;
        private String status;

        public changePassword(Long memberId, String logInId, String email, String phoneNumber, int level, int point, String grade, String status) {
            this.memberId = memberId;
            this.logInId = logInId;
            this.email = email;
            this.phoneNumber = phoneNumber;
            this.level = level;
            this.point = point;
            this.grade = grade;
            this.status = status;
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
