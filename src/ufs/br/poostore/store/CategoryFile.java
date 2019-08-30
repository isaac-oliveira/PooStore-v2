package ufs.br.poostore.store;

public class CategoryFile extends TypeFile{
    public static final String NAME = "name";

    @Override
    public Category newObject(){
        return new Category();
    }

    @Override
    public void setValueByKey(String key, String value) {
        Category category = (Category) getCurrentInstance();
        switch (key) {
            case ID:
                client.setId(Long.parseLong(value));
                break;
            case NAME:
                client.setName(value);
                break;
        }
    }

    @Override
    List<String> parseRegister(Object object) {
        Category category = (category) object;

        List<String> list = new ArrayList<>();
        list.add(getKeyAndValue(ID, String.valueOf(category.getId())));
        list.add(getKeyAndValue(NAME, category.getName()));
        
        return list;
    }
}