package Tipos;
import utils.Tipo;
import utils.Ataque;

public class Normal extends Tipo {    

    public Normal(String img){
        super(img);
        super.setTipo("Normal");
    }

    public int defesa(Tipo golpe){
        if(buscaFraqueza(golpe)){
            return 2*golpe.getDano();
        } else if (buscaImunidade(golpe)){
            return 0;
        } else if (buscaResistencia(golpe)){
            return (1/2) * golpe.getDano();
        }
        return golpe.getDano();
    }
}
