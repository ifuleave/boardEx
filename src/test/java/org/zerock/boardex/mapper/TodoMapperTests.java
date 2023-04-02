package org.zerock.boardex.mapper;

import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.zerock.boardex.domain.TodoVO;

import java.time.LocalDate;
import java.util.List;

@Log4j2
@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations = "file:src/main/webapp/WEB-INF/root-context.xml")
public class TodoMapperTests {

    @Autowired(required = false)
    private TodoMapper todoMapper;

    @Test
    public void testGetTime(){
        log.info(todoMapper.getTime());
    }

    @Test
    public void testInsert(){
        TodoVO todoVO = TodoVO.builder().title("제목테스트입니다.")
                .dueDate(LocalDate.of(2023,03,31))
                .writer("sujin00").build();
        todoMapper.insert(todoVO);
    }

    @Test
    public void testSelectAll(){
        List<TodoVO> voList = todoMapper.selectAll();
        voList.forEach(vo -> log.info(vo));
    }

    @Test
    public void testSelectOnt(){
        TodoVO todoVO = todoMapper.selectOne(3L);
        log.info(todoVO);
    }
}
