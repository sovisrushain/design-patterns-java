package concreteProduct;

import abstractProduct.Checkbox;

// Concrete Product: Mac Checkbox
public class MacCheckbox implements Checkbox {
    @Override
    public void paint() {
        System.out.println("Rendering a checkbox in Mac style");
    }
}
