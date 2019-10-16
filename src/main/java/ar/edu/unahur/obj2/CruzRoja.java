package ar.edu.unahur.obj2;

public class CruzRoja extends Entrenamiento {

    public CruzRoja(Alma alma) {
        super(alma);
        setNivelBondad(getAlma().getNivelBondad());
    }

    @Override
    public int getNivelBondad() {
        return Math.max(super.getNivelBondad(),100);
    }


}


