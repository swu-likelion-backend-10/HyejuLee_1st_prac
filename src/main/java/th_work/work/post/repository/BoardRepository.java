package th_work.work.post.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import th_work.work.post.domain.Board;

public interface BoardRepository extends JpaRepository<Board, Long> {
}
