package Ficheros05.Serializacion.Ejercicio6_bis;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Date;
import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;

import Ficheros02.Texto.Ejercicio3;
import Ficheros05.Serializacion.*;

public class Ejercicio6_bis_copiar {

    private final static String DATOSFILEV2 = "datosPersonasv2.dat";
    public static ObjectOutputStream oOSv2;

    
    public static void inicilizar_v2() {
        try {
            File file = new File(Ejercicio3.RUTADATOS + DATOSFILEV2);
            if (file.exists() && file.length() > 0) {
                oOSv2 = new MyObjectOutputStream(new FileOutputStream(file, true));
            } else {
                oOSv2 = new ObjectOutputStream(new FileOutputStream(file, true));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    // convertir persona 
    public static void convertirPersonas() {
        try (ObjectInputStream oIS = new ObjectInputStream(new FileInputStream(new File(Ejercicio3.RUTADATOS + Ejercicio6.DATOSFILEOUT)))) {
            inicilizar_v2();
            try {
                while (true) {
                    Persona persona = (Persona) oIS.readObject();
                    // Convertir Persona a Persona_v2
                    Persona_v2 personaV2 = new Persona_v2(persona.getNombre(), persona.getApellido1(), persona.getApellido2(), calcularEdad(persona.getNacimiento()));
                    oOSv2.writeObject(personaV2); // Escribir el objeto convertido
                }
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        } catch (EOFException e) {
            // Fin del archivo, no se necesita imprimir nada
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (oOSv2 != null) {
                    oOSv2.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    // método para calcular la edad
    public static int calcularEdad(Date nacimiento) {
        LocalDate fechaNac = nacimiento.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        LocalDate ahora = LocalDate.now();
        return Period.between(fechaNac, ahora).getYears();
    }
    
    // para leer los objetos
    public static void leerObjetos() {
        try (ObjectInputStream oIS = new ObjectInputStream(new FileInputStream(new File(Ejercicio3.RUTADATOS + DATOSFILEV2)))) {
            try {
                while (true) {
                    Persona_v2 personaV2 = (Persona_v2) oIS.readObject(); // leer como Persona_v2
                    System.out.print(personaV2);
                }
            } catch (ClassNotFoundException e) {
                System.out.println("Error de lectura");
                e.printStackTrace();
            }
        } catch (EOFException e) {
        	 e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    
    public static void main(String[] args) {
        convertirPersonas();
        leerObjetos();
    }
}
