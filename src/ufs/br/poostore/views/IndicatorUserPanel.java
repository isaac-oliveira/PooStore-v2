package ufs.br.poostore.views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import ufs.br.poostore.controllers.UserController;

/**
 *
 * @author isaac
 */
public class IndicatorUserPanel extends JPanel {
    
    public IndicatorUserPanel() {
        initComponents();
    }

    private void initComponents() {
        this.setBackground(Color.LIGHT_GRAY);
        this.setLayout(new BorderLayout());
        this.add(new JLabel("Usuário: " + getCurrentUsername()), BorderLayout.LINE_START);
        JButton btnExit = new JButton("Sair");
        btnExit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                UserController.getInstance().userExit();
                System.out.println("BtnExit");
            }
        });
        this.add(btnExit, BorderLayout.LINE_END);
    }
    
    public String getCurrentUsername() {
        switch(UserController.getInstance().getUser()) {
            case CAIXA:
                return "Caixa";
            case GESTOR_ESTOQUE:
                return "Gestor de Estoque";
            case GESTOR_CLIENTE:
                return "Gestor de clientes";
            case GERENTE:
                return "Gerente";
                
            default: return "Desconhecido";
        }
    }
}
