package com.elina.demo.repository;


import com.elina.demo.model.Model;
import org.springframework.data.repository.CrudRepository;

public interface ModelRepository extends CrudRepository<Model, Long> {

}
