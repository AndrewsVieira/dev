package view.cores;

import java.awt.Color;

import javax.swing.JComponent;

public class AppColor {
    private static Color background = new Color(21, 94, 96);
    private static Color button = new Color(21, 84, 85);
    private static Color fontColor = new Color(0, 0, 0);

    public static void setBackGroundColor(JComponent comp) {
        comp.setBackground(background);
    }

    public static void setButtonColor(JComponent comp) {
        comp.setBackground(button);
    }

    public static void setFontColor(JComponent comp) {
        comp.setForeground(fontColor);
    }
}
