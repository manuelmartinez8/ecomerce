package com.example.demo.repository;

import com.example.demo.entity.BrandEntity;

import org.springframework.data.jpa.repository.JpaRepository;

public interface BrandRepository extends JpaRepository<BrandEntity, Long> {
}
