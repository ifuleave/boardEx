package org.zerock.boardex.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Positive;

/**
 *페이지 처리 : 현재페이지번호, 한페이지당 보여주는 데이터의 수가 기본적으로 필요
 *
 */

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PageRequestDTO {

    @Builder.Default
    @Min(value = 1)
    @Positive
    private int page = 1; //페이지 번호

    @Builder.Default // page나 size는 기본값을 가지기 위해서
    @Min(value = 10) //외부에서 조작하는 것에 대비
    @Max(value = 100)
    @Positive
    private int size =10; //한 페이지당 개수
    private String link;
    public int getSkip(){ //건너뛰기의 수  페이징에서 (pre> 버튼 누를떄 적용)
        return (page -1) *10;
    }

    public String getLink(){ //페이지번호가 붙을 때는 page와 size등을 같이 전달해 주어야만 조회페이지에서 다시 목록으로 이동할때 기존페이지를 볼 수 있게 됨.
        if (link == null){
            StringBuilder builder = new StringBuilder();
            builder.append("page="+this.page);
            builder.append("&size="+this.size);
            link = builder.toString();
        }
        return link;
    }

}
