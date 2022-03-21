package com.example.projecteasybuy;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;

import java.io.File;
import java.io.IOException;
import java.net.URL;

public class CartView {
    private Parent view;

    public CartView() throws IOException {
        URL uiFile = new File("C:/Users/Lamiya/IdeaProjects/projectEasyBuy/src/main/resources/com/example/projecteasybuy/cart.fxml").toURI().toURL();
        FXMLLoader fxmlLoader = new FXMLLoader();
        Parent root = FXMLLoader.load(uiFile);
        this.view=root;

    }
    public Parent getView() {
        return this.view;
    }
}
