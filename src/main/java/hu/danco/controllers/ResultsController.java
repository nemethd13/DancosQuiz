package hu.danco.controllers;

import hu.danco.quiz.MainApp;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.Pane;

import java.net.URL;
import java.util.ResourceBundle;

public class ResultsController implements Initializable {

    @FXML
    private ResourceBundle resources;
    @FXML
    private URL location;
    @FXML
    private TableColumn<?, ?> firstColumn;
    @FXML
    private TableColumn<?, ?> secondColumn;
    @FXML
    private Pane panel;
    @FXML
    private TableView<?> table;
    @FXML
    private Button buttonBack;
    @FXML

    void handleButtonBackClick() {
        MainApp.window.setScene(MainApp.SceneWelcome);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        assert firstColumn != null : "fx:id=\"firstColumn\" was not injected: check your FXML file 'SceneResults.fxml'.";
        assert secondColumn != null : "fx:id=\"secondColumn\" was not injected: check your FXML file 'SceneResults.fxml'.";
        assert panel != null : "fx:id=\"panel\" was not injected: check your FXML file 'SceneResults.fxml'.";
        assert table != null : "fx:id=\"table\" was not injected: check your FXML file 'SceneResults.fxml'.";
        assert buttonBack != null : "fx:id=\"buttonBack\" was not injected: check your FXML file 'SceneResults.fxml'.";
    }
}
