package services;

import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;

/**
 * This class is tied to the startup and shutdown of tomcat. Just implement
 * the ServletContextListener and put whatever logic into the overridden
 * methods.
 */
@WebListener("DependencyLoaderListener")
public class DependencyLoaderListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {

    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }
}