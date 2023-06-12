/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sysop.objects;

/**
 *
 * @author CAA201
 */
public class Usuario {

    private String nome;
    private String senha;
    private Integer id;
    private String cpf;

    public String getEmail() {
        return email;
    }

    public void setEmail(String Email) {
        this.email = Email;
    }

    public String getFuncao() {
        return funcao;
    }

    public void setFuncao(String Funcao) {
        this.funcao = Funcao;
    }
    private String email;
    private String funcao;

    public Usuario(String Email, String Funcao) {
        this.email = Email;
        this.funcao = Funcao;
    }
   
    
    public Usuario(){
        
    }

    public Usuario(String nome, String senha, Integer id, String cpf) {
        this.nome = nome;
        this.senha = senha;
        this.id = id;
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
     public Usuario(String nome, String senha, Integer id, String cpf, String email, String funcao) {
        this.nome = nome;
        this.senha = senha;
        this.id = id;
        this.cpf = cpf;
        this.email = email;
        this.funcao = funcao;
    }
}

