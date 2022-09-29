package th_work.work.post.dto;

import lombok.Builder;
import lombok.Getter;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import th_work.work.post.domain.Board;

import java.time.LocalDateTime;


@Getter
public class BoardDto {

    private Long id;
    private String name;
    private Integer age;
    private String major;
    private String contents;
    private LocalDateTime createdTime;
    private LocalDateTime modifiedTime;



    public Board toEntity(){
        Board build = Board.builder()
                .id(id)
                .name(name)
                .age(age)
                .major(major)
                .contents(contents)
                .build();
        return build;
    }




    @Builder
    public BoardDto(Long id, String name, Integer age, String major, String contents, LocalDateTime createdTime, LocalDateTime modifiedTime){
        this.id=id;
        this.name=name;
        this.age=age;
        this.major=major;
        this.contents=contents;
        this.createdTime=createdTime;
        this.modifiedTime=modifiedTime;
    }


}
