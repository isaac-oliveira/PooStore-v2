package ufs.br.poostore.store;

import ufs.br.poostore.models.Client;

import java.util.List;

public interface FileType {
    Object getObject(List<String> atrrs);
    void setValueByKey(Object client, String key, String value);
}
