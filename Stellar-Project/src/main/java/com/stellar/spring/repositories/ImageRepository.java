package com.stellar.spring.repositories;

import org.springframework.data.repository.CrudRepository;

import com.stellar.spring.domain.Image;

public interface ImageRepository extends CrudRepository<Image,Long> {

}
