package moadda.moazzi.dto.festival;

import java.time.LocalDate;

import lombok.Data;

@Data
public class FestivalResponseDto {
	private Long id;
	private String name;
	private String location;
	private LocalDate startDate;
	private LocalDate endDate;
	private String content;
	private String hostOrganization;
	private String sponsor;
	private String phoneNumber;
	private String homePageUrl;
	private String roadAddress;
	private String jibunAddress;
	private Double latitude;
	private Double longitude;
}
