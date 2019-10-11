package ar.edu.unahur.obj2;

public abstract class Entrenamiento extends Alma{
    public Alma alma;


    public Entrenamiento(Alma alma) {
        this.alma = alma;
    }


    @Override
    public int getNivelValor() {
        return alma.getNivelValor() ;
    }

    @Override
    public boolean isFriolenta() {
        return alma.isFriolenta();
    }

    @Override
    public int getNivelBondad() {
        return alma.getNivelBondad();
    }


}
