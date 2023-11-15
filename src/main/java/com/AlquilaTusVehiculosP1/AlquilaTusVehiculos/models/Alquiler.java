package com.AlquilaTusVehiculosP1.AlquilaTusVehiculos.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document(collection = "alquileres")
public class Alquiler {
    @Id
    private String alquilerId;
    private Date fechaInicio;
    private Date fechaFin;
    private double importe;
    private String clienteId; // Referencia al Cliente

    // Constructor, getters y setters

    public Alquiler() {
        // Constructor por defecto
    }

    public Alquiler(Date fechaInicio, Date fechaFin, double importe, String clienteId) {
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.importe = importe;
        this.clienteId = clienteId;
    }

    // Getters y setters

    public String getAlquilerId() {
        return alquilerId;
    }

    public void setAlquilerId(String alquilerId) {
        this.alquilerId = alquilerId;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    public double getImporte() {
        return importe;
    }

    public void setImporte(double importe) {
        this.importe = importe;
    }

    public String getClienteId() {
        return clienteId;
    }

    public void setClienteId(String clienteId) {
        this.clienteId = clienteId;
    }
}
