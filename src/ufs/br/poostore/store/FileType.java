package ufs.br.poostore.store;

import java.util.List;

public abstract class FileType {
    public static final String ID = "id";
    private Object object;

    abstract Object newObject();
    abstract void setValueByKey(String key, String value);
    abstract List<String> getRecord(Object object);

    public Object getCurrentInstance() {
        return object;
    }

    public Object getObject(List<String> attrs) {
        this.object = newObject();
        for (String attr : attrs) {
            String[] parts = attr.split(":");
            String key = parts[0];
            String value = parts[1];
            setValueByKey(key, value);
        }
        return object;
    }

    public String getKeyAndValue(String key, String value) {
        return key + ":" + value;
    }
}
