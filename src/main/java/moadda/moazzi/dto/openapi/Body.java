package moadda.moazzi.dto.openapi;

import java.util.List;

import lombok.Data;

@Data
public class Body {
    private List<Item> items;
    private String totalCount;
    private String numOfRows;
    private String pageNo;
}
