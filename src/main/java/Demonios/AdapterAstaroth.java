package Demonios;

import ar.edu.unahur.obj2.Alma;
import ar.edu.unahur.obj2.diabolico.demonio.Astaroth;

public class AdapterAstaroth extends Demonio{
    private Astaroth astaroth;

    public AdapterAstaroth(int nivelMaldad, Astaroth astaroth) {
        super(nivelMaldad);
        this.astaroth = astaroth;
    }

    @Override
    public boolean cazar(Alma alma) {
       return astaroth.elegirPresa(alma.getNivelBondad(),alma.getNivelValor());
    }

    @Override
    public void atormentarSegunDemonio(Alma alma) {
        astaroth.nivelDeValorAQuitar(alma.getNivelBondad(),alma.getNivelValor());

    }
}
