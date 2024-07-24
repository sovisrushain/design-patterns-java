package concreteFactory;

import abstractFactory.GUIFactory;
import abstractProduct.Button;
import abstractProduct.Checkbox;
import concreteProduct.MacButton;
import concreteProduct.MacCheckbox;

// Concrete Factory: Mac Factory
public class MacFactory implements GUIFactory {
    @Override
    public Button createButton() {
        return new MacButton();
    }

    @Override
    public Checkbox createCheckbox() {
        return new MacCheckbox();
    }
}
