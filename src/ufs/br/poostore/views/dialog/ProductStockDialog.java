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
import ufs.br.poostore.models.ProductStock;
import ufs.br.poostore.store.FileStore;
import ufs.br.poostore.views.ListPanel;

/**
 *
 * @author victor
 */
public class ProductStockDialog extends JDialog {

    private ListPanel listPanel;
    private ListController listController;
    private ProductStock productStock;
    private JComboBox category;
    private JSpinner date;
    private JSpinner quantity;
    
    public ProductStockDialog(ListPanel listPanel) {
        this.listPanel = listPanel;
        this.listController = listPanel.getListController();
        initComponents();
    }
    
    public ProductStockDialog(ProductStock productStock, ListPanel listPanel) {
        this.productStock = productStock;
        this.listPanel = listPanel;
        this.listController = listPanel.getListController();
        initComponents();
    }

    private void initComponents() {
        this.setLayout(new BorderLayout());
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        
        panel.add(new JLabel("Nome"));
        JTextField name = new JTextField();
        name.setPreferredSize(new Dimension(200, 25));
        panel.add(name);
        
        panel.add(new JLabel("Data de validade"));
        date = new JSpinner(new SpinnerDateModel());
        panel.add(date);
        
        panel.add(new JLabel("Categoria"));
        category = new JComboBox(new Vector(new FileStore("./category.dat").read()));
        panel.add(category);
        
        panel.add(new JLabel("Preço"));
        JTextField price = new JTextField();
        price.setPreferredSize(new Dimension(200, 25));
        panel.add(price);
        
        panel.add(new JLabel("Quantidade no estoque"));
        quantity = new JSpinner();
        panel.add(quantity);
        
        panel.add(new JLabel("Promoção em porcentagem"));
        panel.add(new JSpinner());
        
        JLabel message = new JLabel();
        message.setPreferredSize(new Dimension(200, 25));
        panel.add(message);
        
        JPanel bottom = new JPanel();
        
        JButton btnOk = new JButton("Ok");
        btnOk.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                message.setText("");
                if(productStock == null) {
                    if(!listController.add(new ProductStock(1, "Arroz", 1, 1, 1.4f, 1, 1.5f)))
                        message.setText("Produto já registrado");
                    else 
                        ProductStockDialog.this.setVisible(false);
                } else {
                    productStock.setName(name.getText());
                    if(!listController.update(productStock))
                        message.setText("Erro ao atualizar");
                    else 
                        ProductStockDialog.this.setVisible(false);
                }
                listPanel.loadList();
            }
        });
        bottom.add(btnOk);
        
        JButton btnCancel = new JButton("Cancelar");
        btnCancel.addActionListener(new ActionListener() {
            @Override            
            public void actionPerformed(ActionEvent ae) {
                ProductStockDialog.this.setVisible(false);
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
