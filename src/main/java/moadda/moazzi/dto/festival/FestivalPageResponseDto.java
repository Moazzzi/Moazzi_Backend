package moadda.moazzi.dto.festival;

import java.util.List;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class FestivalPageResponseDto {
	private int pageNo;
	private int numOfRows;
	private Long totalCount;
	private List<FestivalResponseDto> data;
}
