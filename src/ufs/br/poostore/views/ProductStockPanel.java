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
import ufs.br.poostore.event.OnItemSelectedListener;
import ufs.br.poostore.models.ProductStock;

/**
 *
 * @author victor
 */
public class ProductStockPanel extends JPanel implements OnItemSelectedListener<ProductStock>{
    
    private JLabel nameLabel;
    private JLabel priceLabel;
    private JLabel quantityStockLabel;
    private JLabel inPromotionLabel;
    private JLabel promotionPercentLabel;
    private ListPanel listPanel;
    private ProductStock productStock;
    private MainScreen mainScreen;
    
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
        keyPanel.add(new JLabel("Preço: "));
        keyPanel.add(new JLabel("Quantidade em estoque: "));
        keyPanel.add(new JLabel("Em promoção: "));
        keyPanel.add(new JLabel("Porcentagem da promoção: "));
        
        JPanel valuePanel = new JPanel();
        valuePanel.setLayout(new BoxLayout(valuePanel, BoxLayout.Y_AXIS));
        nameLabel = new JLabel("-");
        valuePanel.add(nameLabel);
        priceLabel = new JLabel("-");
        valuePanel.add(priceLabel);
        quantityStockLabel = new JLabel("-");
        valuePanel.add(quantityStockLabel);
        inPromotionLabel = new JLabel("-");
        valuePanel.add(inPromotionLabel);
        promotionPercentLabel = new JLabel("-");
        valuePanel.add(promotionPercentLabel);
                
        center.add(keyPanel, new GridBagConstraints());
        center.add(valuePanel, new GridBagConstraints());
        
        JPanel bottomPanel = new JPanel();
        
        JButton btnAdd = new JButton("Adicionar");
        btnAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                
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
                if(listPanel != null && productStock != null) {
                    listPanel.getListController().remove(productStock);
                    listPanel.loadList();
                }
            }
        });
        bottomPanel.add(btnRemove);

        this.add(new BackButtonPanel(mainScreen), BorderLayout.NORTH);
        this.add(center, BorderLayout.CENTER);
        this.add(bottomPanel, BorderLayout.SOUTH);
    }

    @Override
    public void loadInfo(ListPanel listPanel, ProductStock obj) {
        
    }
}
