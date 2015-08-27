package com.woodong.sample.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.woodong.sample.bean.Sample;

public interface SampleJpaDao extends JpaRepository<Sample, Integer> {

}