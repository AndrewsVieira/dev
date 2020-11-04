import java.awt.Dimension;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;

public class BoxLayoutFrame extends PrincipalFrame {
	public BoxLayoutFrame() {
		super("Demo BoxLayout");

		init();
	}

	private void init() {
		setLayout(new BoxLayout(this.getContentPane(), BoxLayout.Y_AXIS));
		
		Box box;
		
//		box = Box.createHorizontalBox();
		box = Box.createVerticalBox();
		
		final int NUM_BOTOES = 5;
		
		for (int i = 1; i <= NUM_BOTOES; i++) {
//			box.add(Box.createHorizontalGlue());
//			box.add(Box.createHorizontalStrut(25));
//			box.add(Box.createVerticalGlue());
//			box.add(Box.createVerticalStrut(50));
			box.add(Box.createRigidArea(new Dimension(20, 5)));
			box.add(new JButton("Botão " + i));
		}
		
		add(box);
	}
}
