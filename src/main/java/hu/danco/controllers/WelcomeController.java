package hu.danco.controllers;

import hu.danco.quiz.MainApp;

import hu.danco.quiz.MainApp;
import hu.danco.quiz.User;
import hu.danco.quiz.XmlUserDAO;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
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
    MainApp.getWindow().setScene(MainApp.getSceneLogIn());
  }

  @FXML
  void handleButtonResultsAction(ActionEvent event) {

    MainApp.getWindow().setScene(MainApp.getSceneResults());
  }

  @Override
  public void initialize(URL location, ResourceBundle resources) {

  }
}
