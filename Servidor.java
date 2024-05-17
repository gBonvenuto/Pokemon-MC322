import java.net.*;

import java.io.*;

class Servidor{

  private String ip;
  private int port;

  private Socket clientSocket;
  private PrintWriter out;
  private BufferedReader in;


  public void conectar(String ip, int port){
    this.ip = ip;
    this.port = port;
    try {
      clientSocket = new Socket(ip, port);
    } catch (Exception e) {
      // TODO: handle exception
      System.err.println("");
    }
    try {
      out = new PrintWriter(clientSocket.getOutputStream(), true);
    } catch (Exception e) {
      // TODO: handle exception
    }
    try {
      in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
    } catch (Exception e) {
      // TODO: handle exception
    }
  }

  public String sendMessage(String msg){
    out.println(msg);
    String resp = in.readLine();
    return resp;
  }

  public void stopConnection(){
    in.close();
    out.close();
    clientSocket.close();
  }

}
