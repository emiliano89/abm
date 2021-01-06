package com.abm.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "Personas")
public class Persona implements Serializable {

    @Column
    private String perApellido;
    @Column
    private Date perFechaNacimiento;
    @Id
    private Long perId;
    @Column
    private String perNombre;
    @Column
    private Long perNumeroDocumento;
    @Column
    private String perTipoDocumento;

    public Persona() {
    }

    public Persona(String perApellido,
                   Date perFechaNacimiento,
                   long perId,
                   String perNombre,
                   Long perNumerpDocumento,
                   String perTipoDocumento) {
        this.perApellido = perApellido;
        this.perFechaNacimiento = perFechaNacimiento;
        this.perId = perId;
        this.perNombre = perNombre;
        this.perNumeroDocumento = perNumerpDocumento;
        this.perTipoDocumento = perTipoDocumento;
    }

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

    public Long getPerId() {
        return perId;
    }

    public void setPerId(Long perId) {
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
        return "Persona{" +
                "perApellido='" + perApellido + '\'' +
                ", perFechaNacimiento=" + perFechaNacimiento +
                ", perId=" + perId +
                ", perNombre='" + perNombre + '\'' +
                ", perNumerpDocumento=" + perNumeroDocumento +
                ", perTipoDocumento='" + perTipoDocumento + '\'' +
                '}';
    }
}
