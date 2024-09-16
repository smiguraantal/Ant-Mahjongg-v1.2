package org.example.gui.dialog;

import com.borland.jbcl.layout.*;
import org.example.entity.Constants;
import org.example.entity.DataModule;
import org.example.entity.GameNumberFormat;
import org.example.entity.GameState;
import org.example.entity.TimeFormat;
import org.example.gui.MainFrame;
import org.example.gui.WindowLocation;
import org.example.gui.manager.ImageIconManager;
import org.example.gui.manager.MessageManager;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.border.Border;
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
import java.awt.event.WindowEvent;
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
 * Játék megnyitása dialógus
 */
public class OpenGameDialog extends JDialog implements Constants {

    /**
     * Adatmodul
     */
    private DataModule dataModule = DataModule.getDataModule();

    /**
     * Főablak
     */
    private MainFrame mainFrame;

    /**
     * A megnyitott játék
     */
    private GameState gameState;

    /**
     * A mentett játékok listája
     */
    JList list = new JList();

    JPanel panel1 = new JPanel();
    GridBagLayout gridBagLayout1 = new GridBagLayout();
    JPanel jPanel1 = new JPanel();
    BorderLayout borderLayout1 = new BorderLayout();
    JPanel pnLeft = new JPanel();
    JPanel pnRight = new JPanel();
    VerticalFlowLayout verticalFlowLayout3 = new VerticalFlowLayout();
    JScrollPane scrollPane = new JScrollPane();
    JPanel jPanel8 = new JPanel();
    JPanel jPanel9 = new JPanel();
    BorderLayout borderLayout4 = new BorderLayout();
    JPanel jPanel10 = new JPanel();
    JButton btDeleteAll = new JButton();
    JButton btDelete = new JButton();
    JButton btCancel = new JButton();
    JButton btOpen = new JButton();
    BorderLayout borderLayout2 = new BorderLayout();
    JPanel jPanel2 = new JPanel();
    BorderLayout borderLayout3 = new BorderLayout();
    JPanel jPanel3 = new JPanel();
    JPanel jPanel4 = new JPanel();
    VerticalFlowLayout verticalFlowLayout1 = new VerticalFlowLayout();
    VerticalFlowLayout verticalFlowLayout2 = new VerticalFlowLayout();
    JLabel lb6 = new JLabel();
    JLabel lb1 = new JLabel();
    JLabel lb7 = new JLabel();
    JLabel lb2 = new JLabel();
    JLabel lb5 = new JLabel();
    JLabel lb3 = new JLabel();
    JLabel lb4 = new JLabel();
    JLabel lbLayout = new JLabel();
    JLabel lbRule = new JLabel();
    JLabel lbGameNumber = new JLabel();
    JLabel lbTime = new JLabel();
    JLabel lbPenalty = new JLabel();
    JLabel lbTiles = new JLabel();
    JLabel lbOpens = new JLabel();
    JLabel lb8 = new JLabel();
    JLabel lb9 = new JLabel();
    JLabel lbUndo = new JLabel();
    JLabel lbRedo = new JLabel();
    JPanel jPanel5 = new JPanel();
    JLabel jLabel1 = new JLabel();
    GridBagLayout gridBagLayout2 = new GridBagLayout();
    Border border1;
    Border border2;
    Border border3;

    //----------------------------------------------------------------------

    /**
     * Konstruktor
     */
    public OpenGameDialog(MainFrame mainFrame) {
        super(mainFrame, "Játék megnyitása", true);
        this.mainFrame = mainFrame;
        try {
            jbInit();
            pack();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    //----------------------------------------------------------------------

    private void jbInit() throws Exception {
        border1 = BorderFactory.createEmptyBorder(5, 0, 0, 0);
        border2 = BorderFactory.createEmptyBorder(-5, 0, 0, 0);
        border3 = BorderFactory.createEmptyBorder(-5, 0, 0, 0);
        setResizable(false);
        panel1.setLayout(gridBagLayout1);
        jPanel1.setLayout(borderLayout1);
        pnRight.setLayout(borderLayout2);
        pnLeft.setLayout(verticalFlowLayout3);
        scrollPane.setPreferredSize(new Dimension(200, 200));
        list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        this.setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        this.addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                this_windowClosing(e);
            }
        });
        jPanel8.setLayout(borderLayout4);
        btDeleteAll.setText("Összes törlése");
        btDeleteAll.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(ActionEvent e) {
                btDeleteAll_actionPerformed(e);
            }
        });
        btDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(ActionEvent e) {
                btDelete_actionPerformed(e);
            }
        });
        btOpen.setText("Megnyitás");
        btOpen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(ActionEvent e) {
                btOpen_actionPerformed(e);
            }
        });
        btDelete.setText("Törlés");
        btCancel.setText("Mégse");
        btCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(ActionEvent e) {
                btCancel_actionPerformed(e);
            }
        });
        jPanel2.setLayout(borderLayout3);
        jPanel3.setLayout(verticalFlowLayout1);
        jPanel4.setLayout(verticalFlowLayout2);
        lb6.setText("Párok:");
        lb1.setText("Kövek:");
        lb7.setText("Büntetés:");
        lb2.setText("Idő:");
        lb5.setText("Játék:");
        pnRight.setPreferredSize(new Dimension(250, 125));
        borderLayout3.setHgap(10);
        verticalFlowLayout1.setAlignment(VerticalFlowLayout.TOP);
        verticalFlowLayout1.setVgap(5);
        verticalFlowLayout1.setVerticalFill(false);
        verticalFlowLayout2.setAlignment(VerticalFlowLayout.TOP);
        lb3.setText("Elrendezés:");
        lb4.setText("Szabály:");

        lbLayout.setForeground(BLUE_LABEL);
        lbRule.setForeground(BLUE_LABEL);
        lbGameNumber.setForeground(BLUE_LABEL);
        lbTime.setForeground(BLUE_LABEL);
        lbPenalty.setForeground(BLUE_LABEL);
        lbTiles.setForeground(BLUE_LABEL);
        lbOpens.setForeground(BLUE_LABEL);
        lbUndo.setForeground(BLUE_LABEL);
        lbRedo.setForeground(BLUE_LABEL);

        lbLayout.setText("");
        lbRule.setText("");
        lbGameNumber.setText("");
        lbTime.setText("");
        lbPenalty.setText("");
        lbTiles.setText("");
        lb8.setText("Visszavonható lépés:");
        lb9.setText("Megismételhető lépés:");
        jLabel1.setText("Mentett játékok:");
        jPanel5.setLayout(gridBagLayout2);
        verticalFlowLayout3.setVgap(0);
        jPanel8.setBorder(border1);
        jPanel3.setBorder(border2);
        jPanel4.setBorder(border3);
        jPanel4.setDebugGraphicsOptions(0);
        getContentPane().add(panel1);
        panel1.add(jPanel1,
                new GridBagConstraints(0, 0, 1, 1, 1.0, 1.0,
                        GridBagConstraints.CENTER,
                        GridBagConstraints.BOTH,
                        new Insets(0, 0, 5, 0), 0, 0));
        jPanel1.add(pnLeft, BorderLayout.WEST);
        jPanel1.add(pnRight, BorderLayout.CENTER);
        pnRight.add(jPanel2, BorderLayout.CENTER);
        jPanel2.add(jPanel3, BorderLayout.WEST);
        jPanel3.add(lb3, null);
        jPanel3.add(lb4, null);
        jPanel3.add(lb5, null);
        jPanel3.add(lb2, null);
        jPanel3.add(lb7, null);
        jPanel3.add(lb1, null);
        jPanel3.add(lb6, null);
        jPanel3.add(lb8, null);
        jPanel3.add(lb9, null);
        jPanel2.add(jPanel4, BorderLayout.CENTER);

        jPanel4.add(lbLayout, null);
        jPanel4.add(lbRule, null);
        jPanel4.add(lbGameNumber, null);
        jPanel4.add(lbTime, null);
        jPanel4.add(lbPenalty, null);
        jPanel4.add(lbTiles, null);
        jPanel4.add(lbOpens, null);
        jPanel4.add(lbUndo, null);
        jPanel4.add(lbRedo, null);
        jPanel1.add(jPanel8, BorderLayout.SOUTH);
        jPanel8.add(jPanel9, BorderLayout.WEST);
        jPanel9.add(btDelete, null);
        jPanel9.add(btDeleteAll, null);
        jPanel8.add(jPanel10, BorderLayout.EAST);
        jPanel10.add(btOpen, null);
        jPanel10.add(btCancel, null);
        jPanel1.add(jPanel5, BorderLayout.NORTH);
        jPanel5.add(jLabel1, new GridBagConstraints(0, 0, 1, 1, 1.0, 0.0
                , GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(5, 5, 2, 0), 0, 0));
        pnLeft.add(scrollPane, null);
        scrollPane.getViewport().add(list, null);

        list.addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent e) {
                if (list.getSelectedValue() != null)
                    writeGameProperties(((GameState) list.getSelectedValue()));
            }
        });

        btOpen.setIcon(new ImageIconManager().createImageIcon("icons/open.gif"));

        addKeyListening();
    }

    //----------------------------------------------------------------------

    /**
     * Kiírja az elmentett játék jellemzőit
     */
    private void writeGameProperties(GameState gameState) {
        lbLayout.setText(gameState.getLayout().getName());
        lbRule.setText(ruleToString(gameState.getRule()));
        lbGameNumber.setText(GameNumberFormat.format(gameState.getGameNumber()));
        lbTime.setText(TimeFormat.format(gameState.getTime()));
        lbPenalty.setText(TimeFormat.format(gameState.getPenalty()));
        lbTiles.setText("" + gameState.getTiles());
        lbOpens.setText("" + gameState.getOpens());
        lbUndo.setText("" + gameState.getUndo().size());
        lbRedo.setText("" + gameState.getRedo().size());

        lb1.setEnabled(true);
        lb2.setEnabled(true);
        lb3.setEnabled(true);
        lb4.setEnabled(true);
        lb5.setEnabled(true);
        lb6.setEnabled(true);
        lb7.setEnabled(true);
        lb8.setEnabled(true);
        lb9.setEnabled(true);
    }

    //----------------------------------------------------------------------

    /**
     * Visszaadja a szabályt szöveges formában
     */
    private String ruleToString(int rule) {
        if (rule == RULE_HORIZONTAL)
            return "Vízszintes";
        if (rule == RULE_VERTICAL)
            return "Függőleges";
        return "Egyszerű";
    }

    //----------------------------------------------------------------------

    /**
     * Törli a játék jellemzőket
     */
    private void clearGameProperties() {
        lbLayout.setText("");
        lbRule.setText("");
        lbGameNumber.setText("");
        lbTime.setText("");
        lbPenalty.setText("");
        lbTiles.setText("");
        lbOpens.setText("");
        lbUndo.setText("");
        lbRedo.setText("");

        lb1.setEnabled(false);
        lb2.setEnabled(false);
        lb3.setEnabled(false);
        lb4.setEnabled(false);
        lb5.setEnabled(false);
        lb6.setEnabled(false);
        lb7.setEnabled(false);
        lb8.setEnabled(false);
        lb9.setEnabled(false);
    }

    //----------------------------------------------------------------------

    /**
     * Hozzáadja a komponensekhez az Escape figyelést
     */
    private void addKeyListening() {
        Vector components = new Vector();

        components.add(scrollPane.getHorizontalScrollBar());
        components.add(scrollPane.getVerticalScrollBar());
        components.add(list);
        components.add(btCancel);
        components.add(btOpen);
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
        if (e.getKeyCode() == KeyEvent.VK_ESCAPE)
            cancel();
    }

    //----------------------------------------------------------------------

    /**
     * Megjeleníti a dialógust
     */
    public GameState showDialog() {
        gameState = null;
        list.setListData(dataModule.getGameStates());
        select(0);
        new WindowLocation(this, WindowLocation.CENTER);
        dataModule.setDialogShowing(true);
        show();
        dataModule.setDialogShowing(false);
        return gameState;
    }

    //----------------------------------------------------------------------

    /**
     * Mentés
     */
    private void open() {
        if (list.getModel().getSize() == 0) // üres a lista
            MessageManager.showInfoDialog(this, "Nincs megnyitható játék!");
        else if (!list.isSelectionEmpty()) { // van kijelölt elem
            gameState = (GameState) list.getSelectedValue();
            hide();
        } else  // nincs kijelölt elem
            MessageManager.showInfoDialog(this, "Jelöld ki a megnyitni kívánt játékot");
    }

    //----------------------------------------------------------------------

    /**
     * Mégse
     */
    private void cancel() {
        hide();
    }

    //----------------------------------------------------------------------

    /**
     * Törlés
     */
    private void delete() {
        if (list.getModel().getSize() == 0) // üres a lista
            MessageManager.showInfoDialog(this, "Nincs törölhető játék!");
        else if (!list.isSelectionEmpty()) { // van kijelölt elem
            if (MessageManager.showConfirmDialog(this, "Biztosan törlöd?")) { // tölrlés megerősítése
                dataModule.deleteGameState((GameState) list.getSelectedValue());
                int selectedIndex = list.getSelectedIndex();
                list.setListData(dataModule.getGameStates());
                select(selectedIndex);
            }
        } else  // nincs kijelölt elem
            MessageManager.showInfoDialog(this, "Jelöld ki a törölni kívánt játékot");
    }

    //----------------------------------------------------------------------

    /**
     * Öszes törlése
     */
    private void deleteAll() {
        if (list.getModel().getSize() == 0) // üres a lista
            MessageManager.showInfoDialog(this, "Nincs törölhető játék!");
        else if (MessageManager.showConfirmDialog(this, "Biztosan törlöd az összes játékot?")) {
            dataModule.deleteAllGameState();
            list.setListData(dataModule.getGameStates());
            clearGameProperties();
        }
    }

    //----------------------------------------------------------------------

    /**
     * Kijelöli a törlés utáni aktuális játékot a listában
     */
    private void select(int selectedIndex) {
        int size = list.getModel().getSize();
        if (size != 0) { // ha van eleme a listának
            if (size - 1 >= selectedIndex)
                list.setSelectedIndex(selectedIndex);
            else
                list.setSelectedIndex(selectedIndex - 1);
            writeGameProperties(((GameState) list.getSelectedValue()));
        } else // ha nincs eleme a listának
            clearGameProperties();
    }

    //----------------------------------------------------------------------

    void btDelete_actionPerformed(ActionEvent e) {
        delete();
    }

    void btOpen_actionPerformed(ActionEvent e) {
        open();
    }

    void btCancel_actionPerformed(ActionEvent e) {
        cancel();
    }

    void this_windowClosing(WindowEvent e) {
        cancel();
    }

    void btDeleteAll_actionPerformed(ActionEvent e) {
        deleteAll();
    }


}

class OpenGameDialog_btDelete_actionAdapter implements java.awt.event.ActionListener {
    OpenGameDialog adaptee;

    OpenGameDialog_btDelete_actionAdapter(OpenGameDialog adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.btDelete_actionPerformed(e);
    }
}

class OpenGameDialog_btOpen_actionAdapter implements java.awt.event.ActionListener {
    OpenGameDialog adaptee;

    OpenGameDialog_btOpen_actionAdapter(OpenGameDialog adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.btOpen_actionPerformed(e);
    }
}

class OpenGameDialog_btCancel_actionAdapter implements java.awt.event.ActionListener {
    OpenGameDialog adaptee;

    OpenGameDialog_btCancel_actionAdapter(OpenGameDialog adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.btCancel_actionPerformed(e);
    }
}












