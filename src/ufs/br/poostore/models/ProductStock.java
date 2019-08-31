package ufs.br.poostore.models;

public class ProductStock extends Product {
    
    private int quantityStock;
    private boolean inPromotion;
    private float promotionPercent;

    ProductStock() {}

    public ProductStock(int quantityStock, boolean inPromotion, float promotionPercent) {
        this.quantityStock = quantityStock;
        this.inPromotion = inPromotion;
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
}