package Ficheros04.AccesoAleatorio;

import java.io.File;

import java.io.IOException;
import java.io.RandomAccessFile;

import Ficheros02.Texto.Ejercicio3;

public class Ejercicio5 {
	
    private final static String DATOSFILEOUTPUT = "FicheroAleatorio.dat";
    private static  RandomAccessFile RandomFile;
    private final static int TAMANIO = 4;


	public static void main(String[] args) {
		
		

	}
	
	//metodo para escribir de forma aletoria
	public static int escribir() {
		//objeto file que vamos a pasar para escribir
		File filePathOUTPUT = new File(Ejercicio3.RUTADATOS + DATOSFILEOUTPUT);
		
		try {
			RandomFile = new RandomAccessFile(filePathOUTPUT, "rw"); // el ramdon file así puede escribir
			
			int i;
			for (i=1; i<= 100; i++){ // escribimos numeros del 1 al 100 en el fichero
				RandomFile.write(i);
			}
			
			RandomFile.close();
			return i; // devuelve el numero total de elementos
			
		} catch (IOException e) {
			System.err.println("ERROR de escritura");
			e.printStackTrace();
			return -1;
		}
	}
	
	
	//método lectura del archivo de acceso aletorio. Hay que tener en cuenta la posicion del puntero
	public static int leer() {
		
		try {
			RandomFile.seek(0); // posiciona el puntero al comienzo del archivo
			while(RandomFile.getFilePointer() != RandomFile.length()) { // como lee secuencialmente con un puntero mientras haya elementos, habrá que leer miestras sea distinta al tamaño del archivo
				System.out.println(RandomFile.readInt());
			}
			
			RandomFile.close();
			
		} catch (IOException e) {
			System.err.println("ERROR de lectura");
			e.printStackTrace();
			return -2;
		} 
		
		return 0;
	}
	
	
    /** muestra por consola el valor almacenado en una determinada posición.
     * @param lugar posicion a la que se accederá para mostrar el valor almacenado.
     * @return devuelvo el valor almacenado en la posicion pasada como parámetro
     * 		- 1 en caso de error
     */
	
	public static int consultar(int lugar) { // se le pasa un lugar para leer, una posición
		
		try {
			
			long posicion = (lugar - 1) * TAMANIO; //para que pueda leer desde esa posición hay que ir uno hacia atrás (empieza en 0) y colocar el puntero. multiplicar por el tamaño es porque cada int ocupa 4 bytes entonces hay que hacer el cálculo para encontrar el valor en esa posicion
			
			// comprobar si la posición es válida
			if(posicion >= RandomFile.length() || lugar <= 0) { // si la posicion es mayor o igual al tamaño total del archivo, no se puede leer o escribir más allá del final o se intenta escribir en posiciones negativas o igual a 0 (las posiciones válidas es a partir de 1)
				System.out.println("No existe valor para esa posición");
				return -1;
			}
			
			// si se pasa una posicion valida
			RandomFile.seek(posicion);//colocamos el puntero en la posicion
			return RandomFile.readInt(); // y devolvemos la lectura del valor de esa posicion
			
		} catch (IOException e) {
            e.printStackTrace();
            System.err.println("Error de lectura");
            return -1;
		}
		
	}
	
	public static boolean anadirFinal(int valor) {
		
		
		return false;
	}
	
	
}
