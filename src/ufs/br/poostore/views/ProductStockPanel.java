package ufs.br.poostore.views;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import ufs.br.poostore.consts.User;
import ufs.br.poostore.controllers.ListController;
import ufs.br.poostore.event.OnItemSelectedListener;
import ufs.br.poostore.models.Category;
import ufs.br.poostore.models.ProductStock;
import ufs.br.poostore.views.dialog.ProductStockDialog;

/**
 *
 * @author victor
 */
public class ProductStockPanel extends JPanel implements OnItemSelectedListener<ProductStock>{
    
    private JLabel nameLabel;
    private JLabel priceLabel;
    private JLabel quantityStockLabel;
    private JLabel promotionPercentLabel;
    private ListPanel listPanel;
    private ProductStock productStock;
    private MainScreen mainScreen;
    private JLabel validateLabel;
    private JLabel categoryLabel;
    
    ProductStockPanel(MainScreen mainScreen) {
        this.mainScreen = mainScreen;
        initComponents();
    }
    
    private void initComponents() {
        this.setLayout(new BorderLayout());
        
        JPanel center = new JPanel();
        center.setLayout(new GridBagLayout());
        
        JPanel keyPanel = new JPanel();
        keyPanel.setLayout(new BoxLayout(keyPanel, BoxLayout.Y_AXIS));
        keyPanel.add(new JLabel("Nome: "));
        keyPanel.add(new JLabel("Data de validade: "));
        keyPanel.add(new JLabel("Categoria: "));
        keyPanel.add(new JLabel("Preço: "));
        keyPanel.add(new JLabel("Quantidade em estoque: "));
        keyPanel.add(new JLabel("Porcentagem da promoção: "));
        
        JPanel valuePanel = new JPanel();
        valuePanel.setLayout(new BoxLayout(valuePanel, BoxLayout.Y_AXIS));
        nameLabel = new JLabel("-");
        valuePanel.add(nameLabel);
        validateLabel = new JLabel("-");
        valuePanel.add(validateLabel);
        categoryLabel = new JLabel("-");
        valuePanel.add(categoryLabel);
        priceLabel = new JLabel("-");
        valuePanel.add(priceLabel);
        quantityStockLabel = new JLabel("-");
        valuePanel.add(quantityStockLabel);
        promotionPercentLabel = new JLabel("-");
        valuePanel.add(promotionPercentLabel);
                
        center.add(keyPanel, new GridBagConstraints());
        center.add(valuePanel, new GridBagConstraints());
        
        JPanel bottomPanel = new JPanel();
        
        JButton btnAdd = new JButton("Adicionar");
        btnAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                if(listPanel != null)
                    new ProductStockDialog(listPanel).setVisible(true);
            }
        });
        bottomPanel.add(btnAdd);
        
        JButton btnUpdate = new JButton("Alterar");
        btnUpdate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                if(listPanel != null && productStock != null)
                    new ProductStockDialog(productStock, listPanel).setVisible(true);
            }
        });
        bottomPanel.add(btnUpdate);
        
        JButton btnRemove = new JButton("Remover");
        btnRemove.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                if(listPanel != null && productStock != null) {
                    listPanel.getListController().remove(productStock);
                    listPanel.loadList();
                }
            }
        });
        bottomPanel.add(btnRemove);

        this.add(new BackButtonPanel(mainScreen, User.GESTOR_ESTOQUE), BorderLayout.NORTH);
        this.add(center, BorderLayout.CENTER);
        this.add(bottomPanel, BorderLayout.SOUTH);
    }

    @Override
    public void loadInfo(ListPanel listPanel, ProductStock obj) {
        boolean notNull = obj != null;
        this.listPanel = listPanel;
        this.productStock = obj;
        nameLabel.setText(notNull ? productStock.getName() : "-");
        validateLabel.setText(notNull ? productStock.getExpirationDate() : "-");
        categoryLabel.setText(notNull ? new ListController<Category>("./category.dat").findOne(productStock.getCategoryId()).getName() : "-");
        priceLabel.setText(notNull ? String.valueOf(productStock.getPrice()) : "-");
        quantityStockLabel.setText(notNull ? String.valueOf(productStock.getQuantityStock()) : "-");
        promotionPercentLabel.setText(notNull ? String.valueOf(productStock.getPromotionPercent()) + "%" : "-");
    }
}
