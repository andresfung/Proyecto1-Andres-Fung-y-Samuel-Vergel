/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Funciones;

/**
 *
 * @author Andres Fung y Samuel Vergel
 */
    public class Validacion {
    private boolean validarnumeros(String num){
        return num.matches("[0-9]*");
    }
    
    /**
     *
     * @param numero
     * @return el numero convertido a int
     */
    public int ValidarNumeros(String numero){
        if(validarnumeros(numero)){
            int num = Integer.parseInt(numero);
            return num;
        }else{
            return -1;
        }
    }
}
