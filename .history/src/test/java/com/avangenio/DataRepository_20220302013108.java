package com.avangenio;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DataRepository extends CrudRepository<Data, Integer>{
    List<String> findByName(String name);
    List<String> findByCity(String lot);
    List<String> findById(String id);
}

