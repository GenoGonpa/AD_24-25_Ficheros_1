package Ficheros05.Serializacion;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;
import Ficheros02.Texto.Ejercicio3;

public class Ejercicio6 {

	public static Scanner sn = new Scanner(System.in);
	public final static String DATOSFILEOUT = "FicheroSerializaPersonas.dat";
	public static ObjectOutputStream oOS;

	// voy a comprobar si ya hay datos para ello, miro si hay cabeceras por eso se
	// usa una u otra
	public static void inicializar() {
		try {
			File file = new File(Ejercicio3.RUTADATOS + DATOSFILEOUT);
			if (file.exists() && file.length() > 0) { // significa que tiene dato el mayor de 0
				oOS = new MyObjectOutputStream(new FileOutputStream(file, true));
			} else {
				oOS = new ObjectOutputStream(new FileOutputStream(file, true));
			}
		} catch (FileNotFoundException e) {
			System.out.println("No se encuentra el fichero");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("Error de entrada/salida");
			e.printStackTrace();
		}
	}

	public static Persona obtenerDatos() { // metodo para obtener datos de los objetos persona
		Persona persona = new Persona();
		System.out.println("DATOS DE USUARIO:");
		System.out.println("\tNombre:");
		persona.setNombre(new StringBuilder(sn.nextLine()));
		System.out.println("\tPrimer Apellido:");
		persona.setApellido1(new StringBuilder(sn.nextLine()));
		System.out.println("\tSegundo Apellido:");
		persona.setApellido2(new StringBuilder(sn.nextLine()));
		System.out.println("\tFecha de Nacimiento (dd-MM-yyyy):");
		try {
			persona.setNacimiento(new SimpleDateFormat("dd-MM-yyyy").parse(sn.nextLine()));
		} catch (ParseException e) {
			System.out.println("erorr");
		}
		return persona;
	}

	public static void escribirObjeto(Persona persona) {
		try {
			// TODO revisar
			oOS.writeObject(persona);
			// oOS.close();
			// sn.close();
		} catch (FileNotFoundException e) {
			System.out.println("Fichero no encontrado");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("Error de escritura");
			e.printStackTrace();
		}
	}

	public static void leerObjetos() {
		try {

			ObjectInputStream oIS = new ObjectInputStream(
					new FileInputStream(new File(Ejercicio3.RUTADATOS + DATOSFILEOUT)));
			try {
				while (true) {
					System.out.print((Persona) oIS.readObject());
				}
			} catch (ClassNotFoundException e) {
				System.out.println("Error de lectura");
				e.printStackTrace();
			} finally {
				oIS.close();
			}
		} catch (EOFException e) {

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public static void main(String[] args) {
		// Escribir objetos
		inicializar();
		escribirObjeto(obtenerDatos());
		escribirObjeto(obtenerDatos());

		// Cerrar el ObjectOutputStream una vez terminada la escritura
		try {
			oOS.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

		// Leer objetos
		leerObjetos();
	}
}
