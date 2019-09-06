package ufs.br.poostore.views.dialog;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerDateModel;
import ufs.br.poostore.controllers.ListController;
import ufs.br.poostore.models.Client;
import ufs.br.poostore.models.Sale;
import ufs.br.poostore.store.FileStore;
import ufs.br.poostore.store.IdFile;
import ufs.br.poostore.views.ListPanel;

/**
 *
 * @author victor
 */
public class SaleDialog extends JDialog {

private ListPanel listPanel;
    private ListController listController;
    private Sale sale;
    private JSpinner date;
    private JComboBox client;
    private JComboBox itens;
    private JButton btnUpdate;
    
    public SaleDialog(ListPanel listPanel) {
        this.listPanel = listPanel;
        this.listController = listPanel.getListController();
        initComponents();
    }
    
    public SaleDialog(Sale sale, ListPanel listPanel) {
        this.sale = sale;
        this.listPanel = listPanel;
        this.listController = listPanel.getListController();
        initComponents();
    }

    private void initComponents() {
        this.setLayout(new BorderLayout());
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        
        panel.add(new JLabel("Data da venda"));
        date = new JSpinner(new SpinnerDateModel());
        panel.add(date);
        panel.add(new JLabel("Cliente"));
        client = new JComboBox(new Vector(new FileStore("./clients.dat").read()));
        panel.add(client);
        panel.add(new JLabel("Itens"));
        itens = new JComboBox();
        panel.add(itens);
        btnUpdate = new JButton("Alterar itens");
        panel.add(btnUpdate);
        
        JLabel message = new JLabel();
        message.setPreferredSize(new Dimension(200, 25));
        panel.add(message);
        
        JPanel bottom = new JPanel();
        
        JButton btnOk = new JButton("Ok");
        btnOk.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                message.setText("");
                if(sale == null) {
                    long id = IdFile.getInstance().generateID(IdFile.SALE_ID);
                    sale = new Sale();
                    sale.setId(id);
                    sale.setClientId(((Client) client.getSelectedItem()).getId());
                    sale.setDate(date.getValue().toString());
                    sale.setItens(null);
                    if(!listController.add(sale)) 
                        message.setText("Produto já registrado");
                    else 
                        SaleDialog.this.setVisible(false);
                } else {
                    sale.setClientId(((Client) client.getSelectedItem()).getId());
                    sale.setDate(date.getValue().toString());
                    sale.setItens(null);
                    if(!listController.update(sale))
                        message.setText("Erro ao atualizar");
                    else 
                        SaleDialog.this.setVisible(false);
                }
                listPanel.loadList();
            }
        });
        bottom.add(btnOk);
        
        JButton btnCancel = new JButton("Cancelar");
        btnCancel.addActionListener(new ActionListener() {
            @Override            
            public void actionPerformed(ActionEvent ae) {
                SaleDialog.this.setVisible(false);
            }
        });
        bottom.add(btnCancel);
        
        this.add(panel, BorderLayout.CENTER);
        this.add(bottom, BorderLayout.SOUTH);
        this.setLocationRelativeTo(null);
        this.setModal(true);
        this.pack();
    }
    
}
