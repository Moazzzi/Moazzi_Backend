package moadda.moazzi.dto.openapi.data.go.kr.comm;

import lombok.Data;

@Data
public class OpenApiResponse<T> {
    private Response<T> response;
}
