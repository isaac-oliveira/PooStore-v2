package ufs.br.poostore.models;

import java.io.Serializable;

public class ProductStock extends Product implements Serializable, Equals<ProductStock>{
    
    private int quantityStock;
    private boolean inPromotion;
    private float promotionPercent;

    public ProductStock(long id, String name, int expirationDate, int categoryId, float price, int quantityStock, float promotionPercent) {
        super(id, name, expirationDate, categoryId, price);
        this.quantityStock = quantityStock;
        //this.inPromotion = inPromotion;
        this.promotionPercent = promotionPercent;
    }

    public int getQuantityStock() {
        return quantityStock;
    }

    public void setQuantityStock(int quantityStock) {
        this.quantityStock = quantityStock;
    }

    public boolean isInPromotion() {
        return inPromotion;
    }

    public void setInPromotion(boolean inPromotion) {
        this.inPromotion = inPromotion;
    }

    public float getPromotionPercent() {
        return promotionPercent;
    }

    public void setPromotionPercent(float promotionPercent) {
        this.promotionPercent = promotionPercent;
    }
    
    @Override
    public String toString(){
        return "Código " + super.getId() + "- Nome: " + super.getName();
    }
    
    @Override
    public boolean isRegistered(ProductStock obj){
        return super.getName().equalsIgnoreCase(obj.getName());
    }
}