package ficheros03.Binarios;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import Ficheros02.Texto.Ejercicio3;

/**
 * Ejercicio 4:
 * Leer el fichero imagen.jpg y copiar su contenido en el fichero imagen_copia.gif.
 */

public class Ejercicio4 {
	
    private final static String DATOSFILEINPUT = "imagen.jpg";
    private final static String DATOSFILEOUTPUT = "imagen_copia.jpg";

	public static void main(String[] args) {
		
		// file de Entrada de datos
		File filePathINPUT = new File(Ejercicio3.RUTADATOS + DATOSFILEINPUT);		
		// lectura del fichero
		FileInputStream fIS;
	
		// file de salida de datos
		File filePathOUTPUT = new File(Ejercicio3.RUTADATOS + DATOSFILEOUTPUT);
		// copia salida datos
		FileOutputStream fOS;
		try {
			//instacioamos los objetos
			fIS = new FileInputStream(filePathINPUT);
			fOS = new FileOutputStream(filePathOUTPUT);
			
            /** con esta opción voy leyendo de uno en uno los bytes
            int leido;
            while ((leido = fIS.read()) != -1) {
            fOS.write(leido);
            }
            **/
			
			//con esta opcion leo todo de golpe
			fOS.write(fIS.readAllBytes()); // le paso el input de lectura
			
			//hay que cerrar ambos Streams
			fIS.close();
			fOS.close();
			
		} catch (FileNotFoundException e) {
			System.out.println("El fichero no existe");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("Error lectura del fichero");
			e.printStackTrace();
		}

	}

}
