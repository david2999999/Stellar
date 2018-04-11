package com.stellar.spring.domain;

import static org.junit.Assert.*;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class TaskTest {

	Task task;
	
	@Mock
	Date date;
	
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
		
		task.setDescription(desc);
		
		assertEquals(task.getDescription(), desc);
	}
	
	@Test
	public void testGetDetail() throws Exception{
		String detail = "This is a test";
		
		task.setDescription(detail);
		
		assertEquals(task.getDescription(), detail);
	}
	
	@Test
	public void testDateCreated() throws Exception{
		task.setCreatedDate(date);
		
		assertEquals(task.getCreatedDate(), date);
	}
	
	@Test
	public void testDueDate() throws Exception{
		task.setDueDate(date);
		
		assertEquals(task.getDueDate(), date);
	}
	
	@Test
	public void testGetImage() throws Exception{
		task.setImage(image);
		
		assertEquals(task.getImage(), image);
	}
	
	@Test
	public void testGetUser() throws Exception{
		
		List<User> users = new ArrayList<User>();
		
		User user1 = new User();
		
		users.add(user1);
		
		task.setUsers(users);
		
		assertEquals(task.getUsers(), users);
	}

}
