package Ficheros05.Serializacion;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

public class MyObjectOutputStream extends ObjectOutputStream {

    public MyObjectOutputStream(OutputStream out) throws IOException {
        super(out);
    }

    @Override// hay que crear este constructor pero vacío. HAY QUE BORRAR SU CONTENIDO
    protected void writeStreamHeader() throws IOException {
    }
}