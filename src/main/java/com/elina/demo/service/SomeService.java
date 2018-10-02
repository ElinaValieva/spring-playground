package com.elina.demo.service;


import com.elina.demo.repository.ModelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SomeService {

    @Autowired
    private ModelRepository modelRepository;
}
