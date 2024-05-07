
import java.util.ArrayList;

public class Tipo {

    private String img;
    private String descricao;
    private String resposta;
    ArrayList<Tipo> imunidade;
    ArrayList<Tipo> fraqueza;
    ArrayList<Tipo> resistencia;

    public Tipo (String img, String descricao, String resposta){
        this.img = img;
        this.descricao = descricao;
        this.resposta = resposta;
        imunidade = new ArrayList<Tipo>();
        fraqueza = new ArrayList<Tipo>();
        resistencia = new ArrayList<Tipo>();
    }

    public String getImg(){
        return img;
    }

    public String getDescricao(){
        return descricao;
    }

    public String getResposta(){
        return resposta;
    }

    public double defesa(Class ataque) {
        return ataque.defesa(ataque);
    }
}