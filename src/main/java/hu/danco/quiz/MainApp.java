package hu.danco.quiz;

import hu.danco.controllers.GameController;
import hu.danco.controllers.GameManager;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Created by Németh Dániel on 2016.03.23..
 */
public class MainApp extends Application {
    public static Stage window;
    public Parent root;
    public Parent second;
    public Parent third;
    public Parent fourth;
    public Parent fifth;
    public Parent sixth;
    public static Scene SceneWelcome;
    public static Scene SceneGame;
    public static Scene SceneResults;
    public static Scene SceneChooseCategory;
    public static Scene SceneLogIn;
    public static Scene SceneLoose;
    public static GameManager gameManager;

    public static void startGame() {
        FXMLLoader loader = new FXMLLoader(
                MainApp.class.getClassLoader().getResource("fxml/SceneGame.fxml")
        );

        Parent parent = null;
        try {
            parent = loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Scene scene = new Scene(parent);

        GameController gameController =
                loader.getController();

        gameController.initData();

        window.setScene(scene);
    }

    @Override
    public void start(Stage stage) throws Exception{
        gameManager = new GameManager();

        window = stage;
        root = FXMLLoader.load(getClass().getClassLoader().getResource("fxml/SceneWelcome.fxml"));
        second = FXMLLoader.load(getClass().getClassLoader().getResource("fxml/SceneChooseCategory.fxml"));
        third = FXMLLoader.load(getClass().getClassLoader().getResource("fxml/SceneResults.fxml"));
        fourth = FXMLLoader.load(getClass().getClassLoader().getResource("fxml/SceneGame.fxml"));
        fifth = FXMLLoader.load(getClass().getClassLoader().getResource("fxml/SceneLogIn.fxml"));
        sixth = FXMLLoader.load(getClass().getClassLoader().getResource("fxml/SceneLoose.fxml"));

        SceneWelcome = new Scene(root);
        SceneChooseCategory = new Scene(second);
        SceneResults = new Scene(third);
        SceneGame = new Scene(fourth);
        SceneLogIn = new Scene(fifth);
        SceneLoose = new Scene(sixth);

        window.setTitle("Danco's Quiz");
        window.setScene(SceneWelcome);
        window.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
