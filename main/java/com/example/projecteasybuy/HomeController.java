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
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class HomeController {

    @FXML
    private GridPane ProductsGridPane;

    @FXML
    public void initialize() throws FileNotFoundException{

        ProductsGridPane.getChildren().clear();
        Label cdsLabel = new Label("IUT CDS");
        cdsLabel.setStyle("-fx-font-weight: bold;-fx-font-size:25pt;-fx-text-fill: #fc0202");
        ProductsGridPane.add(cdsLabel,1,0);


        VBox productView1 = productView(Products.Burger);
        ProductsGridPane.add(productView1,1,1);
        productView1.setPadding(new Insets(10, 10, 10, 0));


        VBox productView2 = productView(Products.Sandwich);
        ProductsGridPane.add(productView2,4,1);
        productView2.setPadding(new Insets(10, 10, 10, 10));

        VBox productView3 = productView(Products.Hot_dog);
        ProductsGridPane.add(productView3,7,1);
        productView3.setPadding(new Insets(10, 10, 10, 10));

        VBox productView4 = productView(Products.Noodles);
        ProductsGridPane.add(productView4,10,1);
        productView4.setPadding(new Insets(10, 10, 10, 10));

        VBox productView5 = productView(Products.Chop);
        ProductsGridPane.add(productView5,13,1);
        productView5.setPadding(new Insets(10, 10, 10, 10));

        VBox productView6 = productView(Products.Coffee);
        ProductsGridPane.add(productView6,16,1);
        productView6.setPadding(new Insets(10, 10, 10, 10));

        VBox productView7 = productView(Products.Puri);
        ProductsGridPane.add(productView7,19,1);
        productView7.setPadding(new Insets(10, 10, 10, 10));

        VBox productView8 = productView(Products.French_Fries);
        ProductsGridPane.add(productView8,1,2);
        productView8.setPadding(new Insets(10, 10, 10, 0));

        VBox productView9 = productView(Products.Drinko_Mango);
        ProductsGridPane.add(productView9,4,2);
        productView9.setPadding(new Insets(10, 10, 10, 10));

        VBox productView10 = productView(Products.Drinko_Litchie);
        ProductsGridPane.add(productView10,7,2);
        productView10.setPadding(new Insets(10, 10, 10, 10));

        VBox productView11 = productView(Products.RC_Lemon);
        ProductsGridPane.add(productView11,10,2);
        productView11.setPadding(new Insets(10, 10, 10, 10));

        VBox productView12 = productView(Products.Kheer_Shake);
        ProductsGridPane.add(productView12,13,2);
        productView12.setPadding(new Insets(10, 10, 10, 10));


    }

    private VBox productView(Products product)throws FileNotFoundException {
        VBox layout=new VBox();
        layout.setAlignment(Pos.CENTER);

        FileInputStream input=new FileInputStream("C:/Users/Lamiya/IdeaProjects/projectEasyBuy/src/main/resources/com/example/projecteasybuy/cds/"+product.getImageFile());
        Image image=new Image(input);
        ImageView imageView=new ImageView(image);
        imageView.setFitWidth(150);
        imageView.setFitHeight(170);
       // imageView.setPadding(new Insets(10, 10, 10, 10));
        Label productName = new Label(product.name());
        Label price= new Label("Tk "+product.getPrice());

        Button addButton= new Button("Add to Cart");
        addButton.setUserData(product.name());          //to identify the product
        //addButton.setStyle("-fx-font-color: white");
        addButton.setStyle("-fx-background-color: #fc0202;-fx-font-weight: bold;-fx-text-fill: white");
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
