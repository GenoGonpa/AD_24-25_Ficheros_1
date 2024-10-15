package Ficheros01.ClaseFILE;

import java.io.File;
import java.util.Scanner;

/**
 * Ejercicio 2:
 * Modificar el ejercicio 2 de manera que se pida por teclado el nombre del
 * fichero o directorio a analizar. En primer lugar se comprobará si existe, en
 * caso de no existir, se indicará. En caso de existir, se verifica si es fichero o
 * directorio. Si es fichero, se muestra su tamaño, si puede leerse, puede
 * modificarse y/o ejecutarse. En caso de ser directorio, se mostrarán los
 * elementos que contiene mediante un listado.
 */

public class Ejercicio2 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		//pedir al usuario el fichero o directorio
		System.out.println("Introduce el nombre el fichero o directorio a analizar: (ruta) ");
		
		String nombre = sc.nextLine();
		
		sc.close();
		
		//crear objeto FIle con el nombre del usuario
		File file = new File(nombre);
		
		//comprobar si existe el fichero o el directorio
		if(file.exists()) {
			
			// verificar si es archivo o directorio
			if(file.isFile()) {
				System.out.println("Es un archivo.");
				System.out.println("Tamaño: " + file.length() + " bytes");
				System.out.println("Se puede leer: " + (file.canRead() ? "SÍ" : "NO"));
				System.out.println("Se puede modificar: " +  (file.canWrite() ? "Sí" : "NO"));
				System.out.println("Se puede ejecutar: " +  (file.canExecute() ? "SÍ" : "NO"));
			
			}else if (file.isDirectory()) {
				
				File [] hijos = file.listFiles(); //obtener los elementos del directorio
				System.out.println("Es un directorio. Contiene: " + hijos.length + " elementos");
				
				// imprimir los elementos
				for (File hijo : hijos) {
					System.out.println("\t" + hijo.getName() +  " ---> " + (hijo.isFile()?"F":"D"));
				
				}
			
			
			}

		}
	}
}

