/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EDD;

/**
 *
 * @author Andres Fung y Samuel Vergel
 */

public class Grafo {
    private Lista verts;

    /**
     *
     */
    public Grafo() {
        this.verts = new Lista();
    }

    /**
     *
     * @return verts
     */
    public Lista getVerts() {
        return verts;
    }

    /**
     *
     * @param verts
     */
    public void setVerts(Lista verts) {
        this.verts = verts;
    }
    
    /**
     *
     * @return True or False
     */
    public boolean isEmpty(){
        return this.verts.isEmpty();
    }
    
    /**
     *
     * @param nombre
     */
    public void addVert(String nombre){
        if(!this.search(nombre)){
            Vertice newVert = new Vertice(nombre);
            newVert.setNumVert(this.verts.getSize());
            this.verts.insertFinale(newVert);
        }
    }
    
    /**
     *
     * @param num
     * @return valor del vertice
     */
    public Vertice numVert(int num){
        if(!this.isEmpty()){
            if(this.verts.getValue(num) != null){
                Vertice v = (Vertice) this.verts.getValue(num);
                return v;
            }
            
            return null;
        }
        
        return null;
    }
    
    /**
     *
     * @param nombre
     * @return nombre del Vertice
     */
    public Vertice nameVert(String nombre){
        if(!this.isEmpty()){
            for (int i = 0; i < this.verts.getSize(); i++) {
                Vertice currentVert = (Vertice) this.verts.getValue(i);
                if(currentVert.getNombre().equalsIgnoreCase(nombre)){
                    return currentVert;
                }
            }
            
            return null;
        }
        
        return null;
    }
    
    /**
     *
     * @param nameOrigen
     * @param nameDestino
     * @param peso
     */
    public void addArist(String nameOrigen, String nameDestino, int peso){
        if(!this.isEmpty()){
           
           if(this.search(nameOrigen) && this.search(nameDestino)){
               Vertice origen = this.nameVert(nameOrigen);
               Vertice destino = this.nameVert(nameDestino);
               
               Arista newArist1 = new Arista(destino.getNumVert(), peso);
               origen.getLad().insertFinale(newArist1);
               
               Arista newArist2 = new Arista(origen.getNumVert(), peso);
               destino.getLad().insertFinale(newArist2);
           }
        }
    }
    
    /**
     *
     * @param nombre
     * @return El vertice buscado
     */
    public boolean search(String nombre){
        boolean encontrado = false;
        if(!this.isEmpty()){
            for (int i = 0; i < this.verts.getSize(); i++) {
                Vertice currentVert = (Vertice) this.verts.getValue(i);
                if(currentVert.getNombre().equalsIgnoreCase(nombre)){
                    encontrado = true;
                    break;
                }
            }
        }
        
        return encontrado;
    }
    
    /**
     *
     * @param v
     * @return Los destinos y pesos de un vertice
     */
    public String convertAd(Vertice v){
        if(!v.getLad().isEmpty()){
            String ady = "";
            for (int i = 0; i < v.getLad().getSize(); i++) {
                Arista currentArist = (Arista) v.getLad().getValue(i);
                int peso = currentArist.getPeso();
                String destino = this.numVert(currentArist.getDestino()).getNombre();
                
                if(i != v.getLad().getSize()-1){
                    ady += destino + "," + peso + "->";
                }else{
                    ady += destino + "," + peso + "->//";
                }
            }
            
            return ady;
        }
        
        return "//";
    }
    
    /**
     *
     * @return Los vertices y sus adyacencias
     */
    public String convertVert(){
        if(!this.isEmpty()){
            String verts = "";
            for (int i = 0; i < this.verts.getSize(); i++) {
                Vertice currentVert = (Vertice) this.verts.getValue(i);
                verts += currentVert.getNombre() + "---> " + this.convertAd(currentVert) + "\n";
            }
            
            return verts;
        }
        
        return "La red se encuentra vacia.";
    }

    /**
     *
     * @return La representacion en Strings del grafo
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Grafo:\n");
        sb.append(this.convertVert());
        return sb.toString();
    }
    
    
}
