package ar.edu.unahur.obj2;

public abstract class Entrenamiento extends Alma{
    private Alma alma;


    public Entrenamiento(Alma alma) {
        this.alma = alma;
    }

    public Alma getAlma() {
        return alma;
    }

    @Override
    public void setNivelBondad(int nivelBondad) {
        alma.setNivelBondad(nivelBondad);
    }

    @Override
    public void setFriolenta(boolean friolenta) {
        super.setFriolenta(friolenta);
    }

    @Override
    public void setNivelValor(int nivelValor) {
        super.setNivelValor(nivelValor);
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
