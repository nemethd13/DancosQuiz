package hu.danco.quiz;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;


public class XmlUserDAO implements UserDAO {
    private final String XML_FILE = "users.xml";

    @Override
    public List<User> getUsers() {
        try {
            List<User> listUsers = new ArrayList<>();

            File fXmlFile = new File(XML_FILE);

            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(fXmlFile);

            doc.getDocumentElement().normalize();

            NodeList nList = doc.getElementsByTagName("user");

            for (int i = 0; i < nList.getLength(); i++) {
                Element eElement = (Element) nList.item(i);

                listUsers.add(new User(eElement.getElementsByTagName("username").item(0).getTextContent(),
                        Integer.parseInt(eElement.getElementsByTagName("questions").item(0).getTextContent())));
            }

            return listUsers;
        } catch (Exception e) {
            e.printStackTrace();

            return new ArrayList<User>();
        }
    }

    @Override
    public void persistUsers(List<User> users) {
        try {
            DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docFactory.newDocumentBuilder();

            // root elements
            Document doc = docBuilder.newDocument();
            Element rootElement = doc.createElement("users");
            doc.appendChild(rootElement);

            // user elements
            for (int i = 0; i < users.size(); i++) {

                Element user = doc.createElement("user");
                rootElement.appendChild(user);

                Element userName = doc.createElement("username");
                userName.appendChild(doc.createTextNode(users.get(i).getUser()));
                user.appendChild(userName);

                // point elements
                Element point = doc.createElement("questions");
                point.appendChild(doc.createTextNode(Integer.toString(users.get(i).getPoint())));
                user.appendChild(point);
            }

            // write the content into xml file
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(new File(XML_FILE));

            // Output to console for testing
            // StreamResult result = new StreamResult(System.out);
            transformer.transform(source, result);

            System.out.println("File saved!");

        } catch (ParserConfigurationException pce) {
            pce.printStackTrace();
        } catch (TransformerException tfe) {
            tfe.printStackTrace();
        }
    }
}
