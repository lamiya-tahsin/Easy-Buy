package com.example.projecteasybuy;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;

import java.io.IOException;

public class MenuController {
    @FXML
    private BorderPane contentPane;

    public void closeApp(){
        Project.getWindow().close();
    }

    public void showHomeView() throws IOException {
        contentPane.setCenter(new HomeView().getView());
    }

    public void showCartView() throws IOException {
        contentPane.setCenter(new CartView().getView());
    }
}