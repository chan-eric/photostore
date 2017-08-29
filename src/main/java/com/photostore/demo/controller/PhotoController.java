package com.photostore.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.photostore.demo.domain.PhotoStore;
import com.photostore.demo.repositories.PhotoStorageRepository;

@RestController
@RequestMapping("test")
public class PhotoController {
	
	@Autowired PhotoStorageRepository repo;

	@GetMapping("findall")
	public Iterable<PhotoStore> getAll() {
		
		Iterable<PhotoStore> x = repo.findAll();
		
		return x;
		
	}
	
	
	@PostMapping("insert/{id}")
	public String postOne(@PathVariable("id") String id, @RequestParam("name") String name)	{
		
		PhotoStore entity = new PhotoStore();
		entity.setName(name);
		PhotoStore res = repo.save(entity);
		
		return res.getId();
	}
}
