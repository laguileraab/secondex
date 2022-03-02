package com.avangenio;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DataRepository extends CrudRepository<Data, Integer>{
    String findByName(String name);
    String findByCity(String lot);
    List<Product> findByEnvelop(EnvelopType envelop);
}

