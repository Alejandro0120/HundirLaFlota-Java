/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hundirflota;

import java.util.Scanner;

/**
 *
 * @author Alejandro Gonzalez y Raúl dino
 */
public class Tablero {
    
    private String[][] tabla = null;
    private String[][] copiaTabla = null;
    private String nombre;
    private int tamanio;
    private int minimo = 0;//minimo para el los ejeX o eje Y
    private int numBarcos = 0;//numero de barcos contando el tamaño
    
    /**
     * En el constructor hay que pasar los siguientes parametros:
     * @param nombre Nombre de usuario
     * @param tamanio Tamaño del tablero
     * @param tabla Es el array bidimensional con el tamaño del tablero
     */
    public Tablero(String nombre, int tamanio, String[][] tabla) {
        this.nombre = nombre;
        this.tamanio = tamanio;
        this.tabla = tabla;
        this.copiaTabla = tabla;

    }

    public int getNumBarcos() {
        return numBarcos;
    }
    
    /**
     * En este metodo muestra el tablero donde esta situado los barcos
     */
    public void mostrarTablero() {

        //cabecera
        System.out.printf("%3s", " ");
        for (int i = 0; i < (tamanio); i++) {

            System.out.printf("%d ", i);
            if (i == (tamanio) - 1) {

                System.out.printf("\n %2s", " ");
            }

        }
        for (int i = 0; i < (tamanio); i++) {
            System.out.printf("%s ", "-");
        }
        System.out.printf("\n");
        //cuerpo
        for (int i = 0; i < tamanio; i++) {
            System.out.printf("%d%s", i, "|");
            for (int j = 0; j < tamanio; j++) {
                //creamos la tabla donde pueden ir los barcos  con todo asteriscos y se encuentrar dentro del array
                this.tabla[i][j] = "*";
                System.out.printf(" %s", this.tabla[i][j]);

            }
            System.out.printf(" %s%d", "|", i);
            System.out.printf("\n");
        }

        //cierre
        System.out.printf("%3s", " ");

        for (int i = 0; i < (tamanio); i++) {
            System.out.printf("%s ", "-");
            if (i == (tamanio) - 1) {

                System.out.printf("\n");
            }

        }
        System.out.printf("%3s", " ");
        for (int i = 0; i < (tamanio); i++) {

            System.out.printf("%d ", i);

        }

        System.out.println("");

    }

    /**
     * En este metodo se genera un numero aleatorio entre los numeros que pasamos 
     * por parametro
     * @param minimo
     * @param maximo
     * @return int 
     */
    public static int generarNumerosAleatorios(int minimo, int maximo) {
        int num = (int) Math.floor(Math.random() * (maximo - minimo + 1) + (minimo));
        return num;
    }
    
    /**
     * En este metodo es para colocar el barco con un tamaño y direccion aleatorio
     * para colocar el barco se introduce por teclado la fila y la columna
     */
    public void colocarBarco() {
        Scanner sn = new Scanner(System.in);
        int tamMax = 4;
        int tamMin = 1;
        int posiEjeX = 0; // se colocara en posicion hacia la derecha de las coordenadas de inicio
        int posiEjeY = 1; // se colocara en posicion hacia abajo  de las coordenadas de inicio

        //generamos el primer barco
        //se elige el tamaño del barco de manera aleatorio
        int tamBarco = generarNumerosAleatorios(tamMin, tamMax);
        System.out.printf("tamaño de barco: %d\n", tamBarco);
        numBarcos +=tamBarco;
        
        //se genera la posicion del eje de colocacion del barco de manera aleatoria;
        int posBarco = generarNumerosAleatorios(posiEjeX, posiEjeY);
        System.out.printf("posicion del eje: %d", posBarco);
        if (posBarco == 0) {
            System.out.printf(" se coloca hacia la derecha\n");
        } else {
            System.out.printf(" se coloca hacia abajo\n");
        }

        System.out.println("Coloca el barco: ");
        System.out.println("coordenada X: ");
        int X = Integer.parseInt(sn.next());
        System.out.println("coordenada Y: ");
        int Y = Integer.parseInt(sn.next());
        if (posBarco == 0) {
            do {
                if ((this.tamanio - Y) >= tamBarco) {
                    System.out.println("Barco colocado");

                } else {
                    System.out.println("no hay espacio");
                    System.out.println("Coloca el barco: ");
                    System.out.println("coordenada X: ");
                    X = Integer.parseInt(sn.next());
                    System.out.println("coordenada Y: ");
                    Y = Integer.parseInt(sn.next());

                }
            } while ((this.tamanio - Y) < tamBarco);
            //cambiamos los * por B 
            for (int columna = 0; columna < tamBarco; columna++) {
                this.tabla[X][(Y + columna)] = "B";
            }
        } else {
            do {
                if (this.tamanio - X >= tamBarco) {
                    System.out.println("Barco colocado");

                } else {
                    System.out.println("no hay espacio");
                    System.out.println("Coloca el barco: ");
                    System.out.println("coordenada X: ");
                    X = Integer.parseInt(sn.next());
                    System.out.println("coordenada Y: ");
                    Y = Integer.parseInt(sn.next());
                }
            } while ((this.tamanio - X) < tamBarco);
            //cambiamos los * por B 
            for (int fila = 0; fila < tamBarco; fila++) {
                this.tabla[(X + fila)][Y] = "B";
            }

            //cuerpo
            for (int i = 0; i < tamanio; i++) {
                System.out.printf("%d%s", i, "|");
                for (int j = 0; j < tamanio; j++) {
                    //creamos la tabla donde pueden ir los barcos  con todo asteriscos y se encuentrar dentro del array

                    System.out.printf(" %s", this.tabla[i][j]);

                }
                System.out.printf(" %s%d", "|", i);
                System.out.printf("\n");
            }

        }
    }
    
    /**
     * En este metodo se dispara a una casilla con las coordenadas que introducimos
     * por teclado
     * @param t tablero donde se apunta 
     */
    public void disparar(String[][] t) {
        Scanner sn = new Scanner(System.in);
        

        System.out.println("Disparar: ");
        System.out.println("coordenada X: ");
        int X = Integer.parseInt(sn.next());
        System.out.println("coordenada Y: ");
        int Y = Integer.parseInt(sn.next());
        if (t[X][Y] == null) {
            copiaTabla[X][Y] = "T";
            System.out.println("!TOCADO¡");
            numBarcos--;
        }else{
            System.out.println("!AGUA!");
        }
        
    }
    
    /**
     * En este metodo se enseña la tabla despues de un disparo
     */
    public void mostrarTableroCopia() {
        //cabecera
        System.out.printf("%3s", " ");
        for (int i = 0; i < (tamanio); i++) {

            System.out.printf("%d ", i);
            if (i == (tamanio) - 1) {

                System.out.printf("\n %2s", " ");
            }

        }
        for (int i = 0; i < (tamanio); i++) {
            System.out.printf("%s ", "-");
        }
        System.out.printf("\n");
        //cuerpo
        for (int i = 0; i < tamanio; i++) {
            System.out.printf("%d%s", i, "|");
            for (int j = 0; j < tamanio; j++) {
                //creamos la tabla donde pueden ir los barcos  con todo asteriscos y se encuentrar dentro del array
                if(!"T".equals(this.copiaTabla[i][j])){
                    this.copiaTabla[i][j] = "*";
                }
                
                System.out.printf(" %s", this.copiaTabla[i][j]);

            }
            System.out.printf(" %s%d", "|", i);
            System.out.printf("\n");
        }

        //cierre
        System.out.printf("%3s", " ");

        for (int i = 0; i < (tamanio); i++) {
            System.out.printf("%s ", "-");
            if (i == (tamanio) - 1) {

                System.out.printf("\n");
            }

        }
        System.out.printf("%3s", " ");
        for (int i = 0; i < (tamanio); i++) {

            System.out.printf("%d ", i);

        }

        System.out.println("");

    }
}
