package hu.danco.controllers;

import hu.danco.quiz.MainApp;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import hu.danco.quiz.XmlUserDAO;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.net.URL;
import java.util.ResourceBundle;
/**
*A bejelentkezés {@code Scene}-jének a {@code Controller} osztálya.
*/
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
  private VBox errVBox;
  @FXML
  private TextField nameInput;
  @FXML
  private Label errorLabel;

  private static final Logger logger = LoggerFactory.getLogger(LoginController.class);

  /**
  *handleButtonStartClick() függvény.
  */


  @FXML
  void handleButtonStartClick() {

    if (!nameInput.getText().equals("")) {

      MainApp.getGameManager().setCurrentUser(nameInput.getText(),0);

      logger.info(nameInput.getText() + " nevű játékos bejelentkezett.");

      MainApp.getWindow().setScene(MainApp.getSceneChooseCategory());

    } else {

      errorLabel.setText("Légyszíves add meg a neved!");

      logger.warn("A továbblépéshez meg kell adnod egy felhasználó nevet!");
    }

  }

  /**
  *initialize() függvény.
  */

  @Override
  public void initialize(URL location, ResourceBundle resources) {

    assert txt2 != null : "fx:id=\"txt2\" was not injected: check your FXML file 'SceneLogIn.fxml'.";
    assert txt1 != null : "fx:id=\"txt1\" was not injected: check your FXML file 'SceneLogIn.fxml'.";
    assert buttonStart != null : "fx:id=\"buttonStart\" was not injected: check your FXML file 'SceneLogIn.fxml'.";
    assert panel != null : "fx:id=\"panel\" was not injected: check your FXML file 'SceneLogIn.fxml'.";
    assert nameInput != null : "fx:id=\"nameInput\" was not injected: check your FXML file 'SceneLogIn.fxml'.";

  }

}
