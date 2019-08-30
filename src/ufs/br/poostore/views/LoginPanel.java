package ufs.br.poostore.views;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import ufs.br.poostore.consts.User;
import ufs.br.poostore.controllers.UserController;

/**
 *
 * @author isaac
 */
public class LoginPanel extends JPanel {
    public LoginPanel() {
        initComponent();
    }

    private void initComponent() {
        JPanel center = new JPanel();
        center.setLayout(new BoxLayout(center, BoxLayout.Y_AXIS));
        
        JLabel userLabel = new JLabel("Usuário");
        userLabel.setPreferredSize(new Dimension(200, 25));
        center.add(userLabel);
        
        JTextField userField = new JTextField();
        userField.setPreferredSize(new Dimension(200, 25));
        center.add(userField);
        
        JLabel passwordLabel = new JLabel("Senha");
        passwordLabel.setPreferredSize(new Dimension(200, 25));
        center.add(passwordLabel);
        
        JPasswordField  passwordField = new JPasswordField();
        passwordField.setPreferredSize(new Dimension(200, 25));
        center.add(passwordField);
        
        JLabel messageError = new JLabel();
        messageError.setPreferredSize(new Dimension(200, 20));
        center.add(messageError);
        
        JButton btnLogin = new JButton("Login");
        btnLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                String username = userField.getText();
                String password = String.valueOf(passwordField.getPassword());
                if(username.equalsIgnoreCase("caixa") && password.equalsIgnoreCase("123"))
                    UserController.getInstance().setUser(User.CAIXA);
                else if(username.equalsIgnoreCase("gestorcliente") && password.equalsIgnoreCase("123"))
                    UserController.getInstance().setUser(User.GESTOR_CLIENTE);
                else if(username.equalsIgnoreCase("gestorestoque") && password.equalsIgnoreCase("123"))
                    UserController.getInstance().setUser(User.GESTOR_ESTOQUE);
                else if(username.equalsIgnoreCase("gerente") && password.equalsIgnoreCase("123"))
                    UserController.getInstance().setUser(User.GERENTE);
                else 
                    messageError.setText("Usuário/senha inválida");
            }
        });
        center.add(btnLogin);
        
        this.setLayout(new GridBagLayout());
        this.add(center, new GridBagConstraints());
    }
}
