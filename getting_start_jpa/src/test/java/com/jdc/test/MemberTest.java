package com.jdc.test;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.jdc.entity.Member;

public class MemberTest {

	static EntityManagerFactory emf;
	
	@BeforeAll
	static void initial() {
		emf = Persistence.createEntityManagerFactory("getting_start_jpa");
	}
	
	@AfterAll
	static void finish() {
		if(emf != null &&  emf.isOpen()) {
			emf.close();
		}
	}
	
	@Test
	void test_member() {
		
		var member = new Member();
		member.setName("Eric");
		
		var em = emf.createEntityManager();
		
		em.getTransaction().begin();
		
		em.persist(member);
		
		em.getTransaction().commit();
		
	}
}
