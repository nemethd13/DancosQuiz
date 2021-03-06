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
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
* Ez az osztály a UserDao interfész implementációja.
*<blockquote><pre>{@code
*A következő kódcsipetben az osztály minkét függvényének működése látható, szemléltető kód :
*
*XmlUserDAO xud = new XmlUserDAO("user.xml");
*ArrayList<User> lista = new ArrayList<>();
*lista = xud.getUsers();
*lista.add("ujNev", ujPont);
*xud.persistUsers(lista);
*
*Előszőr beolvastunk , majd kiírtunk az adatbázisba. }</pre></blockquote>
*/

public class XmlUserDAO implements UserDAO {

  private static final Logger logger = LoggerFactory.getLogger(XmlUserDAO.class);
  private static final Logger logger_two = LoggerFactory.getLogger(XmlUserDAO.class);

  /**
  * Egy konstans változó, az {@code xml} fájl élérési útjának tárolására.
  */

  private final String xmlFile;

  /**
  * Konstruktor egy {@code XmlQuestionDao} objektum létrehozására.
  *
  * @param xmlFile a feldolgozni kívánt {@code xml} fájl
  * elérési útvonala
  */

  public XmlUserDAO(String xmlFile) {
    this.xmlFile = xmlFile;
  }


  @Override
  public List<User> getUsers() {
    try {
      List<User> listUsers = new ArrayList<>();

      File is = new File(xmlFile);

      DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
      DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
      Document doc = dBuilder.parse(is);

      doc.getDocumentElement().normalize();

      NodeList nList = doc.getElementsByTagName("user");

      for (int i = 0; i < nList.getLength(); i++) {
        Element eElement = (Element) nList.item(i);

        listUsers.add(new User(eElement.getElementsByTagName("username").item(0).getTextContent(),
        Integer.parseInt(eElement.getElementsByTagName("questions").item(0).getTextContent())));
      }

      logger.trace("Felhasználók beolvasása megtörtént a " + xmlFile + " fájlból");

      return listUsers;

    } catch (Exception e) {

      logger_two.warn(" A fájl {} nem olvasható , nincsenek korábbi eredmények.", xmlFile);

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
      StreamResult result = new StreamResult(new File(xmlFile));


      // Output to console for testing
      transformer.transform(source, result);

      logger.trace("Adatok kiírása történt a " + xmlFile + " fájlba.");


    } catch (ParserConfigurationException pce) {
      pce.printStackTrace();
    } catch (TransformerException tfe) {
      tfe.printStackTrace();
    }
  }
}
