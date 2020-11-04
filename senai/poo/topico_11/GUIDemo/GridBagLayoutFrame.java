import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JButton;
import javax.swing.JComponent;

public class GridBagLayoutFrame extends PrincipalFrame {
	private GridBagLayout layout;
	private GridBagConstraints constraints;
	
	public GridBagLayoutFrame() {
		super("Demo GridBagLayout");
		
		layout = new GridBagLayout();
		constraints = new GridBagConstraints();
		
		init();
	}
	
	private void init() {
		setLayout(layout);
		
		JButton botao;
		
		botao = new JButton("Botão 1");
		addComponent(botao, 0, 0, 1, 1);
		
		botao = new JButton("Botão 2");
		addComponent(botao, 0, 1, 1, 1);
		
		botao = new JButton("Botão 3");
		constraints.weightx = 10;
		constraints.fill = GridBagConstraints.HORIZONTAL;
		addComponent(botao, 1, 0, 2, 1);
		
		botao = new JButton("Botão 4");
		constraints.fill = GridBagConstraints.HORIZONTAL;
		addComponent(botao, 2, 0, 1, 1);
		
		botao = new JButton("Botão 5");
		constraints.fill = GridBagConstraints.HORIZONTAL;
		addComponent(botao, 3, 0, 1, 1);
		
		botao = new JButton("Botão 6");
		constraints.fill = GridBagConstraints.BOTH;
		addComponent(botao, 2, 1, 1, 2);
	}
	
	private void addComponent(JComponent component, int row, int col, int width, int height) {
		constraints.gridx = col;
		constraints.gridy = row;
		constraints.gridwidth = width;
		constraints.gridheight = height;
		
		layout.setConstraints(component, constraints);
		add(component);
	}
}
