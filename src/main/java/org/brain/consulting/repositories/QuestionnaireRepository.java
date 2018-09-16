package org.brain.consulting.repositories;

import javax.transaction.Transactional;

import org.brain.consulting.entities.Questionnaire;
import org.springframework.data.jpa.repository.JpaRepository;

@Transactional
public interface QuestionnaireRepository extends JpaRepository<Questionnaire, Long> {

}
