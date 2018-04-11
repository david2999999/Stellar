package com.stellar.spring.domain;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class TaskTest {

	Task task;
	
	@Mock
	Image image;
	
	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
		
		task = new Task();
	}

	@Test
	public void testGetId() throws Exception{
		long id = 4L;
		
		task.setId(id);
		
		assertEquals(task.getId(), id);
	}
	
	@Test 
	public void testGetDesc() throws Exception{
		String desc = "This is a test";
		
		task.setTitle(desc);
		
		assertEquals(task.getTitle(), desc);
	}
	
	@Test
	public void testGetDetail() throws Exception{
		String detail = "This is a test";
		
		task.setDetail(detail);
		
		assertEquals(task.getDetail(), detail);
	}
	
	@Test
	public void testDateCreated() throws Exception{
		task.setCreatedDate("April 11 2018");
		
		assertEquals(task.getCreatedDate(), "April 11 2018");
	}
	
	@Test
	public void testDueDate() throws Exception{
		task.setDueDate("February 21 2018");
		
		assertEquals(task.getDueDate(), "February 21 2018");
	}
	
	@Test
	public void testGetImage() throws Exception{
		task.setImage(image);
		
		assertEquals(task.getImage(), image);
	}
}
