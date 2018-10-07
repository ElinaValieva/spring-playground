package com.elina.gallery;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * author: ElinaValieva on 07.10.2018
 */
@RestController
public class GalleryController {

    @GetMapping("/gallery")
    public String galleries() {
        return "gallery service, say hello!";
    }
}
