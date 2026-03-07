/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EDD;

/**
 *
 * @author Andres Fung y Samuel Vergel
 */
public class Nodo {
    private Object dato;
    private Nodo pNext;

    /**
     *
     * @param dato
     */
    public Nodo(Object dato) {
        this.dato = dato;
        this.pNext = null;
    }

    
    //Metodos get y set para los atributos

    /**
     *
     * @return dato
     */

    public Object getDato() {
        return dato;
    }

    /**
     *
     * @param dato
     */
    public void setDato(Object dato) {
        this.dato = dato;
    }

    /**
     *
     * @return El siguiente
     */
    public Nodo getpNext() {
        return pNext;
    }

    /**
     *
     * @param pNext
     */
    public void setpNext(Nodo pNext) {
        this.pNext = pNext;
    }

    /**
     *
     * @return La representacion en Strings del nodo
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Dato: ").append(dato);
        return sb.toString();
    }
    
    
}
