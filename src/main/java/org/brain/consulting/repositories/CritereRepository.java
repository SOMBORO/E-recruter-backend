package org.brain.consulting.repositories;

import javax.transaction.Transactional;

import org.brain.consulting.entities.Critere;
import org.springframework.data.jpa.repository.JpaRepository;

@Transactional
public interface CritereRepository extends JpaRepository<Critere, Long> {

}
