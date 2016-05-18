package hu.danco.quiz;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
* Ez az osztály a QuestionDAO interfész implementációja.
*<blockquote><pre>{@code
*Egy kis működést szemléltető kód :
*
*XmlQuestionDAO xqd = new XmlQuestionDAO("Questions.xml");
*List<Question> lista = new ArrayList<>();
*lista = xqd.readQuestions();}</pre></blockquote>
*
*Minimális különbség van ha téma szerint szeretnénk beolvasni a kérdéseket , kód itt:
*
*<blockquote><pre>{@code
*XmlQuestionDAO xqd = new XmlQuestionDAO("Questions.xml");
*List<Question> lista = new ArrayList<>();
*lista = xqd.readQuestions("Biológia");}</pre></blockquote>
*
*Ilyenkor a  lista csak a paraméterűl kapott Biológia témájú kérdéseket fogja csak tartalmazni.
*/

public class XmlQuestionDAO implements QuestionDAO {

  private static final Logger logger = LoggerFactory.getLogger(XmlQuestionDAO.class);
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
  public XmlQuestionDAO(String xmlFile) {
    this.xmlFile = xmlFile;
  }

  @Override
  public List<Question> readQuestions() {
    try {
      List<Question> listQuestions = new ArrayList<>();

      InputStream is = this.getClass().getClassLoader().getResourceAsStream(xmlFile);
      DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
      DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
      Document doc = dBuilder.parse(is);

      doc.getDocumentElement().normalize();

      NodeList nList = doc.getElementsByTagName("question");

      for (int i = 0; i < nList.getLength(); i++) {
        Element eElement = (Element) nList.item(i);

        listQuestions.add(new Question(eElement.getElementsByTagName("theme").item(0).getTextContent(),
        eElement.getElementsByTagName("quest").item(0).getTextContent(),
        eElement.getElementsByTagName("ansA").item(0).getTextContent(),
        eElement.getElementsByTagName("ansB").item(0).getTextContent(),
        eElement.getElementsByTagName("ansC").item(0).getTextContent(),
        eElement.getElementsByTagName("ansD").item(0).getTextContent(),
        eElement.getElementsByTagName("correct").item(0).getTextContent()));
      }


      return listQuestions;
    } catch (Exception e) {
      e.printStackTrace();

      return null;
    }
  }

  @Override
  public List<Question> readQuestions(String theme) {
    logger.trace("Kérdések beolvasása megtörtént!");
    return readQuestions().stream()
    .filter(x -> x.getTheme().equals(theme))
    .collect(Collectors.toList());
  }
}
