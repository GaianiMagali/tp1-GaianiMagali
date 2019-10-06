package Demonios;

import ar.edu.unahur.obj2.Alma;
import ar.edu.unahur.obj2.Lugar;

import java.util.ArrayList;
import java.util.List;

public class DemonioFuego extends Demonio{
    private Alma alma;

    public DemonioFuego(int nivelMaldad) {
        super(nivelMaldad);
        this.alma = alma;
    }

    @Override
    public boolean cazar(Alma alma) {
        return ! alma.isFriolenta();
    }

    @Override
    public List<Alma> getAlmasCazadas() {
        return super.getAlmasCazadas();
    }

    @Override
    public void atormentarSegunDemonio(Alma alma) {
        alma.setFriolenta(false);
    }


    @Override
    public String toString() {
        return "DemonioFuego{" +
                "alma=" + alma +
                '}';
    }
}
