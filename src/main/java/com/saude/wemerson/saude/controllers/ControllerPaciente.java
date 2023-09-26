package com.saude.wemerson.saude.controllers;

import com.saude.wemerson.saude.models.Consulta;
import com.saude.wemerson.saude.models.Especialidade;
import com.saude.wemerson.saude.models.Medico;
import com.saude.wemerson.saude.models.Paciente;
import com.saude.wemerson.saude.services.ServiceConsulta;
import com.saude.wemerson.saude.services.ServiceEspecialidade;
import com.saude.wemerson.saude.services.ServiceMedico;
import com.saude.wemerson.saude.services.ServicePaciente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/pacientes")
public class ControllerPaciente {

    @Autowired
    private ServicePaciente servicePaciente;

    @Autowired
    private ServiceConsulta serviceConsulta;

    @Autowired
    private ServiceEspecialidade serviceEspecialidade;

    @Autowired
    private ServiceMedico serviceMedico;

    @GetMapping("")
    public String listAll(Model model){
        model.addAttribute("pacientes", servicePaciente.pacienteList());
        return "pacientes/pacientes";
    }

    @GetMapping("novopaciente")
    public String novoPaciente(Model model){

        List<Medico> medicos = serviceMedico.medicoList();
        List<Consulta> consultas = serviceConsulta.consultaList();
        List<Paciente> pacientes = servicePaciente.pacienteList();
        List<Especialidade> especialidades = serviceEspecialidade.especialidadeList();

        model.addAttribute("medicos", medicos);
        model.addAttribute("consultas", consultas);
        model.addAttribute("pacientes", pacientes);
        model.addAttribute("especialidades", especialidades);
        model.addAttribute("paciente", new Paciente());

        return "pacientes/novopaciente";
    }

    @PostMapping("/salvar")
    public String salvar(@ModelAttribute Paciente paciente){
        servicePaciente.salvarPaciente(paciente);

        return "redirect:/pacientes";
    }

    @GetMapping("/excluir/{codigo}")
    public String excluirPaciente(@PathVariable("codigo") int codigo){
        Optional<Paciente> optionalPaciente = servicePaciente.getPaciente(codigo);
        if (optionalPaciente.isPresent()){
            servicePaciente.excluirPaciente(optionalPaciente.get());
        }

        return "redirect:/pacientes";
    }

    @GetMapping("editar/{codigo}")
    public String editarPaciente(@PathVariable("codigo") int codigo, Model model){
        List<Consulta> consultas = serviceConsulta.consultaList();
        List<Paciente> pacientes = servicePaciente.pacienteList();
        List<Especialidade> especialidades = serviceEspecialidade.especialidadeList();

        model.addAttribute("consultas", consultas);
        model.addAttribute("pacientes", pacientes);
        model.addAttribute("especialidades", especialidades);

        Optional<Paciente> optionalPaciente = servicePaciente.getPaciente(codigo);
        model.addAttribute("paciente", optionalPaciente.get());

        return "pacientes/novopaciente";
    }

}
