/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GenerationType;
import javax.persistence.Table;

/**
 *
 * @author estef
 */
@Entity
@Table(name="usuario")

public class Usuario implements Serializable {


    private static final long serialVersionUID = 1L;
    @javax.persistence.Id
    @javax.persistence.GeneratedValue(strategy = GenerationType.IDENTITY)
    //@javax.persistence.Entity(name = "usuario")
    //@GeneratedValue(strategy = GenerationType.AUTO)
    
    @Column(name="id",nullable=false)
    private Long id;
    
    @Column(name="usuario", nullable=false)
    private String usuario;
    
    @Column(name="password", nullable=false)
    private String password;
    
    @Column(name="nombre", nullable=false)
    private String nombre;
    
    @Column(name="ap_paterno", nullable=false)
    private String ap_paterno;
    
    @Column(name="ap_materno", nullable=false)
    private String ap_materno;

    public String getAp_paterno() {
        return ap_paterno;
    }

    public void setAp_paterno(String ap_paterno) {
        this.ap_paterno = ap_paterno;
    }

    public String getAp_materno() {
        return ap_materno;
    }

    public void setAp_materno(String ap_materno) {
        this.ap_materno = ap_materno;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Usuario)) {
            return false;
        }
        Usuario other = (Usuario) object;
//        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
//            return false;
//        }
        return true;
    }

    @Override
    public String toString() {
        return "Clases.Usuario[ id=" + id + " ]";
    }

    public void setId(int i) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
        public Usuario() {
        super();
//        this.id = id;
//        this.usuario = usuario;
//        this.password = password;
//        this.nombre = nombre;
//        this.ap_paterno = ap_paterno;
//        this.ap_materno = ap_materno;
    }
}
