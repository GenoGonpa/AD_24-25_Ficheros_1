package Ficheros05.Serializacion;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;


public class Persona implements Serializable { //serialverison UI te pondrá el que quiera al generarla por eso hay que estandalizarlo para poder usarlo en otro pc y el compilador no error. Se getistra en la cabeza del fichero

    private static final long serialVersionUID = 8L; 
    /**
     * Este campo es un identificador único que asegura que los objetos serializados puedan ser deserializados correctamente, 
     * incluso si la clase cambia ligeramente en el futuro. Al tener un valor fijo (8L), 
     * estás asegurando que las versiones de la clase entre diferentes máquinas o compiladores sean compatibles.
     **/

    private StringBuilder  nombre;
    private StringBuilder  apellido1;
    private StringBuilder  apellido2;
    private Date nacimiento;

    public Persona() {
        super();
    }

    public Persona(StringBuilder nombre, StringBuilder apellido1, StringBuilder apellido2, Date nacimiento) {
        super();
        this.nombre = nombre;
        this.apellido1 = apellido1;
        this.apellido2 = apellido2;
        this.nacimiento = nacimiento;
    }
    @Override
    public String toString() {
        return apellido1 + " " + apellido2 + ", " + nombre + "(" + new SimpleDateFormat("dd-MM-yyyy").format(nacimiento) + ") ";
    }
    public StringBuilder getNombre() {
        return nombre;
    }
    public void setNombre(StringBuilder nombre) {
        this.nombre = nombre;
    }
    public StringBuilder getApellido1() {
        return apellido1;
    }
    public void setApellido1(StringBuilder apellido1) {
        this.apellido1 = apellido1;
    }
    public StringBuilder getApellido2() {
        return apellido2;
    }
    public void setApellido2(StringBuilder apellido2) {
        this.apellido2 = apellido2;
    }
    public Date getNacimiento() {
        return nacimiento;
    }
    public void setNacimiento(Date nacimiento) {
        this.nacimiento = nacimiento;
    }

}