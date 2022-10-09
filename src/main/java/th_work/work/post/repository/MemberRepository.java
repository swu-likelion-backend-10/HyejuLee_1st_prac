package th_work.work.post.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import th_work.work.post.domain.Member;

import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member, Long> {
    Optional<Member> findByEmail(String userEmail);
}
