package com.jacidi.asignacion.entities;


import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "membership", schema = "jacidi")
public class Membership {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id")
    private Integer id;

    @Column(name = "key")
    private String key;

    @Column(name = "name")
    private BigDecimal name;

    @Column( name = "prio")
    private Integer prio;

    @Column(name = "duration")
    private Long duration;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public BigDecimal getName() {
        return name;
    }

    public void setName(BigDecimal name) {
        this.name = name;
    }

    public Integer getPrio() {
        return prio;
    }

    public void setPrio(Integer prio) {
        this.prio = prio;
    }

    public Long getDuration() {
        return duration;
    }

    public void setDuration(Long duration) {
        this.duration = duration;
    }
}
