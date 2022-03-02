package com.avangenio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DataService {
    @Autowired
    DataRepository dataRepository;


    public List<Data> getAllProducts() {
        List<Data> datas = new ArrayList<Data>();
        dataRepository.findAll().forEach(data -> datas.add(data));
        return datas;
    }

    public Data getProductById(int id) {
        return dataRepository.findById(id).get();
    }

    public Data saveOrUpdate(Data product) {
        return dataRepository.save(product);
    }

    public void delete(int id) {
        dataRepository.deleteById(id);
    }

    public void deleteAll() {
        dataRepository.deleteAll();
    }

}
