package ufs.br.poostore.views.dialog;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import ufs.br.poostore.controllers.ListController;
import ufs.br.poostore.models.Category;
import ufs.br.poostore.store.IdFile;
import ufs.br.poostore.views.ListPanel;

/**
 *
 * @author victor
 */
public class CategoryDialog extends JDialog {

private ListPanel listPanel;
    private ListController listController;
    private Category category;
    
    public CategoryDialog(ListPanel listPanel) {
        this.listPanel = listPanel;
        this.listController = listPanel.getListController();
        initComponents();
    }
    
    public CategoryDialog(Category category, ListPanel listPanel) {
        this.category = category;
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
        
        if(category != null) 
            name.setText(category.getName());
            
        JLabel message = new JLabel();
        message.setPreferredSize(new Dimension(200, 25));
        panel.add(message);
        
        JPanel bottom = new JPanel();
        
        JButton btnOk = new JButton("Ok");
        btnOk.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                message.setText("");
                if(category == null) {
                    long id = IdFile.getInstance().generateID(IdFile.CATEGORY_ID);
                    if(!listController.add(new Category(id, name.getText())))
                        message.setText("Categoria já registrada");
                    else 
                        CategoryDialog.this.setVisible(false);
                } else {
                    category.setName(name.getText());
                    if(!listController.update(category))
                        message.setText("Erro ao atualizar");
                    else 
                        CategoryDialog.this.setVisible(false);
                }
                listPanel.loadList();
            }
        });
        bottom.add(btnOk);
        
        JButton btnCancel = new JButton("Cancelar");
        btnCancel.addActionListener(new ActionListener() {
            @Override            
            public void actionPerformed(ActionEvent ae) {
                CategoryDialog.this.setVisible(false);
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
