package ufs.br.poostore.models;

import java.io.Serializable;

public class Sale implements Serializable, Equals<Sale>{
    
    private long id;
    private int date;
    private ProductSale [] itens;
    private int clientId;

    public Sale() {}

    public Sale(long id, int date, ProductSale[] itens, int clientId) {
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

    public int getDate() {
        return date;
    }

    public void setDate(int date) {
        this.date = date;
    }

    public ProductSale[] getItens() {
        return itens;
    }

    public void setItens(ProductSale[] itens) {
        this.itens = itens;
    }

    public int getClientId() {
        return clientId;
    }

    public void setClientId(int clientId) {
        this.clientId = clientId;
    }
    
    @Override
    public String toString(){
        return "Código " + id + "- Data: " + date; //converter para data usual
    }
    
    @Override
    public boolean isRegistered(Sale obj){
        return this.date == obj.getDate();
    }

}