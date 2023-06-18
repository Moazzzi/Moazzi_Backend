package moadda.moazzi.dto.festival;

import lombok.Data;

@Data
public class FestivalRequestDto {
	private int pageNo = 1;
	private int numOfRows = 10;
	private String startDate = "1900-01-01";
	private String endDate = "2100-12-30";
}
