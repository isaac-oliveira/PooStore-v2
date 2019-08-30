package ufs.br.poostore.controllers;

import java.util.ArrayList;
import java.util.List;
import ufs.br.poostore.models.Client;
import ufs.br.poostore.store.ClientFile;
import ufs.br.poostore.store.FileStore;

/**
 *
 * @author isaac
 */
public class ClientController implements FileController {
    private List<Client> clients = new ArrayList<>();
    private final FileStore fileStore;
    
    public ClientController() {
        this.fileStore = new FileStore(new ClientFile());
        this.clients = this.fileStore.read();
    }

    @Override
    public void add(Object object) {
        this.clients.add((Client) object);
        this.fileStore.write(object, true);
    }

    @Override
    public void remove(Object object) {
        int index = getIndex(object);
        if(index != -1) {
            this.clients.remove(index);
            //Mudar a lógica abaixo depois
            this.fileStore.clearFile();
            for(Client client : clients)
                this.fileStore.write(client, true);
        }
    }
    
    @Override
    public void update(Object object) {
        Client client = (Client) object;
        int index = getIndex(object);
        if(index != -1) {
            this.clients.set(index, client);
            //Mudar a lógica abaixo depois
            this.fileStore.clearFile();
            for(Client c : clients)
                this.fileStore.write(c, true);
        }
    }
    
    @Override
    public boolean exists(Object object) {
        for(Client client : clients) {
            if(client.equals(object))
                return true;
        }
        return false;
    }

    @Override
    public Object findOne(String value) {
        for(Client client : clients) {
            if(client.getCpf().equals(value) 
               || String.valueOf(client.getId()).equals(value))
                return client;
        }
        return null;
    }

    @Override
    public List<Client> find(String value) {
        List<Client> finds = new ArrayList<>();
        for(Client client : clients) {
            if(client.getName().toLowerCase().contains(value.toLowerCase()))
                finds.add(client);
        }
        return finds;
    }
    
    @Override
    public int getIndex(Object object) {
        Client client = (Client) object;
        for(int i = 0; i < clients.size(); i++) 
            if(clients.get(i).getId() == client.getId())
                return i;
        return -1;
    }

    @Override
    public List<Client> getAllList() {
        return clients;
    }
}
