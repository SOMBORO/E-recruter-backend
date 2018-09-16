package org.brain.consulting.repositories;

import javax.transaction.Transactional;

import org.brain.consulting.entities.Candidat;
import org.springframework.data.jpa.repository.JpaRepository;

@Transactional
public interface CandidatRepository extends JpaRepository<Candidat, Long> {

}
