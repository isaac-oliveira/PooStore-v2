package ufs.br.poostore.store;

import ufs.br.poostore.models.Product;

public class ProductFile extends TypeFile{
    public static final String NAME = "name";
    public static final int EXPIRATIONDATE = "expirationDate";
    public static final int CATEGORYID = "categoryID";
    public static final float PRICE = "price";

    @Override
    public Product newObject(){
        return new Object();
    }

    @Override
    public void setValueByKey(String key, String value) {
        Product product = (Product) getCurrentInstance();
        switch (key) {
            case ID:
                product.setId(Long.parseLong(value));
                break;
            case NAME:
                product.setName(value);
                break;
            case EXPIRATIONDATE:
                product.setExpirationDate(Int.parseInt(expirationDate));
                break;
            case CATEGORYID:
                product.setCategoryId(Int.parseInt(categoryId));
                break;
            case PRICE:
                product.setPrice(Float.parseFloat(price));
                break;
        }
    }

    @Override
    List<String> parseRegister(Object object) {
        Product product = (Product) object;

        List<String> list = new ArrayList<>();
        list.add(getKeyAndValue(ID, String.valueOf(product.getId())));
        list.add(getKeyAndValue(NAME, product.getName()));
        list.add(getKeyAndValue(String.valueOf(EXPIRATIONDATE), String.valueOf(product.getExpirationDate())));
        list.add(getKeyAndValue(String.valueOf(CATEGORYID), String.valueOf(product.getCategoryId())));
        list.add(getKeyAndValue(String.valueOf(PRICE), String.valueOf(product.getPrice())));
        return list;
    }
}