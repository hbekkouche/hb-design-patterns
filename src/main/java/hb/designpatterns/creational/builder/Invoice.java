package hb.designpatterns.creational.builder;

public class Invoice {
    private String customerName;
    private String invoiceNumber;
    private double amount;
    // Other fields omitted for brevity

    // Private constructor to prevent direct instantiation
    private Invoice() {}

    // Getters
    public String getCustomerName() {
        return customerName;
    }

    public String getInvoiceNumber() {
        return invoiceNumber;
    }

    public double getAmount() {
        return amount;
    }

    // Builder class for constructing Invoice objects
    static class Builder {
        private String customerName;
        private String invoiceNumber;
        private double amount;
        // Other fields omitted for brevity

        // Builder methods to set the properties
        public Builder withCustomerName(String customerName) {
            this.customerName = customerName;
            return this;
        }

        public Builder withInvoiceNumber(String invoiceNumber) {
            this.invoiceNumber = invoiceNumber;
            return this;
        }

        public Builder withAmount(double amount) {
            this.amount = amount;
            return this;
        }

        // Other builder methods for additional properties

        // Build method to construct the Invoice object
        public Invoice build() {
            Invoice invoice = new Invoice();
            invoice.customerName = this.customerName;
            invoice.invoiceNumber = this.invoiceNumber;
            invoice.amount = this.amount;
            // Set other properties here if needed
            return invoice;
        }
    }

    public static void main(String[] args) {
        // Creating an Invoice using the Builder Pattern
        Invoice invoice = new Invoice.Builder()
                .withCustomerName("John Doe")
                .withInvoiceNumber("INV-123")
                .withAmount(100.50)
                // Add more properties if needed
                .build();

        // Accessing properties of the constructed Invoice object
        System.out.println("Customer Name: " + invoice.getCustomerName());
        System.out.println("Invoice Number: " + invoice.getInvoiceNumber());
        System.out.println("Amount: " + invoice.getAmount());
    }
}
