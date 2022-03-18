package com.example.projecteasybuy;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class HomeController {

    @FXML
    private GridPane ProductsGridPane;

    @FXML
    public void initialize() throws FileNotFoundException{
        ProductsGridPane.getChildren().clear();

        VBox productView1 = productView(Products.Burger);
        ProductsGridPane.add(productView1,0,0);

        VBox productView2 = productView(Products.Sandwich);
        ProductsGridPane.add(productView2,1,0);

        VBox productView3 = productView(Products.Hot_dog);
        ProductsGridPane.add(productView3,2,0);
    }

    private VBox productView(Products product)throws FileNotFoundException {
        VBox layout=new VBox();
        layout.setAlignment(Pos.CENTER);

        FileInputStream input=new FileInputStream("C:/Users/Lamiya/IdeaProjects/projectEasyBuy/src/main/resources/com/example/projecteasybuy/cds/"+product.getImageFile());
        Image image=new Image(input);
        ImageView imageView=new ImageView(image);
        imageView.setFitWidth(100);
        imageView.setFitHeight(100);

        Label productName = new Label(product.name());
        Label price= new Label("Tk "+product.getPrice());

        Button addButton= new Button("Add to Cart");
        addButton.setUserData(product.name());
        addButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                //add product to Shopping Cart
                Node sourceComponent= (Node)actionEvent.getSource();
                String productName=(String)sourceComponent.getUserData();
                ShoppingCart shoppingCart=ShoppingCart.getInstance();
                shoppingCart.addProduct(productName);
            }
        });
        layout.getChildren().addAll(imageView,productName,price,addButton);

        return layout;
    }

}
