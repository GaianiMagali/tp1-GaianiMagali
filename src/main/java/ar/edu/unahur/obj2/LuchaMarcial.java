package ar.edu.unahur.obj2;

public class LuchaMarcial extends Entrenamiento{

    public LuchaMarcial(Alma alma) {
        super(alma);
    }

    public int getNivelValor() {
        return super.getNivelValor() * 2;
    }


    @Override
    public boolean isFriolenta() {
        return super.isFriolenta();
    }

    @Override
    public int getNivelBondad() {
        return super.getNivelBondad();
    }

    @Override
    public String toString() {
        return "LuchaMarcial{}";
    }
}
