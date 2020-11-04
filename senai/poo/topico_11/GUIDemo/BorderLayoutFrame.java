import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JPanel;

public class BorderLayoutFrame extends PrincipalFrame {
	public BorderLayoutFrame() {
		super("Demo BorderLayout");
		
		init();
	}
	
	private void init() {
		setLayout(new BorderLayout());
		
		JButton botao;
		
		botao = new JButton("Botão 1");
		botao.setPreferredSize(new Dimension(100, 150));
		add(botao, BorderLayout.NORTH);
		
		botao = new JButton("Botão 2");
		add(botao, BorderLayout.EAST);

		botao = new JButton("Botão 3");
		add(botao, BorderLayout.WEST);

		botao = new JButton("Botão 4");
		add(botao, BorderLayout.SOUTH);

		JPanel panel = new JPanel();
		panel.setBackground(Color.BLACK);
		botao = new JButton("Botão 5");
		panel.add(botao);
		botao = new JButton("Botão 6");
		panel.add(botao);
		add(panel, BorderLayout.CENTER);
	}
}
