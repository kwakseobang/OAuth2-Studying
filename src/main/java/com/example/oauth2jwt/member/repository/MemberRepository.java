package com.example.oauth2jwt.member.repository;

import com.example.oauth2jwt.member.domain.Member;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member,Long> {
     Optional<Member> findBySocialLoginId(String socialLoginId);
     Optional<Member> findByUsername(String username);

     boolean existsByUsername(String username);
     boolean existsByNickname(String nickname);

}
