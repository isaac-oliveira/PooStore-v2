package ufs.br.poostore.controllers;

import javax.swing.JFrame;

/**
 *
 * @author isaac
 */
public class WindowsController {
    private static final WindowsController instance = new WindowsController();
    private JFrame frame;
    
    public static WindowsController getInstance() {
        return instance;
    }
    
    private WindowsController() {}

    public JFrame getFrame() {
        return frame;
    }

    public void setFrame(JFrame frame) {
        this.frame = frame;
    }
}
