package ar.edu.unahur.obj2;


import Demonios.DemonioFuego;
import Demonios.DemonioHielo;
import Demonios.DemonioSombra;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.testng.AssertJUnit.assertEquals;

public class TestDemonios {
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
        demonioSombra = new DemonioSombra(10);

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

    }

    @Test
    public void testLugar() {
        List<Alma> almasDelLugar= Stream.of(alma1,alma2,alma3,alma4,alma5,alma6).collect(Collectors.toList());
        assertEquals(lugar1.getAlmas(),almasDelLugar);
    }

    @Test
    public void testCazarAlmaDemonioDeFuego() {
        List<Alma> almasRecolectadas= Stream.of(alma1,alma3).collect(Collectors.toList());
        demonioFuego.cazarAlmas(lugar1);
        assertEquals(demonioFuego.getAlmasCazadas(),almasRecolectadas);
    }

    @Test
    public void testCazarAlmaDemonioDeHielo() {
        List<Alma> almasRecolectadas1 = Stream.of(alma5,alma6).collect(Collectors.toList());
        demonioHielo.cazarAlmas(lugar1);
        assertEquals(demonioHielo.getAlmasCazadas(),almasRecolectadas1);
    }

    @Test
    public void testCazarAlmaDemonioDeSombra() {
            List<Alma> almasRecolectadas2 = Stream.of(alma3,alma5,alma6).collect(Collectors.toList());
            demonioSombra.cazarAlmas(lugar1);
            assertEquals(demonioSombra.getAlmasCazadas(),almasRecolectadas2);
    }

    @Test
    public void testAtormentarDemonioFuego() {
        demonioFuego.atormentar(alma2);
        assertEquals(alma2.getNivelBondad(),35);
        assertEquals(alma2.isFriolenta(), false);

        demonioFuego.atormentar(alma4);
        assertEquals(alma4.getNivelBondad(),15);
        assertEquals(alma4.isFriolenta(), false);

        demonioFuego.atormentar(alma5);
        assertEquals(alma5.getNivelBondad(),3);
        assertEquals(alma5.isFriolenta(), false);

        demonioFuego.atormentar(alma6);
        assertEquals(alma6.getNivelBondad(),1);
        assertEquals(alma6.isFriolenta(), false);
    }

    @Test
    public void testAtormentarDemonioHielo() {
        demonioHielo.atormentar(alma1);
        assertEquals(alma1.getNivelBondad(),5);
        assertEquals(alma1.isFriolenta(), true);

        demonioHielo.atormentar(alma3);
        assertEquals(alma3.getNivelBondad(),2);
        assertEquals(alma3.isFriolenta(), true);

    }

    @Test
    public void testAtormentarDemonioSombra() {
        demonioSombra.atormentar(alma1);
        assertEquals(alma1.getNivelBondad(),5);
        assertEquals(alma1.getNivelValor(), 5);

        demonioSombra.atormentar(alma2);
        assertEquals(alma2.getNivelBondad(),35);
        assertEquals(alma2.getNivelValor(), 20);

        demonioSombra.atormentar(alma4);
        assertEquals(alma4.getNivelBondad(),15);
        assertEquals(alma4.getNivelValor(), 5);
    }

    @Test
    public void testQuitarAlmasDelLugar() {
        demonioFuego.cazarAlmas(lugar1);

        List<Alma> almasDelLugar= Stream.of(alma2,alma4,alma5,alma6).collect(Collectors.toList());
        assertEquals(lugar1.getAlmas(),almasDelLugar);

        List<Alma> almasCazadasPorDemonio =  Stream.of(alma1,alma3).collect(Collectors.toList());
        assertEquals(demonioFuego.getAlmasCazadas(),almasCazadasPorDemonio);

        List<Alma> almasAtormentadasPorDemonio =  Stream.of(alma2,alma4,alma5,alma6).collect(Collectors.toList());
        assertEquals(demonioFuego.getAlmasAtormentadas(),almasAtormentadasPorDemonio);

        assertEquals(demonioFuego.getNivelMaldad(),38);
    }

}
