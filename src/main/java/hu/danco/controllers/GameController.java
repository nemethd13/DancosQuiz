package hu.danco.controllers;

import hu.danco.quiz.MainApp;

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

public class GameController implements Initializable {

//    ReadXMLFile rx = new ReadXMLFile();
    @FXML
    private ResourceBundle resources;
    @FXML
    private URL location;
    @FXML
    static RadioButton rb1;
    @FXML
    static RadioButton rb3;
    @FXML
    static RadioButton rb2;
    @FXML
    static RadioButton rb4;
    @FXML
    private Button buttonNext;
    @FXML
    private ToggleGroup answersToggleGroup;
    @FXML
    private VBox panel;
    @FXML
    public Label labelQuestion;

    String sq ;

//    ControllerOfSceneChooseCategory c = new ControllerOfSceneChooseCategory();

    public int currentQuestion = 0;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
//        Main.rx.readQuestions();
       // labelQuestion.setText(Main.rx.listQuestions.get(0).getQuestion());

        assert rb1 != null : "fx:id=\"rb1\" was not injected: check your FXML file 'SceneGame.fxml'.";
        assert rb3 != null : "fx:id=\"rb3\" was not injected: check your FXML file 'SceneGame.fxml'.";
        assert rb2 != null : "fx:id=\"rb2\" was not injected: check your FXML file 'SceneGame.fxml'.";
        assert rb4 != null : "fx:id=\"rb4\" was not injected: check your FXML file 'SceneGame.fxml'.";
        assert buttonNext != null : "fx:id=\"buttonNext\" was not injected: check your FXML file 'SceneGame.fxml'.";
        assert answersToggleGroup != null : "fx:id=\"answersToggleGroup\" was not injected: check your FXML file 'SceneGame.fxml'.";
        assert panel != null : "fx:id=\"panel\" was not injected: check your FXML file 'SceneGame.fxml'.";
        //assert labelQuestion != null : "fx:id=\"labelQuestion\" was not injected: check your FXML file 'SceneGame.fxml'.";
//        rx.readQuestions();
//        System.out.println(rx.listQuestions.get(0).getAnswerA());
    }

    @FXML
    void handleButtonNextClick() {

//                rx.readQuestions();
//        System.out.println(rx.listQuestions.get(0).getAnswerA());

//        rx.readQuestions();
//        labelQuestion.setText(rx.listQuestions.get(0).getQuestion());

//        String answer="Nem választottál";
//
//        if(rb1.isSelected()){
//            answer = rb1.getText();
//        }
//        if(rb2.isSelected()){
//            answer = rb2.getText();
//        }
//        if(rb3.isSelected()){
//            answer = rb3.getText();
//        }
//        if(rb4.isSelected()){
//            answer = rb4.getText();
//        }
//
//
//        //rx.readQuestions();
//
//        if( answer.equals(rx.listQuestions.get(currentQuestion).getCorrect())){
//            currentQuestion = currentQuestion + 1;
//        }
//
//
//        labelQuestion.setText(rx.listQuestions.get(currentQuestion).getQuestion());
//        rb1.setText(rx.listQuestions.get(currentQuestion).getAnswerA());
//        rb2.setText(rx.listQuestions.get(currentQuestion).getAnswerB());
//        rb3.setText(rx.listQuestions.get(currentQuestion).getAnswerC());
//        rb4.setText(rx.listQuestions.get(currentQuestion).getAnswerD());
//
//
//        rb1.setSelected(false);
//        rb2.setSelected(false);
//        rb3.setSelected(false);
//        rb4.setSelected(false);

        //Main.window.setScene(Main.SceneLoose);
    }



}
