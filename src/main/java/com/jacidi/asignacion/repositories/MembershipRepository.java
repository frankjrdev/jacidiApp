package com.jacidi.asignacion.repositories;

import com.jacidi.asignacion.entities.Membership;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MembershipRepository extends CrudRepository<Membership, Integer> {
    List<Membership> findAll();
}
