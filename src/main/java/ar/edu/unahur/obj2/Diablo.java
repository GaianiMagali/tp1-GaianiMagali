package ar.edu.unahur.obj2;

import Demonios.Demonio;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Diablo{
    protected List<Demonio> demonios;


    public Diablo(List<Demonio> demonios) {
        this.demonios = demonios;
    }

    public Alma entrenar(Tecnica tecnica, Alma alma) {
        switch (tecnica){
            case luchaMarcial:
                new LuchaMarcial(alma);
                case cruzRoja:
                    new CruzRoja(alma);
            case supervivenciaExtrema:
                 new SupervivenciaExtrema(alma);
        }
        return alma;
    }

    public List<Alma> almas() {
        return demonios.stream()
                    .flatMap(demonio->
                        demonio.getAlmasCazadas().stream())
                    .collect( Collectors.toList());
    }

    public Alma almaMasValiente() {
        return almas().stream().max(Comparator.comparing(Alma::getNivelValor)).get();
    }

    public Demonio almaQueMasCazo(){
        return demonios.stream().max(Comparator.comparing(Demonio::cantidadAlmasCazadas)).get();
    }
    @Override
    public String toString() {
        return "Diablo{" +
                "demonios=" + demonios +
                '}';
    }
}
