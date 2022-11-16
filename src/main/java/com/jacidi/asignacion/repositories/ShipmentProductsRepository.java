package com.jacidi.asignacion.repositories;

import com.jacidi.asignacion.entities.ShipmentProducts;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ShipmentProductsRepository extends CrudRepository<ShipmentProducts, Long> {

    String REMOVE_PRODUCT_BY_ID = "DELECT * FROM jacidi.shipment_products " +
            "WHERE (id_shipment = :id_shipment)  " +
            "AND (identificacion = :id_product ) ";
    @Query(nativeQuery = true, value = REMOVE_PRODUCT_BY_ID)
    List<Integer> removeById_productAndId_shipment(
            @Param("id_shipment") Integer idShipment,
            @Param("id_product") Integer idProduct
    );


}
