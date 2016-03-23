package hu.danco.controllers;

import hu.danco.quiz.MainApp;

import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import sun.applet.Main;

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
    @FXML
    static String ChosenCategory;

    @FXML String firstQuestion;
    @FXML String firstAnsA;
    @FXML String firstAnsB;
    @FXML String firstAnsC;
    @FXML String firstAnsD;

//    public ControllerOfSceneChooseCategory() {
//        //if you want to set a FXML
//        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("SceneChooseCategory.fxml"));
//        //Defines this class as the controller
//
//        fxmlLoader.setRoot(this);
//        fxmlLoader.setController(this);
//        try {
//            fxmlLoader.load();
//        } catch (IOException exception) {
//            throw new RuntimeException(exception);
//        }
//    }
//
//    public String getFirstQuestion() {
//        return firstQuestion;
//    }
//
//    public void setFirstQuestion(String firstQuestion) {
//        rx1.readQuestions();
//        this.firstQuestion = (String) rx1.listQuestions.get(0).getQuestion();
//    }

    static String getChosenCategory() {
        return ChosenCategory;
    }

    @FXML
    void handleOptions() {

        if(firstRadioButton.isSelected()){
            ChosenCategory = "Biológia";
            System.out.println("Biosz");
        }
        if (secondRadioButton.isSelected()) {
            ChosenCategory = "Irodalom";
            System.out.println("Irci");
        }
    }

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
