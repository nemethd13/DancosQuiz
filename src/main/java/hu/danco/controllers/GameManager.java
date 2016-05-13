package hu.danco.controllers;

import hu.danco.quiz.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.ArrayList;
import java.util.List;

public class GameManager {

    private final String QUESTION_XML_FILE = "xml/Questions.xml";
    
    private User currentUser = null;
    private String currentCategory;
    private QuestionDAO questionDAO;
    private List<Question> questions;
    private int currentQuestionIndex;

    public GameManager() {
        questionDAO = new XmlQuestionDAO(QUESTION_XML_FILE);

        currentQuestionIndex = 0;
    }

    public void setCurrentUser(String name, int point) {
        currentUser = new User(name, point);
    }

    public String getCurrentUserName() {
        return currentUser.getUser();
    }

    public User getCurrentUser() {
        return currentUser;
    }

    public void setCurrentCategory(String category) {
        currentCategory = category;

        questions = questionDAO.readQuestions(currentCategory);
    }

    public String getRightAnswerWhenLoose() {
        return questions.get(currentQuestionIndex - 1).getCorrect();
    }

    public Question getNextQuestion() {
        if (currentQuestionIndex < questions.size()) {
            return questions.get(currentQuestionIndex++);
        }

        return null;
    }

    public boolean isAnswerCorrect(String answer) {
        return answer.equals(questions.get(currentQuestionIndex - 1).getCorrect());
    }

    public int getCurrentQuestionIndex() {
        return currentQuestionIndex;
    }

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
