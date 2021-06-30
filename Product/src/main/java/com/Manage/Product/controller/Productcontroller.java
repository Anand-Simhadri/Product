package com.Manage.Product.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Manage.Product.entity.Product;
import com.Manage.Product.exception.ProductnotSavedException;
import com.Manage.Product.exception.Productnotfoundexception;
import com.Manage.Product.service.ProductService;


@RestController
@RequestMapping("api")
public class Productcontroller {

	@Autowired
	private ProductService productService;

	@PostMapping("/product/saveproduct")
	public ResponseEntity<Product> saveproduct(@RequestBody Product product) {
		Product product1 = productService.save(product);
		if (null != product1) {
			return new ResponseEntity<>(product1, HttpStatus.OK);
		} else {
			throw new ProductnotSavedException();
		}
	}

	@DeleteMapping("/products/{productid}")
	public void deleteproduct(@PathVariable Integer productid) {
		productService.delete(productid);
	}

	@PutMapping("/products/{productid}")
	public Product modifyproduct(@RequestBody Product product, @PathVariable Integer productid) { 
		return productService.updateProuct(product, productid);
	}
	
	@GetMapping("/product/searchproduct/{id}")
	public ResponseEntity<Product> getproduct(@PathVariable Integer id) {
		Product product = productService.findByproductId(id);
		if (null != product) {
			return new ResponseEntity<>(product, HttpStatus.OK);
		} else {
			throw new Productnotfoundexception();
		}
	}
	
	@GetMapping("/product/findAll")
	public ResponseEntity<List<Product>> findAll() {
		List<Product> product = productService.findAll();
		if (null != product) {
			return new ResponseEntity<>(product, HttpStatus.OK);
		} else {
			throw new Productnotfoundexception();
		}
	}
	
	@GetMapping("/product/searchproductbyname/{name}")
	public ResponseEntity<Product> getproductByName(@PathVariable String name) {
		Product product = productService.findByproductName(name);
		if (null != product) {
			return new ResponseEntity<>(product, HttpStatus.OK);
		} else {
			throw new Productnotfoundexception();
		}
	}
	
	@GetMapping("/product/searchproductbycategory/{category}")
	public ResponseEntity<List<Product>> getproductByCategory(@PathVariable String category) {
		List<Product> product = productService.findByproductCategory(category);
		if (null != product) {
			return new ResponseEntity<>(product, HttpStatus.OK);
		} else {
			throw new Productnotfoundexception();
		}
	}
	
	@GetMapping("/product/searchproductbyprice/{price}")
	public ResponseEntity<List<Product>> getproductByPrice(@PathVariable Double price) {
		List<Product> product = productService.findByproductPrice(price);
		if (null != product) {
			return new ResponseEntity<>(product, HttpStatus.OK);
		} else {
			throw new Productnotfoundexception();
		}
	}
	
	@GetMapping("/product/findbyproductnamestartswith/{name}")
	public ResponseEntity<List<Product>> findByProductnameStartsWith(@PathVariable String name) {
		List<Product> product = productService.findByProductnameStartsWith(name);
		if (null != product) {
			return new ResponseEntity<>(product, HttpStatus.OK);
		} else {
			throw new Productnotfoundexception();
		}
	}
	
	@GetMapping("/product/findbyProductthanequal/{price}")
	public ResponseEntity<List<Product>> findByProductThanEqual(@PathVariable Double price) {
		List<Product> product = productService.findByProductThanEqualproductPrice(price);
		if (null != product) {
			return new ResponseEntity<>(product, HttpStatus.OK);
		} else {
			throw new Productnotfoundexception();
		}
	}
	
	@GetMapping("/product/findbyproductgreaterthanequal/{price}")
	public ResponseEntity<List<Product>> findByProductGreaterThanEqual(@PathVariable Double price) {
		List<Product> product = productService.findByProductGreaterThanEqualproductPrice(price);
		if (null != product) {
			return new ResponseEntity<>(product, HttpStatus.OK);
		} else {
			throw new Productnotfoundexception();
		}
	}
	
	@GetMapping("/product/findbyproductcategorystartswith/{category}")
	public ResponseEntity<List<Product>> findByProductcategoryStartsWith(@PathVariable String category) {
		List<Product> product = productService.findByProductcategoryStartsWith(category);
		if (null != product) {
			return new ResponseEntity<>(product, HttpStatus.OK);
		} else {
			throw new Productnotfoundexception();
		}
	}
	
	@GetMapping("/product/findByproductnameendingwith/{name}")
	public ResponseEntity<List<Product>> findByProductnameEndingWith(@PathVariable String name) {
		List<Product> product = productService.findByProductnameEndingWith(name);
		if (null != product) {
			return new ResponseEntity<>(product, HttpStatus.OK);
		} else {
			throw new Productnotfoundexception();
		}
	}
}
