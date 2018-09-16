package org.brain.consulting.repositories;

import javax.transaction.Transactional;

import org.brain.consulting.entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;

@Transactional
public interface ClientRepository extends JpaRepository<Client, Long> {

}
