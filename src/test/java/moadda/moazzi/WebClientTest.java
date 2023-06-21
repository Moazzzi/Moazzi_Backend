package moadda.moazzi;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.client.response.MockRestResponseCreators.withSuccess;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClient.ResponseSpec;
import org.springframework.web.util.DefaultUriBuilderFactory;
import org.springframework.web.util.DefaultUriBuilderFactory.EncodingMode;
import org.springframework.web.util.UriComponentsBuilder;

import moadda.moazzi.constant.PlaceType;
import moadda.moazzi.dto.openapi.data.go.kr.comm.OpenApiResponse;
import moadda.moazzi.dto.openapi.data.go.kr.festival.FestivalItem;
import moadda.moazzi.dto.openapi.data.go.kr.permitArea.PermitAreaItem;
import moadda.moazzi.entity.Festival;
import moadda.moazzi.entity.FoodTruckPermitArea;
import moadda.moazzi.mapper.FestivalMapper;
import moadda.moazzi.mapper.PermitAreaMapper;

@SpringBootTest
class WebClientTest {
	@Autowired
	FestivalMapper festivalMapper;
	@Autowired
	PermitAreaMapper permitAreaMapper;
	
	//@Test
//	void test() {
//		DefaultUriBuilderFactory uriBuilderFactory = new DefaultUriBuilderFactory();
//		uriBuilderFactory.setEncodingMode(EncodingMode.NONE);
//
//		WebClient client = WebClient.builder()
//		        .uriBuilderFactory(uriBuilderFactory)
//		        .build();
//
//		CultureFestivalDto cultureFestivalDto = client.get()
//		        .uri("http://api.data.go.kr", uriBuilder -> uriBuilder
//		        		.path("/openapi/tn_pubr_public_cltur_fstvl_api")
//		                .queryParam("serviceKey", "")
//		                .queryParam("type", "json")
//		                .queryParam("pageNo", "1")
//		                .queryParam("numOfRows", "10")
//		                .build())
//		        .retrieve()
//		        .bodyToMono(CultureFestivalDto.class)
//		        .block();
//		
//		List<Item> items = cultureFestivalDto.getResponse().getBody().getItems();
//		
//		for(Item item : items ) {
//			Festival festival = festivalMapper.toEntity(item);
//			System.out.println(festival);
//		}
//	}
	
	@Test
	void permitAreaApi() {
		DefaultUriBuilderFactory uriBuilderFactory = new DefaultUriBuilderFactory();
		uriBuilderFactory.setEncodingMode(EncodingMode.NONE);

		WebClient client = WebClient.builder()
		        .uriBuilderFactory(uriBuilderFactory)
		        .build();

		OpenApiResponse<PermitAreaItem> permitAreaDto  = client.get()
		        .uri("http://api.data.go.kr/openapi", uriBuilder -> uriBuilder
		        		.path("/tn_pubr_public_food_truck_permit_area_api")
		                .queryParam("serviceKey", "")
		                .queryParam("type", "json")
		                .queryParam("pageNo", "1")
		                .queryParam("numOfRows", "10")
		                .build())
		        .retrieve()
		        .bodyToMono(new ParameterizedTypeReference<OpenApiResponse<PermitAreaItem>>() {})
		        .block();
		
		List<PermitAreaItem> items = permitAreaDto.getResponse().getBody().getItems();
		
		for(moadda.moazzi.dto.openapi.data.go.kr.permitArea.PermitAreaItem item : items ) {
			FoodTruckPermitArea foodTruckPermitArea = permitAreaMapper.toEntity(item);
			System.out.println(foodTruckPermitArea);
		}
	}
}
