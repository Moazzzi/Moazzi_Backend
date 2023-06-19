package moadda.moazzi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import lombok.RequiredArgsConstructor;
import moadda.moazzi.dto.openapi.CultureFestivalDto;
import moadda.moazzi.dto.openapi.Item;
import moadda.moazzi.entity.Festival;
import moadda.moazzi.mapper.FestivalMapper;
import moadda.moazzi.repository.FestivalRepository;

@Service
@RequiredArgsConstructor
public class OpenApiFestivalService {
	
	@Value("${apikeys.festival}")
	private String API_KEY;
	private final WebClient webClient;
	private final FestivalRepository festivalRepository;
	private final FestivalMapper festivalMapper;
	
	public void initDataInsert() {
		int totalCount = totalCountFestivalData();
		int page = (int) Math.ceil(totalCount / 100.0);
		
		for(int i = 1; i <= page; i++) {
			CultureFestivalDto cultureFestivalDto = getFestivalData(i);
			List<Item> items = cultureFestivalDto.getResponse().getBody().getItems();
			
			for(Item item : items ) {
				Festival festival = festivalMapper.toEntity(item);
				festivalRepository.save(festival);
				//System.out.println(festival);
			}
		}
	}
	
	private int totalCountFestivalData() {
		CultureFestivalDto cultureFestivalDto = getFestivalData(1, 1);
		return Integer.parseInt(cultureFestivalDto.getResponse().getBody().getTotalCount());
	}
	
	private CultureFestivalDto getFestivalData(int pageNo) {
		return getFestivalData(pageNo, 100);
	}
	
	private CultureFestivalDto getFestivalData(int pageNo, int numOfRows) {
		return webClient.get()
		        .uri("http://api.data.go.kr", uriBuilder -> uriBuilder
		        		.path("/openapi/tn_pubr_public_cltur_fstvl_api")
		                .queryParam("serviceKey", API_KEY)
		                .queryParam("type", "json")
		                .queryParam("pageNo", pageNo)
		                .queryParam("numOfRows", numOfRows)
		                .build())
		        .retrieve()
		        .bodyToMono(CultureFestivalDto.class)
		        .block();
	}
	
}
