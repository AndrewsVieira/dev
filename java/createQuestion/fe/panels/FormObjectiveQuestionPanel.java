package fe.panels;

import be.domain.Alternative;
import be.domain.ObjectiveQuestion;
import be.domain.base.Question;
import be.services.QuestionService;
import be.utils.ValidateText;
import be.utils.ValidateTextArea;
import be.utils.Validation;
import fe.MainFrame;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class FormObjectiveQuestionPanel extends FormQuestionPanel {

  private Question question;
  private JTextField textFieldA;
  private JTextField textFieldB;
  private JTextField textFieldC;

  private JTextField typeQuestionTxt;
  private JCheckBox checkBoxATrue;
  private JCheckBox checkBoxBTrue;
  private JCheckBox checkBoxCTrue;

  private JButton saveBtn;

  public FormObjectiveQuestionPanel(MainFrame frame) {
    super(frame);
    this.question = null;
    checkBoxATrue.setBackground(new Color(118, 206, 166));
    checkBoxBTrue.setBackground(new Color(118, 206, 166));
    checkBoxCTrue.setBackground(new Color(118, 206, 166));

    addComponentListener(new ComponentAdapter() {
      @Override
      public void componentShown(ComponentEvent arg0) {
        if (Objects.isNull(question)) {
          getIdTxt().setText("");
          typeQuestionTxt.setText("");
          getQuestionTxt().setText("");
          textFieldA.setText("");
          textFieldB.setText("");
          textFieldC.setText("");
          checkBoxATrue.setSelected(false);
          checkBoxBTrue.setSelected(false);
          checkBoxCTrue.setSelected(false);


        } else {
          ObjectiveQuestion objectiveQuestion = (ObjectiveQuestion) question;

          getIdTxt().setText(Integer.toString(question.getId()));
          typeQuestionTxt.setText(String.valueOf(objectiveQuestion.getTypeQuestion()));
          getQuestionTxt().setText(objectiveQuestion.getQuestion());

          textFieldA.setText(objectiveQuestion.getAlternativeList().get(0).getAlternative());
          textFieldB.setText(objectiveQuestion.getAlternativeList().get(1).getAlternative());
          textFieldC.setText(objectiveQuestion.getAlternativeList().get(2).getAlternative());

          checkBoxATrue
              .setSelected(objectiveQuestion.getAlternativeList().get(0).getRigthAlternative());
          checkBoxBTrue
              .setSelected(objectiveQuestion.getAlternativeList().get(1).getRigthAlternative());
          checkBoxCTrue
              .setSelected(objectiveQuestion.getAlternativeList().get(2).getRigthAlternative());
        }
      }
    });
  }

  private void createAlternatives() {
    JLabel label;

    label = new JLabel("Alternativas: ");
    label.setForeground(Color.BLACK);
    addComponent(label, 7, 0, 1, 1);
    label = new JLabel("Verdadeira");
    addComponent(label, 7, 2, 1, 1);

    label = new JLabel("1) ");
    label.setForeground(Color.BLACK);
    addComponent(label, 8, 0);
    textFieldA = new JTextField(1);
    addComponent(textFieldA, 8, 1);

    checkBoxATrue = new JCheckBox();
    addComponent(checkBoxATrue, 8, 2);

    label = new JLabel("2) ");
    label.setForeground(Color.BLACK);
    addComponent(label, 9, 0);
    textFieldB = new JTextField(1);
    addComponent(textFieldB, 9, 1);

    checkBoxBTrue = new JCheckBox();
    addComponent(checkBoxBTrue, 9, 2);

    label = new JLabel("3) ");
    label.setForeground(Color.BLACK);
    addComponent(label, 10, 0);
    textFieldC = new JTextField(1);
    addComponent(textFieldC, 10, 1);

    checkBoxCTrue = new JCheckBox();
    addComponent(checkBoxCTrue, 10, 2);

    label = new JLabel();
    addComponent(label, 14, 0, 1, 1);

  }

  @Override
  public void setQuestion(Question question) {
    this.question = question;
  }

  @Override
  public Question getQuestion() {
    return question;
  }

  @Override
  public void createTypeQuestionComponent() {
    JLabel label;
    label = new JLabel("Tipo da Questão");
    addComponent(label, 1, 0);
    typeQuestionTxt = new JTextField(1);
    typeQuestionTxt.setEditable(false);
    addComponent(typeQuestionTxt, 1, 1);
    createAlternatives();
  }

  @Override
  public void createSaveButton() {
    this.saveBtn = new JButton("Salvar");
    saveBtn.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent arg0) {
        if (validateAlternatives() && validateQuestionText()) {
          List<Alternative> alternativeList = this.getListAlternative(
              new Alternative(textFieldA.getText(), checkBoxATrue.isSelected()),
              new Alternative(textFieldB.getText(), checkBoxBTrue.isSelected()),
              new Alternative(textFieldC.getText(), checkBoxCTrue.isSelected()));

          System.out.println(alternativeList.get(0).getRigthAlternative());

          Question quest = new ObjectiveQuestion(getQuestionTxt().getText(), alternativeList);

          if (Objects.isNull(getQuestion())) {
            quest.createQuestion();
            JOptionPane
                .showMessageDialog(FormObjectiveQuestionPanel.this, "Questão criado com sucesso!",
                    MainFrame.TITLE,
                    JOptionPane.INFORMATION_MESSAGE);
            getFrame().showQuestionPanel();
          } else {
            quest.setId(question.getId());
            quest.setTypeQuestion(typeQuestionTxt.getText());
            QuestionService.updateQuestion(quest);
            JOptionPane
                .showMessageDialog(FormObjectiveQuestionPanel.this, "Questão Alterada com sucesso!",
                    MainFrame.TITLE,
                    JOptionPane.INFORMATION_MESSAGE);
            getFrame().showQuestionPanel();
          }
        } else {
          JOptionPane.showMessageDialog(FormObjectiveQuestionPanel.this, "Preencha todos os campos",
              MainFrame.TITLE, JOptionPane.INFORMATION_MESSAGE);
        }
      }

      private List<Alternative> getListAlternative(Alternative alternative,
          Alternative alternative1,
          Alternative alternative2) {
        List<Alternative> alternatives = new ArrayList<>();
        alternatives.add(alternative);
        alternatives.add(alternative1);
        alternatives.add(alternative2);
        return alternatives;
      }
    });
    setSaveBtn(saveBtn);
  }

  private boolean validateQuestionText() {
    Validation validator = new ValidateTextArea();
    return validator.validate(getQuestionTxt());
  }

  private boolean validateAlternatives() {
    Validation validator = new ValidateText();
    boolean aIsValid = validator.validate(textFieldA);
    boolean bIsValid = validator.validate(textFieldB);
    boolean cIsValid = validator.validate(textFieldC);
    return aIsValid && bIsValid && cIsValid;
  }
}
