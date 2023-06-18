package moadda.moazzi.service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import moadda.moazzi.dto.festival.FestivalPageResponseDto;
import moadda.moazzi.dto.festival.FestivalRequestDto;
import moadda.moazzi.dto.festival.FestivalResponseDto;
import moadda.moazzi.entity.Festival;
import moadda.moazzi.mapper.FestivalMapper;
import moadda.moazzi.repository.FestivalRepository;

@Service
@RequiredArgsConstructor
public class FestivalService {
	private final FestivalMapper festivalMapper;
	private final FestivalRepository festivalRepository;
	
	public FestivalPageResponseDto getFestivals(FestivalRequestDto festivalRequestDto){
		int pageNo = festivalRequestDto.getPageNo();
		int numOfRows = festivalRequestDto.getNumOfRows();
		String startDate = festivalRequestDto.getStartDate();
		String endDate = festivalRequestDto.getEndDate();
		
		Sort sort = Sort.by(Sort.Direction.DESC, "startDate");
		Pageable pageable = PageRequest.of(pageNo - 1, numOfRows, sort);
		
		Page<Festival> festivalPage = festivalRepository.findAllByStartDateBetween(LocalDate.parse(startDate), LocalDate.parse(endDate), pageable);
		List<FestivalResponseDto> festivalResponseDtos = festivalPage.stream().map(festivalMapper::toDto).collect(Collectors.toList());
		
		return FestivalPageResponseDto.builder()
								.pageNo(pageNo)
								.numOfRows(numOfRows)
								.totalCount(festivalPage.getTotalElements())
								.data(festivalResponseDtos)
								.build();
	}
	
	public FestivalResponseDto getgetFestival(Long festivalId) {
		Festival festival = festivalRepository.findById(festivalId).orElse(new Festival());
		return festivalMapper.toDto(festival);
	}
}
