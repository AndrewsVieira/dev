import javax.swing.JButton;

public class NullLayoutFrame extends PrincipalFrame {
	public NullLayoutFrame() {
		super("Demo NullLayout");
		
		init();
	}
	
	private void init() {
		setLayout(null);
		
		JButton botao;
		
		botao = new JButton("Botão 1");
		botao.setBounds(50, 20, 200, 50);
		add(botao);
		
		botao = new JButton("Botão 2");
		botao.setBounds(200, 100, 100, 20);
		add(botao);
	}
}
