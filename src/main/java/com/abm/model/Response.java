package com.abm.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;

import java.util.Date;

@JsonPOJOBuilder
public class Response {

    @JsonProperty("per_apellido")
    private String perApellido;
    @JsonProperty("per_fecha_nacimiento")
    private Date perFechaNacimiento;
    @JsonProperty("per_id")
    private long perId;
    @JsonProperty("per_nombre")
    private String perNombre;
    @JsonProperty("per_numero_documento")
    private Long perNumeroDocumento;
    @JsonProperty("per_tipo_documento")
    private String perTipoDocumento;

    public String getPerApellido() {
        return perApellido;
    }

    public void setPerApellido(String perApellido) {
        this.perApellido = perApellido;
    }

    public Date getPerFechaNacimiento() {
        return perFechaNacimiento;
    }

    public void setPerFechaNacimiento(Date perFechaNacimiento) {
        this.perFechaNacimiento = perFechaNacimiento;
    }

    public long getPerId() {
        return perId;
    }

    public void setPerId(long perId) {
        this.perId = perId;
    }

    public String getPerNombre() {
        return perNombre;
    }

    public void setPerNombre(String perNombre) {
        this.perNombre = perNombre;
    }

    public Long getPerNumeroDocumento() {
        return perNumeroDocumento;
    }

    public void setPerNumeroDocumento(Long perNumeroDocumento) {
        this.perNumeroDocumento = perNumeroDocumento;
    }

    public String getPerTipoDocumento() {
        return perTipoDocumento;
    }

    public void setPerTipoDocumento(String perTipoDocumento) {
        this.perTipoDocumento = perTipoDocumento;
    }

    @Override
    public String toString() {
        return "request{" +
                "perApellido='" + perApellido + '\'' +
                ", perFechaNacimiento=" + perFechaNacimiento +
                ", perId=" + perId +
                ", perNombre='" + perNombre + '\'' +
                ", perNumeroDocumento=" + perNumeroDocumento +
                ", perTipoDocumento='" + perTipoDocumento + '\'' +
                '}';
    }
}
