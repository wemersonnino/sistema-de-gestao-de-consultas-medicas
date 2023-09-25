package com.saude.wemerson.saude.models;

import jakarta.persistence.*;

@Entity
@Table(name = "especialidades")
public class Especialidade {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nome;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void informacoesEspecialidade(){
        System.out.println("Nome da Especialidade: " + this.getNome());
    }
}
