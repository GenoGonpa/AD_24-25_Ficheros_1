package ficheros;

public class Utilidades {
	
	// Definir el nombre del archivo CSV a leer
	private final static String FICHEROTRABAJO = "ejercicio08.csv";
	// Definir el separador que se usará para dividir los campos del CSV
	private static final String SEPARADOR = ";";
	// Definir las comillas que se eliminarán de los campos
	private static final String COMILLA = "\"";

    public final static String RUTADATOS =  System.getProperty("user.dir") +
            System.getProperty("file.separator")  + "src" + System.getProperty("file.separator")
            + "main" + System.getProperty("file.separator")
            + "resources" + System.getProperty("file.separator");

	public static String getFicherotrabajo() {
		return FICHEROTRABAJO;
	}

	public static String getSeparador() {
		return SEPARADOR;
	}

	public static String getComilla() {
		return COMILLA;
	}

	public static String getRutadatos() {
		return RUTADATOS;
	}
    
    
    

}
