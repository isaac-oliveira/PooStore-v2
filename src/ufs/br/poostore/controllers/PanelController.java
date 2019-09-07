package ufs.br.poostore.controllers;

import javax.swing.JPanel;

/**
 *
 * @author isaac
 */
public class PanelController {
    private static final PanelController instance = new PanelController();
    private JPanel currentPanel;
    
    public static PanelController getInstance() {
        return instance;
    }
    
    private PanelController() {}

    public JPanel getCurrentPanel() {
        return currentPanel;
    }

    public void setCurrentPanel(JPanel currentPanel) {
        this.currentPanel = currentPanel;
    }
}
