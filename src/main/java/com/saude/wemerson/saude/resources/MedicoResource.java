package com.saude.wemerson.saude.resources;

import com.saude.wemerson.saude.models.Medico;
import com.saude.wemerson.saude.services.ServiceMedico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/medicos")
public class MedicoResource {

    @Autowired
    private ServiceMedico serviceMedico;

    @GetMapping("")
    public ResponseEntity<List<Medico>> listAll(){
        return new ResponseEntity<>(serviceMedico.medicoList(), HttpStatus.OK);
    }

    @GetMapping("/{codigo}")
    public ResponseEntity<Medico> getMedico(@PathVariable("codigo") int codigo){
        Optional<Medico> optionalMedico = serviceMedico.getMedico(codigo);

        // Check if the consultas property is empty
        if (optionalMedico.isPresent() && optionalMedico.get().getConsultas().isEmpty()) {
            // Return an empty list if the consultas property is empty
            return new ResponseEntity<>(new Medico(), HttpStatus.OK);
        }

        return optionalMedico.map(medico -> new ResponseEntity<>(medico, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("salvar")
    public ResponseEntity<Medico> salvarMedico(@RequestBody Medico medico){
        serviceMedico.salvarMedico(medico);
        return new ResponseEntity<Medico>(medico, HttpStatus.CREATED);
    }

    @DeleteMapping("/excluir/{codigo}")
    public ResponseEntity<Medico> excluirMedico(@PathVariable("codigo") int codigo){
        Optional<Medico> optionalMedico = serviceMedico.getMedico(codigo);

        if (optionalMedico.isPresent()){
            serviceMedico.excluirMedico(optionalMedico.get());
            return new ResponseEntity<>(null, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping("/editar/{codigo}")
    public ResponseEntity<Medico> updateMedico(@PathVariable("codigo") int codigo, @RequestBody Medico medico){
        Optional<Medico> optionalMedico = serviceMedico.getMedico(codigo);

        if (optionalMedico.isPresent()){
            medico.setId(codigo);
            serviceMedico.salvarMedico(optionalMedico.get());
            return new ResponseEntity<>(null, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

}
