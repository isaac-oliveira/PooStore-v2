package ufs.br.poostore.models;

import java.io.Serializable;

public abstract class Product implements Serializable {
    
    private long id;
    private String name;
    private String expirationDate;
    private long categoryId;
    private float price;

    Product() {}

    public Product(long id, String name, String expirationDate, long categoryId, float price) {
        this.id = id;
        this.name = name;
        this.expirationDate = expirationDate;
        this.categoryId = categoryId;
        this.price = price;
    }

    public long getId(){
        return id;
    }

    public void setId(long id){
        this.id = id;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getExpirationDate(){
        return expirationDate;
    }

    public void setExpirationDate(String expirationDate){
        this.expirationDate = expirationDate;
    }

    public long getCategoryId(){
        return categoryId;
    }

    public void setCategoryId(long categoryId){
        this.categoryId = categoryId;
    }

    public float getPrice(){
        return price;
    }

    public void setPrice(float price){
        this.price = price;
    }
}