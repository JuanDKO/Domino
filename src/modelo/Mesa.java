package modelo;

import java.util.LinkedList;
import java.util.Deque;

public class Mesa {
    private Deque<Ficha> m;
    private int[] contador;
    
    public Mesa(){
        m= new LinkedList();
        contador = new int[7];
    }
        
    public Ficha getPrimero(){
        return m.getFirst();
    }
    
    public Ficha getUltimo(){
        return m.getLast();
    }

    /** Te inserta la ficha de un jugador en el inicio yen caso de que la mesa este vacia coloca esa ficha como primera
     *
     * @param j es el jugador al que le pertenece la ficha que se va a colocar
     * @param f es la fucha que se va a colocar en el inicio
     * @return devuelve true si se ha colocado correctamente y false si no se ha podido colocar
     */
    public boolean insertarPrincipio(Jugador j, Ficha f){
        boolean colocada=false;
        if(isPosibleAlPrincipio(f)){
            if(mesaVacia() || f.getNum2()==getPrimero().getNum1()){
                m.addFirst(f);
            }
            else{
                m.addFirst(f.inversa());
            }
            j.eliminaFicha(f);
            getContador()[f.getNum1()]++;
            getContador()[f.getNum2()]++;
            colocada=true;
        }
        return colocada;
    }

    /** Te inserta una ficha de un jugador determinado en el final de la linea
     *
     * @param j es el jugador del cual se va a insertar la ficha
     * @param f es la ficha que el jugador a elejido para insertar al final
     * @return devuelve true si la ficha se ha colocado correctamente
     * y fdlse si la ficha no era posible colocarse en el final
     */
    public boolean insertarFinal(Jugador j, Ficha f) {
        boolean colocada=false;
        if(isPosibleAlFinal(f)){
            if(mesaVacia() || f.getNum2()==getUltimo().getNum1()){
                m.addLast(f);
            }
            else{
                m.addLast(f.inversa());
            }
            j.eliminaFicha(f);
            getContador()[f.getNum1()]++;
            getContador()[f.getNum2()]++;
            colocada=true;
        }
        return colocada;
    }

    /** Te indica el contador actual
     *
     * @return devuelve el contador de la mesa
     */
    public int[] getContador() {
        return contador;
    }

    /** Te indica si una ficha es posible colocarla al inicio
     *
     * @param aux es la ficha que se busca comprobar
     * @return devuelve true si cualquiera de los dos numeros de la ficha es compatible con el numero del inicio
     * y false en caso de que ninguno sea compatible
     */
    public boolean isPosibleAlPrincipio(Ficha aux) {
        return this.mesaVacia()
                || aux.getNum1() == getPrimero().getNum1()
                || aux.getNum2() == getPrimero().getNum1();
    }

    /**Te indica si la ficha seleccionada puede coloarse al final de la lista
     *
     * @param aux es la ficha que se quiere comprobar
     * @return devuelve true en caso de que alguno de los dos numeros de la ficha coincida con el final
     * y false en caso contrario
     */
    public boolean isPosibleAlFinal(Ficha aux) {
        return this.mesaVacia()
                || aux.getNum1()==getUltimo().getNum2()
                || aux.getNum2()==getUltimo().getNum2();
    }

    /** Te indica si la mesa se encuentra vacia
     *
     * @return te devuelvw true en caso de que la mesa este vacia y false en caso de que no
     */
    public boolean mesaVacia(){
        return m.isEmpty();
    }
    
    public String toString(){
        StringBuilder texto = new StringBuilder("");
        for(Ficha  i : m){
            texto.append(i.toString());
        }
        return texto.toString();
    }
}
