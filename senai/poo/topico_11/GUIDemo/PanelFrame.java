import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JPanel;

public class PanelFrame extends PrincipalFrame {
	public PanelFrame() {
		super("Demo Panel");
		
		init();
	}
	
	private void init() {
		setLayout(new BorderLayout());
		
		JPanel panel;
		JButton botao;
		
		final int NUM_BOTOES = 3;
		
		panel = new JPanel();
		panel.setBackground(Color.BLACK);
		panel.setPreferredSize(new Dimension(100, 80));
		add(panel, BorderLayout.NORTH);
		
		panel = new JPanel();
		panel.setBackground(Color.ORANGE);
		panel.setPreferredSize(new Dimension(150, 100));
		panel.setLayout(new FlowLayout());
		for (int i = 1; i <= NUM_BOTOES; i++) {
			botao = new JButton("Botão " + i);
			panel.add(botao);
		}
		add(panel, BorderLayout.WEST);
		
		panel = new JPanel();
		panel.setBackground(Color.DARK_GRAY);
		add(panel, BorderLayout.CENTER);
	}
}
