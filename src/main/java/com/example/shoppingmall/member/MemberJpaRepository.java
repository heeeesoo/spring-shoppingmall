package com.example.shoppingmall.member;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.QueryByExampleExecutor;

import java.util.List;

public interface MemberJpaRepository extends JpaRepository<Member, Integer> {
    List<Member> findByUserId(String userId);

    Member findById(long id);
}
