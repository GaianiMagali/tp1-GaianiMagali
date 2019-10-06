package Demonios;

import ar.edu.unahur.obj2.Alma;
import ar.edu.unahur.obj2.Lugar;

import java.util.List;

public class DemonioHielo extends Demonio {
    private Alma alma;

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

    @Override
    public String toString() {
        return "DemonioHielo{" +
                "alma=" + alma +
                '}';
    }
}
