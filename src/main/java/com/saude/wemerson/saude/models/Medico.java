package com.saude.wemerson.saude.models;


import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "medicos")
public class Medico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nome;

    @ManyToOne
    private Especialidade especialidade;

    private Integer crm;

    @OneToMany(mappedBy = "medico")
    @JsonManagedReference
    private List<Consulta> consultas;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Especialidade getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(Especialidade especialidade) {
        this.especialidade = especialidade;
    }

    public Integer getCrm() {
        return crm;
    }

    public void setCrm(Integer crm) {
        this.crm = crm;
    }

    public List<Consulta> getConsultas() {
        return consultas;
    }

    public void setConsultas(List<Consulta> consultas) {
        this.consultas = consultas;
    }

    public void informacoesMedico(){
        System.out.println("Nome: " + this.getNome());
        System.out.println("Especialidade: " + this.getEspecialidade());
        System.out.println("CRM: " + this.getCrm());
        System.out.println("Consultas: " + this.getConsultas());
    }

}
