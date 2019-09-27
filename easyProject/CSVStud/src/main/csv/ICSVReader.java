package main.csv;

import java.util.List;
import main.service.Question;

public interface ICSVReader {
  public List<Question> getQuestions();
}
