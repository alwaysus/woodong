package com.woodong.sample.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.woodong.sample.bean.Sample;
import com.woodong.sample.dao.SampleJpaDao;

@Controller
public class WoodongController {
	@Autowired
	private SampleJpaDao sampleDao;

	@RequestMapping("/sample")
	public String sample(Model model) {
		model.addAttribute("name", "Sample SpringBoot Project");
		return "sample";
	}

	@RequestMapping("/samplelist")
	public String sampleList(Model model) {
		List<Sample> sampleList = sampleDao.findAll();
		model.addAttribute("samplelist", sampleList);
		return "samplelist";
	}
}