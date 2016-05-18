package hu.danco.quiz;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import hu.danco.controllers.GameController;
import hu.danco.controllers.GameManager;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * A QuizGame applikáció main() függvényét tartalmazó osztálya.
 */

public class MainApp extends Application {

    private static final Logger logger = LoggerFactory.getLogger(MainApp.class);

    private static Stage window;
    private Parent root;
    private Parent second;
    private Parent third;
    private Parent fourth;
    private Parent fifth;
    private Parent sixth;

    private static Scene sceneWelcome;
    private static Scene sceneGame;
    private static Scene sceneResults;
    private static Scene sceneChooseCategory;
    private static Scene sceneLogIn;
    private static Scene sceneWin;

    /**
    *Visszaadja a sceneResults {@code Scene-t}.
    *
    *@return sceneResults
    */
    public static Scene getSceneResults() {
      return sceneResults;
    }

    /**
    *Visszaadja a sceneLogIn {@code Scene-t}.
    *
    *@return sceneLogIn
    */
    public static Scene getSceneLogIn() {
      return sceneLogIn;
    }

    /**
    *Visszaadja a sceneWin {@code Scene-t}.
    *
    *@return sceneWin
    */
    public static Scene getSceneWin() {
      return sceneWin;
    }

    /**
    *Visszaadja a sceneChooseCategory {@code Scene-t}.
    *
    *@return sceneChooseCategory
    */
    public static Scene getSceneChooseCategory() {
      return sceneChooseCategory;
    }

    /**
    *Visszaadja a sceneWelcome {@code Scene-t} .
    *
    *@return sceneWelcome
    */
    public static Scene getSceneWelcome() {
      return sceneWelcome;
    }

    /**
    *Visszaadja az applikációban használt egyetlen {@code Stage} objektumot .
    *
    *@return window
    */
    public static Stage getWindow() {
      return window;
    }

    private static GameManager gameManager;

    /**
    *Visszaadja az ebben az osztályban pédányosított {@code GameManager} objektumunkat .
    *
    *@return gameManager
    */
    public static GameManager getGameManager() {
      return gameManager;
    }

    /**
    *A metódus meghívásával elérhetjük a controller osztályokban
    *az itt példányosított {@code GameManager objektumot} .
    *
    */
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

        GameController gameController = loader.getController();

        gameController.initData();

        window.setScene(scene);
    }

    /**
    *Az applikáció {@code start()} függvénye.
    *
    * @param stage Stage objektum
    */
    @Override
    public void start(Stage stage) throws Exception {

        logger.info("A játék elkezdődött.");

        gameManager = new GameManager();

        window = stage;
        root = FXMLLoader.load(getClass().getClassLoader().getResource("fxml/SceneWelcome.fxml"));
        second = FXMLLoader.load(getClass().getClassLoader().getResource("fxml/SceneChooseCategory.fxml"));
        third = FXMLLoader.load(getClass().getClassLoader().getResource("fxml/SceneResults.fxml"));
        fourth = FXMLLoader.load(getClass().getClassLoader().getResource("fxml/SceneGame.fxml"));
        fifth = FXMLLoader.load(getClass().getClassLoader().getResource("fxml/SceneLogIn.fxml"));
        sixth = FXMLLoader.load(getClass().getClassLoader().getResource("fxml/SceneWin.fxml"));

        sceneWelcome = new Scene(root);
        sceneChooseCategory = new Scene(second);
        sceneResults = new Scene(third);
        sceneGame = new Scene(fourth);
        sceneLogIn = new Scene(fifth);
        sceneWin = new Scene(sixth);

        window.setTitle("Danco's Quiz");
        window.setScene(sceneWelcome);
        window.show();
    }
    /**
    *Az applikáció {@code main()} függvénye.
    *
    *@param args parancssori argumentumok
    */
    public static void main(String[] args) {
        launch(args);
    }
}
