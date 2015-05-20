package nl.windesheim.kbsm2.opc01.asrs;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by Berry on 16-4-2015.
 * snatched by Rob on 17-4-2015.
 */
public class XMLReader {

    public static void readXML(File xmlFile) throws ParserConfigurationException, IOException, SAXException, ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
        Document doc = dBuilder.parse(xmlFile);
        doc.getDocumentElement().normalize();

        NodeList nListArtikel = doc.getElementsByTagName("artikelnr");
        ArrayList<Integer> artikelNRs = new ArrayList<>();
        for (int i = 0; i < nListArtikel.getLength(); i++) {
            Node node = nListArtikel.item(i);
            artikelNRs.add(Integer.valueOf(node.getTextContent()));
        }

        String ordernummer = doc.getElementsByTagName("ordernummer").item(0).getTextContent();

        NodeList nListKlant = doc.getElementsByTagName("klant");
        String voornaam = null;
        String achternaam = null;
        String adres = null;
        String postcode = null;
        String plaats = null;
        Node klantNode = nListKlant.item(0);
        NodeList childNodes = klantNode.getChildNodes();
        for (int i = 0; i < childNodes.getLength(); i++) {
            Node item = childNodes.item(i);
            if (item.getNodeName().equals("voornaam")) {
                voornaam = item.getTextContent();
            } else if (item.getNodeName().equals("achternaam")) {
                achternaam = item.getTextContent();
            } else if (item.getNodeName().equals("adres")) {
                adres = item.getTextContent();
            } else if (item.getNodeName().equals("postcode")) {
                postcode = item.getTextContent();
            } else if (item.getNodeName().equals("plaats")) {
                plaats = item.getTextContent();
            }
        }
        Klant klant = new Klant(voornaam, achternaam, adres, postcode, plaats);
        Order order = new Order(Integer.valueOf(ordernummer), klant, artikelNRs);
        order.toString();
        
        int ordernr = Integer.valueOf(ordernummer);
        
        DatabaseCon con = new DatabaseCon();
        con.InsertOrder(klant, artikelNRs, ordernr);
    }
}
