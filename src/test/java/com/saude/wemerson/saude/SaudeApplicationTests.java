package com.saude.wemerson.saude;

import com.saude.wemerson.saude.models.Medico;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class SaudeApplicationTests {

    @Test
    public void testSalvarMedico() {
        // Crie um objeto Medico
        Medico medico = new Medico();

        // Defina os atributos do Medico
        medico.setNome("Dr. John Doe");
        medico.setEspecialidade("Cardiologia");
        medico.setCrm(12345);

        // Verifique se os atributos estão corretamente definidos
        assertEquals("Dr. John Doe", medico.getNome());
        assertEquals("Cardiologia", medico.getEspecialidade());
        assertEquals(Integer.valueOf(12345), medico.getCrm());
    }

}
