package org.zerock.boardex.dto;

import lombok.*;
import org.modelmapper.internal.bytebuddy.implementation.bind.annotation.BindingPriority;

import javax.validation.constraints.Future;
import javax.validation.constraints.NotEmpty;
import java.time.LocalDate;

@ToString
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TodoDTO {
    private  Long  tno; //번호
    @NotEmpty //null, 빈문자불가
    private  String title; //제목

    @Future // 현재보다 이후 날짜
    private LocalDate dueDate; //날짜
    private boolean finished; //완료 체크

    @NotEmpty // null, 빈문자불가ㄴ
    private  String writer; // 작성자 // 새로추가됨
    
}
