package com.elina.image;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * author: ElinaValieva on 07.10.2018
 */
@RestController
public class ImageController {

    @GetMapping("/images")
    public String images() {
        return "images server, say hi";
    }
}
