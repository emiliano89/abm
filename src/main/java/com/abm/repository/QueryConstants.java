package com.abm.repository;

public class QueryConstants {

    public static final String FIND_BY_NAME = "SELECT p \n" +
            "FROM Persona AS p \n" +
            "WHERE p.perNombre = :perNombre ";

    public static final String FIND_BY_DOCUMENT_TYPE = "SELECT p \n" +
            "FROM Persona AS p \n" +
            "WHERE p.perTipoDocumento = :perTipoDocumento ";
}
