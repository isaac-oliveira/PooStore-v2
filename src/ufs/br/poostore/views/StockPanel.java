package ufs.br.poostore.views;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import ufs.br.poostore.models.Category;
import ufs.br.poostore.models.ProductStock;

/**
 *
 * @author isaac
 */
public class StockPanel extends JPanel {
    private final MainScreen mainScreen;
    
    public StockPanel(MainScreen mainScreen) {
        this.mainScreen = mainScreen;
        initComponents();
    }

    private void initComponents() {
        this.setLayout(new GridBagLayout());
        JPanel center = new JPanel();
        center.setLayout(new BoxLayout(center, BoxLayout.Y_AXIS));
        
        JButton btnCategory = new JButton("Categorias");
        btnCategory.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                mainScreen.addCenterPanel(new ListPanel<Category>(new CategoryPanel(mainScreen), "./category.dat"));
            }            
        });
        this.add(btnCategory);
        
        JButton btnProduct = new JButton("Produtos");
        btnProduct.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                mainScreen.addCenterPanel(new ListPanel<ProductStock>(new ProductStockPanel(mainScreen), "./productStock.dat"));
            }            
        });
        this.add(btnProduct);
        
        this.add(center, new GridBagConstraints());        
    }
}
