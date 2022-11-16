package com.jacidi.asignacion.repositories;


import com.jacidi.asignacion.entities.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends CrudRepository<Product, Long> {

    List<Product> findAll();
    Product findById(int id);
    Product findByName(String name);
}
