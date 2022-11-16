package com.jacidi.asignacion.repositories;

import com.jacidi.asignacion.entities.Client;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClientRepository extends CrudRepository<Client, Long> {

    List<Client> findAll();
    Client findByEmail(String email);
    Client findById(int id);

}
