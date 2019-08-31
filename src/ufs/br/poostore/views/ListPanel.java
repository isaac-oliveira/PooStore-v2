package ufs.br.poostore.views;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.util.List;
import java.util.Vector;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import ufs.br.poostore.controllers.ListController;
import ufs.br.poostore.event.OnItemSelectedListener;

/**
 *
 * @author isaac
 */
public class ListPanel<T> extends JPanel {
    private ListController<T> listController;
    private List<T> list;
    private JList jList;
    private final OnItemSelectedListener rightPanel;
    private String path;
    
    public ListPanel(OnItemSelectedListener rightPanel, String path) {
        this.rightPanel = rightPanel;
        this.path = path;
        initComponents();
    }
    
    public void loadList() {
        listController = new ListController<T>(path);
        list = listController.getAllList();
        jList.setListData(new Vector<T>(list));
        rightPanel.loadInfo(ListPanel.this, null);
    }
    
    private void initComponents() {
        jList = new JList();
        loadList();
        jList.setMinimumSize(new Dimension(150, 150));
        jList.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent lse) {
                Object selected = jList.getSelectedValue();
                if(lse.getValueIsAdjusting() && selected != null)
                    rightPanel.loadInfo(ListPanel.this, selected);
            }
        });
        JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,
                jList, (Component) rightPanel);
        
        this.setLayout(new BorderLayout());
        this.add(splitPane);
    }

    public ListController<T> getListController() {
        return listController;
    }
}
