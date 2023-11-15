package com.AlquilaTusVehiculosP1.AlquilaTusVehiculos.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "clientes") // Define el nombre de la colección en MongoDB
public class Cliente {
    @Id
    private String clienteId;
    private String usuario;
    private String contraseña;
    private String nombre;
    private String apellidos;
    private String email;
    private String telefono;

    // Constructor, getters y setters

    public Cliente() {
        // Constructor por defecto
    }

    // Constructor con parámetros
    public Cliente( String contraseña, String nombre, String apellidos, String email, String telefono) {
        this.contraseña = contraseña;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.email = email;
        this.telefono = telefono;
    }

    // Getters y setters

    public String getClienteId() {
        return clienteId;
    }

    public void setClienteId(String clienteId) {
        this.clienteId = clienteId;
    }



    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    @Override
    public String toString() {
        return "Cliente [clienteId=" + clienteId + ", usuario=" + usuario + ", contraseña=" + contraseña + ", nombre="
                + nombre + ", apellidos=" + apellidos + ", email=" + email + ", telefono=" + telefono + "]";
    }
}
