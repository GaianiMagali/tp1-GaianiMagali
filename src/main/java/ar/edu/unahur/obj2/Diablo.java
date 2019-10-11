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
                return new LuchaMarcial(alma);
                case cruzRoja:
                   return new CruzRoja(alma);
            case supervivenciaExtrema:
                 return new SupervivenciaExtrema(alma);
            default: return null;
        }

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
