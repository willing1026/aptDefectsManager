package com.defect.manager.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.defect.manager.domain.entity.Apt;

public interface AptRepository extends JpaRepository<Apt, Long> {

}
