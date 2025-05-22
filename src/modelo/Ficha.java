package modelo;

public class Ficha {
    private final int num1;
    private final int num2;
    
    public Ficha(int n1, int n2){
        num1=n1;
        num2=n2;
    }

    public int getNum1() {
        return num1;
    }

    public int getNum2() {
        return num2;
    }
    

    public Ficha inversa(){
        return new Ficha(num2,num1);
    }

    /** La clase determina si la fiche en cuestión es colocable en el tablero
     * Esto sucede si alguno de los dos numeros de la ficha coincide con el primero o ultimo de los colocados en la mesa
     *
     * @param mesa es la mesa en la que se quiere colocar la ficha en cuestión
     * @return devuelve true si la ficha es colocable y flase si no lo es
     */
    public boolean esColocable(Mesa mesa){
        boolean colocable=false;
        if(num1==mesa.getPrimero().getNum1() || num2==mesa.getPrimero().getNum1() ||
           num1==mesa.getUltimo().getNum2() || num2==mesa.getUltimo().getNum2()) {
            colocable=true;
        }
        return colocable;
    }
    
    public String toString(){
        return("["+num1+"|"+num2+"]");
    }
}
