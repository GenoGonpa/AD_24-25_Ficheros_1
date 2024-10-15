package ficheros;


import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import com.opencsv.CSVReader;

public class Ejercicio8_1 {
	

	private final static String FICHEROTRABAJO = "ejercicio08.csv";
	private static final char SEPARADOR = ','; // HAY QUE CAMBIAR DE STRING A CHAR PARA QUE SE LE PUEDA PASAR AL CONSTRUCTOR DEL CSVREADER
	private static final char COMILLA = '"';
	
	private static void mostrarValores(String[] fields) {
		for (int i=0; i<fields.length; i++) {
			System.out.print("\t - " + fields[i]); // CADA ELEMENTO SE IMPRIME CON UNA TABULACION Y UN " -"
		}
		System.out.println();
	}

	public static void main(String[] args) {
		
		/**
		 * ABRIR EL FICHERO
		 */
		CSVReader reader = null; // OBJETO CSV DE LA LIBRERIA CSVREADER
		
		try {
			reader = new CSVReader(new FileReader(Utilidades.getRutadatos() + FICHEROTRABAJO), SEPARADOR, COMILLA); // SE LE PASA EL CONSTRUCTOR TRES PARAMETROS: el ARCHIVO (FICHERO) Y DOS CARACTERES (EL DELIMITADOR PARA SEPARAR ELEMENTOS Y LAS COMILLAS POR SI ALGUN ELEMENTO LAS TIENE Y LAS RESPECTE)
			//LEER EN BUCLE Y CARGAR EL VALOR EN EL STRING 
			String[] nextLine = null;
			while((nextLine=reader.readNext())!= null){
				mostrarValores(nextLine); // SE MUESTRA EL VALOR ALMACENADO EN EL ARRAY CON EL METODO mostrarValores
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}catch (IOException e) {
			e.printStackTrace();
		}finally {
			try {
				reader.close();
			}catch(IOException e) {
				e.printStackTrace();
			}
		}
		
	}

	
}
