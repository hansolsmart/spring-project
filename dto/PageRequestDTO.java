package com.example.b01.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;


import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Positive;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor

public class PageRequestDTO {
    @Builder.Default
    @Min(value = 1)
    @Positive
    private int page = 1;

    @Builder.Default
    @Min(value = 10)
    @Max(value = 100)
    @Positive
    private int size = 10;

    public int getSkip(){
        return (page -1) * 10;
    }
    ///////////////////////

    private String type;
    private String keyword;

    public String[] getTypes(){
        if(type == null || type.isEmpty()){
            return  null;
        }
        return  type.split("");
    }

    public Pageable getPageable(String...props){
        return PageRequest.of(this.page -1,this.size, Sort.by(props).descending());
    }
    private String link;

    public String getLink(){

        if(link == null){
            StringBuilder builder = new StringBuilder();
            builder.append("page="+this.page);
            builder.append("&size="+this.size);
            if(type != null && type.length() > 0){
                builder.append("&type="+type);

            }
            if(keyword != null){
                try{
                    builder.append("&keyword=" + URLEncoder.encode(keyword,"UTF-8"));
                }catch (UnsupportedEncodingException e){

                }
            }
            link = builder.toString();
        }
        return link;
    }
}
