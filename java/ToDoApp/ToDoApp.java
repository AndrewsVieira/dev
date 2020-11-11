import javax.swing.SwingUtilities;

import View.ToDoFrame;

public class ToDoApp {
    public static void main(String[] args) {
        
        SwingUtilities.invokeLater(new Runnable(){
            @Override
            public void run() {
                ToDoFrame frame = new ToDoFrame();
                frame.draw();
            }
        });

    }// fim do método main
} // fim da classe ToDoApp
