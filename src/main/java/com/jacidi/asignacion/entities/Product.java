package com.jacidi.asignacion.entities;


import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "product", schema = "jacidi")
public class Product {

    @ManyToOne
    @JoinColumn(nullable=false)
    private Shipment shipment;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Integer id;

    @Column(name = "name")
    private  String name;

    @Column(name = "cost")
    private BigDecimal cost;

    @Column(name = "minPrio")
    private Integer minPrio;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getCost() {
        return cost;
    }

    public void setCost(BigDecimal cost) {
        this.cost = cost;
    }

    public Integer getMinPrio() {
        return minPrio;
    }

    public void setMinPrio(Integer minPrio) {
        this.minPrio = minPrio;
    }
}
