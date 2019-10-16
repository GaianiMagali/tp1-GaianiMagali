package Demonios;

import ar.edu.unahur.obj2.Alma;


public class DemonioHielo extends Demonio {

    public DemonioHielo(int nivelMaldad) {
        super(nivelMaldad);
    }

    @Override
    public boolean cazar(Alma alma) {
        return alma.isFriolenta();
    }

    @Override
    public void atormentarSegunDemonio(Alma alma) {
        alma.setFriolenta(true);
    }


}
