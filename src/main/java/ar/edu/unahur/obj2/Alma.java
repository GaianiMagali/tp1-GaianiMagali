package ar.edu.unahur.obj2;

public class Alma{
    private int nivelBondad;
    private int nivelValor;
    private boolean friolenta;

    public Alma(){};


    public Alma(int nivelBondad, int nivelValor, boolean friolenta) {
        this.nivelBondad = nivelBondad;
        this.nivelValor = nivelValor;
        this.friolenta = friolenta;
    }

    public void setNivelBondad(int nivelBondad) {
        this.nivelBondad = nivelBondad;
    }

    public int getNivelBondad() {
        return nivelBondad;
    }

    public int getNivelValor() {
        return nivelValor;
    }

    public void setFriolenta(boolean friolenta) {
        this.friolenta = friolenta;
    }

    public boolean isFriolenta() {
        return friolenta;
    }

    public void serAtormentada(int bondad){
        nivelBondad -= bondad;
    }

    public void reducirValor(int valor){
        this.nivelValor = valor;
    }

    @Override
    public String toString() {
        return "Alma{" +
                "nivelBondad=" + nivelBondad +
                ", nivelValor=" + nivelValor +
                ", friolenta=" + friolenta +
                '}';
    }
}
