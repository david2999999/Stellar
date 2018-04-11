package com.stellar.spring.domain;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class ImageTest {

	Image image;
	
	@Before
	public void setUp() throws Exception {
		image = new Image();
	}

	@Test
	public void getId() throws Exception{
		Long id = 4L;
		
		image.setId(id);
		
		assertEquals(image.getId(), 4L);
	}
	
	@Test
	public void getUrl() throws Exception{
		String desc = "image.com";
		
		image.setUrl(desc);
		
		assertEquals(image.getUrl(), desc);
	}

}
