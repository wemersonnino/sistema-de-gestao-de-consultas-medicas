package com.saude.wemerson.saude.controllers;

import com.saude.wemerson.saude.models.Consulta;
import com.saude.wemerson.saude.models.Especialidade;
import com.saude.wemerson.saude.models.Medico;
import com.saude.wemerson.saude.models.Paciente;
import com.saude.wemerson.saude.services.ServiceConsulta;
import com.saude.wemerson.saude.services.ServiceEspecialidade;
import com.saude.wemerson.saude.services.ServiceMedico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/medicos")
public class ControllerMedico {

    @Autowired
    private ServiceMedico serviceMedico;

    @Autowired
    private ServiceEspecialidade serviceEspecialidade;

    @Autowired
    private ServiceConsulta serviceConsulta;

    @GetMapping("")
    public String listAll(Model model){
        model.addAttribute("medicos", serviceMedico.medicoList());
        return "medicos/medicos";
    }


    @GetMapping(value = "/novomedico")
    public String novoMedico(Model model) {

        List<Especialidade> especialidades = serviceEspecialidade.especialidadeList();
        List<Consulta> consultas = serviceConsulta.consultaList();

        model.addAttribute("especialidades", especialidades);
        model.addAttribute("consultas", consultas);
        model.addAttribute("medico", new Medico());

        return "redirect:/medicos";
    }

    @PostMapping("/salvar")
    public String salvar(@ModelAttribute Medico medico){
        medico.informacoesMedico();
        serviceMedico.salvarMedico(medico);
        return "redirect:/medicos/novomedico";
    }

    @GetMapping("/excluir/{codigo}")
    public String excluirMedico(@PathVariable("codigo") int codigo){
        Optional<Medico> optionalMedico = serviceMedico.getMedico(codigo);

        optionalMedico.ifPresent(medico -> serviceMedico.excluirMedico(medico));

        return "redirect:/medicos";
    }

    @GetMapping("/editar/{codigo}")
    public String editarMedico(@PathVariable("codigo") int codigo, Model model){

        List<Especialidade> especialidades = serviceEspecialidade.especialidadeList();

        Optional<Medico> optionalMedico = serviceMedico.getMedico(codigo);

        if (optionalMedico.isPresent()) {
            Medico medico = optionalMedico.get();
            List<Paciente> pacientes = new ArrayList<>();

            for (Consulta consulta : medico.getConsultas()) {
                pacientes.add(consulta.getPaciente());
            }

            model.addAttribute("especialidades", especialidades);
            model.addAttribute("especialidade", new Especialidade());
            model.addAttribute("consultas", medico.getConsultas());
            model.addAttribute("pacientes", pacientes);
            model.addAttribute("medico", medico);

            return "medicos/novomedico";
        } else {
            model.addAttribute("mensagemErro", "Médico não encontrado");
            return "redirect:/medicos";
        }
    }

}
