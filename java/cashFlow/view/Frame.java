package view;

import java.awt.CardLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

import model.FinancialRecord;
import model.utils.Category;
import view.panels.CashFlowPanel;
import view.panels.CategoryFormPanel;
import view.panels.CategoryPanel;
import view.panels.HomePanel;
import view.panels.PayFormPanel;
import view.panels.PayPanel;
import view.panels.ToReceiveFormPanel;
import view.panels.ToReceivePanel;

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

	private CategoryPanel categoryPanel;
	private CategoryFormPanel categoryFormPanel;

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

		categoryPanel = new CategoryPanel(this);
		cardsPanel.add(categoryPanel, CategoryPanel.class.getName());

		categoryFormPanel = new CategoryFormPanel(this);
		cardsPanel.add(categoryFormPanel, CategoryFormPanel.class.getName());
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
		payFormPanel.setRecord(record);
		layout.show(cardsPanel, PayFormPanel.class.getName());
	}

	public void showToReceiveFormPanel(FinancialRecord revenue) {
		toReceiveFormPanel.setRevenue(revenue);
		layout.show(cardsPanel, ToReceiveFormPanel.class.getName());
	}

	public void showCategoryPanel() {
		categoryPanel.reload();
		layout.show(cardsPanel, CategoryPanel.class.getName());
	}

	public void showCategoryFormPanel(Category category) {
		categoryFormPanel.setCategory(category);
		layout.show(cardsPanel, CategoryFormPanel.class.getName());
	}

}
