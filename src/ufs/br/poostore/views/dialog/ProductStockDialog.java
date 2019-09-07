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
import ufs.br.poostore.models.Category;
import ufs.br.poostore.models.ProductStock;
import ufs.br.poostore.store.FileStore;
import ufs.br.poostore.store.IdFile;
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
    private JTextField price;
    private JSpinner promotion;
    
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
        price = new JTextField();
        price.setPreferredSize(new Dimension(200, 25));
        panel.add(price);
        
        panel.add(new JLabel("Quantidade no estoque"));
        quantity = new JSpinner();
        panel.add(quantity);
        
        panel.add(new JLabel("Promoção em porcentagem"));
        promotion = new JSpinner();
        panel.add(promotion);
        
        if(productStock != null) {
            name.setText(productStock.getName());
            price.setText(String.valueOf(productStock.getPrice()));
        }
        
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
                    long id = IdFile.getInstance().generateID(IdFile.PRODUCT_STOCK_ID);
                    ProductStock p = new ProductStock();
                    p.setId(id);
                    p.setName(name.getText());
                    p.setCategoryId(((Category) category.getSelectedItem()).getId());
                    p.setPrice(Float.parseFloat(price.getText()));
                    p.setExpirationDate(date.getValue().toString());
                    p.setQuantityStock(Integer.parseInt(quantity.getValue().toString()));
                    p.setPromotionPercent(Float.parseFloat(promotion.getValue().toString()));
                    if(!listController.add(p)) 
                        message.setText("Produto já registrado");
                    else 
                        ProductStockDialog.this.setVisible(false);
                } else {
                    productStock.setName(name.getText());
                    productStock.setCategoryId(((Category) category.getSelectedItem()).getId());
                    productStock.setPrice(Float.parseFloat(price.getText()));
                    productStock.setExpirationDate(date.getValue().toString());
                    productStock.setQuantityStock(Integer.parseInt(quantity.getValue().toString()));
                    productStock.setPromotionPercent(Float.parseFloat(promotion.getValue().toString()));
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
