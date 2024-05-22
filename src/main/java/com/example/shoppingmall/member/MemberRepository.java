package com.example.shoppingmall.member;

import jakarta.persistence.*;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.jdbc.datasource.DataSourceUtils;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;

@Repository
@Transactional // MemberService로 옮기기
public class MemberRepository {

    private final EntityManager entityManager;

    @Autowired
    public MemberRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Autowired
    DataSource dataSource;

    public void makeConnection() {
        System.out.println("datasource");
        DataSourceUtils.getConnection(dataSource);
    }

    public String save(Member member) {
        entityManager.persist(member);
        Member savedMember = entityManager.find(Member.class, member.getId());
        System.out.println("savedMember - " + savedMember);
        return member.getUserId();
    }

    public Member findByUserId(String userId) {
        return entityManager.find(Member.class, userId);
    }

    public Member getMemberByUserId(String userId) {
        System.out.println("/MemberRepository - " + userId);
        String jpql = "SELECT m FROM Member m WHERE m.userId = :userId";
        TypedQuery<Member> query = entityManager.createQuery(jpql, Member.class);
        query.setParameter("userId", userId);
        try {
            Member member = query.getSingleResult();
            System.out.println("result - " + member);
            return member;
        } catch (NoResultException e) {
            return null;
        }
    }


}
