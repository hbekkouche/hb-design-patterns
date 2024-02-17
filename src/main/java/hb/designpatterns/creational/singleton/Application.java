package hb.designpatterns.creational.singleton;

public class Application {
    public static void main(String[] args) {
        // Get the configuration manager instance
        ConfigurationManager configManager = ConfigurationManager.getInstance();

        // Access configuration settings
        System.out.println("Database URL: " + configManager.getDatabaseUrl());
        System.out.println("Username: " + configManager.getUsername());
        System.out.println("Password: " + configManager.getPassword());

        // Update a configuration setting
        configManager.updateDatabaseUrl("jdbc:mysql://newhost:3306/mydatabase");

        // Access updated configuration settings
        System.out.println("Updated Database URL: " + configManager.getDatabaseUrl());
    }
}
