package com.jacidi.asignacion.repositories;

import com.jacidi.asignacion.entities.Membership;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MembershipRepository extends CrudRepository<Membership, Long> {
    List<Membership> findAll();

    Membership findById(int id);
    Membership findByKey(String key);
}
