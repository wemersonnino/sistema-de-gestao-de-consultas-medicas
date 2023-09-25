package com.saude.wemerson.saude.models;


import java.util.List;

public class Medico {

    private Integer id;
    private String nome;
    private List<Especialidade> especialidades;
    private Integer crm;
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

    public List<Especialidade> getEspecialidades() {
        return especialidades;
    }

    public void setEspecialidades(List<Especialidade> especialidades) {
        this.especialidades = especialidades;
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
        System.out.println("Especialidade: " + this.getEspecialidades());
        System.out.println("CRM: " + this.getCrm());
    }
}
