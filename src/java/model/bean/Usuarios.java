/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.bean;

import java.sql.Date;

/**
 * Classe que representa um usuário do sistema.
 * 
 * Um usuário possui um identificador único, um nome, uma senha, um nome de usuário, um telefone, uma data de nascimento, um CPF e um status.
 * 
 * O status pode indicar diferentes níveis de acesso, por exemplo, um status de 2 pode representar um administrador.
 * 
 * @author aluno
 */
public class Usuarios {
    // Identificador único do usuário
    private int id_usuario;
    // Nome do usuário
    private String nome;
    // Senha do usuário
    private String senha;
    // Nome de usuário do usuário
    private String usuario;
    // Telefone do usuário
    private String telefone;
    // Data de nascimento do usuário
    private Date data_nascimento;
    // CPF do usuário
    private String cpf;
    // Status do usuário
    private int status;

    /**
     * Construtor padrão da classe.
     */
    public Usuarios() {
    }

    /**
     * Construtor parametrizado da classe.
     * 
     * @param id_usuario O identificador único do usuário.
     * @param nome O nome do usuário.
     * @param senha A senha do usuário.
     * @param usuario O nome de usuário do usuário.
     * @param telefone O telefone do usuário.
     * @param data_nascimento A data de nascimento do usuário.
     * @param cpf O CPF do usuário.
     * @param status O status do usuário.
     */
    public Usuarios(int id_usuario, String nome, String senha, String usuario, String telefone, Date data_nascimento, String cpf, int status) {
        this.id_usuario = id_usuario;
        this.nome = nome;
        this.senha = senha;
        this.usuario = usuario;
        this.telefone = telefone;
        this.data_nascimento = data_nascimento;
        this.cpf = cpf;
        this.status = status;
    }

    /**
     * Obtém o identificador único do usuário.
     * 
     * @return O identificador único do usuário.
     */
    public int getId_usuario() {
        return id_usuario;
    }

    /**
     * Define o identificador único do usuário.
     * 
     * @param id_usuario O identificador único do usuário.
     */
    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    /**
     * Obtém o nome do usuário.
     * 
     * @return O nome do usuário.
     */
    public String getNome() {
        return nome;
    }

    /**
     * Define o nome do usuário.
     * 
     * @param nome O nome do usuário.
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * Obtém a senha do usuário.
     * 
     * @return A senha do usuário.
     */
    public String getSenha() {
        return senha;
    }

    /**
     * Define a senha do usuário.
     * 
     * @param senha A senha do usuário.
     */
    public void setSenha(String senha) {
        this.senha = senha;
    }

    /**
     * Obtém o nome de usuário do usuário.
     * 
     * @return O nome de usuário do usuário.
     */
    public String getUsuario() {
        return usuario;
    }

    /**
     * Define o nome de usuário do usuário.
     * 
     * @param usuario O nome de usuário do usuário.
     */
    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    /**
     * Obtém o telefone do usuário.
     * 
     * @return O telefone do usuário.
     */
    public String getTelefone() {
        return telefone;
    }

    /**
     * Define o telefone do usuário.
     * 
     * @param telefone O telefone do usuário.
     */
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    /**
     * Obtém a data de nascimento do usuário.
     * 
     * @return A data de nascimento do usuário.
     */
    public Date getData_nascimento() {
        return data_nascimento;
    }

    /**
     * Define a data de nascimento do usuário.
     * 
     * @param data_nascimento A data de nascimento do usuário.
     */
    public void setData_nascimento(Date data_nascimento) {
        this.data_nascimento = data_nascimento;
    }

    /**
     * Obtém o CPF do usuário.
     * 
     * @return O CPF do usuário.
     */
    public String getCpf() {
        return cpf;
    }

    /**
     * Define o CPF do usuário.
     * 
     * @param cpf O CPF do usuário.
     */
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    /**
     * Obtém o status do usuário.
     * 
     * @return O status do usuário.
     */
    public int getStatus() {
        return status;
    }

    /**
     * Define o status do usuário.
     * 
     * @param status O status do usuário.
     */
    public void setStatus(int status) {
        this.status = status;
    }
}
