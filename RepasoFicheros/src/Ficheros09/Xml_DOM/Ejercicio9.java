package Ficheros09.Xml_DOM;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import Ficheros02.Texto.Ejercicio3;

public class Ejercicio9 {
	
	public final static String FICHEROTRABAJO = "Ejercicio09.xml";
	

	public static void main(String[] args) {
	
		
		try {
			
			// CREAR DOCUMENTO EN MEMORIA
			DocumentBuilderFactory dBf = DocumentBuilderFactory.newInstance();
			DocumentBuilder dB = dBf.newDocumentBuilder();
			Document doc = dB.parse(new File(Ejercicio3.RUTADATOS + FICHEROTRABAJO));
			
			//CREAR EL TRANSFORMADOR
			TransformerFactory tF = TransformerFactory.newInstance();
			Transformer t = tF.newTransformer();
			t.transform(new DOMSource(doc), new StreamResult(System.out)); // SE LE PASA UN ORIGEN Y UN DESTINO (EN ESTE CASO LA SALIDA POR CONSOLA)
			
			
			// PARA PASAR UN XML DE UNA URL
//			System.out.println("DOCUMENTO WEB");
//			URL url = new URL("https://acortar.link/dO4FNx");
			
			URL url = new URI("https://acortar.link/dO4FNx").toURL();
			Document docWeb = dB.parse(url.openStream());
			
			t.transform(new DOMSource(docWeb), new StreamResult(System.out)); // SE LE PASA LA URL A LEER COMO ORIGEN, DESTINO DE NUEVO CONSOLA
			
		} catch (ParserConfigurationException  | SAXException | IOException | TransformerException | URISyntaxException e) {
			e.printStackTrace();
		}
		
	}

}
