package be.domain;

import be.domain.base.Question;
import be.domain.base.TypeQuestion;
import be.services.QuestionService;
import java.util.List;

public class ObjectiveQuestion extends Question {

  private List<Alternative> alternativeList;

  public ObjectiveQuestion(String question, List<Alternative> listAlternatives) {
    super(question);
    this.alternativeList = listAlternatives;
  }

  @Override
  public String createQuestion() {
    this.setTypeQuestion(TypeQuestion.OBJECTIVE);
    QuestionService.createQuestion(this);
    System.out.println("Questão objetiva criada com sucesso!");
    return "Questão criada com sucesso";
  }

  public List<Alternative> getAlternativeList() {
    return alternativeList;
  }

  public void setAlternativeList(List<Alternative> alternativeList) {
    this.alternativeList = alternativeList;
  }
}
