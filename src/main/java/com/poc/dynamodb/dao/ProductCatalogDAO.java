package com.poc.dynamodb.dao;

import java.util.List;

import com.poc.dynamodb.entity.ProductCatalog;
import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.data.repository.CrudRepository;

@EnableScan
public interface ProductCatalogDAO extends CrudRepository<ProductCatalog, String>{
	
	ProductCatalog findById(String id);

	List<ProductCatalog> findAll();
	

}
