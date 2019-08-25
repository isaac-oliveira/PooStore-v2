package ufs.br.poostore.store;

import ufs.br.poostore.models.Client;

import java.util.ArrayList;
import java.util.List;

public class ClientFile extends FileType {
    public static final String NAME = "name";
    public static final String CPF = "cpf";
    public static final String PHONE = "phone";

    @Override
    public Client newObject() {
        return new Client();
    }

    @Override
    public void setValueByKey(String key, String value) {
        Client client = (Client) getCurrentInstance();
        switch (key) {
            case ID:
                client.setId(Long.parseLong(value));
                break;
            case NAME:
                client.setName(value);
                break;
            case CPF:
                client.setCpf(value);
                break;
            case PHONE:
                client.setPhone(value);
                break;
        }
    }

    @Override
    List<String> getRecord(Object object) {
        Client client = (Client) object;

        List<String> list = new ArrayList<>();
        list.add(getKeyAndValue(ID, String.valueOf(client.getId())));
        list.add(getKeyAndValue(NAME, client.getName()));
        list.add(getKeyAndValue(CPF, client.getCpf()));
        list.add(getKeyAndValue(PHONE, client.getPhone()));

        return list;
    }
}
