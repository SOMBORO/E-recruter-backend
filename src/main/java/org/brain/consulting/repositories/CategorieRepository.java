package org.brain.consulting.repositories;

import javax.transaction.Transactional;

import org.brain.consulting.entities.Categorie;
import org.springframework.data.jpa.repository.JpaRepository;

@Transactional
public interface CategorieRepository extends JpaRepository<Categorie, Long> {

}
