package moadda.moazzi;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.client.response.MockRestResponseCreators.withSuccess;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClient.ResponseSpec;
import org.springframework.web.util.DefaultUriBuilderFactory;
import org.springframework.web.util.DefaultUriBuilderFactory.EncodingMode;
import org.springframework.web.util.UriComponentsBuilder;

import moadda.moazzi.dto.openapi.CultureFestivalDto;
import moadda.moazzi.dto.openapi.Item;

class WebClientTest {

	@Test
	void test() {
		DefaultUriBuilderFactory uriBuilderFactory = new DefaultUriBuilderFactory("http://api.data.go.kr");
		uriBuilderFactory.setEncodingMode(EncodingMode.NONE);

		WebClient client = WebClient.builder()
		        .uriBuilderFactory(uriBuilderFactory)
		        .build();

		CultureFestivalDto cultureFestivalDto = client.get()
		        .uri(uriBuilder -> uriBuilder
		        		.path("/openapi/tn_pubr_public_cltur_fstvl_api")
		                .queryParam("serviceKey", "")
		                .queryParam("type", "json")
		                .build())
		        .retrieve()
		        .bodyToMono(CultureFestivalDto.class)
		        .block();
		
		List<Item> items = cultureFestivalDto.getResponse().getBody().getItems();
		for(Item item : items ) {
			System.out.println(item);
		}
	}

}
