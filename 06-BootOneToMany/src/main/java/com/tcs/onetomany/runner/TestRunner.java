package com.tcs.onetomany.runner;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import com.tcs.onetomany.entities.CategoryEntity;
import com.tcs.onetomany.entities.ItemEntity;
import com.tcs.onetomany.repository.CategoryRepository;


@Component
public class TestRunner implements ApplicationRunner {


	@Autowired
	CategoryRepository categoryRepo;

	@Override
	public void run(ApplicationArguments args) throws Exception {
				
		CategoryEntity categoryEntity=new CategoryEntity();
		categoryEntity.setCategoryId(1011);
		categoryEntity.setCategoryName("Electronics");
		/*
		 * 
		 * 
		 * ItemEntity item1 = new ItemEntity(); item1.setItem_id(1);
		 * item1.setItem_name("TV");
		 * 
		 * ItemEntity item2 = new ItemEntity(); item2.setItem_id(2);
		 * item2.setItem_name("Phone");
		 * 
		 * ItemEntity item3 = new ItemEntity(); item3.setItem_id(3);
		 * item3.setItem_name("Watch");
		 * 
		 * List<ItemEntity> lst=Arrays.asList(item1,item2,item3);
		 * categoryEntity.setItemCollection(lst);
		 * 
		 * categoryRepo.save(categoryEntity);
		 */
		 
		
		categoryRepo.deleteById(1011);
		
		
		



	}


}
