package com.github.kalsmic;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.util.Objects;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        // load the font
        Font.loadFont( Objects.requireNonNull( getClass().getResource( "/fonts/VarelaRound-Regular.ttf" ) ).toExternalForm(), 10);

        Parent root = FXMLLoader.load( Objects.requireNonNull( getClass().getResource(
                "/com.github.kalsmic/fxml/home.fxml" ) ) );
        primaryStage.setScene(new Scene(root, 500, 500));
        primaryStage.setResizable( false );
        primaryStage.setTitle( "Pomodoro Timer" );
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
