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
    @Column( name = "id_shipment")
    private Integer id;

    @OneToOne(cascade = {CascadeType.PERSIST})
    @JoinColumn( name = "id_client")
    private Client client;

    @Column( name = "total_cost")
    private BigDecimal totalCost;

    @Column( name = "deliver_date")
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
