package utils;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.time.LocalDate;

public class Savelog {
  private static File path;

  public static void setPath(File caminho){
    path = new File(caminho.getAbsolutePath()+File.separator+LocalDate.now().toString()+".log");
  }

  public static File getPath(){
    return path;
  }

  public static void log(String str) {
    try {
      BufferedWriter writer = new BufferedWriter(new FileWriter(path));
      writer.append(str);
      writer.newLine();
      writer.close();
      System.out.println(str);
    } catch (Exception e) {
      System.err.println("Não foi posível enconrtar o arquivo");
      e.printStackTrace();
    }
  }

}
