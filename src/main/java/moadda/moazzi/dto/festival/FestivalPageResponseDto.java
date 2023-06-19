package moadda.moazzi.dto.festival;

import java.util.List;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class FestivalPageResponseDto {
	
	@Schema(description = "페이지 번호", defaultValue = "1")
	private int pageNo;
	
	@Schema(description = "페이지 당 데이터 수", defaultValue = "10")
	private int numOfRows;
	
	@Schema(description = "데이터 총 갯수", defaultValue = "1000")
	private Long totalCount;
	
	@Schema(description = "축제 데이터 리스트")
	private List<FestivalResponseDto> data;
}
