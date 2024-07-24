package concreteFactory;

import abstractFactory.GUIFactory;
import abstractProduct.Button;
import abstractProduct.Checkbox;
import concreteProduct.WindowsButton;
import concreteProduct.WindowsCheckbox;

// Concrete Factory: Windows Factory
public class WindowsFactory implements GUIFactory {
    @Override
    public Button createButton() {
        return new WindowsButton();
    }

    @Override
    public Checkbox createCheckbox() {
        return new WindowsCheckbox();
    }
}
