package net.swapra.usermanagement.util;

import java.util.Properties;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

import net.swapra.usermanagement.model.User;

/**
 * Utility class to manage Hibernate SessionFactory.
 * This class follows the Singleton pattern to provide a global point of access to the SessionFactory.
 */
public class HibernateUtil {
    // Single SessionFactory instance for the application
    private static SessionFactory sessionFactory;
    
    /**
     * Gets the Hibernate SessionFactory, creating it if it doesn't exist yet.
     * 
     * @return SessionFactory instance that can be used to create Sessions for database operations
     */
    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            try {
                // Create a new Configuration instance for Hibernate
                Configuration configuration = new Configuration();
                
                // Set up database connection and Hibernate properties
                Properties settings = new Properties();
                // JDBC driver class for MySQL database
                settings.put(Environment.DRIVER, "com.mysql.cj.jdbc.Driver");
                // Database URL (connecting to MySQL on localhost, port 3306, database name 'demo123')
                settings.put(Environment.URL, "jdbc:mysql://localhost:3306/demo123?useSSL=false");
                // Database username
                settings.put(Environment.USER, "root");
                // Database password
                settings.put(Environment.PASS, "root");
                // Dialect to use for MySQL 8
                settings.put(Environment.DIALECT, "org.hibernate.dialect.MySQL8Dialect");
                // Enable logging of SQL statements (for debugging)
                settings.put(Environment.SHOW_SQL, "true");
                // Bind session to current thread
                settings.put(Environment.CURRENT_SESSION_CONTEXT_CLASS, "thread");
                // Update schema automatically if needed
                settings.put(Environment.HBM2DDL_AUTO, "update");

                // Apply settings to configuration
                configuration.setProperties(settings);
                // Register the User entity class with Hibernate
                configuration.addAnnotatedClass(User.class);

                // Build the ServiceRegistry from the configuration properties
                ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                        .applySettings(configuration.getProperties()).build();

                // Create the SessionFactory using the ServiceRegistry
                sessionFactory = configuration.buildSessionFactory(serviceRegistry);
            } catch (Exception e) {
                // Print stack trace if initialization fails
                e.printStackTrace();
            }
        }
        // Return existing or newly created SessionFactory
        return sessionFactory;
    }

    /**
     * Gracefully shuts down the SessionFactory.
     * Should be called when the application is shutting down.
     */
    public static void shutdown() {
        if (sessionFactory != null) {
            sessionFactory.close();
        }
    }
}