package Demonios;

import ar.edu.unahur.obj2.Alma;

public class DemonioFuego extends Demonio{

    public DemonioFuego(int nivelMaldad) {
        super(nivelMaldad);
    }

    @Override
    public boolean cazar(Alma alma) {
        return ! alma.isFriolenta();
    }

    @Override
    public void atormentarSegunDemonio(Alma alma) {
        alma.setFriolenta(false);
    }

}
