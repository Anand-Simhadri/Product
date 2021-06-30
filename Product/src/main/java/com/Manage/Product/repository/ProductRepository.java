package com.Manage.Product.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.Manage.Product.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {

	@Query("select u from Product u where u.productName = ?1")
	Product findByProductNameEquals(String productName);

	@Query("select u from Product u where u.productId = ?1")
	Product findByProductId(Integer productId);
	
	@Query("select u from Product u where u.productCategory = ?1")
	List<Product> findByProductCategoryEquals(String category);
	
	@Query("select u from Product u where u.productPrice = ?1")
	List<Product> findByProductPriceEquals(Double productprice);
	
	@Query("select u from Product u where u.productName like ?1%")
	List<Product> findByProductNameStartsWithLike(String productName);
	
	@Query("select u from Product u where u.productName like %?1")
	List<Product> findByProductNameEndingWithLike(String productName);
	
	@Query("select u from Product u where u.productPrice <= ?1")
	List<Product> findByProductThanEqual(Double productprice);
	
	@Query("select u from Product u where u.productPrice >= ?1")
	List<Product> findByProductGreaterThanEqual(Double productprice);
	
	@Query("select u from Product u where u.productCategory like ?1%")
	List<Product> findByProductCategoryStartsWithLike(String productCategory);
	
	@Query("select u from Product u where u.productCategory like %?1")
	List<Product> findByProductCategoryEndsWithLike(String productCategory);

}
