package be.services;

import be.domain.base.Question;
import java.util.ArrayList;
import java.util.List;

public class QuestionService {

  private static int index = 0;
  private static List<Question> questions = new ArrayList<>();

  public static void createQuestion(Question question) {
    question.setId(++index);
    questions.add(question);
  }

  public static List<Question> getQuestions() {
    return questions;
  }

  public static void updateQuestion(Question question) {
    int index = questions.indexOf(question);
    if (index >= 0) {
      questions.set(index, question);
    }
  }

  public static void deleteQuestion(Question question) {
    questions.removeIf(x -> x.getId().equals(question.getId()));
    System.out.println("Questão removida , Id = " + question.getId());
  }
}