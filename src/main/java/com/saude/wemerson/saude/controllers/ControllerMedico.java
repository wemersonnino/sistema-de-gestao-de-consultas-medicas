package com.saude.wemerson.saude.controllers;

import com.saude.wemerson.saude.models.Medico;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/medicos")
public class ControllerMedico {

    @GetMapping(value = "/novomedico")
    public String novoMedico(Model model) {

        List<String> especialidades = new ArrayList<>();
        especialidades.add("Clinico");
        especialidades.add("Pediatra");
        especialidades.add("Urologista");
        especialidades.add("Pneumolologista");
        especialidades.add("Ginecologista");

        List<String> consultas = new ArrayList<>();
        consultas.add("Maria");
        consultas.add("Joao");
        consultas.add("Sergio");
        consultas.add("Paula");

        model.addAttribute("especialidades", especialidades);
        model.addAttribute("consultas", consultas);
        model.addAttribute("medico", new Medico());

        return "medicos/novomedico";
    }

    @PostMapping("/salvar")
    public String salvar(@ModelAttribute Medico medico, Model model){
        medico.informacoesMedico();
        model.addAttribute("medico", new Medico());
        return "medicos/novomedico";
    }
}
