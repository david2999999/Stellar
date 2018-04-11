package com.stellar.spring.domain;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class RoleTest {

	Role role;

	@Before
	public void setUp() throws Exception {
		role = new Role();
	}

	@Test
	public void testGetId() throws Exception {
		long id = 4L;
		
		role.setId(id);
		
		assertEquals(role.getId(), id);
	}
	
	@Test
	public void testDesc()  throws Exception{
		String desc = "This is a test";
		
		role.setDescription(desc);
		
		assertEquals(role.getDescription(), desc);
	}
	

}
