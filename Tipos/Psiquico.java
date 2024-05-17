package Tipos;

import utils.Ataque;
import utils.Tipo;

public class Psiquico extends Tipo {
    
    public Psiquico(String img){
        super(img);
        super.setTipo("Psiquico");
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
