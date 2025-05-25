package modelo;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class JugadorTest {

    @Test
    void tieneFichas() {
        Ficha f1 = new Ficha(1,2);
        Ficha f2 = new Ficha(3,4);
        Ficha f3 = new Ficha(2,6);
        Jugador j1 = new Jugador("paco");
        Jugador j2 = new Jugador("paca");

        j1.anadirFicha(f1);
        j1.anadirFicha(f3);

        assertTrue(j1.tieneFichas());

        assertFalse(j2.tieneFichas());
    }

    @Test
    void puedeJugar() {
        Ficha f1 = new Ficha(1,2);
        Ficha f2 = new Ficha(3,4);
        Ficha f3 = new Ficha(2,6);
        Jugador j1 = new Jugador("paco");
        j1.anadirFicha(f1);
        j1.anadirFicha(f3);
        j1.anadirFicha(f2);

        Jugador j2 = new Jugador("paquito");
        Mesa ms1 = new Mesa();
        ms1.insertarPrincipio(j1,f1);

        Mesa ms2 = new Mesa();

        // Devuevle true si la mesa esta vacia da igual si el jugador no tiene fichas
        assertTrue(j2.puedeJugar(ms2));

        //Devuelve true si alguna de las fichas del jugadores es colocable
        assertTrue(j1.puedeJugar(ms1));

        //Devuelve false si la mesa no esta vacia y el jugador no tiene ninguna ficha colocable
        assertFalse(j2.puedeJugar(ms1));
    }

    @Test
    void fichasJugables() {
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

        List<Ficha> lista1 = new ArrayList<>();
        lista1.add(f2); lista1.add(f3);

        List<Ficha> lista2 = new ArrayList<>();
        lista2.add(f3);

        assertEquals(lista1,j1.fichasJugables(ms2));
        assertEquals(lista2,j1.fichasJugables(ms1));
    }

    @Test
    void sumarPuntos() {
        Ficha f1 = new Ficha(1,2);
        Ficha f2 = new Ficha(3,4);
        Ficha f3 = new Ficha(2,6);
        Jugador j1 = new Jugador("paco");
        Jugador j2 = new Jugador("paquete");
        j1.anadirFicha(f1);
        j1.anadirFicha(f2);
        j1.anadirFicha(f3);

        assertEquals(18,j1.sumarPuntos());
        assertNotEquals(15,j1.sumarPuntos());
        //Probando con jugador vacio
        assertEquals(0,j2.sumarPuntos());
    }
}