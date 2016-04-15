package hu.danco.controllers;

import hu.danco.quiz.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.chart.XYChart;

import java.util.ArrayList;
import java.util.List;


public class GameManager {

    private User currentUser = null;

    private String currentCategory;

    private QuestionDAO questionDAO;

    private List<Question> questions;

    private int currentQuestionIndex;

    public GameManager() {
        questionDAO = new XmlQuestionDAO();

        currentQuestionIndex = 0;
    }

    public void setCurrentUser(String name , int point) {
        currentUser = new User(name, point);
    }

    public String getCurrentUserName() {
        return currentUser.getUser();
    }

    public int getCurrentPoint() {
        return currentUser.getPoint();
    }

    public User getCurrentUser() {
        return currentUser;
    }

    public void setCurrentCategory(String category) {
        currentCategory = category;

        questions = questionDAO.readQuestions(currentCategory);
    }

    public String getCurrentRightAnswer() {
        return questions.get(currentQuestionIndex).getCorrect();
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

    public ObservableList<User> getResults (){
        XmlUserDAO xu = new XmlUserDAO();
        List<User> lista = new ArrayList<>();

        lista = xu.getUsers();
        ObservableList<User> results = FXCollections.observableArrayList();
        for(User vmi : lista){
            results.add(vmi);
        }

        return results;
    }
}
