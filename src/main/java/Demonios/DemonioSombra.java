package Demonios;

import ar.edu.unahur.obj2.Alma;

public class DemonioSombra extends Demonio {

    public DemonioSombra(int nivelMaldad) {
        super(nivelMaldad);
    }

    @Override
    public boolean cazar(Alma alma) {
        return alma.getNivelValor() < 50;
    }

    @Override
    public void atormentarSegunDemonio(Alma alma) {
        alma.reducirValor(alma.getNivelValor() / 2);
    }

}
