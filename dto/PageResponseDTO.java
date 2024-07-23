package com.example.b01.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import java.util.List;

@Getter
@ToString
public class PageResponseDTO<E>{ //클래스 생성자 = 객체생성

    private int page;
    private int size;
    private int total;

    private int start;//시작 페이지번호
    private int end;//끝 페이지번호

    private boolean prev;//이전 페이지의 존재여부
    private boolean next;//다음 페이지의 존재여부

    private List<E> dtoList; //List는 java의 상위클래스 필드선언

    @Builder(builderMethodName = "withAll")
    public PageResponseDTO(PageRequestDTO pageRequestDTO, List<E> dtoList, int total){ //위에 기본자료형 다 쓰겠다는뜻

        this.page = pageRequestDTO.getPage();
        this.size = pageRequestDTO.getSize();

        this.total = total;
        this.dtoList = dtoList;

        this.end = (int)(Math.ceil(this.page / 10.0)) * 10;

        this.start = this.end - 9;

        int last = (int)(Math.ceil((total/(double)size)));

        this.end = end > last ? last : end;

        this.prev = this.start > 1;

        this.next = total > this.end * this.size;

        if(total <= 0){
            return;
        }

    }
}
