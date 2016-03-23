package hu.danco.quiz;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Németh Dániel on 2016.03.23..
 */
public class XmlQuestionDAO implements QuestionDAO {

    private final String XML_FILE = "xml/Questions.xml";

    public List<Question> readQuestions() {
        try {
            List<Question> listQuestions = new ArrayList<>();

            InputStream is = this.getClass().getClassLoader().getResourceAsStream(XML_FILE);
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(is);

            doc.getDocumentElement().normalize();

            NodeList nList = doc.getElementsByTagName("question");
            
            for (int i = 0; i < nList.getLength(); i++) {
                Element eElement = (Element)nList.item(i);

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

    public List<Question> readQuestions(String theme) {
        return readQuestions().stream()
                .filter(x -> x.getTheme().equals(theme))
                .collect(Collectors.toList());
    }
}
