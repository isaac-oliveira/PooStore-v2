package ufs.br.poostore;

import java.util.ArrayList;
import java.util.List;
import ufs.br.poostore.controllers.ListController;
import ufs.br.poostore.models.Client;
import ufs.br.poostore.store.FileStore;

/**
 *
 * @author isaac
 */
public class Main {
    
    public static void main(String args[]) {
       List<Client> clients = new ArrayList();
       clients.add(new Client(4, "Isaac Santos de Oliveira", "894651265", "74210653"));
       clients.add(new Client(4, "Victor Queiroz de Souza", "8946512655", "74210653"));
       clients.add(new Client(4, "Milena Alves Silva", "5412212", "74210653"));
       clients.add(new Client(4, "Mirelle Alves Silva", "3225652", "74210653"));


       ListController<Client> list = new ListController<Client>();
       for(Client c : clients) {
           if(list.add(c))
               System.out.println("Adicionou");
           else
               System.out.println("Cadastro já existe");
       }
       
       if(list.update(new Client(4, "Milena Alves Silva", "5412212", "74210653")))
            System.out.println("Atualizou");
       else 
            System.out.println("Não existe");
       
       for(Client c : list.getAllList()) {
           System.out.println(c.getName());
       }
    }
}
