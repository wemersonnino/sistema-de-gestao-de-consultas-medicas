package com.saude.wemerson.saude.repositories;

import com.saude.wemerson.saude.models.Medico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositoryMedico extends JpaRepository<Medico, Integer> {
}
