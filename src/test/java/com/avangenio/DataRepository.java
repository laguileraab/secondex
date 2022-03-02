package com.avangenio;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DataRepository extends CrudRepository<Data, Integer>{
    List<Data> findByName(String name);
    List<Data> findByCity(String lot);
    List<Data> findById(String id);
}

