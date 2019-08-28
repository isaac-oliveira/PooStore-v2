package ufs.br.poostore.models;

public class Sale{
    
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

}