package Ficheros09.Xml_DOM;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Text;

import Ficheros02.Texto.Ejercicio3;

public class Ejercicio10 {
	
	public final static String FICHEROTRABAJO = "Ejercicio10.xml";

	public static void main(String[] args) {


		try {
			DocumentBuilderFactory dBf = DocumentBuilderFactory.newInstance();
			DocumentBuilder dB = dBf.newDocumentBuilder();
			Document doc = dB.newDocument(); // SE ESTÁ CREANDO EN MEMORIA
			
			//CREAMOS LOS NODOS
			Element raiz = doc.createElement("raiz");
			Element hijo_1 = doc.createElement("hijo");
			Element hijo_2 = doc.createElement("hijo");
			
			// CONTENIDO DE LOS HIJOS
			Text contenidoH1 = doc.createTextNode("Soy el contenido del primer hijo");
			Text contenidoH2 =doc.createTextNode("Soy el contenido del segundo hijo");
			
			//CONSTRUIMOS EL ARBOL AÑADIENDO LOS NODOS EN MEMORIA
			doc.appendChild(raiz);
			raiz.appendChild(hijo_1);
			raiz.appendChild(hijo_2);
			hijo_1.appendChild(contenidoH1);
			//AÑADIR ATRIBUTO
			hijo_1.setAttribute("name", "alfonso");
			hijo_2.appendChild(contenidoH2);
			
			
			// HACEMOS EL ARBOL PERSISTENTE. PASAMOS EL DOCUMENTO DOM DE MEMORIA A UN FICHERO FISICO			
			//CREAR EL TRANSFORMADOR
			TransformerFactory tF = TransformerFactory.newInstance();
			Transformer t = tF.newTransformer();
			t.transform(new DOMSource(doc), new StreamResult(new File(Ejercicio3.RUTADATOS + FICHEROTRABAJO))); // SE LE PASA UN ORIGEN Y UN DESTINO (EN ESTE CASO LA SALIDA POR CONSOLA)
					
			
		} catch (ParserConfigurationException | TransformerException e) {

			e.printStackTrace();
		}
		
	}

}
