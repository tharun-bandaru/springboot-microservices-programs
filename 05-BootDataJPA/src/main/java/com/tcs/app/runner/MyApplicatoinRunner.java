package com.tcs.app.runner;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

import com.tcs.app.entity.ProductEntity;
import com.tcs.app.repository.ProductRepository;

@Component
public class MyApplicatoinRunner implements ApplicationRunner {

	@Autowired
	ProductRepository productRepo;
	
	@Override
	public void run(ApplicationArguments args) throws Exception {

		// to display the proxy class
		System.out.println(productRepo.getClass().getName());

		
		  ProductEntity p=new ProductEntity();
		  p.setProductId(103);p.setProductName("camera"); p.setQuantity(5);
		  p.setUnitprice(5000.0); productRepo.save(p);
		 

		// findById is used fetch the particular record by id using primary key
		// findByAll is used fetch all the records in the table
		
		  List<ProductEntity> lstOfEnt = productRepo.findAll();
		  
		  lstOfEnt.forEach(System.out::println);
		  
		  // to update the product 
		  Optional<ProductEntity> opt =
		  productRepo.findById(103); 
		  ProductEntity pe = opt.get();
		  productRepo.saveAndFlush(pe);
		 
		
		/*
		 * System.out.println("deleted the record"); //to delete the product
		 * productRepo.deleteById(103);
		 */
		
		/*
		 * fetchProductByPriceBetween
		 */
		/*
		 * List<ProductEntity> lst=productRepo.fetchProductsWithPriceBetween(20000.0,
		 * 30000.0); lst.forEach(System.out::print);
		 */
		  
			/*
			 * fetchProductByName
			 */
		   
			/*
			 * List<ProductEntity> ls=productRepo.fetchProductsByName("a");
			 * ls.forEach(System.out::println);
			 */
		  
		  /*
		   * delete products 
		   */
			/*
			 * int removeProducts= productRepo.removeProductsByPrice(10000.0);
			 * System.out.println("The no of products deleted "+removeProducts);
			 */
		  
			/*
			 * Sort sort=Sort.by("unitprice").descending(); List<ProductEntity>
			 * l=productRepo.findAll(sort); l.forEach(System.out::println);
			 */
		  /*
		   * getProductsByQuantity()
		   */
		  System.out.println("get products");
		  List<ProductEntity> l=productRepo.getProductsByQuantity(5);
		  l.forEach(System.out::print);
	}

}
