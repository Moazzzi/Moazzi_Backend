package moadda.moazzi.mapper;

import java.time.LocalDate;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import moadda.moazzi.dto.openapi.data.go.kr.permitArea.Item;
import moadda.moazzi.entity.FoodTruckPermitArea;

@Mapper(componentModel = "spring")
public interface PermitAreaMapper {
	
	@Mapping(target = "id", ignore = true)
	@Mapping(target = "zoneName", source = "item.prmisnZoneNm")
	@Mapping(target = "placeType", source = "item.lcType")
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
	@Mapping(target = "weekdayOpenTime", source = "item.weekdayOperOpenHhmm")
	@Mapping(target = "weekdayCloseTime", source = "item.weekdayOperColseHhmm")
	@Mapping(target = "weekendOpenTime", source = "item.wkendOperOpenHhmm")
	@Mapping(target = "weekendCloseTime", source = "item.wkendOperCloseHhmm")
	@Mapping(target = "janOpenTime", source = "item.janOperOpenHhmm")
	@Mapping(target = "janCloseTime", source = "item.janOperColseHhmm")
	@Mapping(target = "febOpenTime", source = "item.febOperOpenHhmm")
	@Mapping(target = "febCloseTime", source = "item.febOperColseHhmm")
	@Mapping(target = "marOpenTime", source = "item.marOperOpenHhmm")
	@Mapping(target = "marCloseTime", source = "item.marOperColseHhmm")
	@Mapping(target = "aprOpenTime", source = "item.aprOperOpenHhmm")
	@Mapping(target = "aprCloseTime", source = "item.aprOperColseHhmm")
	@Mapping(target = "mayOpenTime", source = "item.mayOperOpenHhmm")
	@Mapping(target = "mayCloseTime", source = "item.mayOperColseHhmm")
	@Mapping(target = "junOpenTime", source = "item.junOperOpenHhmm")
	@Mapping(target = "junCloseTime", source = "item.junOperColseHhmm")
	@Mapping(target = "julOpenTime", source = "item.julOperOpenHhmm")
	@Mapping(target = "julCloseTime", source = "item.julOperColseHhmm")
	@Mapping(target = "augOpenTime", source = "item.augOperOpenHhmm")
	@Mapping(target = "augCloseTime", source = "item.augOperColseHhmm")
	@Mapping(target = "sepOpenTime", source = "item.sepOperOpenHhmm")
	@Mapping(target = "sepCloseTime", source = "item.sepOperColseHhmm")
	@Mapping(target = "octOpenTime", source = "item.octOperOpenHhmm")
	@Mapping(target = "octCloseTime", source = "item.octOperColseHhmm")
	@Mapping(target = "novOpenTime", source = "item.novOperOpenHhmm")
	@Mapping(target = "novCloseTime", source = "item.novOperColseHhmm")
	@Mapping(target = "decOpenTime", source = "item.decOperOpenHhmm")
	@Mapping(target = "decCloseTime", source = "item.decOperColseHhmm")
	@Mapping(target = "restrictedItem", source = "item.lmttPrdlst")
	@Mapping(target = "agencyName", source = "item.institutionNm")
	@Mapping(target = "phoneNumber", source = "item.phoneNumber")
	FoodTruckPermitArea toEntity(Item item);
	
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
	
}
