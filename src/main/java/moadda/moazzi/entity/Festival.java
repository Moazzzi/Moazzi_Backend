package moadda.moazzi.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.Comment;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Festival {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Comment("축제명")
	private String name;
	
	@Comment("개최장소")
	private String location;
	
	@Comment("시작일시")
	private LocalDate startDate;
	
	@Comment("종료일시")
	private LocalDate endDate;
	
	@Comment("내용")
	@Column(columnDefinition = "TEXT")
	private String content;
	
	@Comment("주관기관")
	private String hostOrganization;
	
	@Comment("후원기관")
	private String sponsor;
	
	@Comment("전화번호")
	private String phoneNumber;
	
	@Comment("홈페이지 주소")
	private String homePageUrl;
	
	@Comment("도로명 주소")
	private String roadAddress;
	
	@Comment("지번 주소")
	private String jibunAddress;
	
	@Comment("위도")
	private Double latitude;
	
	@Comment("경도")
	private Double longitude;
}
