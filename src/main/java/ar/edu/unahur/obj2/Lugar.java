package ar.edu.unahur.obj2;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Lugar {
    private String nombre;
    protected List<Alma> almas = new ArrayList();

    public Lugar(String nombre) {
        this.nombre = nombre;
        this.almas = almas;
    }

    public void agregarAlmas(Alma alma) {

        almas.add(alma);
    }

    public String getNombre() {
        return nombre;
    }

    public List<Alma> getAlmas() {
        return almas;
    }

    public void remove(Alma alma) {
        almas.remove(alma);
    }

    @Override
    public String toString() {
        return "Lugar{" +
                "nombre='" + nombre + '\'' +
                ", almas=" + almas +
                '}';
    }
}
