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
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/consultas")
public class ControllerConsulta {

    @Autowired
    private ServiceConsulta serviceConsulta;

    @Autowired
    private ServiceEspecialidade serviceEspecialidade;

    @Autowired
    private ServiceMedico serviceMedico;

    @Autowired
    private ServicePaciente servicePaciente;

    @GetMapping("novaconsulta")
    public String novaConsulta(Model model){
        model.addAttribute("consulta", new Consulta());
        model.addAttribute("medicos", serviceMedico.medicoList()); // Buscar médicos
        model.addAttribute("pacientes", servicePaciente.pacienteList()); // Buscar pacientes
        return "consultas/novaconsulta";
    }

    @PostMapping("/salvar")
    public String salvarConsulta(@ModelAttribute Consulta consulta){
        serviceConsulta.salvarConsulta(consulta);
        return "redirect:/consultas/novaconsulta";
    }



    @GetMapping("/consultas")
    public String listAll(Model model){
        model.addAttribute("consultas", serviceConsulta.consultaList());
        return "consultas/consultas";
    }

    @GetMapping("/excluir/{codigo}")
    public String excluirConsulta(@PathVariable("codigo") int codigo){
        Optional<Consulta> optionalConsulta = serviceConsulta.getConsulta(codigo);

        optionalConsulta.ifPresent(consulta -> serviceConsulta.excluirConsulta(consulta));
        return "redirect:/consultas/consultas";
    }

    @GetMapping("/editar/{codigo}")
    public String editarMedico(@PathVariable("codigo") int codigo, Model model){

        model.addAttribute("medicos", serviceMedico.medicoList());
        model.addAttribute("pacientes", servicePaciente.pacienteList());

        Optional<Consulta> consulta = serviceConsulta.getConsulta(codigo);
        model.addAttribute("consulta", consulta);

        return "/consultas/novaconsulta";
    }

}
