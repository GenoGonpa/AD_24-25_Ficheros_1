package Ficheros07.CSVsinLaLibreria;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import Ficheros02.Texto.Ejercicio3;

/**
 * 1. Leer el contenido del documento ejercicio08.csv utilizando Java y mostrar por consola su contenido sin comillas ni separadores.
*  2. Crear otra versión del ejercicio utilizando un proyecto Maven con una dependencia a la librería OpenCSV (versión 3.2)
*/

public class Ejercicio8_1_Java {
	
	// Definir el nombre del archivo CSV a leer
	private final static String DATOSFILE = "ejercicio08.csv";
	// Definir el separador que se usará para dividir los campos del CSV
	private static final String SEPARADOR = ";";
	// Definir las comillas que se eliminarán de los campos
	private static final String COMILLA = "\"";

	
	
	public static void main(String[] args) throws IOException {	
		// Variable para leer el archivo
		BufferedReader br = null;
		try {
			// Inicializar el BufferedReader para leer el archivo CSV
			br = new BufferedReader(new FileReader(Ejercicio3.RUTADATOS + DATOSFILE));
			String line;
			
			// Leer el archivo línea por línea
			while ((line = br.readLine()) != null) {
				// Dividir cada línea en campos usando el separador definido (en este caso ";")
				String[] fields = line.split(SEPARADOR);
				
				// Mostrar los valores originales (con comillas)
				mostrarValores(fields);
				
				// Eliminar las comillas de los campos
				fields = eliminaComillas(fields);
				
				// Mostrar los valores sin comillas
				mostrarValores(fields);
			}
	
		} catch (FileNotFoundException e) {
			// Si el archivo no se encuentra, mostrar el error
			e.printStackTrace();
		} finally {
			// Cerrar el BufferedReader para liberar recursos
			if (br != null) {
				br.close();
			}
		}
	}
	
	
	/**
	 * Método para mostrar los valores de cada campo del array.
	 */
	private static void mostrarValores(String[] fields) {
		// Iterar sobre cada campo y mostrarlo en la consola con un tabulador
		for (String field : fields) {
			System.out.println("\t" + field);
		}
		System.out.println();  // Salto de línea al final
	}
	
	
	/**
	 * Método para eliminar comillas de los campos del array.
	 */
	private static String[] eliminaComillas(String[] fields) {
		// Iterar sobre cada campo
	    for (int i = 0; i < fields.length; i++) {
	        // Eliminar las comillas del inicio y del final, y reemplazar comillas dobles por una sola
	        fields[i] = fields[i].trim().replace(COMILLA, "").replace(COMILLA + COMILLA, COMILLA);
	    }
	    return fields;  // Devolver el array con las comillas eliminadas
	}

}

