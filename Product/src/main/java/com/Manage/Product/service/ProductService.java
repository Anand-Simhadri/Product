package com.Manage.Product.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Manage.Product.entity.Product;
import com.Manage.Product.repository.ProductRepository;

@Service
public class ProductService {

	@Autowired
	ProductRepository productRepository;

	public Product findByproductId(Integer id) {
		return productRepository.findByProductId(id);
	}

	public Product save(Product product) {

		return productRepository.save(product);
	}

	public void delete(Integer productid) {
		productRepository.deleteById(productid);
	}

	public Product updateProuct(Product product, Integer productid) {
		return productRepository.findById(productid).map(b -> {
			b.setProductName(product.getProductName());
			b.setProductCategory(product.getProductCategory());
			b.setQuantity(product.getQuantity());
			b.setProductPrice(product.getProductPrice());
			return productRepository.save(b);
		}).orElseGet(() -> {
			product.setProductId(productid);
			return productRepository.save(product);
		});

	}

	public List<Product> findAll() {
		return productRepository.findAll();
	}

	public Product findByproductName(String name) {
		return productRepository.findByProductNameEquals(name);
	}

	public List<Product> findByproductPrice(Double price) {
		return productRepository.findByProductPriceEquals(price);
	}

	public List<Product> findByproductCategory(String category) {
		return productRepository.findByProductCategoryEquals(category);
	}

	public List<Product> findByProductnameStartsWith(String name) {
		return productRepository.findByProductNameStartsWithLike(name);
	}

	public List<Product> findByProductThanEqualproductPrice(Double price) {
		return productRepository.findByProductThanEqual(price);
	}
	
	public List<Product> findByProductGreaterThanEqualproductPrice(Double price) {
		return productRepository.findByProductGreaterThanEqual(price);
	}

	public List<Product> findByProductcategoryStartsWith(String category) {
		return productRepository.findByProductCategoryStartsWithLike(category);
	}

	public List<Product> findByProductnameEndingWith(String name) {
		return productRepository.findByProductNameEndingWithLike(name);
	}

	
}
