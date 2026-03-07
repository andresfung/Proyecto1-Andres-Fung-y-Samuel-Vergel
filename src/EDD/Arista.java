/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EDD;

/**
 *
 * @author Andres Fung y Samuel Vergel
 */
public class Arista {

    private int destino;
    private int peso;

    /**
     *
     * @param destino
     * @param peso
     */
    public Arista(int destino, int peso) {
        this.destino = destino;
        this.peso = peso;
    }
    
    /**
     *
     * @return peso
     */
    public int getPeso() {
        return peso;
    }

    /**
     *
     * @param peso
     */
    public void setPeso(int peso) {
        this.peso = peso;
    }

    /**
     *
     * @return destino
     */
    public int getDestino() {
        return destino;
    }

    /**
     *
     * @param destino
     */
    public void setDestino(int destino) {
        this.destino = destino;
    }

    /**
     * 
     * @param n
     * @return 
     */
    public boolean equals(Object n) {
        Arista a = (Arista) n;
        return this.destino == a.getDestino();
    }
    
    
}
