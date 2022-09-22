package th_work.work.post.service;

import org.springframework.stereotype.Service;
import th_work.work.post.dto.BoardDto;
import th_work.work.post.repository.BoardRepository;

import javax.transaction.Transactional;

@Service
public class BoardService {

    private final BoardRepository boardRepository;

    public BoardService(BoardRepository boardRepository){
        this.boardRepository = boardRepository;
    }

    @Transactional
    public Long savePost(BoardDto boardDto){
        return boardRepository.save(boardDto.toEntity()).getId();
    }
}
