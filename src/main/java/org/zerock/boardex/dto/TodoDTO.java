package org.zerock.boardex.dto;

import lombok.*;
import org.modelmapper.internal.bytebuddy.implementation.bind.annotation.BindingPriority;

import java.time.LocalDate;

@ToString
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TodoDTO {
    private  Long  tno; //번호
    private  String title; //제목
    private LocalDate dueDate; //날짜
    private boolean finished; //완료 체크
    private  String writer; // 작성자 // 새로추가됨
    
}
