package com.elina.gallery;

import com.elina.gallery.model.Gallery;
import com.elina.gallery.service.GalleryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * author: ElinaValieva on 07.10.2018
 */
@RestController
public class GalleryController {

    @Autowired
    private GalleryService galleryService;

    @GetMapping("/gallery")
    public Gallery galleries() {
        return galleryService.getGallery();
    }
}
