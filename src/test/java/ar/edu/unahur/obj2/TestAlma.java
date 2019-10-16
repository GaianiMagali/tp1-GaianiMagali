package ar.edu.unahur.obj2;

import Demonios.DemonioFuego;
import Demonios.DemonioHielo;
import Demonios.DemonioSombra;
import ar.edu.unahur.obj2.diabolico.alma.proteccion.AnilloDePoder;
import ar.edu.unahur.obj2.diabolico.alma.proteccion.LuzBlanca;
import ar.edu.unahur.obj2.diabolico.alma.proteccion.LuzNegra;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertTrue;

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

    LuzBlanca luzBlanca;
    LuzNegra luzNegra;



    Lugar lugar1;

    @BeforeMethod
    public void setUp() {
        luzBlanca = new LuzBlanca();
        luzNegra = new LuzNegra();


        alma1 = new Alma(10,10,false, luzBlanca);
        alma2 = new Alma(40,40,true,luzNegra);
        alma3 = new Alma(20,10,true,luzNegra);

        cruzRoja = new CruzRoja(alma1);
        luchaMarcial = new LuchaMarcial(alma2);
        supervivenciaExtrema = new SupervivenciaExtrema(alma3);

        demonioFuego = new DemonioFuego(30);
        demonioHielo = new DemonioHielo(50);
        demonioSombra = new DemonioSombra(80);

        lugar1 = new Lugar("Espanto");

    }

    @Test
    public void almaEstaProtegida() {
        lugar1.agregarAlmas(alma1);
        demonioFuego.cazarAlmas(lugar1);

        List<Alma> almascazadas= new ArrayList<>();
        assertEquals(demonioFuego.getAlmasCazadas(),almascazadas);


        alma1.setProteccion(luzNegra);
        List<Alma> almascazadas1= new ArrayList<>();
        assertEquals(demonioFuego.getAlmasCazadas(),almascazadas1);

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
        cruzRoja = new CruzRoja(alma2);
        luchaMarcial = new LuchaMarcial(alma2);

        lugar1.agregarAlmas(luchaMarcial);
        lugar1.agregarAlmas(cruzRoja);

        demonioFuego.cazarAlmas(lugar1);
        List<Alma> almasRecolectadas1= new ArrayList<>();
        //List<Alma> almasRecolectadas= Stream.of(luchaMarcial).collect(Collectors.toList());
        assertEquals(demonioFuego.getAlmasCazadas(),almasRecolectadas1);


        demonioSombra.cazarAlmas(lugar1);
        List<Alma> almasRecolectadas2= new ArrayList<>();
        assertEquals(demonioSombra.getAlmasCazadas(),almasRecolectadas2);

    }
}
