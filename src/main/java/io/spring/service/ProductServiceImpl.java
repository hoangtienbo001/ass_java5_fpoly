package io.spring.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import io.spring.entities.Product;
import io.spring.repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired(required = true)
	private ProductRepository productRepository;

	@Override
	public List<Product> getAllProducts() {
		return productRepository.findAll();
	}

	@Override
	public Product getById(String id) {
		return productRepository.findCategoryById(Integer.parseInt(id));
	}

	@Override
	public Product create(Product product) {
		return productRepository.save(product);
	}

	@Override
	public void delete(Integer id) {
		productRepository.deleteById(id);
		
	}

	@Override
	public List<Product> pageable(int pageSize, int pageNumber) {
		return null;
	}



}
