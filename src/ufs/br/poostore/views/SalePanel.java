package ufs.br.poostore.views;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import ufs.br.poostore.consts.User;
import ufs.br.poostore.event.OnItemSelectedListener;
import ufs.br.poostore.models.Sale;
import ufs.br.poostore.views.dialog.SaleDialog;

/**
 *
 * @author isaac
 */
public class SalePanel extends JPanel implements OnItemSelectedListener<Sale> {

    private MainScreen mainScreen;
    private JLabel dateLabel;
    private JLabel clientLabel;
    private ListPanel listPanel;
    private Sale sale;

    public SalePanel() {
        initComponents();
    }

    public SalePanel(MainScreen mainScreen) {
        this.mainScreen = mainScreen;
        initComponents();
    }
    
    private void initComponents() {
        this.setLayout(new BorderLayout());
        
        JPanel center = new JPanel();
        center.setLayout(new GridBagLayout());
        
        JPanel keyPanel = new JPanel();
        keyPanel.setLayout(new BoxLayout(keyPanel, BoxLayout.Y_AXIS));
        keyPanel.add(new JLabel("Data: "));
        keyPanel.add(new JLabel("Cliente: "));
        JButton btnShowItens = new JButton("Ver itens"); 
        keyPanel.add(btnShowItens);
        
        JPanel valuePanel = new JPanel();
        valuePanel.setLayout(new BoxLayout(valuePanel, BoxLayout.Y_AXIS));
        dateLabel = new JLabel("-");
        valuePanel.add(dateLabel);
        clientLabel = new JLabel("-");
        valuePanel.add(clientLabel);
        JPanel aux = new JPanel();
        aux.setPreferredSize(new Dimension(20, 25));
        valuePanel.add(aux);
                
        center.add(keyPanel, new GridBagConstraints());
        center.add(valuePanel, new GridBagConstraints());
        
        JPanel bottomPanel = new JPanel();
        
        JButton btnAdd = new JButton("Adicionar");
        btnAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                new SaleDialog(listPanel).setVisible(true);
            }
        });
        bottomPanel.add(btnAdd);
        
        JButton btnUpdate = new JButton("Alterar");
        btnUpdate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                
            }
        });
        bottomPanel.add(btnUpdate);
        
        JButton btnRemove = new JButton("Remover");
        btnRemove.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
               
            }
        });
        bottomPanel.add(btnRemove);
        
        if(mainScreen != null)
            this.add(new BackButtonPanel(mainScreen, User.GERENTE), BorderLayout.NORTH);
        this.add(center, BorderLayout.CENTER);
        this.add(bottomPanel, BorderLayout.SOUTH);
    }
    
    @Override
    public void loadInfo(ListPanel listPanel, Sale obj) {
        this.listPanel = listPanel;
        this.sale = obj;
    }    
}
