package ufs.br.poostore.views;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.util.List;
import java.util.Vector;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import ufs.br.poostore.controllers.ListController;
import ufs.br.poostore.models.Client;

/**
 *
 * @author isaac
 */
public class ClientPanel extends JPanel {
    private ListController<Client> clientController;
    private List<Client> clients;
    
    public ClientPanel() {
        initComponents();
    }
    
    private void loadList() {
        clientController = new ListController<Client>();
        clients = clientController.getAllList();
    }
    
    private void initComponents() {
        loadList();
        JList list = new JList(new Vector<Client>(clients));
        list.setMinimumSize(new Dimension(150, 150));
        JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,
                list, new JLabel("Dafny\nHello"));
        splitPane.setResizeWeight(0);
        splitPane.setOneTouchExpandable(true);
        splitPane.setContinuousLayout(true);
        
        this.setLayout(new BorderLayout());
        this.add(splitPane);
    }
}
