package tipos;

import utils.Ataque;
import utils.Tipo;

public class Dragao extends Tipo {
    
    public Dragao(String img){
        super(img);
        super.setTipo("Dragao");
    }

    public int defesa(Ataque golpe){
        if(golpe.getTipo().buscaFraqueza(golpe)){
            return 2*golpe.getDano();
        } else if (buscaImunidade(golpe)){
            return 0;
        } else if (buscaResistencia(golpe)){
            return (1/2) * golpe.getDano();
        }
        return golpe.getDano();
    }
}