package org.zerock.boardex.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import java.util.List;

/**
 * TodoVo의 목록과 전체 데이터의 수를 가져온다면 이를 서비스 계층에서 한번 담아서 처리하도록  DTO를 구성
 *
 * DTO는 PageRequestDTO라는 이름 생성 하고 다음과 같은 기능을 갖도록 구성한다
 * TodoDTO 목록
 * 전체 데이터의 수
 * 페이지 번호의 처리를 위한 데이터들(시작 페이지 번호/끝 페이지 번호)
 *
 *
 */

@Getter
@ToString
public class PageResponseDTO<E> { //제네릭을 이용한 설계 -> 나중에 다른 종류의 객체를 이용해서 PageResponseDTO를 구성하기 위해
                                // 예를 들어 게시판이나 회원정보등도 페이징 처리가 필요할 수 있기때문에 공통적인 처리를 위해 제네릭구성
    private int page;
    private int size;
    private int total;

    //시작페이지 번호
     private int start;
     //끝번호
    private int end;

    //이전페이지의 존재여부
    private boolean prev;
    //다음페이지의 존재여부
    private boolean next;
    private List<E> dtoList;


    @Builder(builderMethodName = "withAll") //여러 정보를 생성자를 이용해서 받아서 처리하는 것이 안전
    public PageResponseDTO(PageRequestDTO pageRequestDTO, List<E> dtoList, int total){
        this.page =pageRequestDTO.getPage();
        this.size =pageRequestDTO.getSize();

        this.total = total;
        this.dtoList = dtoList;

        this.end = (int)(Math.ceil(this.page/10.0)) * 10;
        this.start = this.end -9;
        int last = (int)(Math.ceil((total/(double)size)));
        this.end = end>last ? last:end ;
        this.prev = this.start>1;
        this.next = total>this.end * this.size;
    }

}
