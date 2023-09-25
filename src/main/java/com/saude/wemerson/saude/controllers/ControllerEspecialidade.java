package com.saude.wemerson.saude.controllers;

import com.saude.wemerson.saude.models.Especialidade;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/especialidades")
public class ControllerEspecialidade {

    @GetMapping("/novaespecialidade")
    public String novaEspecialidade(Model model){

        List<String> especialidades = new ArrayList<>();
        especialidades.add("Cardiologista");
        especialidades.add("Pediatra");
        especialidades.add("Clinico");
        especialidades.add("Pumonologista");

        model.addAttribute("especialidades", especialidades);
        model.addAttribute("especialidade", new Especialidade());

        return "especialidades/novaespecialidade";
    }

    @PostMapping("/salvar")
    public String salvar(@ModelAttribute Especialidade especialidade, Model model){
        especialidade.informacoesEspecialidade();
        model.addAttribute("especialidade", new Especialidade());

        return "especialidades/novaespecialidade";
    }
}
