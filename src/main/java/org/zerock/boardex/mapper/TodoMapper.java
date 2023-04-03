package org.zerock.boardex.mapper;

import org.zerock.boardex.domain.TodoVO;

import java.util.List;

public interface TodoMapper {
    String getTime();

    //입력
    void insert(TodoVO todoVO);

    //리스트
    List<TodoVO> selectAll();

    //제목눌렀을때
    TodoVO selectOne(Long tno);

    //삭제
    void delete(Long tno);

    //수정
    void update(TodoVO todoVO);
}
