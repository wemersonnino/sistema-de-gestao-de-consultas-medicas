package com.saude.wemerson.saude.repositories;

import com.saude.wemerson.saude.models.Consulta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositoryConsulta extends JpaRepository<Consulta, Integer> {
}
