package be.utils;

import javax.swing.JComponent;
import javax.swing.JTextField;

public class ValidateText extends Validation {

  @Override
  public boolean validate(JComponent jComponent) {
    JTextField jTextField = (JTextField) jComponent;
    return !jTextField.getText().isBlank();
  }
}
