package com.example.immediatemeetupbe.domain.User.repository;

import com.example.immediatemeetupbe.domain.User.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member, Long> {
    Optional<Member> findByEmail(String email);
}
