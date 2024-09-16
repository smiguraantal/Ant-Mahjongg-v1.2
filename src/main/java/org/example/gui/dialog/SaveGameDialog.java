package org.example.gui.dialog;

import com.borland.jbcl.layout.*;
import org.example.entity.Constants;
import org.example.entity.DataModule;
import org.example.entity.GameState;
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
import javax.swing.JTextField;
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
 * Játék mentése dialógus
 */
public class SaveGameDialog extends JDialog implements Constants {

    /**
     * Adatmodul
     */
    private DataModule dataModule = DataModule.getDataModule();

    /**
     * Főablak
     */
    private MainFrame mainFrame;

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
    BorderLayout borderLayout2 = new BorderLayout();
    JPanel jPanel2 = new JPanel();
    JPanel jPanel3 = new JPanel();
    VerticalFlowLayout verticalFlowLayout2 = new VerticalFlowLayout();
    JButton btDelete = new JButton();
    JButton btCancel = new JButton();
    JButton btSave = new JButton();
    VerticalFlowLayout verticalFlowLayout3 = new VerticalFlowLayout();
    JScrollPane scrollPane = new JScrollPane();
    JPanel jPanel4 = new JPanel();
    GridBagLayout gridBagLayout2 = new GridBagLayout();
    JLabel jLabel1 = new JLabel();
    JTextField tfName = new JTextField();
    JButton btDeleteAll = new JButton();
    JPanel jPanel5 = new JPanel();
    GridBagLayout gridBagLayout3 = new GridBagLayout();
    JLabel jLabel2 = new JLabel();
    GridBagLayout gridBagLayout4 = new GridBagLayout();
    Border border1;

    //----------------------------------------------------------------------

    /**
     * Konstruktor
     */
    public SaveGameDialog(MainFrame mainFrame) {
        super(mainFrame, "Játék mentése", true);
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
        border1 = BorderFactory.createEmptyBorder(0, 0, 5, 0);
        setResizable(false);
        panel1.setLayout(gridBagLayout1);
        jPanel1.setLayout(borderLayout1);
        pnRight.setLayout(borderLayout2);
        jPanel2.setLayout(gridBagLayout4);
        jPanel3.setLayout(verticalFlowLayout2);
        btDelete.setText("Törlés");
        btDelete.addActionListener(new SaveGameDialog_btDelete_actionAdapter(this));
        btCancel.setText("Mégse");
        btCancel.addActionListener(new SaveGameDialog_btCancel_actionAdapter(this));
        btSave.setText("Mentés");
        btSave.addActionListener(new SaveGameDialog_btSave_actionAdapter(this));
        jLabel1.setText("");
        pnLeft.setLayout(verticalFlowLayout3);
        jPanel4.setLayout(gridBagLayout2);
        jLabel1.setText("Név:");
        scrollPane.setPreferredSize(new Dimension(200, 200));
        tfName.setText("");
        tfName.addKeyListener(new SaveGameDialog_tfName_keyAdapter(this));
        list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        this.setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        this.addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                this_windowClosing(e);
            }
        });
        btDeleteAll.setText("Összes törlése");
        btDeleteAll.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(ActionEvent e) {
                btDeleteAll_actionPerformed(e);
            }
        });
        jPanel5.setLayout(gridBagLayout3);
        jLabel2.setText("Mentett játékok:");
        verticalFlowLayout3.setVgap(0);
        jPanel4.setBorder(border1);
        getContentPane().add(panel1);
        panel1.add(jPanel1, new GridBagConstraints(0, 0, 1, 1, 1.0, 1.0
                , GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 5, 0), 0, 0));
        jPanel1.add(pnLeft, BorderLayout.WEST);
        jPanel1.add(pnRight, BorderLayout.EAST);
        pnRight.add(jPanel2, BorderLayout.NORTH);
        jPanel2.add(btDelete, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0
                , GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(0, 5, 0, 5), 0, 0));
        jPanel2.add(btDeleteAll, new GridBagConstraints(0, 1, 1, 1, 0.0, 0.0
                , GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(5, 5, 0, 5), 0, 0));
        pnRight.add(jPanel3, BorderLayout.SOUTH);
        jPanel3.add(btSave, null);
        jPanel3.add(btCancel, null);
        jPanel1.add(jPanel5, BorderLayout.NORTH);
        jPanel5.add(jLabel2, new GridBagConstraints(0, 0, 1, 1, 1.0, 0.0
                , GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(5, 5, 2, 0), 0, 0));
        pnLeft.add(scrollPane, null);
        pnLeft.add(jPanel4, null);
        jPanel4.add(jLabel1, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0
                , GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(5, 0, 0, 0), 0, 0));
        jPanel4.add(tfName, new GridBagConstraints(1, 0, 1, 1, 1.0, 0.0
                , GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL, new Insets(5, 5, 0, 0), 0, 0));
        scrollPane.getViewport().add(list, null);


        list.addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent e) {
                if (list.getSelectedValue() != null)
                    tfName.setText(((GameState) list.getSelectedValue()).getName());
            }
        });

        btSave.setIcon(new ImageIconManager().createImageIcon("icons/save.gif"));

        addKeyListening();
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
        components.add(tfName);
        components.add(btCancel);
        components.add(btSave);
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
    public void showDialog() {
        list.setListData(dataModule.getGameStates());
        new WindowLocation(this, WindowLocation.CENTER);
        tfName.setText("");
        tfName.requestFocus();
        dataModule.setDialogShowing(true);
        show();
        dataModule.setDialogShowing(false);
    }

    //----------------------------------------------------------------------

    /**
     * Mentés
     */
    private void save() {
        if (tfName.getText().trim().equals("")) { // nem töltötte ki
            MessageManager.showInfoDialog(this, "A név nincs kitöltve!");
            tfName.requestFocus();
            tfName.setText("");
        } else { // kitöltötte
            String name = tfName.getText().trim();
            if (dataModule.getGameStates().contains(new GameState(name))) { // már van ilyen néven elmentve
                if (MessageManager.showConfirmDialog(this, "Ezen a néven már van elmentve játék!\nFelülírjam?")) { // felülírja
                    dataModule.overwriteGameState(mainFrame.getGamePanel().createGameState(name));
                    hide();
                }
            } else { // még nincs ilyen néven elmentve
                dataModule.addGameState(mainFrame.getGamePanel().createGameState(name));
                hide();
            }
        }
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
            tfName.setText("");
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
        } else
            tfName.setText("");
    }

    //----------------------------------------------------------------------

    /**
     * Törlés
     */
    void btDelete_actionPerformed(ActionEvent e) {
        delete();
    }

    //----------------------------------------------------------------------

    /**
     * Mentés
     */
    void btSave_actionPerformed(ActionEvent e) {
        save();
    }

    //----------------------------------------------------------------------

    /**
     * Mégse
     */
    void btCancel_actionPerformed(ActionEvent e) {
        cancel();
    }

    //----------------------------------------------------------------------

    /**
     * Ha a szövegmezőn entert ütnek
     */
    void tfName_keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_ENTER)
            save();
    }

    //----------------------------------------------------------------------

    /**
     * Ablakbezárás mentés nélkül
     */
    void this_windowClosing(WindowEvent e) {
        cancel();
    }

    //----------------------------------------------------------------------

    /**
     * Összes mentett játék törlése
     */
    void btDeleteAll_actionPerformed(ActionEvent e) {
        deleteAll();
    }
}

class SaveGameDialog_btDelete_actionAdapter implements java.awt.event.ActionListener {
    SaveGameDialog adaptee;

    SaveGameDialog_btDelete_actionAdapter(SaveGameDialog adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.btDelete_actionPerformed(e);
    }
}

class SaveGameDialog_btSave_actionAdapter implements java.awt.event.ActionListener {
    SaveGameDialog adaptee;

    SaveGameDialog_btSave_actionAdapter(SaveGameDialog adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.btSave_actionPerformed(e);
    }
}

class SaveGameDialog_btCancel_actionAdapter implements java.awt.event.ActionListener {
    SaveGameDialog adaptee;

    SaveGameDialog_btCancel_actionAdapter(SaveGameDialog adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.btCancel_actionPerformed(e);
    }
}

class SaveGameDialog_tfName_keyAdapter extends KeyAdapter {
    SaveGameDialog adaptee;

    SaveGameDialog_tfName_keyAdapter(SaveGameDialog adaptee) {
        this.adaptee = adaptee;
    }

    public void keyPressed(KeyEvent e) {
        adaptee.tfName_keyPressed(e);
    }
}











