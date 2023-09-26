package com.saude.wemerson.saude.services;

import com.saude.wemerson.saude.models.Medico;
import com.saude.wemerson.saude.models.Paciente;
import com.saude.wemerson.saude.repositories.RepositoryPaciente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServicePaciente {

    @Autowired
    private RepositoryPaciente repositoryPaciente;

    public void salvarPaciente(Paciente paciente){
        repositoryPaciente.save(paciente);
    }

    public List<Paciente> pacienteList(){
        return repositoryPaciente.findAll();
    }

    public Optional<Paciente> getPaciente(int id){
        return repositoryPaciente.findById(id);
    }

    public void excluirPaciente(Paciente paciente){
        repositoryPaciente.delete(paciente);
    }
}
