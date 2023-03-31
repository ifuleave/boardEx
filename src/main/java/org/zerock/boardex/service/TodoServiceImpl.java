package org.zerock.boardex.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.zerock.boardex.domain.TodoVO;
import org.zerock.boardex.dto.TodoDTO;
import org.zerock.boardex.mapper.TodoMapper;


/*
* TodoServiceImpl은 TodoService 인터페이스를 구현하여 의존성 주입을 이용해서 데이터베이스 처리를 하는 TodoMapper와 DTO,VO의 변환을 처리한는 ModelMapper를 주입
*
* TodoService 인터페이스에  register()에 주입된 ModelMapper 를 이용해서 TodoDTO를 TOdoVo로 변환하고 TodoMapper를 통해 insert 처리.
*
* service 패키지를 root-context.xml에 component-scan 패키지로 추가해줘야함.
* */
@Service
@Log4j2
@RequiredArgsConstructor
public class TodoServiceImpl implements TodoService { //service implements 받아서 사용함

    private final TodoMapper todoMapper; //의존성주입이 필요한 객체의 타입을  final로 고정 @RequiredArgsConstructor를 이용해서 생성자를 생성하는 방식을 사용
    private  final ModelMapper modelMapper;

    @Override
    public void register(TodoDTO todoDTO){
        log.info(modelMapper);
        TodoVO todoVO = modelMapper.map(todoDTO, TodoVO.class);
        log.info(todoVO);
        todoMapper.insert(todoVO);
    }
}
