package moadda.moazzi.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import moadda.moazzi.service.OpenApiService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/openapi")
public class OpenApiController {
	private final OpenApiService openApiService;
	
	@GetMapping("/init/festival")
	public ResponseEntity<?> initData(){
		openApiService.initFestivalDataInsert();
		return ResponseEntity.ok().build();
	}
}
