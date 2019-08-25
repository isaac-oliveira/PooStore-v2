package ufs.br.poostore.store;

import ufs.br.poostore.models.Client;

import java.util.List;

public class ClientFile implements FileType {
    public static final String ID = "id";
    public static final String NAME = "name";
    public static final String CPF = "cpf";
    public static final String PHONE = "phone";

    @Override
    public Object getObject(List<String> attrs) {
        Client client = new Client();
        for (String attr : attrs) {
            String[] parts = attr.split(":");
            String key = parts[0];
            String value = parts[1];
            setValueForKey(client, key, value);
        }
        return client;
    }

    @Override
    public void setValueForKey(Object object, String key, String value) {
        Client client = (Client) object;
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
}
