import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JSlider;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JToggleButton;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;

public class InputFieldsFrame extends JFrame {
	private static final Insets FIELD_INSETS = new Insets(5, 10, 0, 0);
	private static final int NUM_CHKBOXES = 5;
	private static final int NUM_RADIOBTN = 3;
	private static final String[] LIST_ITEMS = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };

	private GridBagLayout layout;
	private GridBagConstraints constraints;

	public InputFieldsFrame() {
		super("Demo Input Fields");

		JPanel contentPane = new JPanel();
		contentPane.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		setContentPane(contentPane);

		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		layout = new GridBagLayout();
		setLayout(layout);

		constraints = new GridBagConstraints();

		init();

		pack();
	}

	private void init() {
		JLabel label;
		JSeparator separator;
		JScrollPane scrollPane;
		JPanel panel;
		JCheckBox checkBox;
		JRadioButton radioButton;
		JMenu menu;
		JMenuItem menuItem;

		/**
		 * Componentes de texto
		 */
		label = new JLabel("Texto");
		label.setForeground(Color.BLUE);
		addComponent(label, 0, 0, 1, 1);
		separator = new JSeparator();
		addComponent(separator, 0, 1, 3, 1);

		label = new JLabel("TextField:");
		addComponent(label, 1, 0, 1, 1);
		JTextField textField = new JTextField(30);
		addComponent(textField, 1, 1, 3, 1);

		label = new JLabel("TextArea:");
		addComponent(label, 2, 0, 1, 1);
		JTextArea textArea = new JTextArea(3, 30);
		scrollPane = new JScrollPane(textArea);
		addComponent(scrollPane, 2, 1, 3, 3);

		label = new JLabel("PasswordField:");
		addComponent(label, 5, 0, 1, 1);
		JPasswordField passwordField = new JPasswordField(30);
		addComponent(passwordField, 5, 1, 3, 1);

		/**
		 * Componentes de Botão
		 */
		label = new JLabel("Botões");
		label.setForeground(Color.BLUE);
		addComponent(label, 6, 0, 1, 1);
		separator = new JSeparator();
		addComponent(separator, 6, 1, 3, 1);

		label = new JLabel("Button:");
		addComponent(label, 7, 0, 1, 1);
		JButton button = new JButton("Botão Simples");
		addComponent(button, 7, 1, 1, 1);

		label = new JLabel("ToggleButton:");
		addComponent(label, 8, 0, 1, 1);
		JToggleButton toggleButton = new JToggleButton("Botão Ativado/Desativado");
		addComponent(toggleButton, 8, 1, 2, 1);

		label = new JLabel("CheckBox:");
		addComponent(label, 9, 0, 1, 1);
		panel = new JPanel();
		for (int i = 1; i <= NUM_CHKBOXES; i++) {
			checkBox = new JCheckBox("Opção " + i);
			panel.add(checkBox);
		}
		addComponent(panel, 9, 1, 3, 1);

		label = new JLabel("RadioButton:");
		addComponent(label, 10, 0, 1, 1);
		panel = new JPanel();
		ButtonGroup buttonGroup = new ButtonGroup();
		for (int i = 1; i <= NUM_RADIOBTN; i++) {
			radioButton = new JRadioButton("Opção " + i);
			buttonGroup.add(radioButton);
			panel.add(radioButton);
		}
		addComponent(panel, 10, 1, 3, 1);

		/**
		 * Dúvida do Antonio
		 */
//		ButtonGroup btnGrp2 = new ButtonGroup();
//		for (int i = 1; i <= 2; i++) {
//			toggleButton = new JToggleButton("Btn " + i);
//			btnGrp2.add(toggleButton);
//			addComponent(toggleButton, 11, i, 1, 1);
//		}

		/**
		 * Componentes de Lista
		 */
		label = new JLabel("Listas");
		label.setForeground(Color.BLUE);
		addComponent(label, 11, 0, 1, 1);
		separator = new JSeparator();
		addComponent(separator, 11, 1, 3, 1);

		label = new JLabel("ComboBox:");
		addComponent(label, 12, 0, 1, 1);
		JComboBox<String> comboBox = new JComboBox<>(LIST_ITEMS);
		comboBox.setMaximumRowCount(3);
		addComponent(comboBox, 12, 1, 2, 1);

		label = new JLabel("List:");
		addComponent(label, 13, 0, 1, 1);
		JList<String> list = new JList<String>(LIST_ITEMS);
		list.setVisibleRowCount(3);
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollPane = new JScrollPane(list);
		addComponent(scrollPane, 13, 1, 2, 3);
		
		/**
		 * Outros componentes
		 */
		label = new JLabel("Outros");
		label.setForeground(Color.BLUE);
		addComponent(label, 16, 0, 1, 1);
		separator = new JSeparator();
		addComponent(separator, 16, 1, 3, 1);
		
		label = new JLabel("Slider:");
		addComponent(label, 17, 0, 1, 1);
		JSlider slider = new JSlider(SwingConstants.HORIZONTAL, 0, 100, 50);
		slider.setMajorTickSpacing(10);
		slider.setPaintTicks(true);
		addComponent(slider, 17, 1, 3, 1);
		
		label = new JLabel("Table:");
		addComponent(label, 18, 0, 1, 1);
		String[] colNames = { "Nome", "Sobrenome", "E-mail" };
		String[][] data = {
				{ "Luke", "Skywalker", "luke@disney.com" },
				{ "Leia", "Organa", "leia.organa@senate.gov" },
				{ "Anakin", "Skywalker", "vader@empire.gov" },
				{ "Sheev", "Palpatine", "sidious@darkside.org" }
		};
		JTable table = new JTable(data, colNames);
		table.setPreferredScrollableViewportSize(
				new Dimension(table.getPreferredSize().width,
				table.getRowHeight() * 3));
		scrollPane = new JScrollPane(table);
		addComponent(scrollPane, 18, 1, 3, 3);
		
		/**
		 * Menu
		 */
		JMenuBar menuBar = new JMenuBar();
		menu = new JMenu("Menu 1");
		menuItem = new JMenuItem("Opção 1");
		menu.add(menuItem);
		menuBar.add(menu);
		menu = new JMenu("Menu 2");
		menuItem = new JMenuItem("Opção 2");
		menu.add(menuItem);
		menuItem = new JMenuItem("Opção 3");
		menu.add(menuItem);
		menuBar.add(menu);
		setJMenuBar(menuBar);
		
		/**
		 * Diálogo
		 */
		String nome = JOptionPane.showInputDialog("Informe seu nome:");
		int resposta = JOptionPane.showConfirmDialog(null, "Você está certo disso?");
		if (resposta == JOptionPane.OK_OPTION) { // sim
			JOptionPane.showMessageDialog(null, "Seu nome é " + nome);
		} else if (resposta == JOptionPane.NO_OPTION) { // não
			JOptionPane.showMessageDialog(null, "Seu nome NÃO é " + nome);
		} else { // cancelar
			JOptionPane.showMessageDialog(null, "Não sabe seu nome?");
		}
	}

	private void addComponent(JComponent comp, int row, int col, int width, int height) {
		constraints.gridx = col;
		constraints.gridy = row;
		constraints.gridwidth = width;
		constraints.gridheight = height;

		constraints.fill = GridBagConstraints.HORIZONTAL;
		constraints.insets = FIELD_INSETS;
		constraints.anchor = GridBagConstraints.NORTHWEST;

		layout.setConstraints(comp, constraints);
		add(comp);
	}
}
