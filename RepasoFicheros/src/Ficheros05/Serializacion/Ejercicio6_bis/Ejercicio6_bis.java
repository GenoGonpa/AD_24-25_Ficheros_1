package Ficheros05.Serializacion.Ejercicio6_bis;

import Ficheros05.Serializacion.*;

public class Ejercicio6_bis {

	public Ejercicio6_bis() {

	}

    public static void main(String[] args) {
        // Inicializar el archivo y escribir 5 objetos Persona
        Ejercicio6.inicializar();
        
        for (int i = 0; i < 5; i++) {
            Persona persona = Ejercicio6.obtenerDatos(); // pedir datos al usuario
            Ejercicio6.escribirObjeto(persona); // escribir el objeto en el fichero
        }

        Ejercicio6.leerObjetos(); // leer los objetos del fichero
    }
}
