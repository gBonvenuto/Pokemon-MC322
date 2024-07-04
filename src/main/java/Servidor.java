// O servidor começou a ser trabalhado mas decidimos terminá-lo na parte 2
//
// Mas nenhuma lógica será implementada nele, ele somente repassará mensagens
// do estado atual do jogo entre os clientes. Toda a lógica de jogo será
// implementada em cada cliente.
//
// Por mais que essa implementação não seja a ideal no mundo real, preferimos
// fazê-la assim para que o Jogo seja inteiramente escrito em Java com as
// qualidades de uma Programação Orientada a Objeto sem criar um projeo à parte

import java.net.*;

import java.io.*;

// Essa classe somente lida com a conexão ao servidor, o servidor em si será
// criado em python e somente repassará as mensagens entre os clientes
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
    }
    try {
      out = new PrintWriter(clientSocket.getOutputStream(), true);
    } catch (Exception e) {
    }
    try {
      in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
    } catch (Exception e) {
    }
  }

  public String sendMessage(String msg){
    out.println(msg);
    String resp = "";
    try {
      resp = in.readLine();
    } catch (Exception e) {
      // Será implementado na parte 2
    }
    return resp;
  }

  public void stopConnection(){
    try{
    in.close();
    out.close();
    clientSocket.close();
    }
    catch(Exception e){
      // Será implementado na parte 2
    }
  }

}
