package com.saude.wemerson.saude.services;

import com.saude.wemerson.saude.models.Medico;
import com.saude.wemerson.saude.repositories.RepositoryMedico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServiceMedico {

    @Autowired
    private RepositoryMedico repositoryMedico;

    public void salvarMedico(Medico medico){
        repositoryMedico.save(medico);
    }

    public List<Medico> medicoList(){
        return repositoryMedico.findAll();
    }

    public Optional<Medico> getMedico(int id){
        return repositoryMedico.findById(id);
    }

    public void excluirMedico(Medico medico){
        repositoryMedico.delete(medico);
    }

}
