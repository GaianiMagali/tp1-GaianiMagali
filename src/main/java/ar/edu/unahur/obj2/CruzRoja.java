package ar.edu.unahur.obj2;

public class CruzRoja extends Entrenamiento {
    private Alma alma;

    public CruzRoja(Alma alma) {
        super(alma);
    }


    @Override
    public int getNivelBondad() {
        return 100;
    }

    @Override
    public String toString() {
        return "CruzRoja{}";
    }
}


