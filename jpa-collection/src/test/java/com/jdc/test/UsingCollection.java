package com.jdc.test;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class UsingCollection {

	static EntityManagerFactory emf;
	
	@BeforeAll
	static void init() {
		emf = Persistence.createEntityManagerFactory("jpa-collection");
	}
	
	@AfterAll
	static void close() {
		if(emf != null && emf.isOpen()) {
			emf.close();
		}
	}
	
	@Test
	void test() {
		
	}
}
