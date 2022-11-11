package com.jacidi.asignacion.entities;


import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "client", schema = "jacidi")
public class Client {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id")
    private Integer id;

    @Column(name="lastName")
    private String lastName;

    @Column(name="dni")
    private String dni;

    @Column(name="email")
    private String email;

    @Column(name="lastDelivery")
    private Date lastDelivery;

    @Column(name="nextRenewal")
    private Date nextRenewal;

    @OneToOne(fetch=FetchType.EAGER)
    @JoinColumn(name = "id_membership", referencedColumnName = "id")
    private Membership membership;

    public Membership getMembership() {
        return membership;
    }

    public void setMembership(Membership membership) {
        this.membership = membership;
    }

    public Client() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getLastDelivery() {
        return lastDelivery;
    }

    public void setLastDelivery(Date lastDelivery) {
        this.lastDelivery = lastDelivery;
    }

    public Date getNextRenewal() {
        return nextRenewal;
    }

    public void setNextRenewal(Date nextRenewal) {
        this.nextRenewal = nextRenewal;
    }
}
