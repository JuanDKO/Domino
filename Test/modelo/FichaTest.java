package modelo;

import static org.junit.jupiter.api.Assertions.*;

class FichaTest {

    @org.junit.jupiter.api.Test
    void esColocable() {
        Ficha f1 = new Ficha(1,2);
        Ficha f2 = new Ficha(3,4);
        Ficha f3 = new Ficha(2,6);
        Jugador j1 = new Jugador("paco");
        Mesa ms1 = new Mesa();
        j1.anadirFicha(f1);

        j1.anadirFicha(f3);
        ms1.insertarPrincipio(j1,f1);
        ms1.insertarFinal(j1,f3);


        assertTrue(f1.esColocable(ms1));

        assertFalse(f2.esColocable(ms1));

    }
}