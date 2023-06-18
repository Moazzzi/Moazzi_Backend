package moadda.moazzi.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import moadda.moazzi.dto.festival.FestivalPageResponseDto;
import moadda.moazzi.dto.festival.FestivalRequestDto;
import moadda.moazzi.dto.festival.FestivalResponseDto;
import moadda.moazzi.service.FestivalService;
import moadda.moazzi.service.OpenApiFestivalService;

@RestController
@RequestMapping("/api/v1/festivals")
@RequiredArgsConstructor
public class FestivalController {
	private final OpenApiFestivalService apiFestivalService;
	private final FestivalService festivalService;
	
	//@GetMapping("init")
	public ResponseEntity<?> initData(){
		apiFestivalService.initDataInsert();
		return ResponseEntity.ok().build();
	}
	
	@GetMapping
	public ResponseEntity<?> getFestivals(FestivalRequestDto festivalRequestDto){
		System.out.println(festivalRequestDto);
		FestivalPageResponseDto festivalPageResponseDto = festivalService.getFestivals(festivalRequestDto);
		return ResponseEntity.ok(festivalPageResponseDto); 
	}
	
	@GetMapping("/{festivalId}")
	public ResponseEntity<?> getFestival(@PathVariable Long festivalId){
		FestivalResponseDto festival = festivalService.getgetFestival(festivalId);
		return ResponseEntity.ok(festival);
	}
	
}
