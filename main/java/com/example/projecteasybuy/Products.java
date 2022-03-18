package com.example.projecteasybuy;

public enum Products {

    Burger("burger.jpg",40.00f),Sandwich("sandwich.jpg",40.00f),
    Hot_dog("hot_dog.jpg",30.00f);
    //price and image name;
    private String imageFile;
    private float price;

    Products(String imageFile,float price){
        this.imageFile=imageFile;
        this.price=price;
    }

    public String getImageFile(){
        return imageFile;
    }
    public float getPrice(){
        return this.price;
    }

}
