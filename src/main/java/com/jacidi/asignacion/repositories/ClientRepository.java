package com.jacidi.asignacion.repositories;

import com.jacidi.asignacion.entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClientRepository extends JpaRepository<Client, Integer> {

    List<Client> findAll();

    Client findById(int id);

}
