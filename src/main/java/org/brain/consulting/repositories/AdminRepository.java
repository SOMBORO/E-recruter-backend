package org.brain.consulting.repositories;

import javax.transaction.Transactional;

import org.brain.consulting.entities.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

@Transactional
public interface AdminRepository extends JpaRepository<Admin, Long> {

}
