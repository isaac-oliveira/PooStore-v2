package ufs.br.poostore.views;

import java.awt.BorderLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JFrame;
import ufs.br.poostore.consts.User;
import ufs.br.poostore.controllers.UserController;
import ufs.br.poostore.event.UserEvent;

/**
 *
 * @author isaac
 */
public class MainScreen extends JFrame implements UserEvent {
    public static final int WIDTH = 500;
    public static final int HEIGHT = 400;
    private IndicatorUserPanel indicatorUser;

    public MainScreen() {
        super("PooStore");
        initComponents();
    }

    private void initComponents() {
        this.setSize(WIDTH, HEIGHT);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        this.setLayout(new BorderLayout());
        this.add(new LoginPanel(), BorderLayout.CENTER);
        this.addWindowListener(new WindowAdapter() {
            public void windowClosed(WindowEvent e) {
              System.exit(0);
            }
        });
        UserController.getInstance().setUserEvent(this);
    }

    @Override
    public void onUserSelect(User user) {
        indicatorUser = new IndicatorUserPanel();
        this.add(indicatorUser, BorderLayout.SOUTH);
        this.revalidate();
    }

    @Override
    public void onUserExit() {
        this.remove(indicatorUser);
        this.revalidate();
    }
}
