package org.zerock.boardex.service;

import org.zerock.boardex.dto.TodoDTO;

import java.util.List;

public interface TodoService {
    void register(TodoDTO todoDTO);

    List<TodoDTO> getAll();

    //한개조회
    TodoDTO getOne(Long tno);

    //삭제
    void remove(Long tno);
}
