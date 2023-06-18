package moadda.moazzi.mapper;

import java.time.LocalDate;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import moadda.moazzi.dto.openapi.Item;
import moadda.moazzi.entity.Festival;

@Mapper(componentModel = "spring")
public interface FestivalMapper {
	
	@Mapping(target = "id", ignore = true)
	@Mapping(target = "name", source = "item.fstvlNm")
	@Mapping(target = "location", source = "item.opar")
	@Mapping(target = "startDate", source = "item.fstvlStartDate", qualifiedByName = "toLocalDate")
	@Mapping(target = "endDate", source = "item.fstvlEndDate", qualifiedByName = "toLocalDate")
	@Mapping(target = "content", source = "item.fstvlCo")
	@Mapping(target = "hostOrganization", source = "item.mnnst")
	@Mapping(target = "sponsor", source = "item.suprtInstt")
	@Mapping(target = "phoneNumber", source = "item.phoneNumber")
	@Mapping(target = "homePageUrl", source = "item.homepageUrl")
	@Mapping(target = "roadAddress", source = "item.rdnmadr")
	@Mapping(target = "jibunAddress", source = "item.lnmadr")
	@Mapping(target = "latitude", source = "item.latitude", qualifiedByName = "toDouble")
	@Mapping(target = "longitude", source = "item.longitude", qualifiedByName = "toDouble")
	Festival toEntity(Item item);
	
	@Named("toLocalDate")
	default LocalDate toLocalDate(String date) {
		return LocalDate.parse(date);
	}
	
	@Named("toDouble")
	default Double toDouble(String doubleString) {
		try {
			return Double.parseDouble(doubleString);
		}catch(Exception e) {
			return 0.0;
		}
	}
}
