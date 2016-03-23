package hu.danco.controllers;

import hu.danco.quiz.MainApp;

import hu.danco.quiz.MainApp;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

import java.net.URL;
import java.util.ResourceBundle;


public class WelcomeController implements Initializable {
    @FXML
    private ResourceBundle resources;
    @FXML
    private URL location;
    @FXML
    private Button buttonResults;
    @FXML
    private Button buttonGame;

    @FXML
    void handleButtonGameAction(ActionEvent event) {
        System.out.println("start");
        MainApp.window.setScene(MainApp.SceneLogIn);
    }

    @FXML
    void handleButtonResultsAction(ActionEvent event){
        System.out.println("eredmények");
        MainApp.window.setScene(MainApp.SceneResults);
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
