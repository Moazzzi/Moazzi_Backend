package moadda.moazzi.dto.festival;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(description = "축제 요청 파라미터")
public class FestivalRequestDto {
	@Schema(description = "페이지 번호", nullable = true, defaultValue = "1")
	private int pageNo = 1;
	
	@Schema(description = "페이지 당 데이터 수", nullable = true, defaultValue = "10")
	private int numOfRows = 10;
	
	@Schema(description = "시작일자", nullable = true, defaultValue = "2023-01-01")
	private String startDate = "1900-01-01";
	
	@Schema(description = "종료일자", nullable = true, defaultValue = "2023-01-01")
	private String endDate = "2100-12-30";
	
	public String getStartDate() {
		return this.startDate.equals("") ? "1900-01-01" : this.startDate; 
	}
	
	public String getEndDate() {
		return this.endDate.equals("") ? "1900-01-01" : this.endDate; 
	}
}
