package ufs.br.poostore.models;

public class ProductSale extends Product{
    
    private int soldQuantity;
    private float total;

    ProductSale() {}

    public ProductSale(int soldQuantity, float total) {
        this.soldQuantity = soldQuantity;
        this.total = total;
    }

    public int getSoldQuantity() {
        return soldQuantity;
    }

    public void setSoldQuantity(int soldQuantity) {
        this.soldQuantity = soldQuantity;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }
}