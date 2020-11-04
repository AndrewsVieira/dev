import java.awt.FlowLayout;

import javax.swing.JButton;

public class FlowLayoutFrame extends PrincipalFrame {
	public FlowLayoutFrame() {
		super("Demo FlowLayout");
		
		init();
	}
	
	private void init() {
		setLayout(new FlowLayout(FlowLayout.RIGHT, 20, 50));
		
		final int NUM_BOTOES = 5;
		
		for (int i = 1; i <= NUM_BOTOES; i++) {
			add(new JButton("Botão " + i));
		}
	}
}
