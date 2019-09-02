package ufs.br.poostore.views;

import java.awt.BorderLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import ufs.br.poostore.consts.User;
import ufs.br.poostore.controllers.UserController;
import ufs.br.poostore.controllers.WindowsController;
import ufs.br.poostore.event.UserEvent;
import ufs.br.poostore.models.Category;
import ufs.br.poostore.models.Client;

/**
 *
 * @author isaac
 */
public class MainScreen extends JFrame implements UserEvent {
    public static final int WIDTH = 600;
    public static final int HEIGHT = 400;
    private IndicatorUserPanel indicatorUser;
    private LoginPanel loginPanel = new LoginPanel();
    private JPanel panel;

    public MainScreen() {
        super("PooStore");
        WindowsController.getInstance().setFrame(this);
        initComponents();
    }

    private void initComponents() {
        this.setSize(WIDTH, HEIGHT);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        this.setLayout(new BorderLayout());
        this.addWindowListener(new WindowAdapter() {
            public void windowClosed(WindowEvent e) {
              System.exit(0);
            }
        });
        UserController.getInstance().setUserEvent(this);
        this.addCenterPanel(loginPanel);
        //this.add(new ListPanel<Client>(new ClientPanel(), "./clients.dat"), BorderLayout.CENTER);
    }
    
    public void addCenterPanel(JPanel panel) {
        if(this.panel != null) this.remove(this.panel);
        this.add(panel, BorderLayout.CENTER);
        this.revalidate();

        this.panel = panel;
    }
    
    public JPanel getUserPanel(User user) {
        switch(user) {
            case GESTOR_ESTOQUE: return new EstoquePanel(this);
            case GESTOR_CLIENTE: return new ListPanel<Client>(new ClientPanel(), "./clients.dat");
            default: return loginPanel;
        }
    }

    @Override
    public void onUserSelect(User user) {
        indicatorUser = new IndicatorUserPanel();
        this.add(indicatorUser, BorderLayout.SOUTH);
        this.addCenterPanel(getUserPanel(user));
    }

    @Override
    public void onUserExit() {
        this.remove(indicatorUser);
        loginPanel = new LoginPanel();
        this.addCenterPanel(loginPanel);
    }
}
