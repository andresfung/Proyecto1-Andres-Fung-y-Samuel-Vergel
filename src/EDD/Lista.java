/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EDD;

import javax.swing.JOptionPane;

/**
 *
 * @author Andres Fung y Samuel Vergel
 */
public class Lista {
    private Nodo pFirst; //nodo apuntador al primero
    private int size; //tamaño de la lista
    
    //Constructor de la clase Lista

    /**
     *
     */
    public Lista() {
        this.pFirst = null;
        this.size = 0; 
    }
    
    //Metodos get y set para los atributos

    /**
     *
     * @return El primero de la lista
     */

    public Nodo getpFirst() {
        return pFirst;
    }

    /**
     *
     * @param pFirst
     */
    public void setpFirst(Nodo pFirst) {
        this.pFirst = pFirst;
    }

    /**
     *
     * @return el tamano de la lista
     */
    public int getSize() {
        return size;
    }

    /**
     *
     * @param size
     */
    public void setSize(int size) {
        this.size = size;
    }
    
    //Primitivas
    

    /**
     *
     * @return Verifica si la lista esta vacia (True or False)
     */
    public boolean isEmpty(){
        return this.pFirst == null;
    }
    

    /**
     *
     * @param dato
     * @return un nuevo nodo al inicio de la lista
     */
    public Nodo insertStart(Object dato){
        
        Nodo pNew = new Nodo(dato);
       
        if (this.isEmpty()) {   
            pFirst = pNew;
        } else{
            pNew.setpNext(pFirst);
            pFirst = pNew;
        }
        size++;
        return pNew;
    }
    

    /**
     *
     * @param dato
     */
    public void insertFinale(Object dato){
        Nodo pNew = new Nodo(dato);
        if(this.isEmpty()){
            pFirst = pNew;
        }else{
            Nodo aux = pFirst;
            while (aux.getpNext()!= null){
                aux = aux.getpNext();
            }
            aux.setpNext(pNew);
        }
        size++;
    }
    
    /**
     *
     * @param posicion
     * @param valor
     */
    public void insertForPosition(int posicion, Object valor){
        if(posicion>=0 && posicion<size){
            Nodo nuevo = new Nodo(valor);
            if(posicion == 0){
                nuevo.setpNext(pFirst);
                pFirst = nuevo;
            }
            else{
                if(posicion == size-1){
                    Nodo aux = pFirst;
                    while(aux.getpNext()!= null){
                        aux = aux.getpNext();
                    }
                    aux.setpNext(nuevo);              
                }
                else{
                    Nodo aux = pFirst;
                    for (int i = 0; i < (posicion-1); i++) {
                        aux = aux.getpNext();
                    }
                    Nodo siguiente = aux.getpNext();
                    aux.setpNext(nuevo);
                    nuevo.setpNext(siguiente);
                }
            }
            size++;
        }
    }
    
    /**
     *
     * @param ref
     * @param valor
     */
    public void insertForReference(Object ref,Object valor){
        
        Nodo nuevo = new Nodo(valor);
        
        if (!this.isEmpty()) {
            if (this.search(ref)) {
                Nodo aux = pFirst;
                // Recorre la lista hasta llegar al nodo de referencia.
                while (aux.getDato() != ref) {
                    aux = aux.getpNext();
                }
                // Crea un respaldo de la continuación de la lista.
                Nodo siguiente = aux.getpNext();
                // Enlaza el nuevo nodo despues del nodo de referencia.
                aux.setpNext(nuevo);
                // Une la continuacion de la lista al nuevo nodo.
                nuevo.setpNext(siguiente);
            
                size++;
            }
        }
    }
    
    /**
     *
     * @return la lista en forma de cadena de caracteres
     */
    public String convertString(){
        if(!this.isEmpty()){
            
            Nodo aux = pFirst;
            String expresion = "";
            
            for(int i = 0; i <size;i++){
            expresion += aux.getDato().toString() + "\n";
            aux = aux.getpNext();
            }
            return expresion;
        }
        return "Lista vacia";
    }
    
    /**
     *
     */
    public void mostrar(){
        if (!this.isEmpty()){
            Nodo aux = pFirst;
            String expresion = "";
            while(aux != null){
               expresion = expresion + aux.getDato().toString() + "\n";
               aux = aux.getpNext();
            }
            JOptionPane.showMessageDialog(null,expresion);
            
        }else{
            JOptionPane.showMessageDialog(null, "La lista esta vacia");
        }
    }
    
    /**
     *
     * @return
     */
    public boolean deleteStart(){
        if(!this.isEmpty()){
            pFirst = pFirst.getpNext();
            size--;
            return true;
        }else{
            return false;
        }
    }
    
    /**
     *
     */
    public void deleteFinale(){
        if(!this.isEmpty()){
            if (getSize()==1) {
                this.detroy();
            }else{
                Nodo pointer = getpFirst();
                while(pointer.getpNext()!= null && pointer.getpNext().getpNext()!= null){
                    pointer = pointer.getpNext();
                }
                pointer.setpNext(null);
            }
            size --;
        }  
    }
    
    /**
     *
     * @param referencia
     */
    public void deleteForReference(Object referencia){

        if (this.search(referencia)) {
            if (pFirst.getDato() == referencia) {
                pFirst = pFirst.getpNext();
            } else{
                Nodo aux = pFirst;
                while(aux.getpNext().getDato() != referencia){
                    aux = aux.getpNext();
                }
                Nodo siguiente = aux.getpNext().getpNext();
                aux.setpNext(siguiente);  
            }
            size--;
        }
    }


    /**
     *
     * @param posicion
     * @return El valor de un nodo en una determinada posicion
     */
    public Object getValue(int posicion){

        if(posicion>=0 && posicion<size){
            
            if (posicion == 0) {
                return pFirst.getDato();
            }else{
                Nodo aux = pFirst;
                for (int i = 0; i < posicion; i++) {
                    aux = aux.getpNext();
                }
                return aux.getDato();
            }
        }
        return null;
    }
    
    /**
     *
     * @param referencia
     * @return LA posicion de un elemento en la lista
     */
    public int getPosition(Object referencia){

        if (this.search(referencia)) {
            
            Nodo aux = pFirst;
            int cont = 0;
            while(referencia != aux.getDato()){
                cont ++;
                aux = aux.getpNext();
            }
            return cont;
        } else {
            return -1;
        }
    }
    
    /**
     *
     * @param referencia
     * @return El elemento buscado de la lista
     */
    public boolean search(Object referencia){
        Nodo aux = pFirst;
        boolean encontrado = false;
        while(aux != null && encontrado != true){
            if (referencia == aux.getDato()){ 
                encontrado = true;
            }
            else{
                aux = aux.getpNext();
            }
        }
        return encontrado;
    }
    

    /**
     *
     */
    public void detroy(){
        pFirst = null;
        size = 0;
    }
}
