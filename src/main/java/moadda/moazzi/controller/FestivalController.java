package moadda.moazzi.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import moadda.moazzi.dto.festival.FestivalPageResponseDto;
import moadda.moazzi.dto.festival.FestivalRequestDto;
import moadda.moazzi.dto.festival.FestivalResponseDto;
import moadda.moazzi.service.FestivalService;
import moadda.moazzi.service.OpenApiFestivalService;

@RestController
@RequestMapping("/api/v1/festivals")
@RequiredArgsConstructor
@Tag(name = "축제", description = "축제 정보 api 입니다.")
public class FestivalController {
	private final OpenApiFestivalService apiFestivalService;
	private final FestivalService festivalService;
	
	//@GetMapping("init")
	public ResponseEntity<?> initData(){
		apiFestivalService.initDataInsert();
		return ResponseEntity.ok().build();
	}
	
	@Operation(summary = "축제 데이터 리스트 조회", description = "축제 데이터 리스트 조회 메서드입니다.")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "조회 성공", content = @Content(schema = @Schema(implementation = FestivalPageResponseDto.class))),
        //@ApiResponse(responseCode = "400", description = "Bad Request", content = @Content(schema = @Schema(implementation = Error.class)))
    })
	@GetMapping
	public ResponseEntity<FestivalPageResponseDto> getFestivals(@Parameter(description = "조회 조건") FestivalRequestDto festivalRequestDto){
		System.out.println(festivalRequestDto);
		FestivalPageResponseDto festivalPageResponseDto = festivalService.getFestivals(festivalRequestDto);
		return ResponseEntity.ok(festivalPageResponseDto); 
	}
	
	@Operation(summary = "축제 데이터 상세 조회", description = "축제 데이터 상세 조회 메서드입니다.")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "조회 성공", content = @Content(schema = @Schema(implementation = FestivalResponseDto.class))),
        //@ApiResponse(responseCode = "400", description = "Bad Request", content = @Content(schema = @Schema(implementation = Error.class)))
    })
	@GetMapping("/{festivalId}")
	public ResponseEntity<FestivalResponseDto> getFestival(@Parameter(description = "축제데이터 ID") @PathVariable Long festivalId){
		FestivalResponseDto festival = festivalService.getgetFestival(festivalId);
		return ResponseEntity.ok(festival);
	}
	
}
