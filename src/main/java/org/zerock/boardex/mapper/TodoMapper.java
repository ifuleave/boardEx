package org.zerock.boardex.mapper;

import org.zerock.boardex.domain.TodoVO;

public interface TodoMapper {
    String getTime();

    void insert(TodoVO todoVO);
}
