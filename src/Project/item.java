package Project;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import DBConnection.dbController;

public class item {
    private String ItemID;
    private String ItemName;
    private int ItemQuantity;
    private double price;
    private String sellerID;

    // Constructor
    public item(String ItemID, String ItemName, int ItemQuantity, double price, String sellerID) {
        this.ItemID = ItemID;
        this.ItemName = ItemName;
        this.ItemQuantity = ItemQuantity;
        this.price = price;
        this.sellerID = sellerID;
    }

    // Getter for ItemID
    public String getItemID() {
        return ItemID;
    }

    // Getter for ItemName
    public String getItemName() {
        return ItemName;
    }

    // Getter for ItemQuantity
    public int getItemQuantity() {
        return ItemQuantity;
    }

    // Getter for Price
    public double getPrice() {
        return price;
    }

    // Getter for SellerID
    public String getSellerID() {
        return sellerID;
    }

    // Setter for Price
    public void priceUpdate(float price) {
        this.price = price;
    }
}
