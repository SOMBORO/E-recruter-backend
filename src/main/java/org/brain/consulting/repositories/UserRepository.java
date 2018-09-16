package org.brain.consulting.repositories;

import javax.transaction.Transactional;

import org.brain.consulting.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

@Transactional
public interface UserRepository extends JpaRepository<User, Long> {

}
