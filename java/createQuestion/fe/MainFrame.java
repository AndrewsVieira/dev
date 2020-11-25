package fe;

import be.domain.base.Question;
import fe.panels.DecideTypeQuestionPanel;
import fe.panels.FormDicursiveQuestionPanel;
import fe.panels.FormObjectiveQuestionPanel;
import fe.panels.FormQuestionPanel;
import fe.panels.HomePanel;
import fe.panels.QuestionTablePanel;
import java.awt.CardLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class MainFrame extends JFrame {

  public static final String TITLE = "The Game";
  private CardLayout layout;
  private JPanel cardsPanel;
  private HomePanel homePanel;
  private QuestionTablePanel questionPanel;

  private FormQuestionPanel[] formQuestionPanels = new FormQuestionPanel[2];

  public static final int INDEX_OBJECTIVE = 0;
  public static final int INDEX_DISCURSIVE = 1;

  private DecideTypeQuestionPanel questionDecisivePanel;

  public MainFrame() {
    super(TITLE);
    this.layout = new CardLayout();
    this.cardsPanel = new JPanel();
    this.cardsPanel.setLayout(layout);
    add(cardsPanel);
    this.createCards();

    this.showHomePanel();
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  }

  public FormQuestionPanel[] getFormQuestionPanels() {
    return this.formQuestionPanels;
  }

  public void draw() {
    pack();
    setLocationRelativeTo(null);
    setVisible(true);
  }

  private void createCards() {
    this.homePanel = new HomePanel(this);
    this.cardsPanel.add(this.homePanel, HomePanel.class.getName());

    this.questionPanel = new QuestionTablePanel(this);
    this.cardsPanel.add(this.questionPanel, QuestionTablePanel.class.getName());

    this.questionDecisivePanel = new DecideTypeQuestionPanel(this);
    this.cardsPanel.add(this.questionDecisivePanel, DecideTypeQuestionPanel.class.getName());

    this.formQuestionPanels[INDEX_OBJECTIVE] = new FormObjectiveQuestionPanel(this);
    this.cardsPanel.add(this.formQuestionPanels[INDEX_OBJECTIVE],
        formQuestionPanels[INDEX_OBJECTIVE].getClass().getName());

    this.formQuestionPanels[INDEX_DISCURSIVE] = new FormDicursiveQuestionPanel(this);
    this.cardsPanel.add(this.formQuestionPanels[INDEX_DISCURSIVE],
        formQuestionPanels[INDEX_DISCURSIVE].getClass().getName());
  }

  public void showHomePanel() {
    this.layout.show(this.cardsPanel, HomePanel.class.getName());
  }

  public void showForm(Question question, int index) {
    formQuestionPanels[index].setQuestion(question);
    this.layout.show(this.cardsPanel, formQuestionPanels[index].getClass().getName());
  }

  public void showQuestionPanel() {
    questionPanel.reload();
    this.layout.show(this.cardsPanel, QuestionTablePanel.class.getName());
  }

  public void showQuestionDecisivePanel() {
    this.layout.show(this.cardsPanel, DecideTypeQuestionPanel.class.getName());
  }
}
