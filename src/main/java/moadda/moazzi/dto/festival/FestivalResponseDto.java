package moadda.moazzi.dto.festival;

import java.time.LocalDate;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class FestivalResponseDto {
	@Schema(description = "축제 데이터 ID", defaultValue = "1")
	private Long id;
	
	@Schema(description = "축제 명", defaultValue = "부산시민의종 타종식")
	private String name;
	
	@Schema(description = "장소", defaultValue = "용두산공원")
	private String location;
	
	@Schema(description = "축제 시작일시", defaultValue = "2023-01-01")
	private LocalDate startDate;
	
	@Schema(description = "축제 종료일시", defaultValue = "2023-01-01")
	private LocalDate endDate;
	
	@Schema(description = "내용", defaultValue = "시민의종 타종+문화공연")
	private String content;
	
	@Schema(description = "개최기관", defaultValue = "(사)부산문화관광축제조직위원회")
	private String hostOrganization;
	
	@Schema(description = "후원기관", defaultValue = "BNK")
	private String sponsor;
	
	@Schema(description = "전화번호", defaultValue = "051-123-4567")
	private String phoneNumber;
	
	@Schema(description = "홈페디지", defaultValue = "http://example.com")
	private String homePageUrl;
	
	@Schema(description = "도로명 주소", defaultValue = "부산광역시 중구 용두산길 37-55(광복동2가)")
	private String roadAddress;
	
	@Schema(description = "지번 주소", defaultValue = "부산광역시 중구 동광동2가 17-6")
	private String jibunAddress;
	
	@Schema(description = "위도", defaultValue = "35.10093242")
	private Double latitude;
	
	@Schema(description = "경도", defaultValue = "129.0324385")
	private Double longitude;
}
