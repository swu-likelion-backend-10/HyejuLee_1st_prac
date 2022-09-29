package th_work.work.post.service;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import th_work.work.post.domain.Board;
import th_work.work.post.dto.BoardDto;
import th_work.work.post.repository.BoardRepository;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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

    @Transactional
    public List<BoardDto> getBoardList() {
        List<Board> boards = boardRepository.findAll();
        List<BoardDto> boardDtoList = new ArrayList<>();

        for(Board board : boards) {
            BoardDto boardDto = BoardDto.builder()
                    .id(board.getId())
                    .name(board.getName())
                    .major(board.getMajor())
                    .age(board.getAge())
                    .contents(board.getContents())
                    .createdTime(board.getCreatedTime())
                    .build();
            boardDtoList.add(boardDto);
        }
        return boardDtoList;
    }

    @Transactional
    public Long updatePost(Long id, BoardDto boardDto)
    {
        Board board = boardRepository.findById(id).orElseThrow(()
                -> new IllegalArgumentException("해당 게시물은 존재하지 않습니다. " + id));
        board.update(boardDto);

        return id;
    }

    @Transactional
    public BoardDto getPost(Long id){
        Optional<Board> boardWrapper = boardRepository.findById(id);
        Board board = boardWrapper.get();

        BoardDto boardDto = BoardDto.builder()
                .id(board.getId())
                .name(board.getName())
                .age(board.getAge())
                .major(board.getMajor())
                .contents(board.getContents())
                .createdTime(board.getCreatedTime())
                .modifiedTime(board.getModifiedTime())
                .build();
        return boardDto;
    }

    @Transactional
    public void deletePost(Long id){
        boardRepository.deleteById(id);
    }
}
