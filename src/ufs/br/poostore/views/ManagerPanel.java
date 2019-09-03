package ufs.br.poostore.views;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import ufs.br.poostore.models.Client;

/**
 *
 * @author isaac
 */
public class ManagerPanel extends JPanel {
    private final MainScreen mainScreen;
    
    public ManagerPanel(MainScreen mainScreen) {
        this.mainScreen = mainScreen;
        initComponents();
    }

    private void initComponents() {
        this.setLayout(new GridBagLayout());
        JPanel center = new JPanel();
        center.setLayout(new BoxLayout(center, BoxLayout.Y_AXIS));
        
        JButton btnCashier = new JButton("Operar Caixar");
        btnCashier.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {

            }            
        });
        this.add(btnCashier);
        
        JButton btnClient = new JButton("Gerir Clientes");
        btnClient.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                mainScreen.addCenterPanel(new ListPanel<Client>(new ClientPanel(mainScreen), "./clients.dat"));
            }            
        });
        this.add(btnClient);
        
        JButton btnStock = new JButton("Gerir Estoque");
        btnStock.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
            }            
        });
        this.add(btnStock);
        
        this.add(center, new GridBagConstraints());        
    }
}
