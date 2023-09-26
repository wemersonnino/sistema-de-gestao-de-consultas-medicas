package com.saude.wemerson.saude;

import com.saude.wemerson.saude.models.Especialidade;
import com.saude.wemerson.saude.models.Medico;
import com.saude.wemerson.saude.repositories.RepositoryMedico;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class SaudeApplicationTests {

    @Test
    public void saveMedico() {
        Especialidade especialidade = new Especialidade();
        especialidade.setNome("Cardiologia");

        Medico medico = new Medico();
        medico.setNome("Dr. Wemerson");
        medico.setCrm(123456);
        medico.setEspecialidade(especialidade);

        RepositoryMedico repositoryMedico = null;

        repositoryMedico.save(medico);

        Integer id = medico.getId();

        Medico medicoSalvo = repositoryMedico.findById(id).get();

        assertNotNull(medicoSalvo);
        assertEquals(medico.getNome(), medicoSalvo.getNome());
        assertEquals(medico.getCrm(), medicoSalvo.getCrm());
        assertEquals(medico.getEspecialidade().getNome(), medicoSalvo.getEspecialidade().getNome());
    }

}
