import java.net.*;

import java.io.*;

class Servidor{

  private String ip;
  private int port;

  private Socket clientSocket;
  private PrintWriter out;
  private BufferReader in;


  public void conectar(String ip, int port){
    this.ip = ip;
    this.port = port;
    clientSocket = new Socket(ip, port);
    out = new PrintWriter(clientSocket.getOutputStream(), true);
    in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
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
