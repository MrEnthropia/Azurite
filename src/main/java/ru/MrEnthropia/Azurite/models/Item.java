package ru.MrEnthropia.Azurite.models;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.awt.*;

@Entity(name="item_table")
public class Item {



    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String itemName;

    private Image imageItem;

    private Category categoryItem;

    private QuantityUnit unitItem;

    private int quantity;

    private String articleNumber;

    private Double price;

    private String comment;

    public Item(String itemName, Image imageItem, Category categoryItem, QuantityUnit unitItem, int quantity, String articleNumber, Double price, String comment){};

    public Item(Long id,
                String itemName,
                Image imageItem,
                Category categoryItem,
                QuantityUnit unitItem,
                int quantity,
                String articleNumber,
                Double price,
                String comment
                ) {
        this.id = id;
        this.comment = comment;
        this.price = price;
        this.articleNumber = articleNumber;
        this.quantity = quantity;
        this.unitItem = unitItem;
        this.categoryItem = categoryItem;
        this.imageItem = imageItem;
        this.itemName = itemName;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getArticleNumber() {
        return articleNumber;
    }

    public void setArticleNumber(String articleNumber) {
        this.articleNumber = articleNumber;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public QuantityUnit getUnitItem() {
        return unitItem;
    }

    public void setUnitItem(QuantityUnit unitItem) {
        this.unitItem = unitItem;
    }

    public Category getCategoryItem() {
        return categoryItem;
    }

    public void setCategoryItem(Category categoryItem) {
        this.categoryItem = categoryItem;
    }

    public Image getImageItem() {
        return imageItem;
    }

    public void setImageItem(Image imageItem) {
        this.imageItem = imageItem;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }




}
