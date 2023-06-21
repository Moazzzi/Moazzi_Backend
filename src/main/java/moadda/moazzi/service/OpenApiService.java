package moadda.moazzi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import moadda.moazzi.dto.openapi.data.go.kr.festival.CultureFestivalDto;
import moadda.moazzi.dto.openapi.data.go.kr.festival.Item;
import moadda.moazzi.entity.Festival;
import moadda.moazzi.mapper.FestivalMapper;
import moadda.moazzi.repository.FestivalRepository;

@Slf4j
@Service
@RequiredArgsConstructor
public class OpenApiService {
	
	@Value("${apikeys.festival}")
	private String FESTIVAL_API_KEY;
	private final WebClient webClient;
	private final FestivalRepository festivalRepository;
	private final FestivalMapper festivalMapper;
	
	public void initFestivalDataInsert() {
		for(int i = 1; i <= getFestivalTotalPage(); i++) {
			saveFestivalData(getFestivalData(i));
		}
	}
	
	private int getFestivalTotalPage() {
		return (int) Math.ceil(totalCountFestivalData() / 100);
	}
	
	private int totalCountFestivalData() {
		return Integer.parseInt(getFestivalData(1, 1).getResponse().getBody().getTotalCount());
	}
	
	private List<Item> getFestivalData(int pageNo) {
		return getFestivalData(pageNo, 100).getResponse().getBody().getItems();
	}
	
	private void saveFestivalData(List<Item> items) {
		List<Festival> festivals = items.stream().map(festivalMapper::toEntity).toList();
		for(Festival festival : festivals ) {
			//festivalRepository.save(festival);
			log.info(festival.toString());
		}
	}
	
	private CultureFestivalDto getFestivalData(int pageNo, int numOfRows) {
		return webClient.get()
		        .uri("http://api.data.go.kr/openapi", uriBuilder -> uriBuilder
		        		.path("/tn_pubr_public_cltur_fstvl_api")
		                .queryParam("serviceKey", FESTIVAL_API_KEY)
		                .queryParam("type", "json")
		                .queryParam("pageNo", pageNo)
		                .queryParam("numOfRows", numOfRows)
		                .build())
		        .retrieve()
		        .bodyToMono(CultureFestivalDto.class)
		        .block();
	}
	
}
