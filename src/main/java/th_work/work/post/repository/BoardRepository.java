package th_work.work.post.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import th_work.work.post.domain.Board;

import java.util.List;

public interface BoardRepository extends JpaRepository<Board, Long> {
    List<Board> findByNameContaining(String keyword);
}
