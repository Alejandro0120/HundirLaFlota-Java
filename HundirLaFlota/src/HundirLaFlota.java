/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.hundirlaflota.hundirlaflota;

import java.util.Scanner;

public class HundirLaFlota {

    public static void main(String[] args) {
        
        Scanner sn = new Scanner(System.in);
        
        
        System.out.println("Introduce el tamaño del tablero: ");
        int tamanio = Integer.parseInt(sn.next());
        
        System.out.println("Introduce tu nombre: ");
        String nombre = sn.next();
        
        

        
        Tablero t = new Tablero(nombre, tamanio);
       
        
        System.out.println("Empieza el juego");
        
        int x = -1, y = -1;
        //LocalDate hoy = LocalDate.now();
        
        while(x != 0 && !t.finJuego()){
            t.mostrarTableroTest();
            System.out.println("");
            t.mostrarTablero();
            
            System.out.println("Introducir col fil / 0-> Salir: ");
            y = sn.nextInt();
            x = sn.nextInt();
            if(x !=0){
                t.disparar(x-1, y-1);
            }
        }
        
        if(t.finJuego()){
            System.out.println("Â¡Has ganado!");
        }
    }
}
