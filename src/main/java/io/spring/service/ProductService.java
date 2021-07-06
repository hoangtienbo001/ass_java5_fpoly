package io.spring.service;

import java.util.List;

import org.springframework.stereotype.Service;

import io.spring.entities.Product;

@Service
public interface ProductService {
	Product create(Product category);
	
	void delete(Integer id);
	
	List<Product> getAllProducts();

	Product getById(String id);
	
	List<Product> pageable(int pageSize, int pageNumber);
}
