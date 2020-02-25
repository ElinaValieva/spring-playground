package com.elina.gallery.model;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * author: ElinaValieva on 07.10.2018
 */
@Getter
@Setter
public class Gallery {

    private int id;
    private List<Object> images;
}
