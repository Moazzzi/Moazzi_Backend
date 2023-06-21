package moadda.moazzi.dto.openapi.data.go.kr.comm;

import java.util.List;

import lombok.Data;

@Data
public class Body <T>{
    private List<T> items;
    private String totalCount;
    private String numOfRows;
    private String pageNo;
}
