package com.abm;

import org.apache.catalina.startup.Tomcat;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.web.config.EnableSpringDataWebSupport;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

@ComponentScan("com.abm")
@EnableSpringDataWebSupport
@EnableJpaRepositories
@EnableWebMvc
public class Main {

    public static void main(String[] args) throws Exception {
        createDatabase();
        Tomcat tomcat = new Tomcat();
        tomcat.setPort(8080);
        tomcat.addWebapp("", new File("src/main").getAbsolutePath());
        tomcat.getConnector();
        tomcat.start();
        tomcat.getServer().await();
    }

    private static void createDatabase() throws ClassNotFoundException, IllegalAccessException, InstantiationException, SQLException {
     Class.forName("org.h2.Driver").newInstance();
        Connection con = DriverManager.getConnection("jdbc:h2:./Database/data", "sa", "password");
        Statement statement = con.createStatement();
        String sql = "CREATE TABLE IF NOT EXISTS Personas (\n" +
                "   perId BIGINT NOT NULL PRIMARY KEY,\n" +
                "   perApellido VARCHAR(50) NOT NULL,\n" +
                "   perFechaNacimiento DATE NOT NULL,\n" +
                "   perNombre VARCHAR(50) NOT NULL,\n" +
                "   perNumeroDocumento BIGINT NOT NULL,\n" +
                "   perTipoDocumento VARCHAR(5) NOT NULL\n" +
                ");" ;
        statement.executeUpdate(sql);
        System.out.println("Database created");
    }

}
