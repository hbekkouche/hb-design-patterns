package hb.designpatterns.creational.singleton;

public class ConfigurationManager {
    // The single instance of the configuration manager
    private static ConfigurationManager instance;

    // Configuration settings
    private String databaseUrl;
    private String username;
    private String password;

    // Private constructor to prevent instantiation from outside
    private ConfigurationManager() {
        // Load configuration settings (example: reading from a file or database)
        this.databaseUrl = "jdbc:mysql://localhost:3306/mydatabase";
        this.username = "admin";
        this.password = "secretpassword";
    }

    // Method to provide the single instance of the configuration manager
    public static ConfigurationManager getInstance() {
        if (instance == null) {
            // If the instance doesn't exist, create it
            instance = new ConfigurationManager();
        }
        return instance;
    }

    // Getters for configuration settings
    public String getDatabaseUrl() {
        return databaseUrl;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    // Other methods related to configuration management
    // ...

    // Example: Method to update a configuration setting
    public void updateDatabaseUrl(String newUrl) {
        this.databaseUrl = newUrl;
        // Additional logic to save the updated setting (e.g., to a file or database)
    }
}
