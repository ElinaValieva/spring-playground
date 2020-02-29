package com.spring.image;

import com.spring.image.model.Image;
import com.spring.image.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * author: ElinaValieva on 07.10.2018
 */
@RestController
public class ImageController {

    @Autowired
    private ImageService imageService;

    @GetMapping("/images")
    public List<Image> images() {
        return imageService.getImages();
    }
}
