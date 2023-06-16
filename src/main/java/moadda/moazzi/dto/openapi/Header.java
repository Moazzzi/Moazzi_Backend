package moadda.moazzi.dto.openapi;

import lombok.Data;

@Data
public class Header {
    private String resultCode;
    private String resultMsg;
    private String type;
}
