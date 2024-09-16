package org.example.gui.dialog;

import org.example.entity.Constants;
import org.example.entity.DataModule;
import org.example.gui.MainFrame;
import org.example.gui.WindowLocation;
import org.example.gui.manager.MessageManager;
import org.example.gui.panel.RecordPanel;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.ListSelectionModel;
import javax.swing.border.Border;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Vector;

/**
 * <p>Title: Ant-Mahjongg</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2004-2005</p>
 * <p>Company: </p>
 *
 * @author Smigura Antal
 * @version 1.2
 */

/**
 * Eredmények dialógusablaka
 */
public class ResultDialog extends JDialog implements Constants {

    /**
     * Adatmodul
     */
    private DataModule dataModule = DataModule.getDataModule();

    /**
     * Rekordok panel a vízszintes szabályhoz
     */
    private RecordPanel recordPanelH = new RecordPanel(); // H: Horizontal

    /**
     * Rekordok panel a függőleges szabályhoz
     */
    private RecordPanel recordPanelV = new RecordPanel(); // V: Vertical

    /**
     * Rekordok panel az egyszerű szabályhoz
     */
    private RecordPanel recordPanelS = new RecordPanel(); // V: Vertical

    JPanel panel1 = new JPanel();
    BorderLayout borderLayout1 = new BorderLayout();
    JPanel jPanel1 = new JPanel();
    JPanel jPanel2 = new JPanel();
    BorderLayout borderLayout2 = new BorderLayout();
    JPanel jPanel3 = new JPanel();
    JButton btDeleteAll = new JButton();
    JButton btClose = new JButton();
    JPanel jPanel4 = new JPanel();
    BorderLayout borderLayout3 = new BorderLayout();
    Border border1;
    JScrollPane scrollPane = new JScrollPane();
    JList listLayouts = new JList(LAYOUT_NAMES);
    JPanel jPanel5 = new JPanel();
    BorderLayout borderLayout4 = new BorderLayout();
    JPanel jPanel6 = new JPanel();
    BorderLayout borderLayout5 = new BorderLayout();
    Border border2;
    Border border3;
    Border border4;
    JTabbedPane tabbedPane = new JTabbedPane();
    JButton btDelete = new JButton();
    JPanel jPanel7 = new JPanel();
    GridBagLayout gridBagLayout1 = new GridBagLayout();
    JLabel jLabel1 = new JLabel();

    //----------------------------------------------------------------------

    /**
     * Konstruktor
     */
    public ResultDialog(MainFrame mainFrame) {
        super(mainFrame, "Eredmények", true);
        try {
            jbInit();
            pack();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    //----------------------------------------------------------------------

    private void jbInit() throws Exception {
        border1 = BorderFactory.createEmptyBorder(2, 5, 0, 5);
        border4 = BorderFactory.createEmptyBorder(0, 0, 5, 0);
        setResizable(false);
        border2 = BorderFactory.createEmptyBorder(2, 10, 0, 5);
        border3 = BorderFactory.createEtchedBorder();
        panel1.setLayout(borderLayout1);
        jPanel1.setLayout(borderLayout2);
        btDeleteAll.setText("Összes törlése");
        btDeleteAll.addActionListener(new ResultDialog_btDeleteAll_actionAdapter(this));
        btDelete.addActionListener(new ResultDialog_btDelete_actionAdapter(this));
        btClose.setText("Bezárás");
        btClose.addActionListener(new ResultDialog_btClose_actionAdapter(this));
        jPanel4.setLayout(borderLayout3);
        jPanel5.setLayout(borderLayout4);
        jPanel4.setBorder(border4);
        jPanel5.setBorder(border1);
        listLayouts.setPreferredSize(new Dimension(120, listLayouts.getPreferredSize().height));
        listLayouts.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        jPanel6.setLayout(borderLayout5);
        jPanel6.setBorder(border2);
        //recordPanelH.setBorder(border3);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        tabbedPane.addChangeListener(new ResultDialog_tabbedPane_changeAdapter(this));
        btDelete.setText("Törlés");
        borderLayout4.setHgap(0);
        borderLayout4.setVgap(0);
        borderLayout5.setVgap(0);
        jPanel7.setLayout(gridBagLayout1);
        jLabel1.setText("Elrendezések:");
        getContentPane().add(panel1);
        panel1.add(jPanel1, BorderLayout.SOUTH);
        jPanel1.add(jPanel2, BorderLayout.WEST);
        jPanel2.add(btDelete, null);
        jPanel2.add(btDeleteAll, null);
        jPanel1.add(jPanel3, BorderLayout.EAST);
        jPanel3.add(btClose, null);
        panel1.add(jPanel4, BorderLayout.CENTER);
        scrollPane.getViewport().add(listLayouts, null);
        jPanel4.add(jPanel5, BorderLayout.WEST);
        jPanel5.add(scrollPane, BorderLayout.CENTER);
        jPanel4.add(jPanel6, BorderLayout.CENTER);
        jPanel6.add(tabbedPane, BorderLayout.CENTER);
        tabbedPane.add(recordPanelH, "Vízszintes szabály");
        tabbedPane.add(recordPanelV, "Függőleges szabály");
        tabbedPane.add(recordPanelS, "Egyszerű szabály");
        panel1.add(jPanel7, BorderLayout.NORTH);
        jPanel7.add(jLabel1, new GridBagConstraints(1, 0, 1, 1, 1.0, 0.0
                , GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(5, 5, 0, 0), 0, 0));

        listLayouts.addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent e) {
                refreshRecordPanel();
            }
        });
        tabbedPane.setSelectedComponent(getActualRecordPanel());

        addKeyListening();
    }

    //----------------------------------------------------------------------

    /**
     * Kilépésfigyelés
     */
    private void addKeyListening() {
        Vector components = new Vector();

        components.add(scrollPane.getHorizontalScrollBar());
        components.add(scrollPane.getVerticalScrollBar());
        components.add(tabbedPane);
        components.add(listLayouts);
        components.add(btClose);
        components.add(btDelete);
        components.add(btDeleteAll);

        for (int i = 0; i < components.size(); i++) {
            Component component = (Component) components.get(i);
            component.addKeyListener(new KeyAdapter() {
                public void keyPressed(KeyEvent e) {
                    keyListening(e);
                }
            });
        }
    }

    //----------------------------------------------------------------------

    /**
     * Escape-re kilépés
     */
    private void keyListening(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
            hide();
        }
    }

    //----------------------------------------------------------------------

    /**
     * Megjeleníti a dialógust
     */
    public void showDialog(boolean afterGame) {
        listLayouts.setSelectedValue(dataModule.getLayout().getName(), true);
        tabbedPane.setSelectedComponent(getActualRecordPanel());
        getActualRecordPanel().setRecords(dataModule.getActualTopTen());
        if (afterGame)
            getActualRecordPanel().selectActualRecord();
        pack();
        new WindowLocation(this, WindowLocation.CENTER);
        dataModule.setDialogShowing(true);
        show();
        dataModule.setDialogShowing(false);
    }


    //----------------------------------------------------------------------

    /**
     * Visszaadja az aktuális szabályrendszerhez tartozó rekord panelt
     */
    private RecordPanel getActualRecordPanel() {
        if (dataModule.getRule() == RULE_HORIZONTAL)
            return recordPanelH;
        if (dataModule.getRule() == RULE_VERTICAL)
            return recordPanelV;
        return recordPanelS;
    }

    //----------------------------------------------------------------------

    /**
     *
     */
    private void refreshRecordPanel() {
        RecordPanel selectedRecordPanel = (RecordPanel) tabbedPane.getSelectedComponent();
        if (selectedRecordPanel == null || listLayouts.getSelectedValue() == null)
            return;
        int rule = tabbedPane.getSelectedIndex();
        selectedRecordPanel.setRecords(dataModule.getRecords().getTopTen(rule, // itt nem dataModule.isVerticalRule() kell hanem a fülespanel kiválasztott szabályrendszere, ugyanis attól függ, hogy mit mutat az eredménytábla !!!!!!!!!
                listLayouts.getSelectedValue().toString()));
    }

    //----------------------------------------------------------------------

    void btClose_actionPerformed(ActionEvent e) {
        hide();
    }

    //----------------------------------------------------------------------

    /**
     * Eredmények törlése
     */
    void btDeleteAll_actionPerformed(ActionEvent e) {
        if (MessageManager.showConfirmDialog(this, "Biztosan törlöd az összes létező eredményt?")) {
            dataModule.resetRecords();
            refreshRecordPanel();
        }
    }

    //----------------------------------------------------------------------

    /**
     *
     */
    void tabbedPane_stateChanged(ChangeEvent e) {
        refreshRecordPanel();
    }

    //----------------------------------------------------------------------

    /**
     *
     */
    void btDelete_actionPerformed(ActionEvent e) {
        if (MessageManager.showConfirmDialog(this,
                "Biztosan törlöd a " +
                        rule() + " " +
                        "szabályrendszer " +
                        layoutName() + " " +
                        "elrendezésének eredményeit?")) {
            int rule = tabbedPane.getSelectedIndex();
            dataModule.resetTopTen(rule,
                    listLayouts.getSelectedValue().toString());
            refreshRecordPanel();
        }
    }

    //----------------------------------------------------------------------

    /**
     *
     */
    private String rule() {
        if (tabbedPane.getSelectedIndex() == 0)
            return "vízszintes";
        if (tabbedPane.getSelectedIndex() == 1)
            return "függőleges";
        return "egyszerű";
    }

    //----------------------------------------------------------------------

    /**
     *
     */
    private String layoutName() {
        return listLayouts.getSelectedValue().toString();
    }


}

class ResultDialog_btClose_actionAdapter implements java.awt.event.ActionListener {
    ResultDialog adaptee;

    ResultDialog_btClose_actionAdapter(ResultDialog adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.btClose_actionPerformed(e);
    }
}

class ResultDialog_btDeleteAll_actionAdapter implements java.awt.event.ActionListener {
    ResultDialog adaptee;

    ResultDialog_btDeleteAll_actionAdapter(ResultDialog adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.btDeleteAll_actionPerformed(e);
    }
}

class ResultDialog_tabbedPane_changeAdapter implements javax.swing.event.ChangeListener {
    ResultDialog adaptee;

    ResultDialog_tabbedPane_changeAdapter(ResultDialog adaptee) {
        this.adaptee = adaptee;
    }

    public void stateChanged(ChangeEvent e) {
        adaptee.tabbedPane_stateChanged(e);
    }
}

class ResultDialog_btDelete_actionAdapter implements java.awt.event.ActionListener {
    ResultDialog adaptee;

    ResultDialog_btDelete_actionAdapter(ResultDialog adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.btDelete_actionPerformed(e);
    }
}






