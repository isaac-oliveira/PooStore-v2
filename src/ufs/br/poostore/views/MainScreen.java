package ufs.br.poostore.views;

import java.awt.BorderLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JPanel;
import ufs.br.poostore.consts.User;
import ufs.br.poostore.controllers.UserController;
import ufs.br.poostore.event.OnBack;
import ufs.br.poostore.event.UserEvent;
import ufs.br.poostore.models.Client;
import ufs.br.poostore.models.ProductStock;
import ufs.br.poostore.models.Sale;

/**
 *
 * @author isaac
 */
public class MainScreen extends JFrame implements UserEvent, OnBack {
    public static final int WIDTH = 600;
    public static final int HEIGHT = 400;
    private IndicatorUserPanel indicatorUser;
    private LoginPanel loginPanel = new LoginPanel();
    private List<JPanel> stackNavigation = new ArrayList<JPanel>();
    private JPanel panel;

    public MainScreen() {
        super("PooStore");
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
        //this.add(new ListPanel<ProductStock>(new ProductStockPanel(this), "./stock.dat"), BorderLayout.CENTER);
    }
    
    public void addCenterPanel(JPanel panel) {
        if(this.panel != null) this.remove(this.panel);
        this.add(panel, BorderLayout.CENTER);
        this.revalidate();

        this.panel = panel;
    }
    
    public void addPanel(JPanel panel) {
        if(this.panel != null) this.remove(this.panel);
        this.add(panel, BorderLayout.CENTER);
        this.revalidate();

        this.panel = panel;
    }
    
    public JPanel getUserPanel(User user) {
        switch(user) {
            case CAIXA: return new ListPanel<Sale>(new SalePanel(), "./sale.dat");
            case GESTOR_ESTOQUE: return new StockPanel(this);
            case GESTOR_CLIENTE: return new ListPanel<Client>(new ClientPanel(), "./clients.dat");
            case GERENTE: return new ManagerPanel(this);
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

    void setBackButton(BackButtonPanel button) {
        button.setOnBack(this);
    }

    @Override
    public void onBackPressed(User user) {
        this.addCenterPanel(getUserPanel(user));
    }
}
