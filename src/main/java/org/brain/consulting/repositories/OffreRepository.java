package org.brain.consulting.repositories;

import javax.transaction.Transactional;

import org.brain.consulting.entities.Offre;
import org.springframework.data.jpa.repository.JpaRepository;

@Transactional
public interface OffreRepository extends JpaRepository<Offre, Long> {

}
