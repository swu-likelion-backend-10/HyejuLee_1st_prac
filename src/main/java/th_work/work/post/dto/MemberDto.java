package th_work.work.post.dto;


import lombok.*;
import th_work.work.post.domain.Member;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class MemberDto {

    private Long id;
    private String email;

    private String password;
    private LocalDateTime createdDate;
    private LocalDateTime modifiedDate;

    public Member toEntity(){
        return Member.builder()
                .id(id)
                .email(email)
                .password(password)
                .build();
    }

    @Builder
    public MemberDto(Long id, String email, String password){
        this.id=id;
        this.email=email;
        this.password=password;
    }
}
