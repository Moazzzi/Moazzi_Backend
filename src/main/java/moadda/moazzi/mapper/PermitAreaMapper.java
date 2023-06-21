package moadda.moazzi.mapper;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeParseException;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import moadda.moazzi.constant.PlaceType;
import moadda.moazzi.dto.openapi.data.go.kr.permitArea.PermitAreaItem;
import moadda.moazzi.entity.FoodTruckPermitArea;

@Mapper(componentModel = "spring")
public interface PermitAreaMapper {
	
	@Mapping(target = "id", ignore = true)
	@Mapping(target = "zoneName", source = "item.prmisnZoneNm")
	@Mapping(target = "placeType", source = "item.lcType", qualifiedByName = "toPlaceType")
	@Mapping(target = "provinceName", source = "item.ctprvnNm")
	@Mapping(target = "sigunguName", source = "item.signguNm")
	@Mapping(target = "roadAddress", source = "item.rdnmadr")
	@Mapping(target = "jibunAddress", source = "item.lnmadr")
	@Mapping(target = "latitude", source = "item.latitude", qualifiedByName = "toDouble")
	@Mapping(target = "longitude", source = "item.longitude", qualifiedByName = "toDouble")
	@Mapping(target = "vehicleCount", source = "item.vhcleCo")
	@Mapping(target = "fee", source = "item.prmisnZoneRntfee")
	@Mapping(target = "startDate", source = "item.beginDate", qualifiedByName = "toLocalDate")
	@Mapping(target = "endDate", source = "item.endDate", qualifiedByName = "toLocalDate")
	@Mapping(target = "restDay", source = "item.rstde")
	@Mapping(target = "weekdayOpenTime", source = "item.weekdayOperOpenHhmm", qualifiedByName = "toLocalTime")
	@Mapping(target = "weekdayCloseTime", source = "item.weekdayOperColseHhmm", qualifiedByName = "toLocalTime")
	@Mapping(target = "weekendOpenTime", source = "item.wkendOperOpenHhmm", qualifiedByName = "toLocalTime")
	@Mapping(target = "weekendCloseTime", source = "item.wkendOperCloseHhmm", qualifiedByName = "toLocalTime")
	@Mapping(target = "janOpenTime", source = "item.janOperOpenHhmm", qualifiedByName = "toLocalTime")
	@Mapping(target = "janCloseTime", source = "item.janOperColseHhmm", qualifiedByName = "toLocalTime")
	@Mapping(target = "febOpenTime", source = "item.febOperOpenHhmm", qualifiedByName = "toLocalTime")
	@Mapping(target = "febCloseTime", source = "item.febOperColseHhmm", qualifiedByName = "toLocalTime")
	@Mapping(target = "marOpenTime", source = "item.marOperOpenHhmm", qualifiedByName = "toLocalTime")
	@Mapping(target = "marCloseTime", source = "item.marOperColseHhmm", qualifiedByName = "toLocalTime")
	@Mapping(target = "aprOpenTime", source = "item.aprOperOpenHhmm", qualifiedByName = "toLocalTime")
	@Mapping(target = "aprCloseTime", source = "item.aprOperColseHhmm", qualifiedByName = "toLocalTime")
	@Mapping(target = "mayOpenTime", source = "item.mayOperOpenHhmm", qualifiedByName = "toLocalTime")
	@Mapping(target = "mayCloseTime", source = "item.mayOperColseHhmm", qualifiedByName = "toLocalTime")
	@Mapping(target = "junOpenTime", source = "item.junOperOpenHhmm", qualifiedByName = "toLocalTime")
	@Mapping(target = "junCloseTime", source = "item.junOperColseHhmm", qualifiedByName = "toLocalTime")
	@Mapping(target = "julOpenTime", source = "item.julOperOpenHhmm", qualifiedByName = "toLocalTime")
	@Mapping(target = "julCloseTime", source = "item.julOperColseHhmm", qualifiedByName = "toLocalTime")
	@Mapping(target = "augOpenTime", source = "item.augOperOpenHhmm", qualifiedByName = "toLocalTime")
	@Mapping(target = "augCloseTime", source = "item.augOperColseHhmm", qualifiedByName = "toLocalTime")
	@Mapping(target = "sepOpenTime", source = "item.sepOperOpenHhmm", qualifiedByName = "toLocalTime")
	@Mapping(target = "sepCloseTime", source = "item.sepOperColseHhmm", qualifiedByName = "toLocalTime")
	@Mapping(target = "octOpenTime", source = "item.octOperOpenHhmm", qualifiedByName = "toLocalTime")
	@Mapping(target = "octCloseTime", source = "item.octOperColseHhmm", qualifiedByName = "toLocalTime")
	@Mapping(target = "novOpenTime", source = "item.novOperOpenHhmm", qualifiedByName = "toLocalTime")
	@Mapping(target = "novCloseTime", source = "item.novOperColseHhmm", qualifiedByName = "toLocalTime")
	@Mapping(target = "decOpenTime", source = "item.decOperOpenHhmm", qualifiedByName = "toLocalTime")
	@Mapping(target = "decCloseTime", source = "item.decOperColseHhmm", qualifiedByName = "toLocalTime")
	@Mapping(target = "restrictedItem", source = "item.lmttPrdlst")
	@Mapping(target = "agencyName", source = "item.institutionNm")
	@Mapping(target = "phoneNumber", source = "item.phoneNumber")
	FoodTruckPermitArea toEntity(PermitAreaItem item);
	
	@Named("toPlaceType")
	default PlaceType toPlaceType(String lcType) {
		return PlaceType.valueOf(Integer.parseInt(lcType));
	}
	
	@Named("toDouble")
	default Double toDouble(String doubleString) {
		try {
			return Double.parseDouble(doubleString);
		}catch(Exception e) {
			return 0.0;
		}
	}
	
	@Named("toLocalDate")
	default LocalDate toLocalDate(String date) {
		return LocalDate.parse(date);
	}
	
	@Named("toLocalTime")
	default LocalTime toLocalTime(String time) {
		try {
			return LocalTime.parse(time);
		}catch(DateTimeParseException e){
			return LocalTime.MIN;
		}
	}
	
}
