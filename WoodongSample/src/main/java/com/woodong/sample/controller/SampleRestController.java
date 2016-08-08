package com.woodong.sample.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.woodong.sample.bean.Sample;
import com.woodong.sample.bean.SampleBean;
import com.woodong.sample.mapper.SampleJpaMapper;

@RestController
public class SampleRestController {
	@Autowired
	private SampleJpaMapper sampleMapper;

	@RequestMapping("/add")
	public Sample add(Sample sample) {
		Sample sampleData = sampleMapper.save(sample);
		return sampleData;
	}

	@RequestMapping("/list")
	public List<Sample> list(Model model) {
		List<Sample> sampleList = sampleMapper.findAll();
		return sampleList;
	}

	@RequestMapping("/fgt/index")
	public List<SampleBean> fgtSample() {
		List<SampleBean> list = new ArrayList<SampleBean>();

		list.add(new SampleBean("key1", "value1"));
		list.add(new SampleBean("key2", "value2"));
		list.add(new SampleBean("key3", "value3"));

		return list;
	}
}