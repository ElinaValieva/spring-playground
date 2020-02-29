package com.spring.image.service;

import com.spring.image.model.Image;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * author: ElinaValieva on 07.10.2018
 */
@Service
public class ImageService {

    private List<Image> init() {
        List<Image> images = new ArrayList<>();
        for (int i = 1; i <= 10; i++) {
            Image image = new Image();
            image.setId(i);
            image.setName("name" + i);
            image.setDescription("description" + i);
            images.add(image);
        }
        return images;
    }

    public List<Image> getImages(){
        return init();
    }
}
