package hu.danco.controllers;

import hu.danco.quiz.MainApp;

import javafx.fxml.Initializable;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ChooseCategoryController extends AnchorPane implements Initializable {

    @FXML
    private ResourceBundle resources;
    @FXML
    private URL location;
    @FXML
    private ToggleGroup categoriesToggleGroup;
    @FXML
    private Pane panel;
    @FXML
    private Button buttonContinue;
    @FXML
    private RadioButton secondRadioButton;
    @FXML
    private RadioButton firstRadioButton;

    private static final Logger logger = LoggerFactory.getLogger(ChooseCategoryController.class);


    String getSelectedCategory() {
        if (firstRadioButton.isSelected()) {
            return "Biológia";
        } else
            return "Irodalom";
    }

    @FXML
    void handleButtonContinueClick() {
        String category = getSelectedCategory();

        if (category != null) {

            MainApp.gameManager.setCurrentCategory(category);

            logger.info("Kiválasztott kategória: " + category);

            MainApp.startGame();
        }
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        assert categoriesToggleGroup != null : "fx:id=\"categoriesToggleGroup\" was not injected: check your FXML file 'SceneChooseCategory.fxml'.";
        assert panel != null : "fx:id=\"panel\" was not injected: check your FXML file 'SceneChooseCategory.fxml'.";
        assert buttonContinue != null : "fx:id=\"buttonContinue\" was not injected: check your FXML file 'SceneChooseCategory.fxml'.";
        assert secondRadioButton != null : "fx:id=\"secondRadioButton\" was not injected: check your FXML file 'SceneChooseCategory.fxml'.";
        assert firstRadioButton != null : "fx:id=\"firstRadioButton\" was not injected: check your FXML file 'SceneChooseCategory.fxml'.";
    }
}
