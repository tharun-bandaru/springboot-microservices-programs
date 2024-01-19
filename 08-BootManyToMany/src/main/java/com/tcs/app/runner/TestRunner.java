package com.tcs.app.runner;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import com.tcs.app.entities.AuthorEntity;
import com.tcs.app.entities.BookEntity;
import com.tcs.app.repositories.BookRepository;

import jakarta.transaction.Transactional;

@Component
@Transactional
public class TestRunner implements ApplicationRunner {

	@Autowired
	BookRepository bookRepo;
	@Override
	public void run(ApplicationArguments args) throws Exception {
		
		/*
		 * creating instances of book
		 */
		/*
		 * BookEntity b1=new BookEntity(); b1.setBookId(1);
		 * b1.setBookName("Learn Java");
		 * 
		 * BookEntity b2=new BookEntity(); b2.setBookId(2); b2.setBookName("Lear AWS");
		 */		
		/*
		 * creating instances of author
		 */
		/*
		 * AuthorEntity a1=new AuthorEntity(101,"A"); AuthorEntity a2=new
		 * AuthorEntity(102,"B"); AuthorEntity a3=new AuthorEntity(103,"C");
		 * 
		 */
	
		
		/*
		 * List<AuthorEntity> lstOfAuthorsBook1= Arrays.asList(a1,a3);
		 * List<AuthorEntity> lstOfAuthorsBook2= Arrays.asList(a1,a2,a3);
		 * 
		 * b1.setAuthorsList(lstOfAuthorsBook1); b2.setAuthorsList(lstOfAuthorsBook2);
		 * 
		 * bookRepo.save(b1); bookRepo.save(b2);
		 */
		
		BookEntity b=bookRepo.findById(2).get();
		List<AuthorEntity> lst=b.getAuthorsList();
		System.out.println("lst of authors for 103: "+lst);
		lst.forEach(author->{
			if(author.getAuthorId()==103)
				lst.remove(author);
		});
		
		
		
	}
	
	

}
