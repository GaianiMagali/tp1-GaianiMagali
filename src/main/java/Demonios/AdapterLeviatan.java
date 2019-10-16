package Demonios;

import ar.edu.unahur.obj2.Alma;
import ar.edu.unahur.obj2.diabolico.demonio.Leviatan;

public class AdapterLeviatan extends Demonio{
    private Leviatan leviatan;

    public AdapterLeviatan(int nivelMaldad, Leviatan leviatan) {
        super(nivelMaldad);
        this.leviatan = leviatan;
    }

    @Override
    public boolean cazar(Alma alma) {
       return leviatan.seleccionar(alma.getNivelValor());
    }

    @Override
    public void atormentarSegunDemonio(Alma alma) {

    }
}
