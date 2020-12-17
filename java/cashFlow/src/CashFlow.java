package src;
import src.view.Frame;
import javax.swing.SwingUtilities;


public class CashFlow {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                Frame frame = new Frame();
                frame.draw();
            }
        });
    }
}
