package com.example.projecteasybuy;

public enum Products {

    Burger("burgir.jpg",40.00f),Sandwich("sandwich2.jpg",40.00f),
    Hot_dog("htdg.jpg",30.00f),Coffee("cooffeee.jpg",20.00f),Puri("puri.jpg",10.00f), Noodles("noodles2.jpg",30.00f),
    Chop("chop2.jpg",10.00f),French_Fries("ff.jpg",30.00f), Drinko_Litchie("drinko_lichie.jpg",25.00f),Drinko_Mango("drinko_mango.jpeg",25.00f),
    Kheer_Shake("shake.jpg",35.00f),RC_Lemon("rc_q_lemon.jpg",15.00f),Pran_Lacchi("pran_lassi.jpeg",30.00f);

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
