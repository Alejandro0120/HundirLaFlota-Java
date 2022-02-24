/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hundirflota;

import java.util.Scanner;

/**
 * En esta clase HundirFlota esta el main
 * @author Alejandro Gonzalez y Raúl dino
 */
public class HundirFlota {
    /**
     * En el main se crea el Tablero con un tamaño, donde colocar el barco, donde 
     * dispara y si has ganado o has perdido
     * @param args 
     */
    public static void main(String[] args) {
        String[][] tabla = null;
        Scanner sn = new Scanner(System.in);
        // TODO code application logic here
        //el tamaño es mayor que 4 y menor o igual que 10
        int tamanio = 0;
        do {
            System.out.println("Introduce el tamaño del tablero: ");
            tamanio = Integer.parseInt(sn.next());
        } while (tamanio < 4 || tamanio > 10);
        tabla = new String[tamanio][tamanio];
        System.out.println("Introduce tu nombre: ");
        String nombre = sn.next();

        Tablero t = new Tablero(nombre, tamanio, tabla);

        t.mostrarTablero();
        int salir = 0;
        t.colocarBarco();
        do {
            salir = 1;

            System.out.println("Colocar mas barcos? (Si(S) o No(N)): ");
            char resp = sn.next().toLowerCase().charAt(0);

            if (resp == 'n') {

                salir = 0;

            } else if (resp == 's') {
                t.colocarBarco();

            }
        } while (salir != 0);

        int rendirse = 0;
        int cont = 0;
        do {
            rendirse = 1;
            cont = t.getNumBarcos();
            System.out.println(cont);
            if(cont > 0){
                System.out.println("Rendirse? (Si(S) o No(N)): ");
                char rend = sn.next().toLowerCase().charAt(0);

                if (rend != 's') {
                    t.disparar(tabla);
                    t.mostrarTableroCopia();
                } else {
                    rendirse = 0;
                }
            }
        } while (rendirse != 0 && cont > 0);
        
        if(cont == 0){
            System.out.println("!HAS GANADO¡");
        }else{
            System.out.println("!HAS PERDIDO¡");
        }

    }
    
}
