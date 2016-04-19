package hu.danco.controllers;


import java.net.URL;
import java.util.ResourceBundle;

import hu.danco.quiz.MainApp;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class LoseController implements Initializable {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Label rightAnswer;

    @FXML
    private Button buttonExit;

    @FXML
    private Label text;

    @FXML
    void handleExitButtonClick() {
        MainApp.window.close();
    }



    @Override
    public void initialize(URL location, ResourceBundle resources) {

        assert rightAnswer != null : "fx:id=\"rightAnswer\" was not injected: check your FXML file 'SceneLoose.fxml'.";
        assert buttonExit != null : "fx:id=\"buttonExit\" was not injected: check your FXML file 'SceneLoose.fxml'.";
        assert text != null : "fx:id=\"text\" was not injected: check your FXML file 'SceneLoose.fxml'.";
    }

    public void initData(String helyes) {
        if (rightAnswer != null) {
            rightAnswer.setText(helyes);
        }
    }
}