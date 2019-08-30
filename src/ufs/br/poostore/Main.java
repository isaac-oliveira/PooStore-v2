package ufs.br.poostore;

import java.util.List;
import ufs.br.poostore.controllers.ClientController;
import ufs.br.poostore.models.Client;

/**
 *
 * @author isaac
 */
public class Main {
    
    public static void main(String args[]) {
       ClientController c = new ClientController();
       //c.add(new Client(4, "Isaac Testando Teste", "894651265", "74210653"));
       //c.remove(new Client(4, "Isaac Testando Teste", "894651265", "74210653"));
       c.update(new Client(4, "Isaac Teste", "894651265", "74210653"));
       List<Client> cs = c.getAllList();
       for(Client client : cs) {
           System.out.println(client.getName());
           System.out.println(client.getPhone());
       }
    }
}
