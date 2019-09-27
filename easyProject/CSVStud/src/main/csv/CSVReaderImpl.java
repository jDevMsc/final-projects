package main.csv;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import main.service.Question;

public class CSVReaderImpl implements ICSVReader {

  private String filePath;


  public void setFilePath(String filePath) {
    this.filePath = filePath;
  }

  public CSVReaderImpl(){}

  public CSVReaderImpl(String filePath){
    this.filePath = filePath;
  }

  public List<Question> getQuestions() {
    List<Question> result = new ArrayList<>();
    File file = new File("C:\\projects\\Practise\\CSVStud\\src\\main\\resource\\question.csv");

    try {
      BufferedReader br = new BufferedReader(new FileReader(file));
      String str;
      while((str = br.readLine()) != null ) {
        String[] answers = str.split(";");
        result.add(new Question(answers[0], answers[1]));
      }
      br.close();
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    }
    return result;
  }
}
