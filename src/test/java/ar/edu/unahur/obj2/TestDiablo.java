package ar.edu.unahur.obj2;

import Demonios.Demonio;
import Demonios.DemonioFuego;
import Demonios.DemonioHielo;
import Demonios.DemonioSombra;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.testng.AssertJUnit.assertEquals;


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

    @BeforeMethod
    public void setUp() {

        demonioFuego = new DemonioFuego(30);
        demonioHielo = new DemonioHielo(20);
        demonioSombra = new DemonioSombra(40);

        List<Demonio> demonios = Stream.of(demonioFuego,demonioHielo,demonioSombra).collect(Collectors.toList());
        diablo = new Diablo(demonios);


        alma1 = new Alma(10,10,false);
        alma2 = new Alma(40,40,true);
        alma3 = new Alma(7,20,false);
        alma4 = new Alma(20,10,true);
        alma5 = new Alma(8,30,true);
        alma6 = new Alma(6,10,true);

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
        assertEquals(diablo.entrenar(Tecnica.cruzRoja,alma1),alma1);
        assertEquals(diablo.entrenar(Tecnica.luchaMarcial,alma2),alma2);
    }

    //Parte 3

    @Test
    public void testAlmasCazadas() {
        List<Alma> almasRecolectadas= Stream.of(alma1,alma3,alma2,alma4,alma5,alma6).collect(Collectors.toList());

        assertEquals(diablo.almas(),almasRecolectadas);
    }

    @Test
    public void testAlmaMasValiente() {
        assertEquals(diablo.almaMasValiente(),alma2);
    }

    @Test
    public void testDemonioConMasAlmasCazadas() {
        assertEquals(diablo.almaQueMasCazo(),demonioSombra);
    }

    @Test
    public void testCazarAlmaDemonioDeFuego() {
        List<Alma> almasRecolectadas= Stream.of(alma1,alma3).collect(Collectors.toList());
        assertEquals(demonioFuego.getAlmasCazadas(),almasRecolectadas);
    }

    @Test
    public void testCazarAlmaDemonioDeHielo() {
        List<Alma> almasRecolectadas1 = new ArrayList<>();
        assertEquals(demonioHielo.getAlmasCazadas(),almasRecolectadas1);
    }

    @Test
    public void testCazarAlmaDemonioDeSombra() {
        List<Alma> almasRecolectadas2 = Stream.of(alma2,alma4,alma5,alma6).collect(Collectors.toList());
        assertEquals(demonioSombra.getAlmasCazadas(),almasRecolectadas2);
    }








}
