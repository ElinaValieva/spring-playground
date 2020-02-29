package com.spring.gallery.service;

import com.spring.gallery.model.Gallery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * author: ElinaValieva on 07.10.2018
 */
@Service
public class GalleryService {

    @Autowired
    private RestTemplate restTemplate;

    public Gallery getGallery(){
        Gallery gallery = new Gallery();
        gallery.setId(1);
        List<Object> images = restTemplate.getForObject("http://image-service/images/", List.class);
        gallery.setImages(images);
        return gallery;
    }
}
