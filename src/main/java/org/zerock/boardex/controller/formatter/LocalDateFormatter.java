package org.zerock.boardex.controller.formatter;

import org.springframework.format.Formatter;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
 /*
 * p.272-3
 * http는 문자열로 데이터를 전달하기 떄문에 컨트롤러 문자열을 기준으로 특정한 클래스의 객체로 처리하는 작업이 진행
 * 브라우저에서 2020-10-10고ㅏ 같은 형태의 문자열을 date나 localdate,localdatetime등으로 변환하는 작업 많이 필요, 이제 파라미터 수집은 에러 발생
 * 서버쪽에서 String타입을 java.time.localdate로 변환할 수 없어 생긴 에러
 * 
 * Formatter는 문자열을 포맷을 이용해서 특정한 객체로 변환해주는 경우
 * 
 * servlet-context.xml 에 등록해줘야함
 * 
 * */
public class LocalDateFormatter implements Formatter<LocalDate> {

    @Override
    public LocalDate parse(String text, Locale locale){
        return LocalDate.parse(text, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
    }

    @Override
    public String print(LocalDate object, Locale locale){
        return DateTimeFormatter.ofPattern("yyyy-MM-dd").format(object);
    }
}
