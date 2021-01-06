package com.abm.config;

import org.springframework.data.rest.webmvc.RepositoryRestDispatcherServlet;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

public class RestWebInitializer implements WebApplicationInitializer {

    @Override
    public void onStartup(ServletContext ctx) throws ServletException {

        AnnotationConfigWebApplicationContext rootCtx = new AnnotationConfigWebApplicationContext();
        rootCtx.register(Config.class);

        ctx.addListener(new ContextLoaderListener(rootCtx));

        RepositoryRestDispatcherServlet exporter = new RepositoryRestDispatcherServlet();

        ServletRegistration.Dynamic reg = ctx.addServlet("rest-exporter", exporter);
        reg.setLoadOnStartup(1);
        reg.addMapping("/*");

    }
}
