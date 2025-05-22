package modelo;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class Monton {
    private List<Ficha> m;
    
    public Monton(){
        m = new LinkedList<Ficha>();
        for(int i=6;i>=0;i--){
            for(int j=0;j<=i;j++){
                m.add(new Ficha(i,j));
            }
        }
    }

    /** Saca una ficha aleatoria del monton
     *
     * @return devuelve el monton quitando la ficha extraida
     */
    public Ficha extraerRandom(){
        Random rand = new Random();
        int valor = rand.nextInt(m.size());
        return m.remove(valor);
    }

    /** Te indica si el monton esta vacio de fichas
     *
     * @return devuelve true si esta vacio y false si no lo esta
     */
    public boolean esVacio(){
        return m.isEmpty();
    }
    
    public String toString(){
        StringBuilder texto = new StringBuilder("El monton tiene: ");
        for(Ficha i : m){
            texto.append(i.toString()).append(" ");
        }
        return texto.toString();
    }
    
}
