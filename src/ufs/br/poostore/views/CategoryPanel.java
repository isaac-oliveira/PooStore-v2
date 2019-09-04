/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
import ufs.br.poostore.event.OnItemSelectedListener;
import ufs.br.poostore.models.Category;
import ufs.br.poostore.views.dialog.CategoryDialog;

/**
 *
 * @author victor
 */
public class CategoryPanel extends JPanel implements OnItemSelectedListener<Category> {

    private JLabel nameLabel;
    private ListPanel listPanel;
    private Category category;
    private MainScreen mainScreen;

    CategoryPanel(MainScreen mainScreen) {
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
        
        JPanel valuePanel = new JPanel();
        valuePanel.setLayout(new BoxLayout(valuePanel, BoxLayout.Y_AXIS));
        nameLabel = new JLabel("-");
        valuePanel.add(nameLabel);
                
        center.add(keyPanel, new GridBagConstraints());
        center.add(valuePanel, new GridBagConstraints());
        
        JPanel bottomPanel = new JPanel();
        
        JButton btnAdd = new JButton("Adicionar");
        btnAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                if(listPanel != null)
                    new CategoryDialog(listPanel).setVisible(true);
            }
        });
        bottomPanel.add(btnAdd);
        
        JButton btnUpdate = new JButton("Alterar");
        btnUpdate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                if(listPanel != null && category != null)
                    new CategoryDialog(category, listPanel).setVisible(true);
            }
        });
        bottomPanel.add(btnUpdate);
        
        JButton btnRemove = new JButton("Remover");
        btnRemove.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                if(listPanel != null && category != null) {
                    listPanel.getListController().remove(category);
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
    public void loadInfo(ListPanel listPanel, Category obj) {
        boolean notNull = obj != null;
        this.listPanel = listPanel;
        this.category = obj;
        nameLabel.setText(notNull ? obj.getName() : "-");
    }
}
