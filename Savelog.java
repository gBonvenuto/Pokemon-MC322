import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Savelog {
    private List<Savetxt> acoes;

    public Savelog(){
        acoes = new ArrayList<>();
    }

    public void logAcao(String tipoacao, String jogador) {
        Savetxt acao = new Savetxt(jogador, tipoacao);
        acoes.add(acao);
    }

    public void SalvaAcaoArquivo(String nomeArquivo){
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(nomeArquivo))){
            for (Savetxt acao : acoes){
                writer.write(acao.toString());
                writer.newLine();
            }
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    public List<Savetxt> getAcoes() {
        return acoes;
    }
}
