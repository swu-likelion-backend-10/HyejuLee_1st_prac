package th_work.work.post.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import th_work.work.post.dto.BoardDto;

import javax.persistence.*;
import java.sql.Timestamp;

@Data
@NoArgsConstructor
@Entity
public class Board extends BaseTimeEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private Integer age;

    @Column(nullable = false)
    private String major;

    @Column(nullable = false)
    private String contents;

    @Builder
    public Board(Long id, String name, Integer age, String major, String contents){
        this.id=id;
        this.name=name;
        this.age=age;
        this.major=major;
        this.contents=contents;
    }

    public void update(BoardDto boardDto)
    {
        this.name = boardDto.getName();
        this.age = boardDto.getAge();
        this.major = boardDto.getMajor();
        this.contents = boardDto.getContents();
    }
}