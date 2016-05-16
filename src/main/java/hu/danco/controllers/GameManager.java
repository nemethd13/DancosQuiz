package hu.danco.controllers;

import hu.danco.quiz.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.ArrayList;
import java.util.List;

/**
 *Ez az osztály magát az applikációt, a játék menetét menedzseli.
 *
 *
 *
 */

public class GameManager {

    private final String QUESTION_XML_FILE = "xml/Questions.xml";

    private User currentUser = null;
    private String currentCategory;
    private QuestionDAO questionDAO;
    private List<Question> questions;
    private int currentQuestionIndex;

    /**
     *Konstruktor egy {@code GameManeger} létrehozására.
     *Példányosít egy {@code XmlQuestionDAO} objektumot
     * a kérdések beolvasásához , illetve inicializálja
     * az aktuális kérdés számot ,amit később arra használ,
     * hogy tudja, hogy hol jár éppen a játék.
     */

    public GameManager() {
        questionDAO = new XmlQuestionDAO(QUESTION_XML_FILE);

        currentQuestionIndex = 0;
    }

    /**
     * Beállítja az aktuális játékos adatait.
     *
     * @param name a játékos neve
     * @param point a helyesen megválaszolt kérdések darabszáma
     */

    public void setCurrentUser(String name, int point) {
        currentUser = new User(name, point);
    }

    /**
     * Visszaadja az aktuális , éppen játékban lévő
     * játékos nevét.
     *
     * @return aktuális játékos neve
     */

    public String getCurrentUserName() {
        return currentUser.getUser();
    }

    /**
     * Vissza adja az aktuális játkost , {@code User} objektumként.
     *
     * @return aktualis {@code User} objektum
     */

    public User getCurrentUser() {
        return currentUser;
    }

    /**
     * Beolvassa a paraméterként kapott témájú kérdéseket
     * és az osztály {@code question} nevű listájába tárolja.
     *
     * @param category beolvasni kívánt kategória
     */

    public void setCurrentCategory(String category) {
        currentCategory = category;

        questions = questionDAO.readQuestions(currentCategory);
    }

    /**
     * Visszaadja az aktuális kérdéshez tartozó helyes választ.
     *
     * @return aktuális helyes válasz
     */

    public String getRightAnswerWhenLoose() {
        return questions.get(currentQuestionIndex - 1).getCorrect();
    }

    /**
     * Visszaadja a soron következő kérdést , ezt mintaddig
     * amig az aktuális kérdés indexe ({@code currentQuestionIndex})
     * kisebb mint az összes kérdés száma. Ha ez a <em>feltétel</em>
     * nem teljesül akkor a függvény <em>null</em> értékkel tér vissza.
     *
     * @return a soron következő kérdés vagy null
     */

    public Question getNextQuestion() {
        if (currentQuestionIndex < questions.size()) {
            return questions.get(currentQuestionIndex++);
        }

        return null;
    }

    /**
     * Eldönti , hogy a paraméterként kapott válasz-e
     * a helyes válasz a hozzá tartozó kérdésre.
     *
     * @param answer a vizsgálandó válasz
     *
     * @return true , ha a vizsgálandó válasz a helyes válasz
     */

    public boolean isAnswerCorrect(String answer) {
        return answer.equals(questions.get(currentQuestionIndex - 1).getCorrect());
    }

    /**
     * Azt aktuális kérdés számát adja vissza.
     *
     * @return aktuális kérdés száma
     */
    public int getCurrentQuestionIndex() {
        return currentQuestionIndex;
    }

    /**
     * Visszaad egy {@code User} objektumokat tartalmazó
     * {@code ObservableList}-et ami az eredményeknél a
     * {@code TableView} feltöltéséhez szükséges.
     *
     * @return {@code User} objektumokat tartalmazó {@code ObservableList}
     */

    public ObservableList<User> getResults() {
        XmlUserDAO xu = new XmlUserDAO("users.xml");
        List<User> lista = new ArrayList<>();

        lista = xu.getUsers();
        ObservableList<User> results = FXCollections.observableArrayList();
        for (User vmi : lista) {
            results.add(vmi);
        }

        return results;
    }
}
