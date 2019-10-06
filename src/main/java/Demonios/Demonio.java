package Demonios;

import ar.edu.unahur.obj2.Alma;
import ar.edu.unahur.obj2.Lugar;

import java.util.ArrayList;
import java.util.List;

public abstract class Demonio {
    private int nivelMaldad;
    protected List<Alma> almasCazadas = new ArrayList<>();
    private List<Alma> almasAtormentadas = new ArrayList<>();


    public Demonio(int nivelMaldad) {
        this.nivelMaldad = nivelMaldad;
        this.almasCazadas = almasCazadas;
        this.almasAtormentadas = almasAtormentadas;
    }

    public abstract boolean cazar(Alma alma);

    public boolean nivelDeMaldadParaCazar(Alma alma){
        return this.getNivelMaldad() > alma.getNivelBondad();
    }

    public List<Alma> getAlmasCazadas() {
        return almasCazadas;
    }

    public int cantidadAlmasCazadas(){
        return getAlmasCazadas().size();
    }

    public int getNivelMaldad() {
        return nivelMaldad;
    }

    public void cazarAlma(Alma alma){
        almasCazadas.add(alma);
    }

    public void atormentarAlma(Alma alma){
        almasAtormentadas.add(alma);
    }

    public List<Alma> getAlmasAtormentadas() {
        return almasAtormentadas;
    }

    public void atormentar(Alma alma){
       alma.serAtormentada(5);
       atormentarSegunDemonio(alma);
    }

    public int cantidadAlmasAtormentadas(){
        return getAlmasAtormentadas().size();
    }

    public int dobleDeAlmasCazadas(){
        return getAlmasCazadas().size() * 2;
    }

    public abstract void atormentarSegunDemonio(Alma alma);

    public void cazarAlmas(Lugar lugar){
        List<Alma> almaRecolectadas = new ArrayList();
        almaRecolectadas.addAll(lugar.getAlmas());

        almaRecolectadas.forEach(alma -> {
        if (nivelDeMaldadParaCazar(alma) && cazar(alma)) {
            cazarAlma(alma);
            lugar.remove(alma);
        } else {
            atormentar(alma);
            atormentarAlma(alma);
        }
    });
        nivelMaldad += cantidadAlmasAtormentadas() + dobleDeAlmasCazadas();
    }

    @Override
    public String toString() {
        return "Demonio{" +
                "nivelMaldad=" + nivelMaldad +
                ", almasCazadas=" + almasCazadas +
                ", almasAtormentadas=" + almasAtormentadas +
                '}';
    }
}