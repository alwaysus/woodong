package com.woodong.sample.mapper;

import org.springframework.data.jpa.repository.JpaRepository;

import com.woodong.sample.bean.Sample;

public interface SampleJpaMapper extends JpaRepository<Sample, Integer> {

}