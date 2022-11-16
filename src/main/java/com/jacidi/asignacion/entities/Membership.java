package com.jacidi.asignacion.entities;


import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "membership", schema = "jacidi")
public class Membership {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id_membership")
    private Integer id;

    @Column(name = "key_membership")
    private String key;

    @Column(name = "name")
    private String name;

    @Column( name = "prio")
    private Integer prio;

    @Column(name = "duration")
    private Long duration;

    public Integer getId() {
        return id;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
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
