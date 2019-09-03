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
import ufs.br.poostore.controllers.UserController;
import ufs.br.poostore.event.OnItemSelectedListener;
import ufs.br.poostore.models.Client;
import ufs.br.poostore.views.dialog.ClientDialog;

/**
 *
 * @author isaac
 */
public class ClientPanel  extends JPanel implements OnItemSelectedListener<Client> {

    private JLabel nameLabel;
    private JLabel cpfLabel;
    private JLabel phoneLabel;
    private ListPanel listPanel;
    private Client client;
    private MainScreen mainScreen;
    
    public ClientPanel() {
        initComponents();
    }
    
    public ClientPanel(MainScreen mainScreen) {
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
        keyPanel.add(new JLabel("CPF: "));
        keyPanel.add(new JLabel("Telefone: "));
        
        JPanel valuePanel = new JPanel();
        valuePanel.setLayout(new BoxLayout(valuePanel, BoxLayout.Y_AXIS));
        nameLabel = new JLabel("-");
        valuePanel.add(nameLabel);
        cpfLabel = new JLabel("-");
        valuePanel.add(cpfLabel);
        phoneLabel = new JLabel("-");
        valuePanel.add(phoneLabel);
                
        center.add(keyPanel, new GridBagConstraints());
        center.add(valuePanel, new GridBagConstraints());
        
        JPanel bottomPanel = new JPanel();
        
        JButton btnAdd = new JButton("Adicionar");
        btnAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                if(listPanel != null)
                    new ClientDialog(listPanel).setVisible(true);
            }
        });
        bottomPanel.add(btnAdd);
        
        JButton btnUpdate = new JButton("Alterar");
        btnUpdate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                if(listPanel != null && client != null)
                    new ClientDialog(client, listPanel).setVisible(true);
            }
        });
        bottomPanel.add(btnUpdate);
        
        JButton btnRemove = new JButton("Remover");
        btnRemove.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                if(listPanel != null && client != null) {
                    listPanel.getListController().remove(client);
                    listPanel.loadList();
                }
            }
        });
        bottomPanel.add(btnRemove);
        
        if(mainScreen != null)
            this.add(new BackButtonPanel(mainScreen), BorderLayout.NORTH);
        this.add(center, BorderLayout.CENTER);
        this.add(bottomPanel, BorderLayout.SOUTH);
    }

    @Override
    public void loadInfo(ListPanel listPanel, Client obj) {
        boolean notNull = obj != null;
        this.listPanel = listPanel;
        this.client = obj;
        nameLabel.setText(notNull ? obj.getName() : "-");
        cpfLabel.setText(notNull ? obj.getCpf() : "-");
        phoneLabel.setText(notNull ? obj.getPhone() : "-");
    }
}
