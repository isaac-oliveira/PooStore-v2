package ufs.br.poostore.models;

import java.io.Serializable;

public class ProductSale extends Product implements Serializable, Equals<ProductSale>{
    
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
    
    @Override
    public String toString(){
        return "Código " + id + "- Nome: " + name;
    }
    
    @Override
    public boolean isRegistered(ProductSale obj){
        return this.name.equalsIgnoreCase(obj.getName());
    }
}