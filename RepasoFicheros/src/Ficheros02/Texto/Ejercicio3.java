package Ficheros02.Texto;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Ejercicio 3:
 *
 * Leer el contenido del archivo 3_ejercicio.csv, línea a línea, utilizando un buffer
 * intermedio y mostrar su contenido en la consola. Seguidamente añade al fichero csv
 * una línea con tus datos personales.
 */

public class Ejercicio3 {
	
    public final static String RUTADATOS =  System.getProperty("user.dir") +
            System.getProperty("file.separator")  + "data" + System.getProperty("file.separator");

    private final static String DATOSFILE = "3_Ejercicio.csv";

	public static void main(String[] args) {
		//1.abrir el fichero
		//2. leerlo
		//3.Escribir mis datos
		//4.leerlo de nuevo
		
		// instancias para leer
		FileReader filePathReader;
		BufferedReader bfRd;
		
		
		// instanciar para leer
		FileWriter filePathWriter;
		PrintWriter pW;
	
		try {
			
			filePathReader = new FileReader(RUTADATOS + DATOSFILE);
			bfRd = new BufferedReader(filePathReader);
			
			//leer linea a linea. Declarar una variable y un bucle para ir leyendo cada linea mientras no sea nula
			String linea;
			while((linea = bfRd.readLine()) != null){
				//imprimimos la linea
				System.out.println(linea);
			}
			
			// cerramos el lector para escribir
			bfRd.close();
			
			// escribimos una linea con nuestros datos
			filePathWriter = new FileWriter(RUTADATOS + DATOSFILE, true); // hay que pasarle el modo append en TRUE si no sobreescribe y borra todo lo anterior
			pW = new PrintWriter(filePathWriter);
			
			//escrimos la linea
			pW.println("GENO;GONZALEZ;DAM;2");
			pW.flush(); // vaciamos el canal
			pW.close(); // cerramos el writer que te hace el flush y el close a la vez
			
			
		} catch (FileNotFoundException e) {
            System.out.println("ERROR. El fichero no existe");
            e.printStackTrace();
		} catch (IOException e) {
            System.out.println(" ERROR de lectura. No quedan más líneas disponibles");
            e.printStackTrace();
		}
		
		
		
	}

}
