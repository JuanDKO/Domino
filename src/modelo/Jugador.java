package modelo;

import java.util.List;
import java.util.LinkedList;

public class Jugador {
    private String nombre;
    private List<Ficha> array;
    private boolean mano;
    
    public Jugador(String nom){
        nombre=nom;
        array = new LinkedList<Ficha>();
        mano=false;
    }

    /**
     *
     * @param f un objeto ficha que se añade a la mano del jugador
     */
    public void anadirFicha(Ficha f){
        array.add(f);
    }

    public String getNombre() {
        return nombre;
    }
    
    public void setMano(){
        mano=true;
    }
    
    public boolean esMano(){
        return mano;
    }

    /**Determina si el jugador tiene o no fichas para jugar
     *
     * @return devuelve true si el jugador no tiene fichas y false cuando si tiene
     */
    public boolean tieneFichas(){
        return !array.isEmpty();
    }

    /**Esta clase determina si el jugador posee alguna ficha que se pueda jugar en el momento
     *
     * @param mesa es el objeto mesa en el que el jugador esta jugando
     * @return Devuevle true cuando alguna de las fichas es jugable y flase cuando ninguna lo es
     */
    public boolean puedeJugar (Mesa mesa){
        boolean res=false;
        if(!mesa.mesaVacia()){
            for(Ficha i : array){
                if(i.esColocable(mesa)){
                    res=true;
                }
            }
        }
        else{
            res=true;
        }

        return res;
    }

    /** Determina cuales son las fichas que el jugador puede jugar en el momento
     *
     * @param mesa es el objeto mesa en el que el jugador esta jugando
     * @return devuelve una lista con las fichas que se pueden jugar en el momento
     */
    public List<Ficha> fichasJugables(Mesa mesa){
        List<Ficha> jugables = new LinkedList<Ficha>();
        if(mesa.mesaVacia()){
            jugables = array;
        }
        else{
            for(Ficha i: array){
                if(i.esColocable(mesa)){
                    jugables.add(i);
                }
            }
        }
        return jugables;
    }

    /** Contabiliza la cantidad de puntos que el jugador ha obtenido
     *
     * @return devuelve la suma de los puntos de las caras de las fichas
     */
    public int sumarPuntos(){
        int suma=0;
        for(Ficha i : array){
            suma+=i.getNum1();
            suma+=i.getNum2();
        }
        return suma;
    }

    /** Muestra por pantalla las fichas que el jugador posee ahora mismo.
     *
     */
    public void mostrarFichas(){
        for(Ficha i : array){
            System.out.print(i.toString());
        }
    }
    
    public boolean eliminaFicha(Ficha f){
        return array.remove(f);
    }
    
    public String toString(){
        StringBuilder texto = new StringBuilder("Nombre: ");
        texto.append(nombre + "\nFichas: ");
        for(Ficha i : array){
            texto.append(i.toString()+ " ");
        }
        return texto.toString();
    }
    
    
}
