package moadda.moazzi;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.client.response.MockRestResponseCreators.withSuccess;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClient.ResponseSpec;
import org.springframework.web.util.DefaultUriBuilderFactory;
import org.springframework.web.util.DefaultUriBuilderFactory.EncodingMode;
import org.springframework.web.util.UriComponentsBuilder;

import moadda.moazzi.dto.openapi.festival.CultureFestivalDto;
import moadda.moazzi.dto.openapi.festival.Item;
import moadda.moazzi.entity.Festival;
import moadda.moazzi.mapper.FestivalMapper;

@SpringBootTest
class WebClientTest {
	@Autowired
	FestivalMapper festivalMapper;

	//@Test
	void test() {
		DefaultUriBuilderFactory uriBuilderFactory = new DefaultUriBuilderFactory();
		uriBuilderFactory.setEncodingMode(EncodingMode.NONE);

		WebClient client = WebClient.builder()
		        .uriBuilderFactory(uriBuilderFactory)
		        .build();

		CultureFestivalDto cultureFestivalDto = client.get()
		        .uri("http://api.data.go.kr", uriBuilder -> uriBuilder
		        		.path("/openapi/tn_pubr_public_cltur_fstvl_api")
		                .queryParam("serviceKey", "")
		                .queryParam("type", "json")
		                .queryParam("pageNo", "1")
		                .queryParam("numOfRows", "10")
		                .build())
		        .retrieve()
		        .bodyToMono(CultureFestivalDto.class)
		        .block();
		
		List<Item> items = cultureFestivalDto.getResponse().getBody().getItems();
		
		for(Item item : items ) {
			Festival festival = festivalMapper.toEntity(item);
			System.out.println(festival);
		}
	}

}
