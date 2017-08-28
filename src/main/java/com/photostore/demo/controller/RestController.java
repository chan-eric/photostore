package com.photostore.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@org.springframework.web.bind.annotation.RestController
@RequestMapping("test")
public class RestController {

	@GetMapping("findall")
	public List<String> getAll() {
		
		
		List<String> res = new ArrayList<>();
		res.add("abc");
		res.add("efg");
		return res;
	}
	
	@PostMapping("insert")
	public String postOne()	{
		
		
		return "ok";
	}
}
