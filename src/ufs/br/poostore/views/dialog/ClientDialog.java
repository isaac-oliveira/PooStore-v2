package ufs.br.poostore.views.dialog;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import ufs.br.poostore.controllers.ListController;
import ufs.br.poostore.controllers.WindowsController;
import ufs.br.poostore.models.Client;

/**
 *
 * @author isaac
 */
public class ClientDialog extends JDialog {

    private ListController listController;
    
    public ClientDialog(ListController listController) {
        this.listController = listController;
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
        
        panel.add(new JLabel("CPF"));
        JTextField cpf = new JTextField();
        cpf.setPreferredSize(new Dimension(200, 25));
        panel.add(cpf);
        
        panel.add(new JLabel("Telefone"));
        JTextField phone = new JTextField();
        phone.setPreferredSize(new Dimension(200, 25));
        panel.add(phone);
        
        JLabel message = new JLabel();
        message.setPreferredSize(new Dimension(200, 25));
        panel.add(message);
        
        JPanel bottom = new JPanel();
        
        JButton btnOk = new JButton("Ok");
        btnOk.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                message.setText("");
                if(!listController.add(new Client(1, name.getText(), cpf.getText(), phone.getText())))
                    message.setText("CPF já registrado");
                else 
                    ClientDialog.this.setVisible(false);
            }
        });
        bottom.add(btnOk);
        
        JButton btnCancel = new JButton("Cancelar");
        btnCancel.addActionListener(new  ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                ClientDialog.this.setVisible(false);
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
