package com.revatureproj.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revatureproj.servlets.LoginServlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.ServletRegistration;
import java.time.LocalDateTime;

public class ContextLoaderListener  implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("[LOG] - The servlet context was initialized at " + LocalDateTime.now());

        ObjectMapper mapper = new ObjectMapper();

        LoginServlet loginServlet = new LoginServlet(mapper);

        ServletContext context = sce.getServletContext();
        ServletRegistration.Dynamic registeredServlet = context.addServlet("LoginServlet", loginServlet);
        registeredServlet.addMapping("/login");
        registeredServlet.setLoadOnStartup(1);
        registeredServlet.setInitParameter("user-servlet-key", "user-servlet-value");
        registeredServlet.setInitParameter("another-param", "another-value");


    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        ServletContextListener.super.contextDestroyed(sce);
    }
}
