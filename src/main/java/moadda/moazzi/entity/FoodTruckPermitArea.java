package moadda.moazzi.entity;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.Comment;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import moadda.moazzi.constant.PlaceType;

@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class FoodTruckPermitArea {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Comment("허가구역명")
	private String zoneName;
	
	@Comment("장소유형")
	private PlaceType placeType;
	
	@Comment("시도명")
	private String provinceName;
	
	@Comment("시군구명")
	private String sigunguName;
	
	@Comment("도로명 주소")
	private String roadAddress;
	
	@Comment("지번 주소")
	private String jibunAddress;
	
	@Comment("위도")
	private Double latitude;
	
	@Comment("경도")
	private Double longitude;
	
	@Comment("푸드트럭운영대수")
	private String vehicleCount;
	
	@Comment("허가구역사용료")
	private String fee;
	
	@Comment("허가구역시작일자")
	private LocalDate startDate;
	
	@Comment("허가구역종료일자")
	private LocalDate endDate;
	
	@Comment("허가구역휴무일")
	private String restDay;
	
	@Comment("허가구역 평일 운영 시작시각")
	private String weekdayOpenTime;
	
	@Comment("허가구역 평일 운영 종료시각")
	private String weekdayCloseTime;
	
	@Comment("허가구역 주말 운영 시작시각")
	private String weekendOpenTime;
	
	@Comment("허가구역 주말 운영 종료시각")
	private String weekendCloseTime;
	
	@Comment("1월 운영 시작시각")
	private String janOpenTime;
	
	@Comment("1월 운영 시작시각")
	private String janCloseTime;
	
	@Comment("2월 운영 시작시각")
	private String febOpenTime;
	
	@Comment("2월 운영 시작시각")
	private String febCloseTime;
	
	@Comment("3월 운영 시작시각")
	private String marOpenTime;
	
	@Comment("3월 운영 시작시각")
	private String marCloseTime;
	
	@Comment("4월 운영 시작시각")
	private String aprOpenTime;
	
	@Comment("4월 운영 시작시각")
	private String aprCloseTime;
	
	@Comment("5월 운영 시작시각")
	private String mayOpenTime;
	
	@Comment("5월 운영 시작시각")
	private String mayCloseTime;
	
	@Comment("6월 운영 시작시각")
	private String junOpenTime;
	
	@Comment("6월 운영 시작시각")
	private String junCloseTime;
	
	@Comment("7월 운영 시작시각")
	private String julOpenTime;
	
	@Comment("7월 운영 시작시각")
	private String julCloseTime;
	
	@Comment("8월 운영 시작시각")
	private String augOpenTime;
	
	@Comment("8월 운영 시작시각")
	private String augCloseTime;
	
	@Comment("9월 운영 시작시각")
	private String sepOpenTime;
	
	@Comment("9월 운영 시작시각")
	private String sepCloseTime;
	
	@Comment("10월 운영 시작시각")
	private String octOpenTime;
	
	@Comment("10월 운영 시작시각")
	private String octCloseTime;
	
	@Comment("11월 운영 시작시각")
	private String novOpenTime;
	
	@Comment("11월 운영 시작시각")
	private String novCloseTime;
	
	@Comment("12월 운영 시작시각")
	private String decOpenTime;
	
	@Comment("12월 운영 시작시각")
	private String decCloseTime;
	
	@Comment("판매제한품목")
	private String restrictedItem;
	
	@Comment("관리기관명")
	private String agencyName;
	
	@Comment("관리기관 전화번호")
	private String phoneNumber;
}
