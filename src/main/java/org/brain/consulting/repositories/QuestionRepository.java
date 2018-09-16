package org.brain.consulting.repositories;

import javax.transaction.Transactional;

import org.brain.consulting.entities.Question;
import org.springframework.data.jpa.repository.JpaRepository;

@Transactional
public interface QuestionRepository extends JpaRepository<Question, Long> {

}
