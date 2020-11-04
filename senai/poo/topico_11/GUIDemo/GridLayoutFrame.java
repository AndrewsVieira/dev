import java.awt.GridLayout;

import javax.swing.JButton;

public class GridLayoutFrame extends PrincipalFrame {
	public GridLayoutFrame() {
		super("Demo GridLayout");

		init();
	}

	private void init() {
		setLayout(new GridLayout(2, 3, 0, 0));
		
		final int NUM_BOTOES = 5;

		for (int i = 1; i <= NUM_BOTOES; i++) {
			add(new JButton("Botão " + i));
		}
	}
}
