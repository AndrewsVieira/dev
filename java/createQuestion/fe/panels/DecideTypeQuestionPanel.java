package fe.panels;

import fe.MainFrame;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;

public class DecideTypeQuestionPanel extends JPanel {

  private MainFrame frame;

  public DecideTypeQuestionPanel(MainFrame mainFrame) {
    this.frame = mainFrame;
    setMinimumSize(new Dimension(1200, 800));
    init();
  }

  private void init() {

    setLayout(new BorderLayout());

    JPanel panel;
    JPanel panelbt;
    JButton btnCreaterQuestions;
    JButton btnReadQuestions;

    panel = new JPanel();
    panel.setBackground(new Color(118, 206, 166));
    panel.setPreferredSize(new Dimension(200, 150));
    add(panel, BorderLayout.NORTH);

    panel = new JPanel();
    panel.setBackground(new Color(118, 206, 166));
    panel.setPreferredSize(new Dimension(200, 150));
    add(panel, BorderLayout.SOUTH);

    panel = new JPanel();
    panel.setBackground(new Color(118, 206, 166));
    panel.setPreferredSize(new Dimension(350, 100));
    panel.setLayout(new FlowLayout());

    add(panel, BorderLayout.WEST);
    panel = new JPanel();
    panel.setBackground(new Color(118, 206, 166));
    panel.setPreferredSize(new Dimension(250, 100));
    panel.setLayout(new FlowLayout());
    add(panel, BorderLayout.EAST);

    panelbt = new JPanel();
    panel.setPreferredSize(new Dimension(350, 40));
    panelbt.setLayout(new GridLayout(4, 1, 5, 10));
    panelbt.setBackground(new Color(118, 206, 166));

    btnCreaterQuestions = new JButton("Questão Discursiva");
    btnCreaterQuestions.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent arg0) {
        frame.showForm(null, MainFrame.INDEX_DISCURSIVE);
      }
    });
    btnCreaterQuestions.setFont(new Font("Comic Neue", 1, 24));
    btnCreaterQuestions.setForeground(new Color(255, 255, 255));
    btnCreaterQuestions.setBackground(new Color(4, 141, 95));
    btnCreaterQuestions.setRolloverEnabled(false);
    panelbt.add(btnCreaterQuestions);

    btnReadQuestions = new JButton("Questão Objetiva");
    btnReadQuestions.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent actionEvent) {
        if (actionEvent.getActionCommand().equals("Questão Objetiva")) {
          frame.showForm(null, MainFrame.INDEX_OBJECTIVE);
        }
      }
    });
    btnReadQuestions.setFont(new Font("Comic Neue", 1, 24));
    btnReadQuestions.setForeground(new Color(4, 141, 95));
    btnReadQuestions.setBackground(Color.WHITE);
    btnReadQuestions.setRolloverEnabled(false);
    panelbt.add(btnReadQuestions);
    add(panelbt, BorderLayout.CENTER);
  }
}
