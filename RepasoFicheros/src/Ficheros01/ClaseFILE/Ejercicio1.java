package Ficheros01.ClaseFILE;

import java.io.File;

/**
 * Ejercicio 1:
 * Mostrar el contenido del directorio actual, indicando su nombre y cuántos
 * archivos y directorios tiene. Para cada elemento contenido mostrar su nombre
 * y si se trata de un fichero o directorio.*/

public class Ejercicio1 {
	
	public static void main(String[] args) {
		
		File dirActual = new File(System.getProperty("user.dir")); // clase FILE no lee y escribe sólo comprueba la existencia de elementos en directorios o bien crea el elemento reservado en memoria (no físicamente)
		File [] hijos = dirActual.listFiles(); // array para guardar los elmentos de la ruta
		
		
		//Imprimir los elementos
		System.out.println("Nombre del directorio de trabajo actual: " + dirActual.getName() + " tiene " + hijos.length + " hijos");
		
		// recorrer el array e imprimir si es directorio (d) o archivo (f)
		for (File file : hijos) {
			System.out.println("\t" + file.getName() +  " ---> " + (file.isFile()?"F":"D")); // OPERADOR TERNARIO "condicion ? valor_si_verdadero : valor_si_falso;"
		}
	}

}
