package com.huawei.demo;


import com.intellij.find.SearchTextArea;
import com.intellij.ui.components.JBTextArea;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class MainDemo extends Application {

    @Override
    public void start(Stage stage) {
        JBTextArea jbTextArea = new JBTextArea();
        jbTextArea.setLineWrap(true);
        jbTextArea.setWrapStyleWord(true);
        SearchTextArea searchTextArea = new SearchTextArea(jbTextArea,true,true);
        Label resultLabel = new Label();



        VBox vbox = new VBox();
        Scene scene = new Scene(vbox, 400, 400);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}