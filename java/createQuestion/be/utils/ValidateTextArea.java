package be.utils;

import javax.swing.JComponent;
import javax.swing.JTextArea;

public class ValidateTextArea extends Validation {

  @Override
  public boolean validate(JComponent jComponents) {
    JTextArea jTextArea = (JTextArea) jComponents;
    return !jTextArea.getText().isBlank();
  }
}
