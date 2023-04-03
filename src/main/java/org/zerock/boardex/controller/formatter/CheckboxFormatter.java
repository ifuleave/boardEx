package org.zerock.boardex.controller.formatter;

import org.springframework.format.Formatter;

import java.text.ParseException;
import java.util.Locale;

/*
* checkbox를 위한 Formatter
*
* 수정작업에서는 화면에서 체크박스를 이용해서 완료여부를 처리하게됨
* 문제는 브라우저가 체크박스(클릭)-> 전송되는 값(on)이 전달해야함
*
* TodoDTO로 데이터를 수집할 때에는 문자열 'on'을 boolean타입으로 처리할 수 있어야 하므로 컨트롤러에서 데이터를 수집할 때 타입을 변경해주기 위한
* checkboxFormatter를 formmater패키지에 추가해서 개발함.
* */
public class CheckboxFormatter implements Formatter<Boolean> {
    @Override
    public Boolean parse(String text, Locale locale) throws ParseException{
        if (text == null){
            return false;
        }
        return text.equals("on");
    }
    @Override
    public String print(Boolean object, Locale locale){
        return object.toString();
    }
}

