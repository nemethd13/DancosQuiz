package hu.danco.controllers;

import hu.danco.quiz.MainApp;

import hu.danco.quiz.Question;
import hu.danco.quiz.User;
import hu.danco.quiz.XmlUserDAO;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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

  private static final Logger logger = LoggerFactory.getLogger(GameController.class);


  XmlUserDAO rx = new XmlUserDAO("users.xml");
  List<User> jatekos = new ArrayList<>();

  private String helyes = "";

  private String chosen = "";

  public void initData() {
    stepQuestion();
  }

  private void stepQuestion() {

    Question q = MainApp.getGameManager().getNextQuestion();

    setLabels(q);
  }

  private void setLabels(Question q) {
    labelQuestion.setText(MainApp.getGameManager().getCurrentQuestionIndex() + ". " + q.getQuestion());
    rb1.setText(q.getAnswerA());
    rb2.setText(q.getAnswerB());
    rb3.setText(q.getAnswerC());
    rb4.setText(q.getAnswerD());
  }

  @FXML
  public void handleOption() {

    if (rb1.isSelected()) {
      chosen = rb1.getText();
    }
    if (rb2.isSelected()) {
      chosen = rb2.getText();
    }
    if (rb3.isSelected()) {
      chosen = rb3.getText();
    }
    if (rb4.isSelected()) {
      chosen = rb4.getText();
    }

    logger.trace("A játékos választott egy választ.");
  }

  @FXML
  void handleButtonNextClick() throws IOException {

    if (MainApp.getGameManager().isAnswerCorrect(chosen)) {

      logger.info("Helyes válasz");

      if (MainApp.getGameManager().getCurrentQuestionIndex() != 20) {
        stepQuestion();
        rb1.setSelected(false);
        rb2.setSelected(false);
        rb3.setSelected(false);
        rb4.setSelected(false);

      } else {
        MainApp.getGameManager().setCurrentUser(MainApp.getGameManager().getCurrentUserName(), MainApp.getGameManager().getCurrentQuestionIndex());
        jatekos.addAll(rx.getUsers());
        jatekos.add(MainApp.getGameManager().getCurrentUser());
        rx.persistUsers(jatekos);
        MainApp.getWindow().setScene(MainApp.getSceneWin());
      }

    } else {
      MainApp.getGameManager().setCurrentUser(MainApp.getGameManager().getCurrentUserName(), MainApp.getGameManager().getCurrentQuestionIndex() - 1);

      logger.info("Rossz válasz!");

      jatekos.addAll(rx.getUsers());
      jatekos.add(MainApp.getGameManager().getCurrentUser());
      rx.persistUsers(jatekos);

      helyes = MainApp.getGameManager().getRightAnswerWhenLoose();

      Stage stage;
      Parent root;

      stage = (Stage) buttonNext.getScene().getWindow();

      FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("fxml/SceneLose.fxml"));

      root = (Parent) loader.load();
      loader.<LoseController>getController().initData(helyes);

      Scene scene = new Scene(root);

      stage.setScene(scene);
      stage.show();
    }
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

}
