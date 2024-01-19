package com.tcs.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.tcs.app.entity.ProductEntity;

import jakarta.transaction.Transactional;

public interface ProductRepository extends JpaRepository<ProductEntity, Integer> {
		
		/*
		 * using jpql query
		 */
		//@Query(value = "SELECT P FROM ProductEntity P WHERE P.unitprice BETWEEN ?1 AND ?2")
		
		/*
		 * using native query i.e normal sql query
		 */
		@Query(value="select * from prod_tbl where unitprice between ? and ?",nativeQuery=true)
		List<ProductEntity> fetchProductsWithPriceBetween(Double lowPrice, Double highPrice);
		
		
		/*
		 * fetch the products whose name starts with the letter 'E'
		 */
		
		@Query(value ="select p from ProductEntity p where p.productName like concat('%',?1,'%')")
		List<ProductEntity> fetchProductsByName(String letter);
		
		/*
		 * remove the product
		 */
		
		@Query(value="delete from ProductEntity p where p.unitprice<?1")
		@Modifying
		@Transactional
		int removeProductsByPrice(double price);
		
		List<ProductEntity> getProductsByQuantity(int quantity);
		
		
	
}
