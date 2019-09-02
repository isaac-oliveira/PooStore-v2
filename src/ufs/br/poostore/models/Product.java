package ufs.br.poostore.models;

public abstract class Product {
    
    private long id;
    private String name;
    private int expirationDate;
    private int categoryId;
    private float price;

    Product() {}

    public Product(long id, String name, int expirationDate, int categoryId, float price) {
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

    public int getExpirationDate(){
        return expirationDate;
    }

    public void setExpirationDate(int expirationDate){
        this.expirationDate = expirationDate;
    }

    public int getCategoryId(){
        return categoryId;
    }

    public void setCategoryId(int categoryId){
        this.categoryId = categoryId;
    }

    public float getPrice(){
        return price;
    }

    public void setPrice(float price){
        this.price = price;
    }
}