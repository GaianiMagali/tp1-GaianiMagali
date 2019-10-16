package ar.edu.unahur.obj2;

import Demonios.Demonio;
import ar.edu.unahur.obj2.diabolico.alma.proteccion.Proteccion;

import java.util.List;
import java.util.Objects;

public class Alma{
    private int nivelBondad;
    private int nivelValor;
    private boolean friolenta;
    private Proteccion proteccion;

    public Alma(){};


    public Alma(int nivelBondad, int nivelValor, boolean friolenta,Proteccion proteccion) {
        this.nivelBondad = nivelBondad;
        this.nivelValor = nivelValor;
        this.friolenta = friolenta;
        this.proteccion = proteccion;
    }


    public Proteccion getProteccion() {
        return proteccion;
    }

    public void setProteccion(Proteccion proteccion) {
        this.proteccion = proteccion;
    }

    public boolean estaProtegida(Demonio demonio){
        return proteccion.estaProtegido(demonio.getNivelMaldad(),demonio.cantidadAlmasCazadas());
    }


    public void setNivelBondad(int nivelBondad) {
        this.nivelBondad = nivelBondad;
    }

    public void setNivelValor(int nivelValor) {
        this.nivelValor = nivelValor;
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
