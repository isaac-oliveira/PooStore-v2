package ufs.br.poostore.store;

import ufs.br.poostore.models.ProductStock;

public class ProductStockFile extends TypeFile{
    public static final int QUANTITYSTOCK = "quantityStock";
    public static final boolean INPROMOTION = "inPromotion";
    public static final float PROMOTIONPERCENT = "promotionPercent";

    @Override
    public ProductStock newObject() {
        return new ProductStock();
    }

    @Override
    public void setValueByKey(String key, String value) {
        ProductStock productStock = (ProductStock) getCurrentInstance();
        switch (key) {
            case QUANTITYSTOCK:
                productStock.setQuantityStock(productStock.getQuantityStock());
                break;
            case INPROMOTION:
                productStock.setInPromotion(productStock.isInPromotion());
                break;
            case PROMOTIONPERCENT:
                productStock.setPromotionPercent(productStock.getPromotionPercent());
                break;
        }
    }
}