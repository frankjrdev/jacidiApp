package com.jacidi.asignacion.entities;


import javax.persistence.*;

@Entity
@Table(name = "shipment_products", schema = "jacidi")
public class ShipmentProducts {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idshipment_products")
    private Integer id;

    @Column(name = "id_shipment")
    private Integer id_shipment;

    @Column(name = "id_product")
    private Integer id_product;

    public ShipmentProducts() {
    }

    public Integer getId() {
        return id;
    }

    public Integer getId_shipment() {
        return id_shipment;
    }

    public void setId_shipment(Integer id_shipment) {
        this.id_shipment = id_shipment;
    }

    public Integer getId_product() {
        return id_product;
    }

    public void setId_product(Integer id_product) {
        this.id_product = id_product;
    }
}
