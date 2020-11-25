package fe.panels;

import be.domain.base.Question;
import be.domain.base.TypeQuestion;
import be.services.QuestionService;
import fe.MainFrame;
import fe.QuestionTableModel;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class QuestionTablePanel extends JPanel {

  MainFrame frame;
  QuestionTableModel tableModel;

  private JButton btnCreate;
  private JButton btnChange;
  private JButton btnRemove;
  private JButton btnInit;

  private JTable tableQuestions;

  public QuestionTablePanel(MainFrame frame) {
    this.frame = frame;

    setLayout(new BorderLayout(10, 10));
    setBackground(new Color(118, 206, 166));

    createBtns();
    createTable();
  }

  public void reload() {
    tableModel.load(QuestionService.getQuestions());
  }

  private void createTable() {
    tableModel = new QuestionTableModel(QuestionService.getQuestions());
    tableQuestions = new JTable(tableModel);
    tableQuestions.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    tableQuestions.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
      @Override
      public void valueChanged(ListSelectionEvent event) {
        if (!event.getValueIsAdjusting()) {
          if (tableQuestions.getSelectedRow() >= 0) {
            ablebtns();
          } else {
            disableBtns();
          }
        }
      }

    });
    JScrollPane scroll = new JScrollPane(tableQuestions);

    add(scroll, BorderLayout.CENTER);
  }

  private void createBtns() {
    JPanel panelBtn = new JPanel();
    panelBtn.setBackground(new Color(118, 206, 166));
    FlowLayout layout = (FlowLayout) panelBtn.getLayout();
    layout.setAlignment(FlowLayout.RIGHT);

    btnInit = new JButton("Inicio");
    btnInit.setForeground(new Color(255, 255, 255));
    btnInit.setBackground(new Color(4, 141, 95));

    btnInit.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent event) {
        frame.showHomePanel();
      }
    });

    panelBtn.add(btnInit);

    btnCreate = new JButton("Adicionar");
    btnCreate.setForeground(new Color(255, 255, 255));
    btnCreate.setBackground(new Color(4, 141, 95));

    btnCreate.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent event) {
        frame.showQuestionDecisivePanel();
      }
    });

    panelBtn.add(btnCreate);

    btnChange = new JButton("Alterar");
    btnChange.setForeground(new Color(255, 255, 255));
    btnChange.setBackground(new Color(4, 141, 95));

    panelBtn.add(btnChange);

    btnChange.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent event) {

        if (tableModel.getQuestion(tableQuestions.getSelectedRow()).getTypeQuestion()
            .equals(TypeQuestion.OBJECTIVE)) {
          frame.showForm(tableModel.getQuestion(tableQuestions.getSelectedRow()),
              MainFrame.INDEX_OBJECTIVE);

        } else {
          frame.showForm(tableModel.getQuestion(tableQuestions.getSelectedRow()),
              MainFrame.INDEX_DISCURSIVE);
        }
      }
    });

    panelBtn.add(btnChange);

    btnRemove = new JButton("Remover");

    btnRemove.setForeground(new Color(255, 255, 255));
    btnRemove.setBackground(new Color(4, 141, 95));

    btnRemove.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent arg0) {
        Question quest = tableModel.getQuestion(tableQuestions.getSelectedRow());
        int answer = JOptionPane
            .showConfirmDialog(QuestionTablePanel.this, "Você deseja remover essa tarefa ?",
                MainFrame.TITLE, JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
        if (answer == JOptionPane.YES_OPTION) {
          QuestionService.deleteQuestion(quest);
          tableModel.delete(quest);
        }
      }
    });
    disableBtns();
    panelBtn.add(btnRemove);

    add(panelBtn, BorderLayout.NORTH);

  }

  private void disableBtns() {
    btnChange.setEnabled(false);
    btnRemove.setEnabled(false);
  }

  private void ablebtns() {
    btnChange.setEnabled(true);
    btnRemove.setEnabled(true);
  }
}
