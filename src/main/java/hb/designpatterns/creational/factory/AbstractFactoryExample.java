package hb.designpatterns.creational.factory;

// Button interface
interface Button {
    void render();
}

// TextField interface
interface TextField {
    void render();
}

// Checkbox interface
interface Checkbox {
    void render();
}

// Concrete Product: FlatButton
class FlatButton implements Button {
    @Override
    public void render() {
        System.out.println("Rendering Flat Button");
        // Actual rendering logic for flat button
    }
}

// Concrete Product: FlatTextField
class FlatTextField implements TextField {
    @Override
    public void render() {
        System.out.println("Rendering Flat Text Field");
        // Actual rendering logic for flat text field
    }
}

// Concrete Product: FlatCheckbox
class FlatCheckbox implements Checkbox {
    @Override
    public void render() {
        System.out.println("Rendering Flat Checkbox");
        // Actual rendering logic for flat checkbox
    }
}

// Concrete Product: NeomorphicButton
class NeomorphicButton implements Button {
    @Override
    public void render() {
        System.out.println("Rendering Neomorphic Button");
        // Actual rendering logic for neomorphic button
    }
}

// Concrete Product: NeomorphicTextField
class NeomorphicTextField implements TextField {
    @Override
    public void render() {
        System.out.println("Rendering Neomorphic Text Field");
        // Actual rendering logic for neomorphic text field
    }
}

// Concrete Product: NeomorphicCheckbox
class NeomorphicCheckbox implements Checkbox {
    @Override
    public void render() {
        System.out.println("Rendering Neomorphic Checkbox");
        // Actual rendering logic for neomorphic checkbox
    }
}

// Abstract Factory Interface
interface GUIComponentFactory {
    Button createButton();

    TextField createTextField();

    Checkbox createCheckbox();
}

// Concrete Factory: FlatGUIComponentFactory
class FlatGUIComponentFactory implements GUIComponentFactory {
    @Override
    public Button createButton() {
        return new FlatButton();
    }

    @Override
    public TextField createTextField() {
        return new FlatTextField();
    }

    @Override
    public Checkbox createCheckbox() {
        return new FlatCheckbox();
    }
}

// Concrete Factory: NeomorphicGUIComponentFactory
class NeomorphicGUIComponentFactory implements GUIComponentFactory {
    @Override
    public Button createButton() {
        return new NeomorphicButton();
    }

    @Override
    public TextField createTextField() {
        return new NeomorphicTextField();
    }

    @Override
    public Checkbox createCheckbox() {
        return new NeomorphicCheckbox();
    }
}

public class AbstractFactoryExample {
    public static void main(String[] args) {
        // Choose the design style (Flat or Neomorphic)
        boolean useFlatDesign = false;

        // Create a GUI component factory based on the chosen design style
        GUIComponentFactory componentFactory = useFlatDesign ? new FlatGUIComponentFactory() : new NeomorphicGUIComponentFactory();

        // Create GUI components
        Button button = componentFactory.createButton();
        TextField textField = componentFactory.createTextField();
        Checkbox checkbox = componentFactory.createCheckbox();

        // Render GUI components
        button.render();
        textField.render();
        checkbox.render();
    }
}
