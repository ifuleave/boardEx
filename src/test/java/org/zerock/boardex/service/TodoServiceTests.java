package org.zerock.boardex.service;

import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.zerock.boardex.dto.TodoDTO;

import java.time.LocalDate;

@Log4j2
@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations = "file:src/main/webapp/WEB-INF/root-context.xml")
public class TodoServiceTests {

    @Autowired
    private TodoService todoService; // bean 주입 오류시 main service패키지 TodoserviceImpl이 잘못된 것임.

    @Test
    public void testRegister(){
        TodoDTO todoDTO = TodoDTO.builder()
                .title("ttt제목테스트입니다.")
                .dueDate(LocalDate.now())
                .writer("sujin01").build();
        todoService.register(todoDTO);
    }
}
