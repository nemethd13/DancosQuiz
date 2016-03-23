package hu.danco.controllers;

import hu.danco.quiz.Question;
import hu.danco.quiz.QuestionDAO;
import hu.danco.quiz.User;
import hu.danco.quiz.XmlQuestionDAO;
import javafx.scene.chart.XYChart;

import java.util.List;

/**
 * Created by Németh Dániel on 2016.03.23..
 */
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

    public void setCurrentUser(String name) {
        currentUser = new User(name, "0");
    }

    public void setCurrentCategory(String category) {
        currentCategory = category;

        questions = questionDAO.readQuestions(currentCategory);
    }

    public Question getNextQuestion() {
        if (currentQuestionIndex < questions.size()) {
            return questions.get(currentQuestionIndex++);
        }

        return null;
    }

    public boolean isAnswerCorrect(String answer) {
        return answer.equals(questions.get(currentQuestionIndex).getCorrect());
    }
}
