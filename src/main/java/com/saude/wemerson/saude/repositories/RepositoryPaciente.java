package com.saude.wemerson.saude.repositories;

import com.saude.wemerson.saude.models.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositoryPaciente extends JpaRepository<Paciente, Integer> {
}
