package hb.designpatterns.structural.decorator;

// Component interface representing the base coffee
interface Coffee {
    String getDescription();
    double getCost();
}

// Concrete component representing a basic coffee
class BasicCoffee implements Coffee {
    @Override
    public String getDescription() {
        return "Basic Coffee";
    }

    @Override
    public double getCost() {
        return 2.0; // Cost of basic coffee
    }
}

// Decorator class for adding milk to coffee
class MilkDecorator implements Coffee {
    private Coffee coffee;

    public MilkDecorator(Coffee coffee) {
        this.coffee = coffee;
    }

    @Override
    public String getDescription() {
        return coffee.getDescription() + ", Milk";
    }

    @Override
    public double getCost() {
        return coffee.getCost() + 0.5; // Additional cost for milk
    }
}

// Decorator class for adding sugar to coffee
class SugarDecorator implements Coffee {
    private Coffee coffee;

    public SugarDecorator(Coffee coffee) {
        this.coffee = coffee;
    }

    @Override
    public String getDescription() {
        return coffee.getDescription() + ", Sugar";
    }

    @Override
    public double getCost() {
        return coffee.getCost() + 0.3; // Additional cost for sugar
    }
}

// Decorator class for adding flavor to coffee
class FlavorDecorator implements Coffee {
    private Coffee coffee;
    private String flavor;

    public FlavorDecorator(Coffee coffee, String flavor) {
        this.coffee = coffee;
        this.flavor = flavor;
    }

    @Override
    public String getDescription() {
        return coffee.getDescription() + ", " + flavor + " Flavor";
    }

    @Override
    public double getCost() {
        return coffee.getCost() + 0.7; // Additional cost for flavor
    }
}

// Example usage
public class Main {
    public static void main(String[] args) {
        // Order a basic coffee
        Coffee basicCoffee = new BasicCoffee();
        System.out.println("Description: " + basicCoffee.getDescription());
        System.out.println("Cost: $" + basicCoffee.getCost());

        // Order a coffee with milk
        Coffee coffeeWithMilk = new MilkDecorator(new BasicCoffee());
        System.out.println("Description: " + coffeeWithMilk.getDescription());
        System.out.println("Cost: $" + coffeeWithMilk.getCost());

        // Order a coffee with milk, sugar, and flavor
        Coffee coffeeWithMilkSugarFlavor = new FlavorDecorator(new SugarDecorator(new MilkDecorator(new BasicCoffee())), "Vanilla");
        System.out.println("Description: " + coffeeWithMilkSugarFlavor.getDescription());
        System.out.println("Cost: $" + coffeeWithMilkSugarFlavor.getCost());
    }
}
