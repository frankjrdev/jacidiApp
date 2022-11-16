package com.jacidi.asignacion.entities;


import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "product", schema = "jacidi")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_product")
    private Integer id;

    @Column(name = "name")
    private  String name;

    @Column(name = "cost")
    private BigDecimal cost;

    @Column(name = "min_prio")
    private Integer minPrio;

    public Integer getId() {
        return id;
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
