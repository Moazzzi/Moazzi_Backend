package moadda.moazzi.mapper;

import java.time.LocalDate;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import moadda.moazzi.dto.festival.FestivalRequestDto;
import moadda.moazzi.dto.festival.FestivalResponseDto;
import moadda.moazzi.dto.openapi.festival.Item;
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
	
	@Mapping(target = "id", source = "festival.id")
	@Mapping(target = "name", source = "festival.name")
	@Mapping(target = "location", source = "festival.location")
	@Mapping(target = "startDate", source = "festival.startDate")
	@Mapping(target = "endDate", source = "festival.endDate")
	@Mapping(target = "content", source = "festival.content")
	@Mapping(target = "hostOrganization", source = "festival.hostOrganization")
	@Mapping(target = "sponsor", source = "festival.sponsor")
	@Mapping(target = "phoneNumber", source = "festival.phoneNumber")
	@Mapping(target = "homePageUrl", source = "festival.homePageUrl")
	@Mapping(target = "roadAddress", source = "festival.roadAddress")
	@Mapping(target = "jibunAddress", source = "festival.jibunAddress")
	@Mapping(target = "latitude", source = "festival.latitude")
	@Mapping(target = "longitude", source = "festival.longitude")
	FestivalResponseDto toDto (Festival festival);
	
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
