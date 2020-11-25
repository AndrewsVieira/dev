package be.domain;

import be.domain.base.Question;
import be.domain.base.TypeQuestion;
import be.services.QuestionService;

public class DiscursiveQuestion extends Question {

  public DiscursiveQuestion(String question) {
    super(question);
  }

  @Override
  public String createQuestion() {
    this.setTypeQuestion(TypeQuestion.DISCURSIVE);
    QuestionService.createQuestion(this);
    System.out.println("Questão discursiva criada com sucesso!");
    return "Questão discursiva criada com sucesso!";
  }
}
