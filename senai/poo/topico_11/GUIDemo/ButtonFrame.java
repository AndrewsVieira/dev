import javax.swing.JButton;

public class ButtonFrame extends PrincipalFrame {
	public ButtonFrame() {
		super("Demo ButtonFrame");
		
		init();
	}
	
	private void init() {
		JButton botao = new JButton("Botão 1");
		this.add(botao);
	}
}
