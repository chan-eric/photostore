package com.photostore.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.photostore.demo.domain.ErrorResponse;
import com.photostore.demo.domain.PhotoStore;
import com.photostore.demo.repositories.PhotoStorageRepository;

import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@RestController
@RequestMapping("test")
public class PhotoController {
	
	@Autowired PhotoStorageRepository repo;

	@ApiResponses(value = {
			@ApiResponse(code = 204, message = "No content"),
            @ApiResponse(code = 400, message = "Bad Request", response=ErrorResponse.class),
            @ApiResponse(code = 500, message = "Internal Server Error", response=ErrorResponse.class) })
	@GetMapping("findall")
	public Iterable<PhotoStore> getAll(
			@ApiParam(value = "photo name", required = false)
			@RequestParam(value = "name", required=false) String name) {
		
		if (name != null && !name.isEmpty()) {
			
			return repo.findByName(name);
		}
		Iterable<PhotoStore> res = repo.findAll();
		
		return res;
		
	}
	
	
	@ApiResponses(value = {
			@ApiResponse(code = 204, message = "No content"),
            @ApiResponse(code = 400, message = "Bad Request", response=ErrorResponse.class),
            @ApiResponse(code = 500, message = "Internal Server Error", response=ErrorResponse.class) })
	@PostMapping("insert")
	public String postOne(@RequestBody PhotoStore entity)	{
		
		PhotoStore res = repo.save(entity);
		
		return res.getId();
	}
}
