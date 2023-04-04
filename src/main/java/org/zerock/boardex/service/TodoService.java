package org.zerock.boardex.service;

import org.zerock.boardex.dto.PageRequestDTO;
import org.zerock.boardex.dto.PageResponseDTO;
import org.zerock.boardex.dto.TodoDTO;

import java.util.List;

public interface TodoService {
    void register(TodoDTO todoDTO);

//    List<TodoDTO> getAll();

    PageResponseDTO<TodoDTO> getList(PageRequestDTO pageRequestDTO);
    //한개조회
    TodoDTO getOne(Long tno);

    //삭제
    void remove(Long tno);

    void modify(TodoDTO todoDTO); // service/serviceImpl에서 TodoDTO를 TodoVo로 변환해서 처리해야함.
}
