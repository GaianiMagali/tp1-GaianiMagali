package ar.edu.unahur.obj2;

import Demonios.AdapterBelcebu;
import ar.edu.unahur.obj2.diabolico.alma.proteccion.LuzBlanca;
import ar.edu.unahur.obj2.diabolico.alma.proteccion.LuzNegra;
import ar.edu.unahur.obj2.diabolico.demonio.Belcebu;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertEquals;

public class TestDemoniosExtras {

    Alma alma1;
    Alma alma2;
    Alma alma3;
    Alma alma4;
    Alma alma5;
    Alma alma6;

    Lugar lugar1;

    LuzBlanca luzBlanca;
    LuzNegra luzNegra;

    AdapterBelcebu adapterBelcebu;
    Belcebu belcebu;


    @BeforeMethod
    public void setUp() {
        luzBlanca = new LuzBlanca();
        luzNegra = new LuzNegra();

        adapterBelcebu = new AdapterBelcebu(30,belcebu);


        alma1 = new Alma(10,10,false,luzBlanca);
        alma2 = new Alma(40,40,true,luzNegra);
        alma3 = new Alma(7,20,false,luzNegra);
        alma4 = new Alma(20,10,true,luzBlanca);
        alma5 = new Alma(8,30,true,luzNegra);
        alma6 = new Alma(6,10,true,luzNegra);

        lugar1 = new Lugar("Espanto");

        lugar1.agregarAlmas(alma1);
        lugar1.agregarAlmas(alma2);
        lugar1.agregarAlmas(alma3);
        lugar1.agregarAlmas(alma4);
        lugar1.agregarAlmas(alma5);
        lugar1.agregarAlmas(alma6);

    }

}
