/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EDD;

/**
 *
 * @author Andres Fung y Samuel Vergel
 */
public class Vertice {
    private String nombre;
    private int numVert;
    private Lista lad;

    /**
     *
     * @param nombre
     */
    public Vertice(String nombre) {
        this.nombre = nombre;
        this.numVert = -1;
        this.lad = new Lista();
    }

    
    //Metodos get y set para los atributos

    /**
     *
     * @return nombre 
     */ 
    
    public String getNombre() {
        return nombre;
    }

    /**
     *
     * @param nombre
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     *
     * @return numVert
     */
    public int getNumVert() {
        return numVert;
    }

    /**
     *
     * @param numVert
     */
    public void setNumVert(int numVert) {
        this.numVert = numVert;
    }

    /**
     *
     * @return lad
     */
    public Lista getLad() {
        return lad;
    }

    /**
     *
     * @param lad
     */
    public void setLad(Lista lad) {
        this.lad = lad;
    }

    /**
     *
     * @return La representacion en Strings del vertice
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Nombre: ").append(nombre);
        sb.append("\nNumero de Vertice: ").append(numVert);
        return sb.toString();
    }
    
    
}
