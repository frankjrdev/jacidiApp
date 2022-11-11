package com.jacidi.asignacion.entities;


import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Entity
@Table( name = "shipment", schema = "jacidi")
public class Shipment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column( name = "id")
    private Integer id;

    @OneToOne(fetch=FetchType.EAGER)
    @JoinColumn( name = "id_client", referencedColumnName = "id")
    private Client client;

    @OneToMany(mappedBy = "shipment")
    private List<Product> products;

    @Column( name = "totalCost")
    private BigDecimal totalCost;

    @Column( name = "deliverDate")
    private Date deliverDate;


    public Integer getId() {
        return id;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public BigDecimal getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(BigDecimal totalCost) {
        this.totalCost = totalCost;
    }

    public Date getDeliverDate() {
        return deliverDate;
    }

    public void setDeliverDate(Date deliverDate) {
        this.deliverDate = deliverDate;
    }
}
