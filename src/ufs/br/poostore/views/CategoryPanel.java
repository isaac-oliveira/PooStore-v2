/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ufs.br.poostore.views;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import ufs.br.poostore.consts.User;
import ufs.br.poostore.event.OnItemSelectedListener;
import ufs.br.poostore.models.Category;
import ufs.br.poostore.models.ProductStock;
import ufs.br.poostore.store.FileStore;
import ufs.br.poostore.views.dialog.CategoryDialog;

/**
 *
 * @author victor
 */
public class CategoryPanel extends JPanel implements OnItemSelectedListener<Category> {

    private ListPanel listPanel;
    private Category category;
    private MainScreen mainScreen;
    private JList jList;

    CategoryPanel(MainScreen mainScreen) {
        this.mainScreen = mainScreen;
        initComponents();
    }

    private void initComponents() {
        this.setLayout(new BorderLayout());
       
        jList = new JList();
        
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
        this.add(new JScrollPane(jList), BorderLayout.CENTER);
        this.add(bottomPanel, BorderLayout.SOUTH);
    }

    @Override
    public void loadInfo(ListPanel listPanel, Category obj) {
        boolean notNull = obj != null;
        this.listPanel = listPanel;
        this.category = obj;
        List<ProductStock> list = new ArrayList<>();
        if(notNull) {
            for(ProductStock stock : new FileStore<ProductStock>("./stock.dat").read())
                if(stock.getCategoryId() == category.getId()) 
                    list.add(stock);
        }
        jList.setListData(notNull ? new Vector<ProductStock>(list) : new Vector<>());
    }
}
