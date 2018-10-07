package com.elina.gallery;

import com.elina.gallery.model.Gallery;
import com.elina.gallery.service.GalleryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * author: ElinaValieva on 07.10.2018
 */
@RestController
@RequestMapping("/")
public class GalleryController {

    @Autowired
    private Environment environment;

    @RequestMapping("/")
    public String home() {
        return "Hello from Gallery Service running at port: " + environment.getProperty("local.server.port");
    }

    @Autowired
    private GalleryService galleryService;

    @GetMapping("/gallery")
    public Gallery galleries() {
        return galleryService.getGallery();
    }

    @GetMapping("/hello")
    public String hey() {
        return "hello, beach!";
    }
}
