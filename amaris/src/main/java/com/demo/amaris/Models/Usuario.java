package com.demo.amaris.Models;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "usuario")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String primernombre;
    String segundonombre;
    String primerapellido;
    String segundoapellido;
    String numeroIdentidad;
    String direccion;
    String telefono;
    String ciudad;
    public Usuario() {
    }
    public Usuario(Long id, String primernombre, String segundonombre, String primerapellido, String segundoapellido,
            String numeroIdentidad, String direccion, String telefono, String ciudad) {
        this.id = id;
        this.primernombre = primernombre;
        this.segundonombre = segundonombre;
        this.primerapellido = primerapellido;
        this.segundoapellido = segundoapellido;
        this.numeroIdentidad = numeroIdentidad;
        this.direccion = direccion;
        this.telefono = telefono;
        this.ciudad = ciudad;
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getPrimernombre() {
        return primernombre;
    }
    public void setPrimernombre(String primernombre) {
        this.primernombre = primernombre;
    }
    public String getSegundonombre() {
        return segundonombre;
    }
    public void setSegundonombre(String segundonombre) {
        this.segundonombre = segundonombre;
    }
    public String getPrimerapellido() {
        return primerapellido;
    }
    public void setPrimerapellido(String primerapellido) {
        this.primerapellido = primerapellido;
    }
    public String getSegundoapellido() {
        return segundoapellido;
    }
    public void setSegundoapellido(String segundoapellido) {
        this.segundoapellido = segundoapellido;
    }
    public String getNumeroIdentidad() {
        return numeroIdentidad;
    }
    public void setNumeroIdentidad(String numeroIdentidad) {
        this.numeroIdentidad = numeroIdentidad;
    }
    public String getDireccion() {
        return direccion;
    }
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    public String getTelefono() {
        return telefono;
    }
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    public String getCiudad() {
        return ciudad;
    }
    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    
    }
