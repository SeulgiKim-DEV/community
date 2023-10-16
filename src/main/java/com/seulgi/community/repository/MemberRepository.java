package com.seulgi.community.repository;

import com.seulgi.community.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {

    @Override
    Optional<Member> findById(Long id);

    Optional<Member> findByLogInIdAndPassword(String logInId, String password);
}
