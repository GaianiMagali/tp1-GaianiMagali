package ar.edu.unahur.obj2;

public class LuchaMarcial extends Entrenamiento{

    public LuchaMarcial(Alma alma) {
        super(alma);
    }

    public int getNivelValor() {
        return getAlma().getNivelValor() * 2;
    }
}
