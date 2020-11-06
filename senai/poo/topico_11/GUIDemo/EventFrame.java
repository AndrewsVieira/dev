import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;

import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class EventFrame extends PrincipalFrame {
	private static final Insets FIELD_INSETS = new Insets(5, 10, 0, 0);

	private GridBagLayout layout;
	private GridBagConstraints constraints;

	private JPanel panel;
	private JTextArea output;

	public EventFrame() {
		this("Demo EventFrame");
	}

	public EventFrame(String title) {
		super(title);

		layout = new GridBagLayout();
		constraints = new GridBagConstraints();
		panel = new JPanel();
		output = new JTextArea();

		init();
	}

	private void init() {
		setLayout(new GridLayout(1, 2, 2, 2));
		
		panel.setLayout(layout);
		add(panel);
		
		add(output);
	}
	
	public void addComponent(JComponent comp, int row, int col, int width, int height) {
		constraints.gridx = col;
		constraints.gridy = row;
		constraints.gridwidth = width;
		constraints.gridheight = height;
		constraints.fill = GridBagConstraints.BOTH;
		constraints.insets = FIELD_INSETS;
		
		layout.setConstraints(comp, constraints);
		panel.add(comp);
	}
	
	public void prependOutput(String msg) {
		output.setText(msg + "\n" + output.getText());
	}
}
