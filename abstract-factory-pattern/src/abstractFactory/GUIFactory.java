package abstractFactory;

import abstractProduct.Button;
import abstractProduct.Checkbox;

// Abstract Factory
public interface GUIFactory {
    Button createButton();
    Checkbox createCheckbox();
}
