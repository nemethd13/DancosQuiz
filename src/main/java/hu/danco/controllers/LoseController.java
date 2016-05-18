package hu.danco.controllers;

import java.net.URL;
import java.util.ResourceBundle;

import hu.danco.quiz.MainApp;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

/**
*Az applikáció befejezés {@code Scene}-jének a {@code Controller} osztálya.
*/

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

  /**
  *handleExitButtonClick() függvény.
  */

  @FXML
  void handleExitButtonClick() {
    MainApp.getWindow().close();
  }

  /**
  *initData() függvény.
  *
  *@param helyes helyes válasz
  */
  public void initData(String helyes) {
    if (rightAnswer != null) {
      rightAnswer.setText(helyes);
    }
  }

  /**
  *initialize() függvény.
  */
  @Override
  public void initialize(URL location, ResourceBundle resources) {

    assert rightAnswer != null : "fx:id=\"rightAnswer\" was not injected: check your FXML file 'SceneLose.fxml'.";
    assert buttonExit != null : "fx:id=\"buttonExit\" was not injected: check your FXML file 'SceneLose.fxml'.";
    assert text != null : "fx:id=\"text\" was not injected: check your FXML file 'SceneLose.fxml'.";
  }

}
