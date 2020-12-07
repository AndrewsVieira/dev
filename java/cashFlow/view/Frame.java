package view;

import javax.swing.JFrame;
import javax.swing.JPanel;

import model.FinancialRecord;
import view.panels.CashFlowPanel;
import view.panels.HomePanel;
import view.panels.PayFormPanel;
import view.panels.PayPanel;
import view.panels.ToReceiveFormPanel;
import view.panels.ToReceivePanel;

import java.awt.CardLayout;

public class Frame extends JFrame {
	public static String TITLE = "Fluxo de Caixa";

	private CardLayout layout;
	private JPanel cardsPanel;

	private HomePanel homePanel;
	private PayPanel payPanel;
	private ToReceivePanel toReceivePanel;
	private CashFlowPanel cashFlowPanel;

	private PayFormPanel payFormPanel;
	private ToReceiveFormPanel toReceiveFormPanel;

	public Frame() {
		super(TITLE);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		layout = new CardLayout();

		cardsPanel = new JPanel();
		cardsPanel.setLayout(layout);
		add(cardsPanel);

		createCards();
	}

	private void createCards() {
		homePanel = new HomePanel(this);
		cardsPanel.add(homePanel, HomePanel.class.getName());

		payPanel = new PayPanel(this);
		cardsPanel.add(payPanel, PayPanel.class.getName());

		toReceivePanel = new ToReceivePanel(this);
		cardsPanel.add(toReceivePanel, ToReceivePanel.class.getName());

		cashFlowPanel = new CashFlowPanel(this);
		cardsPanel.add(cashFlowPanel, CashFlowPanel.class.getName());

		payFormPanel = new PayFormPanel(this);
		cardsPanel.add(payFormPanel, PayFormPanel.class.getName());

		toReceiveFormPanel = new ToReceiveFormPanel(this);
		cardsPanel.add(toReceiveFormPanel, ToReceiveFormPanel.class.getName());
	}

	public void draw() {
		pack();
		setLocationRelativeTo(null);
		setVisible(true);
	}

	public void showMainPanel() {
		layout.show(cardsPanel, HomePanel.class.getName());
	}

	public void showPayPanel() {
		payPanel.reload();
		layout.show(cardsPanel, PayPanel.class.getName());
	}

	public void showToReceivePanel() {
		toReceivePanel.reload();
		layout.show(cardsPanel, ToReceivePanel.class.getName());
	}

	public void showCashFlowPanel() {
		layout.show(cardsPanel, CashFlowPanel.class.getName());
	}

	public void showPayFormPanel(FinancialRecord record) {
		payFormPanel.setPayament(record);
		layout.show(cardsPanel, PayFormPanel.class.getName());
	}

	public void showToReceiveFormPanel(FinancialRecord revenue) {
		toReceiveFormPanel.setRevenue(revenue);
		layout.show(cardsPanel, ToReceiveFormPanel.class.getName());
	}

}
