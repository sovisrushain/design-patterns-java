package concreteProduct;

import abstractProduct.Checkbox;

// Concrete Product: Windows Checkbox
public class WindowsCheckbox implements Checkbox {
    @Override
    public void paint() {
        System.out.println("Rendering a checkbox in Windows style");
    }
}
