package com.jacidi.asignacion.repositories;


import com.jacidi.asignacion.entities.Shipment;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ShipmentRepository extends CrudRepository<Shipment, Long> {

    List<Shipment> findAll();

    Shipment findById(int id);

    String FIND_SHIPMENT_BY_ID_PRODUCT = "SELECT * FROM jacidi.shipment " +
            "WHERE (id_product = :idProduct )";
    @Query(nativeQuery = true, value = FIND_SHIPMENT_BY_ID_PRODUCT)
    List<Shipment> findByIdProduct(
            @Param("idProduct") Integer idProduct
    );

    String DELETE_SHIPMENT_BY_ID_PRODUCT = "DELECT * FROM jacidi.shipment " +
            "WHERE (id_product = :idProduct )";
    @Query(nativeQuery = true, value = DELETE_SHIPMENT_BY_ID_PRODUCT)
    Shipment deleteByIdProduct(
            @Param("idProduct") Integer idProduct
    );
}
