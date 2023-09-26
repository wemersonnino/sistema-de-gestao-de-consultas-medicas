package com.saude.wemerson.saude.controllers;

import com.saude.wemerson.saude.models.Especialidade;
import com.saude.wemerson.saude.services.ServiceEspecialidade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/especialidades")
public class ControllerEspecialidade {

    @Autowired
    private ServiceEspecialidade serviceEspecialidade;

    @GetMapping("")
    public String listAll(Model model){
        model.addAttribute("especialidades", serviceEspecialidade.especialidadeList());
        return "especialidades/especialidades";
    }

    @GetMapping("/novaespecialidade")
    public String novaEspecialidade(Model model){

        List<Especialidade> especialidades = serviceEspecialidade.especialidadeList();

        model.addAttribute("especialidades", especialidades);
        model.addAttribute("especialidade", new Especialidade());

        return "/especialidades/novaespecialidade";
    }

    @PostMapping("/salvar")
    public String salvar(@ModelAttribute("especialidade") Especialidade especialidade, Model model){

        especialidade.informacoesEspecialidade();
        serviceEspecialidade.salvarEspecialidade(especialidade);

        return "redirect:/especialidades/novaespecialidade";
    }

    @GetMapping("/excluir/{codigo}")
    public String excluirEspecialidade(@PathVariable("codigo") int codigo){
        Optional<Especialidade> optionalEspecialidade = serviceEspecialidade.getEspecialidade(codigo);
        if (optionalEspecialidade.isPresent()){
            serviceEspecialidade.excluirEspecialidade(optionalEspecialidade.get());
        }

        return "redirect:/especialidades";
    }

    @GetMapping("/editar/{codigo}")
    public String editarEspecialidade(@PathVariable("codigo") int codigo, Model model){

        List<Especialidade> especialidades = serviceEspecialidade.especialidadeList();

        model.addAttribute("especialidades", especialidades);

        Optional<Especialidade> optionalEspecialidade = serviceEspecialidade.getEspecialidade(codigo);
        model.addAttribute("especialidade", optionalEspecialidade.get());

        return "especialidades/novaespecialidade";
    }
}
