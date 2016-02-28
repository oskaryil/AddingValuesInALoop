package com.gdm.application;
/**
 * Created by Daniel Andreas Finsrud
 */

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.fxml.JavaFXBuilderFactory;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;
import java.io.InputStream;

public class Main extends Application {
    private Stage stage;

    public static void main(String[] args) {
        launch(Main.class, (String[]) null);
    }

    @Override
    public void start(Stage primaryStage) {
        stage = primaryStage;
        mainWindow();
    }

    public void mainWindow() {
        MainController controller = (MainController) replaceSceneContent("com/gdm/application/MainConstructor.fxml");
        controller.setApplication(this);
    }

    private Initializable replaceSceneContent(String fxml) {
        FXMLLoader loader = new FXMLLoader();
        try {
            loader.setBuilderFactory(new JavaFXBuilderFactory());
            loader.setLocation(getClass().getResource(fxml));
            InputStream in = this.getClass().getClassLoader().getResourceAsStream(fxml);
            Parent root = loader.load(in);
            Scene scene = new Scene(root);
            scene.getStylesheets().add("com/gdm/resources/css/flatterfx.css");
            stage.setScene(scene);
            stage.setTitle("Adding Values In A Loop");
            stage.getIcons().add(new Image("com/gdm/resources/images/empty_window.png"));
            stage.sizeToScene();
            stage.setResizable(false);
            stage.show();
            stage.requestFocus();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return (Initializable) loader.getController();
    }
}
