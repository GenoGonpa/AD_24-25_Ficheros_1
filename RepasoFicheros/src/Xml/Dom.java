package Xml;

import static org.w3c.dom.Node.ELEMENT_NODE;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;


import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import Ficheros02.Texto.Ejercicio3;

public class Dom {
	
	public final static String FICHEROTRABAJO = "ms.xml";

	public static void main(String[] args) {
		
		Path path = Path.of(Ejercicio3.RUTADATOS + FICHEROTRABAJO);

		File xml = path.toFile();
		
		try {
			
			/* ### PRIMEROS PASOS DE CONFIGURACION ### */
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance(); //SINGLETON, SOLO TIENES UNA INSTANCIA EN TU CODIGO
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document document = builder.parse(xml);
			
			/*### TRATAR EL FIICHERO ###*/
			
			/* EJEMPLO 1: QUIERO RECUPERAR TODOS LOS NOMBRES. PRIMERO BUSCAR LOS ELEMENTOS QUE TIENEN TODOS EN COMÚN, EJM "TESTS"*/
			NodeList listaInicial = document.getElementsByTagName("Tests").item(0).getChildNodes(); // SACAR LOS NODOS HIJOS POSICIONANDO EN EL PRIMER ELEMENTO (RAIZ)
			for (int i= 0; i<= listaInicial.getLength(); i++) {		
				Node node = listaInicial.item(i);
				if(node.getNodeType() == ELEMENT_NODE) {
					//SACAR TODA LA INFORMACION
					switch(node.getNodeName()){
						case "Test":
							//SACAR EL ATRIBUTO
							String atrId= node.getAttributes().getNamedItem("TestId").getNodeValue(); // DEVOLVERA TODA LA LISTA DE ATRIBUTOS
							String atrType = node.getAttributes().getNamedItem("TestType").getNodeValue(); 
							System.out.print(node.getNodeName()+ "\t-\t" + atrId + "\t-\t" + atrType);
							System.out.println();
							
							//LLAMAMOS A SUS HIJOS
							NodeList listaHijos = node.getChildNodes();
							for (int j = 0; j < listaHijos.getLength(); j++) {
								
								Node nodeHijo = listaHijos.item(j);
								if(nodeHijo.getNodeType() == Node.ELEMENT_NODE) {
									
									/*SI SOLO QUISIERAMOS MOSTRAR LA INFORMACION DE UN HIJO
									 * switch(nodeHijo.getNodeName(){
									 *  case "Name": // COMO NO TIENE UN BREAK NOS ACCEDERÁ A AMBOS 
									 * 	case "CommandLine":
									 *		System.out.println("\t" + nodeHijo.getNodeName() + "--> " + nodeHijo.getChildNodes().item(0).getNodeValue());
									 *		break;
									 * */
									
									System.out.println("\t" + nodeHijo.getNodeName() + "--> " + nodeHijo.getChildNodes().item(0).getNodeValue());
								}
							}
							
							
						break;
					}
	
					}
				System.out.println();
			}
			
		} catch (ParserConfigurationException | SAXException | IOException e) {
			System.out.println(e.getMessage());
			System.exit(-1);

		}

	}

}
