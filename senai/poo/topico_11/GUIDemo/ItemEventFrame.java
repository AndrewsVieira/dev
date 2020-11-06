import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JRadioButton;

public class ItemEventFrame extends EventFrame {
	private static final int NUM_CHKBOXES = 2;
	private static final int NUM_RADIOBTNS = 3;
	private static final String[] LIST_ITEMS = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };

	private JCheckBox[] chkBoxes;
	private ButtonGroup radioGrp;
	private JRadioButton[] radioBtns;
	private JComboBox<String> comboBox;
	private JButton btn;

	public ItemEventFrame() {
		super("Demo Item Event");

		chkBoxes = new JCheckBox[NUM_CHKBOXES];
		radioBtns = new JRadioButton[NUM_RADIOBTNS];

		init();
	}

	private void init() {
		String name;

		for (int i = 0; i < NUM_CHKBOXES; i++) {
			name = "CheckBox " + (i + 1);
			chkBoxes[i] = new JCheckBox(name);
			chkBoxes[i].addItemListener(new ItemEventHandler(name));
			addComponent(chkBoxes[i], 0, i, 1, 1);
		}

		radioGrp = new ButtonGroup();
		for (int i = 0; i < NUM_RADIOBTNS; i++) {
			name = "RadioButton " + (i + 1);
			radioBtns[i] = new JRadioButton(name);
			radioBtns[i].setActionCommand(name);
			radioBtns[i].addItemListener(new ItemEventHandler(name));
			radioGrp.add(radioBtns[i]);
			addComponent(radioBtns[i], 1, i, 1, 1);
		}

		comboBox = new JComboBox<String>(LIST_ITEMS);
		comboBox.setMaximumRowCount(3);
		comboBox.addItemListener(new ItemEventHandler("ComboBox"));
		addComponent(comboBox, 2, 0, Math.max(NUM_CHKBOXES, NUM_RADIOBTNS), 1);

		btn = new JButton("Clique aqui");

		btn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String msg = "Clicou no btn:\n";

				for (int i = 0; i < NUM_CHKBOXES; i++) {
					if (chkBoxes[i].isSelected()) {
						msg += String.format("\t%s selecionado\n", 
								chkBoxes[i].getActionCommand());
					}
				}
				
				msg += String.format("\t%s selecionado\n", 
						radioGrp.getSelection().getActionCommand());
				msg += String.format("\t%s selecionado\n", comboBox.getSelectedItem());
				
				prependOutput(msg);
			}
		});

		addComponent(btn, 3, 0, Math.max(NUM_CHKBOXES, NUM_RADIOBTNS), 1);
	}

	private class ItemEventHandler implements ItemListener {
		private String name;

		public ItemEventHandler(String name) {
			this.name = name;
		}

		@Override
		public void itemStateChanged(ItemEvent e) {
			String msg = "";

			if (e.getSource() == comboBox) {
				if (e.getStateChange() == ItemEvent.SELECTED) {
					msg = String.format("%s (%d: %s): selecionado", name, comboBox.getSelectedIndex(),
							comboBox.getSelectedItem());
					prependOutput(msg);
				}
			} else {
				msg = String.format("%s: %s", name,
						(e.getStateChange() == ItemEvent.SELECTED ? "selecionado" : "desselecionado"));
				prependOutput(msg);
			}

		}
	} // fim da classe ItemEventHandler
} // fim da classe ItemEventFrame
