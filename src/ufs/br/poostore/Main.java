package ufs.br.poostore;

import ufs.br.poostore.models.Client;
import ufs.br.poostore.store.ClientFile;
import ufs.br.poostore.store.FileStore;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        FileStore fileStore = new FileStore(new ClientFile());
        fileStore.write(new Client(2, "Dafny Testando2", "12345678955", "7998562252455"));
        List list = fileStore.read();
        for (Object object : list) {
            Client client = (Client) object;
            System.out.println(client.getName());
        }
    }
}
