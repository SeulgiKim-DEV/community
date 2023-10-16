package com.seulgi.community.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@Entity
@Table(name = "Member_Access_History")
@NoArgsConstructor(access = AccessLevel.PACKAGE)
public class MemberAccessHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member member;

    @Column(name = "access_time")
    private LocalDateTime accessTime;

    @Builder
    public MemberAccessHistory(Long id, Member member, LocalDateTime accessTime) {
        this.id = id;
        this.member = member;
        this.accessTime = accessTime;
    }


}