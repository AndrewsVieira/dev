package fe;

import be.domain.base.Question;
import be.domain.base.TypeQuestion;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class QuestionTableModel extends AbstractTableModel {

  private List<Question> questions = new ArrayList<>();
  private String[] columns = new String[]{"Id", "Questão", "Tipo"};

  public QuestionTableModel(List<Question> list) {
    this.questions = list;
  }

  @Override
  public String getColumnName(int column) {
    String columnName = null;
    if (column >= 0 && column <= columns.length) {
      columnName = columns[column];
    }
    return columnName;
  }

  @Override
  public int getRowCount() {
    return questions.size();
  }

  @Override
  public int getColumnCount() {
    return columns.length;
  }

  @Override
  public Object getValueAt(int rowIndex, int colIndex) {
    String value = null;
    if (rowIndex >= 0 && rowIndex <= questions.size()) {
      Question question = questions.get(rowIndex);
      switch (colIndex) {
        case 0:
          value = Integer.toString(question.getId());
          break;
        case 1:
          value = question.getQuestion();
          break;
        case 2:
          if (question.getTypeQuestion().equals(TypeQuestion.DISCURSIVE)) {
            value = "Discursiva";
          } else {
            value = "Objetiva";
          }
          break;
        default:
          System.err.printf("[ERRO] Índice de coluna inválido: %d\n", colIndex);
          break;
      }
    }
    return value;
  }

  public void load(List<Question> questions) {
    this.questions = questions;
    fireTableDataChanged();
  }

  public Question getQuestion(int rowIndex) {
    return questions.get(rowIndex);
  }

  public void delete(Question quest) {
    questions.remove(quest);
    fireTableDataChanged();
  }
}
