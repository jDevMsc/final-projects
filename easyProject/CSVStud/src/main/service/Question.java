package main.service;

public class Question {
  private String answer;
  private String question;

  public Question(String question, String answer) {
    this.answer = answer;
    this.question = question;
  }

  public String getAnswer() {
    return answer;
  }

  public void setAnswer(String answer) {
    this.answer = answer;
  }

  public String getQuestion() {
    return question;
  }

  public void setQuestion(String question) {
    this.question = question;
  }
}
