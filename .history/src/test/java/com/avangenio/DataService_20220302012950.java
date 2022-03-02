package com.avangenio;

import java.util.ArrayList;
import java.util.List;

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

    public List<Data> getDataByCity(String city) {
        return dataRepository.findByCity(city);
    }

    public List<Data> getDataByName(String lot) {
        return dataRepository.findByLot(lot);
    }

    public List<Data> getDatatById(Boolean fragile) {
        return dataRepository.findByFragile(fragile);
    }

}
