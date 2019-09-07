package ufs.br.poostore.models;

import java.io.Serializable;

public class Sale implements Serializable, Equals<Sale>{
    
    private long id;
    private String date;
    private ProductSale [] itens;
    private long clientId;

    public Sale() {}

    public Sale(long id, String date, ProductSale[] itens, long clientId) {
        this.id = id;
        this.date = date;
        this.itens = itens;
        this.clientId = clientId;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public ProductSale[] getItens() {
        return itens;
    }

    public void setItens(ProductSale[] itens) {
        this.itens = itens;
    }

    public long getClientId() {
        return clientId;
    }

    public void setClientId(long clientId) {
        this.clientId = clientId;
    }
    
    @Override
    public String toString(){
        return "Código " + id + "- Data: " + date;
    }
    
    @Override
    public boolean isRegistered(Sale obj){
        return this.date == obj.getDate();
    }

}