package moadda.moazzi.dto.openapi.data.go.kr.comm;

import lombok.Data;

@Data
public class Response <T> {
    private Header header;
    private Body<T> body;
}
