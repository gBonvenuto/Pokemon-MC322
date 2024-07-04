import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Savetxt{
    private String acao;
    private String jogador;
    private LocalTime horario;

    Savetxt(String jogador, String acao){
        this.jogador = jogador;
        this.acao = acao;
        horario = LocalTime.now();
    }
    
    public String getAcao(){
        return acao;
    }

    public String getJogador(){
        return jogador;
    }

    public String getHorario(){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        String formattedTime = horario.format(formatter);
        return formattedTime;
    }

    public String toString(){
        String out = "";
        out += "Jogador "+getJogador()+" realizou "+getAcao()+" as ["+getHorario()+"].";
        return out;
    }
}