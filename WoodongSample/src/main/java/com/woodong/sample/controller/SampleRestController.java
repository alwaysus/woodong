package com.woodong.sample.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.woodong.sample.bean.Sample;
import com.woodong.sample.dao.SampleJpaDao;

@RestController
public class SampleRestController {
	@Autowired
	private SampleJpaDao sampleDao;

	@RequestMapping("/add")
	public Sample add(Sample sample) {
		Sample sampleData = sampleDao.save(sample);
		return sampleData;
	}

	@RequestMapping("/list")
	public List<Sample> list(Model model) {
		List<Sample> sampleList = sampleDao.findAll();
		return sampleList;
	}
}