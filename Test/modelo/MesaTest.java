package modelo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MesaTest {

    @Test
    void insertarPrincipio() {
        Ficha f1 = new Ficha(1,2);
        Ficha f2 = new Ficha(3,4);
        Ficha f3 = new Ficha(2,6);
        Jugador j1 = new Jugador("paco");
        j1.anadirFicha(f1);
        j1.anadirFicha(f2);
        j1.anadirFicha(f3);
        Mesa ms1 = new Mesa();
        ms1.insertarPrincipio(j1,f1);
        Mesa ms2 = new Mesa();

        assertTrue(ms1.insertarPrincipio(j1,f1));
        assertFalse(ms1.insertarPrincipio(j1,f2));

        assertTrue(ms2.insertarPrincipio(j1,f2));
    }

    @Test
    void insertarFinal() {
        Ficha f1 = new Ficha(1,2);
        Ficha f2 = new Ficha(3,4);
        Ficha f3 = new Ficha(2,6);
        Jugador j1 = new Jugador("paco");
        j1.anadirFicha(f1);
        j1.anadirFicha(f2);
        j1.anadirFicha(f3);
        Mesa ms1 = new Mesa();
        ms1.insertarPrincipio(j1,f1);
        Mesa ms2 = new Mesa();

        assertTrue(ms1.insertarFinal(j1,f1));
        assertFalse(ms1.insertarFinal(j1,f2));

        assertTrue(ms2.insertarFinal(j1,f2));
    }

    @Test
    void isPosibleAlPrincipio() {
        Ficha f1 = new Ficha(1,2);
        Ficha f2 = new Ficha(3,4);
        Ficha f3 = new Ficha(2,6);
        Ficha f4 = new Ficha(1,7);
        Ficha f5 = new Ficha(7,1);
        Jugador j1 = new Jugador("paco");
        j1.anadirFicha(f1);
        j1.anadirFicha(f2);
        j1.anadirFicha(f3);
        Mesa ms1 = new Mesa();
        ms1.insertarPrincipio(j1,f1);
        Mesa ms2 = new Mesa();

        assertTrue(ms1.isPosibleAlPrincipio(f4));
        assertTrue(ms1.isPosibleAlPrincipio(f5));
        assertFalse(ms1.isPosibleAlPrincipio(f2));

        assertTrue(ms2.isPosibleAlPrincipio(f1));
    }

    @Test
    void isPosibleAlFinal() {
        Ficha f1 = new Ficha(1,2);
        Ficha f2 = new Ficha(3,4);
        Ficha f3 = new Ficha(2,6);
        Ficha f4 = new Ficha(2,7);
        Ficha f5 = new Ficha(7,2);
        Jugador j1 = new Jugador("paco");
        j1.anadirFicha(f1);
        j1.anadirFicha(f2);
        j1.anadirFicha(f3);
        Mesa ms1 = new Mesa();
        ms1.insertarPrincipio(j1,f1);
        Mesa ms2 = new Mesa();

        assertTrue(ms1.isPosibleAlFinal(f4));
        assertTrue(ms1.isPosibleAlFinal(f5));

        assertFalse(ms1.isPosibleAlFinal(f2));

        assertTrue(ms2.isPosibleAlFinal(f1));
    }

    @Test
    void mesaVacia() {
        Ficha f1 = new Ficha(1,2);
        Jugador j1 = new Jugador("paco");
        j1.anadirFicha(f1);
        Mesa ms1 = new Mesa();
        ms1.insertarPrincipio(j1,f1);
        Mesa ms2 = new Mesa();

        assertTrue(ms2.mesaVacia());
        assertFalse(ms1.mesaVacia());
    }
}