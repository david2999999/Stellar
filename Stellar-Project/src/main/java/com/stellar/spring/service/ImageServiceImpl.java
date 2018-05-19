package com.stellar.spring.service;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stellar.spring.domain.Image;
import com.stellar.spring.repositories.ImageRepository;

@Service
public class ImageServiceImpl implements ImageService {

	@Autowired
	private ImageRepository imageRepository;
	
	
	@Override
	public Set<Image> getImages() {
		Set<Image> images = new HashSet<>();
		
		imageRepository.findAll().iterator().forEachRemaining(images::add);
		
		return images;
	}


	@Override
	public Image randomImage() {
		Set<Image> images = new HashSet<>();
		images = this.getImages();
		Image randomImage = new Image();
		
		int size = images.size();
		int item = new Random().nextInt(size); // In real life, the Random object should be rather more shared than this
		int i = 0;
		
		for(Image image : images)
		{
		    if (i == item) {
		    	randomImage = image;
		    	break;
		    }  	
		    i++;
		}
		
		return randomImage;
	}
	

}
