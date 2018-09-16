package org.brain.consulting.repositories;

import javax.transaction.Transactional;

import org.brain.consulting.entities.Employe;
import org.springframework.data.jpa.repository.JpaRepository;

@Transactional
public interface EmployeRepository extends JpaRepository<Employe, Long> {

}
