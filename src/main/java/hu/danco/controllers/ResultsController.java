package hu.danco.controllers;

import hu.danco.quiz.MainApp;

import hu.danco.quiz.User;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;

import java.net.URL;
import java.util.ResourceBundle;

public class ResultsController implements Initializable {

    @FXML
    private ResourceBundle resources;
    @FXML
    private URL location;
    @FXML
    private TableColumn<User, String> user;
    @FXML
    private TableColumn<User, Integer> point;
    @FXML
    private Pane panel;
    @FXML
    private TableView<User> table;
    @FXML
    private Button buttonBack;


    @FXML
    void handleButtonBackClick() {
        MainApp.window.setScene(MainApp.SceneWelcome);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        user.setCellValueFactory(new PropertyValueFactory<>("user"));
        point.setCellValueFactory(new PropertyValueFactory<>("point"));
        table.setItems(MainApp.gameManager.getResults());

        assert panel != null : "fx:id=\"panel\" was not injected: check your FXML file 'SceneResults.fxml'.";
        assert table != null : "fx:id=\"table\" was not injected: check your FXML file 'SceneResults.fxml'.";
        assert buttonBack != null : "fx:id=\"buttonBack\" was not injected: check your FXML file 'SceneResults.fxml'.";
    }
}
