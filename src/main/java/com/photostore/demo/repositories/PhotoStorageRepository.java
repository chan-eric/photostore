package com.photostore.demo.repositories;

import java.util.List;

import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.data.repository.CrudRepository;

import com.photostore.demo.domain.PhotoStore;

@EnableScan
public interface PhotoStorageRepository extends CrudRepository<PhotoStore, String> {

	
	List<PhotoStore> findById(String id);
	
	List<PhotoStore> findByName(String name);
}
