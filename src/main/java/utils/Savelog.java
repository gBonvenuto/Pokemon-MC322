package utils;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.LocalTime;

public class Savelog {
  private static File path; // encontra o path para o arquivo de logs

  public static void setPath(File caminho) {
    path = new File(
        caminho.getAbsolutePath() + File.separator + LocalDate.now() + "-" + LocalTime.now().getHour() + "-"
            + LocalTime.now().getMinute() + "-" + LocalTime.now().getSecond() + ".log");
  }

  public static File getPath() {
    return path;
  }

  public static void log(String str) {
    try {
      PrintWriter writer = new PrintWriter(new FileOutputStream(path, true));
      writer.append(str+"\n");
      writer.close();
      System.out.println(str);
    } catch (Exception e) {
      System.err.println("Não foi posível enconrtar o arquivo");
      e.printStackTrace();
    }
  }

}
