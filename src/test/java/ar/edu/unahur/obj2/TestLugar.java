package ar.edu.unahur.obj2;

import ar.edu.unahur.obj2.diabolico.alma.proteccion.AnilloDePoder;
import ar.edu.unahur.obj2.diabolico.alma.proteccion.LuzBlanca;
import ar.edu.unahur.obj2.diabolico.alma.proteccion.LuzNegra;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.testng.AssertJUnit.assertEquals;

public class TestLugar {
    Alma alma1;
    Alma alma2;
    Alma alma3;
    Alma alma4;
    Alma alma5;
    Alma alma6;

    Lugar lugar1;
    Lugar lugar2;

    LuzBlanca luzBlanca;
    LuzNegra luzNegra;
    AnilloDePoder anilloDePoder;

    @BeforeMethod
    public void setUp() {
        luzBlanca = new LuzBlanca();
        luzNegra = new LuzNegra();
        anilloDePoder = new AnilloDePoder();

        alma1 = new Alma(10,10,false,luzBlanca);
        alma2 = new Alma(40,40,true,luzNegra);
        alma3 = new Alma(7,20,false,luzBlanca);
        alma4 = new Alma(20,10,true,luzNegra);
        alma5 = new Alma(8,30,true,anilloDePoder);
        alma6 = new Alma(6,10,true,anilloDePoder);

        lugar1 = new Lugar("Espanto");
        lugar2 = new Lugar("Pantano");

        lugar1.agregarAlmas(alma1);
        lugar1.agregarAlmas(alma2);
        lugar1.agregarAlmas(alma3);

        lugar2.agregarAlmas(alma4);
        lugar2.agregarAlmas(alma5);
        lugar2.agregarAlmas(alma6);
    }

    @Test
    public void testNombreLugar() {
        assertEquals(lugar1.getNombre(),"Espanto");
        assertEquals(lugar2.getNombre(),"Pantano");
    }

    @Test
    public void testAniadirAlmaAlLugar() {
        List<Alma> almasDelLugar1= Stream.of(alma1,alma2,alma3).collect(Collectors.toList());
        assertEquals(lugar1.getAlmas(),almasDelLugar1);

        List<Alma> almasDelLugar2= Stream.of(alma4,alma5,alma6).collect(Collectors.toList());
        assertEquals(lugar2.getAlmas(),almasDelLugar2);

    }
}
