package org.brain.consulting.repositories;

import javax.transaction.Transactional;

import org.brain.consulting.entities.Domaine;
import org.springframework.data.jpa.repository.JpaRepository;

@Transactional
public interface DomaineRepository extends JpaRepository<Domaine, Long> {

}
