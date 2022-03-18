package com.example.projecteasybuy;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.util.List;

public class CartController {
    @FXML
    private VBox cartPane;

    @FXML
    public void initialize(){
        //populate the view
        List<CartEntry> entries= ShoppingCart.getInstance().getEntries();
        cartPane.getChildren().clear();

        if(entries.isEmpty()){
            Label emptyLabel = new Label("Empty Cart!");
            cartPane.getChildren().add(emptyLabel);
        }
        else{
            Label shoppingCartTitle= new Label("Cart");
            cartPane.getChildren().add(shoppingCartTitle);

            for(CartEntry cartEntry:entries){
                HBox hbox=new HBox();
                Label productName= new Label(CartEntry.getProduct().name());
                hbox.getChildren().add(productName);
                cartPane.getChildren().add(hbox);
            }
        }

    }

}
