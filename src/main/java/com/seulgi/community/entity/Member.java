package com.seulgi.community.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;

@Getter
@Entity
@Table(name = "Member")
@NoArgsConstructor(access = AccessLevel.PACKAGE)
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "login_id", nullable = false, length = 20)
    private String loginId;

    @Column(name = "user_name", nullable = false, length = 15)
    private String userName;

    @Column(name = "password", nullable = false, length = 30)
    private String password;

    @Column(name = "email", nullable = false, length = 50)
    private String email;

    @Column(name = "phone_number", nullable = false, length = 11)
    private String phoneNumber;

    @Column(name = "level", nullable = false)
    @ColumnDefault("0")
    private Integer level;

    @Column(name = "point", length = 10)
    @ColumnDefault("0")
    private Integer point;

    @Column(name = "grade", length = 10)
    @ColumnDefault("USER")
    private String grade;

    @Column(name = "status", nullable = false, length = 10)
    private String status;

    @Column(name = "resign")
    @ColumnDefault("false")
    private boolean resign;

    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    @LastModifiedDate
    private LocalDateTime updatedAt;

    @Builder
    public Member(String loginId, String userName, String password, String email, String phoneNumber, String status) {
        this.loginId = loginId;
        this.userName = userName;
        this.password = password;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.status = status;
    }

    public void updatedMemberInfo(String userName, String phoneNumber) {
        this.userName = userName;
        this.phoneNumber = phoneNumber;
    }

    public void resignMember() {
        this.resign = true;
    }
}