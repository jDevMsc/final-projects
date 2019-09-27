package main;

import java.io.IOException;
import main.csv.CSVReaderImpl;
import main.csv.ICSVReader;
import main.service.Test;

public class Main {

  public static void main(String[] args) throws IOException {
    ICSVReader reader = new CSVReaderImpl();
    Test test = new Test(reader);
    test.startTest();
  }

}
