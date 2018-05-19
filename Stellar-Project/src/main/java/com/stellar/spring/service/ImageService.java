package com.stellar.spring.service;

import java.util.Set;

import com.stellar.spring.domain.Image;


public interface ImageService {

	Set<Image> getImages();
	
	Image randomImage();
}
