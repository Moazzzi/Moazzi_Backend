package moadda.moazzi.repository;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import moadda.moazzi.entity.Festival;

public interface FestivalRepository extends JpaRepository<Festival, Long>{
	Page<Festival> findAllByStartDateBetween(LocalDate start, LocalDate end, Pageable pageable);
}
