import javax.swing.SwingUtilities;

import view.TodoFrame;

public class TodoApp {
    public static void main(String[] args) {
        
        SwingUtilities.invokeLater(new Runnable(){
            @Override
            public void run() {
                TodoFrame frame = new TodoFrame();
                frame.draw();
            }
        });

    }// fim do método main
} // fim da classe ToDoApp
