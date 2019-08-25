package ufs.br.poostore;

import ufs.br.poostore.models.Client;
import ufs.br.poostore.store.ClientFile;
import ufs.br.poostore.store.FileStore;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        List list = new FileStore(new ClientFile()).read("./Poo.txt");
        for (Object object : list) {
            Client client = (Client) object;
            System.out.println(client.toString());
        }
    }
}
