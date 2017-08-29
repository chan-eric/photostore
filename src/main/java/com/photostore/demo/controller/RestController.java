package com.photostore.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.photostore.demo.domain.PhotoStore;
import com.photostore.demo.repositories.PhotoStorageRepository;

@org.springframework.web.bind.annotation.RestController
@RequestMapping("test")
public class RestController {
	
	@Autowired PhotoStorageRepository repo;

	@GetMapping("findall")
	public Iterable<PhotoStore> getAll() {
		
		if (1==1) return repo.findAll();
		
		List<String> res = new ArrayList<>();
		res.add("abc");
		res.add("efg");
		return null;
	}
	
	@PostMapping("insert/{id}")
	public String postOne()	{
		
		
		return "ok";
	}
}
