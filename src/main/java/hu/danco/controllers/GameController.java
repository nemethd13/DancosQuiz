package hu.danco.controllers;

import hu.danco.quiz.MainApp;

import hu.danco.quiz.Question;
import javafx.fxml.Initializable;

import java.awt.event.ActionEvent;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.VBox;
import sun.applet.Main;

public class GameController implements Initializable {
    @FXML
    private ResourceBundle resources;
    @FXML
    private URL location;
    @FXML
    private RadioButton rb1;
    @FXML
    private RadioButton rb3;
    @FXML
    private RadioButton rb2;
    @FXML
    private RadioButton rb4;
    @FXML
    private Button buttonNext;
    @FXML
    private ToggleGroup answersToggleGroup;
    @FXML
    private VBox panel;
    @FXML
    private Label labelQuestion;

    public void initData() {
       stepQuestion();
    }

    private void stepQuestion() {
        Question q = MainApp.gameManager.getNextQuestion();

        setLabels(q);
    }

    private void setLabels(Question q) {
        labelQuestion.setText(q.getQuestion());
        rb1.setText(q.getAnswerA());
        rb2.setText(q.getAnswerB());
        rb3.setText(q.getAnswerC());
        rb4.setText(q.getAnswerD());
        rb1.setSelected(false);
        rb2.setSelected(false);
        rb3.setSelected(false);
        rb4.setSelected(false);

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        assert rb1 != null : "fx:id=\"rb1\" was not injected: check your FXML file 'SceneGame.fxml'.";
        assert rb3 != null : "fx:id=\"rb3\" was not injected: check your FXML file 'SceneGame.fxml'.";
        assert rb2 != null : "fx:id=\"rb2\" was not injected: check your FXML file 'SceneGame.fxml'.";
        assert rb4 != null : "fx:id=\"rb4\" was not injected: check your FXML file 'SceneGame.fxml'.";
        assert buttonNext != null : "fx:id=\"buttonNext\" was not injected: check your FXML file 'SceneGame.fxml'.";
        assert answersToggleGroup != null : "fx:id=\"answersToggleGroup\" was not injected: check your FXML file 'SceneGame.fxml'.";
        assert panel != null : "fx:id=\"panel\" was not injected: check your FXML file 'SceneGame.fxml'.";

    }

    @FXML
    void handleButtonNextClick() {
        stepQuestion();
    }



}
