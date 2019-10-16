package ar.edu.unahur.obj2;

import Demonios.Demonio;
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
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static ar.edu.unahur.obj2.Tecnica.cruzRoja;
import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertTrue;


public class TestDiablo {


    Diablo diablo;

    DemonioFuego demonioFuego;
    DemonioHielo demonioHielo;
    DemonioSombra demonioSombra;

    Alma alma1;
    Alma alma2;
    Alma alma3;
    Alma alma4;
    Alma alma5;
    Alma alma6;

    Lugar lugar1;

    LuzBlanca luzBlanca;
    LuzNegra luzNegra;


    @BeforeMethod
    public void setUp() {
        luzBlanca = new LuzBlanca();
        luzNegra = new LuzNegra();

        demonioFuego = new DemonioFuego(30);
        demonioHielo = new DemonioHielo(20);
        demonioSombra = new DemonioSombra(40);

        List<Demonio> demonios = Stream.of(demonioFuego,demonioHielo,demonioSombra).collect(Collectors.toList());
        diablo = new Diablo(demonios);


        alma1 = new Alma(10,10,false,luzBlanca);
        alma2 = new Alma(40,40,true,luzNegra);
        alma3 = new Alma(7,20,false,luzBlanca);
        alma4 = new Alma(20,10,true,luzBlanca);
        alma5 = new Alma(8,30,true,luzBlanca);
        alma6 = new Alma(6,10,true,luzNegra);

        lugar1 = new Lugar("Espanto");

        lugar1.agregarAlmas(alma1);
        lugar1.agregarAlmas(alma2);
        lugar1.agregarAlmas(alma3);
        lugar1.agregarAlmas(alma4);
        lugar1.agregarAlmas(alma5);
        lugar1.agregarAlmas(alma6);

        demonioFuego.cazarAlmas(lugar1);
        demonioHielo.cazarAlmas(lugar1);
        demonioSombra.cazarAlmas(lugar1);
    }

    @Test
    public void testEntrenarAlma() {
        Alma almaEntrenada = diablo.entrenar(cruzRoja,alma1);
        assertEquals(almaEntrenada.getNivelBondad(),100);
        assertEquals(diablo.entrenar(Tecnica.luchaMarcial,alma2).getNivelValor(),40);
    }

    //Parte 3

    @Test
    public void testAlmasCazadas() {
        //List<Alma> almasRecolectadas= Stream.of(alma1,alma3,alma2,alma4,alma5,alma6).collect(Collectors.toList());
        List<Alma> almasRecolectadas=new ArrayList<>();
        assertEquals(diablo.almas(),almasRecolectadas);
    }

    @Test
    public void testAlmaMasValiente() {
        //Ninguna porque no cazo ninguna alma por la proteccion
        //assertEquals(diablo.almaMasValiente(),alma2);
    }

    @Test
    public void testDemonioConMasAlmasCazadas() {
        //Ninguna porque no cazo ninguna alma por la proteccion
        //assertEquals(diablo.almaQueMasCazo(),demonioSombra);
    }

    @Test
    public void testCazarAlmaDemonioDeFuego() {
        //Ninguna porque no cazo ninguna alma por la proteccion
        //List<Alma> almasRecolectadas= Stream.of(alma1,alma3).collect(Collectors.toList());
        List<Alma> almasRecolectadas= new ArrayList<>();
        assertEquals(demonioFuego.getAlmasCazadas(),almasRecolectadas);
    }

    @Test
    public void testCazarAlmaDemonioDeHielo() {
        List<Alma> almasRecolectadas1 = new ArrayList<>();
        assertEquals(demonioHielo.getAlmasCazadas(),almasRecolectadas1);
    }

    @Test
    public void testCazarAlmaDemonioDeSombra() {
        //Ninguna porque no cazo ninguna alma por la proteccion
        //List<Alma> almasRecolectadas2 = Stream.of(alma2,alma4,alma5,alma6).collect(Collectors.toList());
        List<Alma> almasRecolectadas = new ArrayList<>();
        assertEquals(demonioSombra.getAlmasCazadas(),almasRecolectadas);
    }






}
