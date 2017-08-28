package com.photostore.demo.repositories;

import org.springframework.data.repository.CrudRepository;

import com.photostore.demo.domain.PhotoStore;

public interface PhotoStorage1Repository extends CrudRepository<PhotoStore, String> {

}
