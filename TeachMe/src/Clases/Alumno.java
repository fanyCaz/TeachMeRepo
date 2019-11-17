/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

/**
 *
 * @author estef
 */
public class Alumno extends Usuario{

    
    int semestre, id_usuario;

    public Alumno(){}
    
    @Override
    public String getNombre() {
        return nombre;
    }

    @Override
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String getApPaterno() {
        return apPaterno;
    }

    @Override
    public void setApPaterno(String apPaterno) {
        this.apPaterno = apPaterno;
    }

    @Override
    public String getApMaterno() {
        return apMaterno;
    }

    @Override
    public void setApMaterno(String apMaterno) {
        this.apMaterno = apMaterno;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public void setPassword(String password) {
        this.password = password;
    }
    
    public int getSemestre() {
        return semestre;
    }

    public void setSemestre(int semestre) {
        this.semestre = semestre;
    }

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }
    
}
