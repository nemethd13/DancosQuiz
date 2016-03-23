package hu.danco.controllers;

import hu.danco.quiz.MainApp;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.net.URL;
import java.util.ResourceBundle;

public class LoginController implements Initializable {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Text txt2;

    @FXML
    private Text txt1;

    @FXML
    private Button buttonStart;

    @FXML
    private Pane panel;

    @FXML
    private TextField nameInput;

    @FXML
    void handleButtonStartClick() {
        MainApp.window.setScene(MainApp.SceneChooseCategory);
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        assert txt2 != null : "fx:id=\"txt2\" was not injected: check your FXML file 'SceneLogIn.fxml'.";
        assert txt1 != null : "fx:id=\"txt1\" was not injected: check your FXML file 'SceneLogIn.fxml'.";
        assert buttonStart != null : "fx:id=\"buttonStart\" was not injected: check your FXML file 'SceneLogIn.fxml'.";
        assert panel != null : "fx:id=\"panel\" was not injected: check your FXML file 'SceneLogIn.fxml'.";
        assert nameInput != null : "fx:id=\"nameInput\" was not injected: check your FXML file 'SceneLogIn.fxml'.";
    }


}
