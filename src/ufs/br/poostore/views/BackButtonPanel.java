package ufs.br.poostore.views;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;
import ufs.br.poostore.consts.User;
import ufs.br.poostore.event.OnBack;

/**
 *
 * @author isaac
 */
public class BackButtonPanel extends JPanel {

    private final MainScreen mainScreen;
    private OnBack onBack;
    private final User user;
    
    public BackButtonPanel(MainScreen mainScreen, User user) {
        this.mainScreen = mainScreen;
        this.user = user;
        initComponents();
    }

    public OnBack getOnBack() {
        return onBack;
    }

    public void setOnBack(OnBack onBack) {
        this.onBack = onBack;
    }

    private void initComponents() {
        JButton backButton = new JButton("Voltar");
        mainScreen.setBackButton(this);
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                if(onBack != null)
                    onBack.onBackPressed(user);
            }            
        });
        this.add(backButton);
    }
}
