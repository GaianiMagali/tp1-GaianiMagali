package ar.edu.unahur.obj2;

import Demonios.DemonioFuego;
import Demonios.DemonioHielo;
import Demonios.DemonioSombra;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.testng.AssertJUnit.assertEquals;

public class TestAlma {
    Alma alma1;
    Alma alma2;
    Alma alma3;

    CruzRoja cruzRoja;
    LuchaMarcial luchaMarcial;
    SupervivenciaExtrema supervivenciaExtrema;

    DemonioFuego demonioFuego;
    DemonioHielo demonioHielo;
    DemonioSombra demonioSombra;


    Lugar lugar1;

    @BeforeMethod
    public void setUp() {
        alma1 = new Alma(10,10,false);
        alma2 = new Alma(40,40,true);
        alma3 = new Alma(20,10,true);

        cruzRoja = new CruzRoja(alma1);
        luchaMarcial = new LuchaMarcial(alma2);
        supervivenciaExtrema = new SupervivenciaExtrema(alma3);

        demonioFuego = new DemonioFuego(30);
        demonioHielo = new DemonioHielo(50);
        demonioSombra = new DemonioSombra(80);

        lugar1 = new Lugar("Espanto");

    }

    @Test
    public void testTecnicaCruzRoja() {
        assertEquals(cruzRoja.getNivelBondad(),100);

        //No puede ser cazada por demonio porque la tecnica le aumanto la bondad
        lugar1.agregarAlmas(cruzRoja);
        demonioFuego.cazarAlmas(lugar1);

        List<Alma> almasRecolectadas= new ArrayList<>();
        assertEquals(demonioFuego.getAlmasCazadas(),almasRecolectadas);
    }

    @Test
    public void testTecnicaLuchaMarcial() {
        assertEquals(luchaMarcial.getNivelValor(),80);

        //No puede cazarla porque su valor es mayor a 50 gracias a la tecnica
        lugar1.agregarAlmas(luchaMarcial);
        demonioSombra.cazarAlmas(lugar1);

        List<Alma> almasRecolectadas1= new ArrayList<>() ;
        assertEquals(demonioSombra.getAlmasCazadas(),almasRecolectadas1);
    }

    @Test
    public void testTecnicaSupervivenciaExtrema() {
        assertEquals(supervivenciaExtrema.isFriolenta(),false);

        //Puede ser cazada porque el valor no es condicion
        lugar1.agregarAlmas(supervivenciaExtrema);
        demonioHielo.cazarAlmas(lugar1);

        //No puede cazarla porque dejo de ser friolenta gracias a la tecnica
        List<Alma> almasRecolectadas2=  new ArrayList<>() ;
        assertEquals(demonioHielo.getAlmasCazadas(),almasRecolectadas2);
    }

    @Test
    public void testAlmaConMasDeUnaTecnica() {
        cruzRoja = new CruzRoja(alma1);
        luchaMarcial = new LuchaMarcial(alma1);

        lugar1.agregarAlmas(luchaMarcial);
        lugar1.agregarAlmas(cruzRoja);

        demonioFuego.cazarAlmas(lugar1);
        List<Alma> almasRecolectadas= Stream.of(luchaMarcial).collect(Collectors.toList());
        assertEquals(demonioFuego.getAlmasCazadas(),almasRecolectadas);


        demonioSombra.cazarAlmas(lugar1);
        List<Alma> almasRecolectadas1= new ArrayList<>();
        assertEquals(demonioSombra.getAlmasCazadas(),almasRecolectadas1);


        demonioHielo.cazarAlmas(lugar1);
        List<Alma> almasRecolectadas2=  new ArrayList<>();
        assertEquals(demonioHielo.getAlmasCazadas(),almasRecolectadas2);

    }
}
