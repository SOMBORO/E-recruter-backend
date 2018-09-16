package org.brain.consulting.repositories;

import javax.transaction.Transactional;

import org.brain.consulting.entities.Sujet;
import org.springframework.data.jpa.repository.JpaRepository;

@Transactional
public interface SujetRepository extends JpaRepository<Sujet, Long> {

}
