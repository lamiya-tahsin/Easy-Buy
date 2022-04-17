package com.example.projecteasybuy;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class PProducts {

    //private String imageFile;
    private float price;
    private String name;
    private int id;
    private String imageFile;

    PProducts(String name,int id,float price,String imageFile){
        this.imageFile=imageFile;
        this.price=price;
        this.name=name;
        this.id=id;
    }

    /*public String getImageFile(){
        return imageFile;
    }*/
    public float getPrice(){
        return this.price;
    }
    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }
    public void initialize(URL url, ResourceBundle rb) throws SQLException, InstantiationException, IllegalAccessException {
        loadProductInfo();
    }
    public static ObservableList<PProducts> loadProductInfo() throws SQLException, InstantiationException, IllegalAccessException {
        DBMSConnection dbmsconnect = new DBMSConnection("jdbc:mysql://localhost:3306/product_db", "root", "");
        Connection con = dbmsconnect.getConnection();
        String sqlcount = "SELECT product_id FROM medss";
        String sql="SELECT product_name, product_price from medss";
        PreparedStatement stmt = con.prepareStatement(sqlcount);
        ResultSet rs1 = stmt.executeQuery();
        ResultSet rs2 = stmt.executeQuery();
        ObservableList<PProducts> productList = FXCollections.observableArrayList();
        int totalps=0;

        while (rs1.next())
        {
            totalps+=rs1.getInt(1);
        }
        PProducts product;
        while(rs2.next()) {
            product = new PProducts(rs2.getString("NAME"),rs2.getInt("ID"),rs2.getFloat("PRICE"),rs2.getString("IMAGE"));
            productList.add(product);
        }

        return productList;
    }
}
