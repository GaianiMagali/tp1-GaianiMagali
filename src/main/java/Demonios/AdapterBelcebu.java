package Demonios;

import ar.edu.unahur.obj2.Alma;
import ar.edu.unahur.obj2.diabolico.demonio.Belcebu;

public class AdapterBelcebu extends Demonio{
    private Belcebu balcebu;

    public AdapterBelcebu(int nivelMaldad, Belcebu balcebu) {
        super(nivelMaldad);
        this.balcebu = balcebu;
    }

    @Override
    public boolean cazar(Alma alma) {
        try {
            balcebu.puedeCazarla(alma.getNivelBondad());
            return true;
        } catch (Exception exception){
            return false;
        }


    }

    @Override
    public void atormentarSegunDemonio(Alma alma) {
        balcebu.incrementoDeMaldad(alma.getNivelBondad());
    }
}
