package Ficheros06.DeConfiguracion;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Properties;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import Ficheros02.Texto.Ejercicio3;

/**
 * Crear el fichero de propiedades “configuración.props" con el contenido que se muestra a continuación.

# Fichero de configuracion

	user=usuario
	password=micontrasena
	server=localhost
	port=3306
	date=11-08-2022
	power=true

Posteriormente, realizar dos  métodos, uno para leerlo mostrando su contenido por consola y 
otro que nos permita modificar los valores de sus propiedades. En el caso del puerto se pedirá un valor a sumar al número de puerto actual 
y en el caso de la fecha se modificará el mes manteniéndose día y año.
 */
public class Ejercicio7 {
	
	public static Scanner sc;
	private static Properties propiedadesConfiguracion = new Properties();
	public final static String FICHEROTRABAJO = "configuracion.props";
	
	public static void main(String[] args) {			
		crearConfiguracion();
		System.out.println("Documuento original: ");
		leerConfiguracion();
		modificarConfiguracion();
		System.out.println("Documuento modificado: ");
		leerConfiguracion();
	}
	
	private static void crearConfiguracion() {	
		sc = new Scanner(System.in);
		System.out.println("Introduce el nombre del usuario: ");
		String user = sc.nextLine();
		System.out.println("Introduce el passrword: ");
		String password = sc.nextLine();
		System.out.println("Introduce el valor del server: ");
		String server = sc.nextLine();
		System.out.println("Introduce el puerto: ");
		String puerto = sc.nextLine();
		System.out.println("Introduce la fecha: ");
		String fecha = sc.nextLine();
		System.out.println("¿Power?: (true/false)");
		String power = sc.nextLine();
		
		//añadir propiedades
		propiedadesConfiguracion.setProperty("user", user);
		propiedadesConfiguracion.setProperty("password", password);
		propiedadesConfiguracion.setProperty("server", server);
		propiedadesConfiguracion.setProperty("port", puerto);
		propiedadesConfiguracion.setProperty("date", fecha);
		propiedadesConfiguracion.setProperty("power", power);
		
		try {
			propiedadesConfiguracion.store(new FileOutputStream(Ejercicio3.RUTADATOS + FICHEROTRABAJO), "Fichero de configuracion");
		} catch(IOException e) {
			e.printStackTrace();
		}
			
	}
	
	// metodo para modificar la Condiguracion
	private static void modificarConfiguracion() {
		System.out.println("MODIFICANDO CONFIGURACIÓN");
		sc = new Scanner(System.in);
		System.out.println("Introduce el nombre del usuario: ");
		String user = sc.nextLine();
		System.out.println("Introduce el passrword: ");
		String password = sc.nextLine();
		System.out.println("Introduce el valor del server: ");
		String server = sc.nextLine();
		System.out.println("Introduce el puerto: ");
		int puerto = Integer.valueOf(sc.nextLine() + 1);
		System.out.println("Introduce nuevo mes de la fecha: ");
		int mes = Integer.valueOf(sc.nextLine());
		System.out.println("¿Power?: (true/false)");
		//Boolean power = Boolean.valueOf(sc.nextLine());
		
		
		try {
			propiedadesConfiguracion.load(new FileInputStream(Ejercicio3.RUTADATOS + FICHEROTRABAJO));
			
			propiedadesConfiguracion.setProperty("user", user);
			propiedadesConfiguracion.setProperty("password", password);
			propiedadesConfiguracion.setProperty("server", server);
			propiedadesConfiguracion.setProperty("port", String.valueOf(puerto));
			
			// meter un formato para la fecha
			 DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
			
		    // Parseo de la fecha con el formateador
		    LocalDate fechaOriginal = LocalDate.parse(propiedadesConfiguracion.getProperty("date"), formatter);
		    // Modificar el mes y volver a convertir a String
		    LocalDate nuevaFecha = fechaOriginal.withMonth(mes);
			    propiedadesConfiguracion.setProperty("date", nuevaFecha.format(formatter));
			    	    
			//cambio el valor del power
			propiedadesConfiguracion.setProperty("power", String.valueOf(!Boolean.valueOf(propiedadesConfiguracion.getProperty("power"))));
			propiedadesConfiguracion.store(new FileOutputStream(Ejercicio3.RUTADATOS+FICHEROTRABAJO), "Fichero de configuración");
			
		}catch(FileNotFoundException e) {
			e.printStackTrace();
		} catch(IOException e) {
			e.printStackTrace();
		}
		
	}
	

	private static void leerConfiguracion() {
		try {
			propiedadesConfiguracion.load(new FileInputStream(Ejercicio3.RUTADATOS + FICHEROTRABAJO));
			propiedadesConfiguracion.list(System.out);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
