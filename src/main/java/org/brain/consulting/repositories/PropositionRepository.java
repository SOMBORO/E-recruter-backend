package org.brain.consulting.repositories;

import javax.transaction.Transactional;

import org.brain.consulting.entities.Proposition;
import org.springframework.data.jpa.repository.JpaRepository;

@Transactional
public interface PropositionRepository extends JpaRepository<Proposition, Long> {

}
