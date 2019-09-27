package main.service;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;
import main.csv.ICSVReader;
import main.enity.Student;

public class Test {
  private ICSVReader reader;
  private int count;

  public Test(ICSVReader reader){
    this.reader = reader;
  }

  public void startTest() throws IOException {
    String firstName, secondName;
    File file = new File("C:\\projects\\Practise\\CSVStud\\src\\main\\resource\\answer.csv");
    BufferedWriter br = new BufferedWriter(new FileWriter(file,true));

    try(Scanner sc = new Scanner(System.in)) {
      List<Question> questions = reader.getQuestions();
      System.out.println("Напишите вашу фамилию!");
      secondName = sc.nextLine();
      System.out.println("Напишите ваше имя!");
      firstName = sc.nextLine();

      Student one = new Student(firstName,secondName);

      String name = secondName + " " + firstName;
      System.out.println( name+ " ответьте на вопросы!");
      for (Question question : questions) {
        System.out.println(question.getQuestion());
        if (sc.nextLine().equalsIgnoreCase(question.getAnswer())) {
          count++;
        }
      }
      if (count >= (questions.size() * 70) / 100) {
        System.out.println(name + " вы сдали тест!");
        one.setPass(true);
        br.write(one.getName() + " " + one.getPass());

      } else {
        System.out.println(name + " вы не сдали тест!");
        one.setPass(false);
        br.write(one.getName() + " " + one.getPass());

      }
    }catch (Exception ex){
      ex.printStackTrace();
    }finally {
      br.close();
    }
  }


}
