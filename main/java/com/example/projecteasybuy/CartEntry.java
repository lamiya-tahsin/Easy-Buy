package com.example.projecteasybuy;

public class CartEntry {
    private static Products product;
    private int quantity;
     public CartEntry(Products product, int quantity ){
         this.product=product;
         this.quantity=quantity;
     }

     public static Products getProduct(){
         return product;
     }

     public int getQuantity(){
         return quantity;
     }

     public void increaseQuantity(){
         this.quantity++;
     }

     public void decreaseQuantity(){
        if(this.quantity>0) {
            this.quantity--;
        }
     }

}
