package com.seulgi.community.repository;

import com.seulgi.community.entity.MemberAccessHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberAccessHistoryRepository extends JpaRepository<MemberAccessHistory, Long> {


}


