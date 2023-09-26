package com.saude.wemerson.saude.services;

import com.saude.wemerson.saude.models.Consulta;
import com.saude.wemerson.saude.models.Medico;
import com.saude.wemerson.saude.repositories.RepositoryConsulta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServiceConsulta {

    @Autowired
    private RepositoryConsulta repositoryConsulta;

    public void salvarConsulta(Consulta consulta){
        repositoryConsulta.save(consulta);
    }

    public List<Consulta> consultaList(){
        return repositoryConsulta.findAll();
    }

//    public Optional<Consulta> getConsulta(int id){
//        return repositoryConsulta.findById(id);
//    }
    public Optional<Consulta> getConsulta(int id){
        return repositoryConsulta.findById(id);
    }

    public void excluirConsulta(Consulta consulta){
        repositoryConsulta.delete(consulta);
    }
}
