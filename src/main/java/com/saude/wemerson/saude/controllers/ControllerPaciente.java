package com.saude.wemerson.saude.controllers;

import com.saude.wemerson.saude.models.Paciente;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/pacientes")
public class ControllerPaciente {

    @GetMapping("novopaciente")
    public String novoPaciente(Model model){

        List<String> consultas = new ArrayList<>();
        consultas.add("Ginicologista");
        consultas.add("Clinico");
        consultas.add("Pediatra");

        model.addAttribute("consultas", consultas);
        model.addAttribute("paciente", new Paciente());

        return "pacientes/novopaciente";
    }

    @PostMapping("/salvar")
    public String salvar(@ModelAttribute Paciente paciente, Model model){
        paciente.informacoesPaciente();
        model.addAttribute("paciente", new Paciente());

        return "pacientes/salvar";
    }


}
