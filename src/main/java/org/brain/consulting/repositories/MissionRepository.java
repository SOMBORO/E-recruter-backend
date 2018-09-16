package org.brain.consulting.repositories;

import javax.transaction.Transactional;

import org.brain.consulting.entities.Mission;
import org.springframework.data.jpa.repository.JpaRepository;

@Transactional
public interface MissionRepository extends JpaRepository<Mission, Long> {

}
