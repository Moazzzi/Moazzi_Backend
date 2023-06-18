package moadda.moazzi.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import moadda.moazzi.service.FestivalService;
import moadda.moazzi.service.OpenApiFestivalService;

@RestController
@RequestMapping("/api/v1/festival")
@RequiredArgsConstructor
public class FestivalController {
	private final OpenApiFestivalService apiFestivalService;
	
	//@GetMapping("init")
	public ResponseEntity<?> initData(){
		apiFestivalService.initDataInsert();
		return ResponseEntity.ok().build();
	}
}
