package com.defect.manager.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.defect.manager.domain.entity.Defects;

public interface DefectsRepository extends JpaRepository<Defects, Long> {
	
	@Query("select d from Defects d where d.no = :no")
	Defects findByNo(@Param("no") Long no);
}
