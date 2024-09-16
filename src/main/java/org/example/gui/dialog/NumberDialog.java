package org.example.gui.dialog;

import org.example.entity.Constants;
import org.example.entity.DataModule;
import org.example.gui.MainFrame;
import org.example.gui.WindowLocation;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
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
 * Egy számozott játék sorszámát bekérő dialógus
 */
public class NumberDialog extends JDialog implements Constants {

    /**
     * Adatok
     */
    private DataModule dataModule = DataModule.getDataModule();

    /**
     * Főablak
     */
    private MainFrame mainFrame;

    /**
     * Volt-e mentés
     */
    private boolean save;

    JComboBox cbNumber = new JComboBox(createNumbers());

    JPanel panel1 = new JPanel();
    BorderLayout borderLayout1 = new BorderLayout();
    JPanel jPanel1 = new JPanel();
    JButton btSave = new JButton();
    JButton btCancel = new JButton();
    FlowLayout flowLayout1 = new FlowLayout();
    JPanel jPanel2 = new JPanel();
    FlowLayout flowLayout2 = new FlowLayout();
    JPanel jPanel3 = new JPanel();
    FlowLayout flowLayout3 = new FlowLayout();
    JLabel jLabel1 = new JLabel();

    //----------------------------------------------------------------------

    /**
     * Konstruktor
     */
    public NumberDialog(MainFrame mainFrame) {
        super(mainFrame, "Játék választása", true);
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
        this.setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setResizable(false);
        this.addWindowListener(new NumberDialog_this_windowAdapter(this));
        panel1.setLayout(borderLayout1);
        btSave.setText("Rendben");
        btSave.addActionListener(new NumberDialog_btSave_actionAdapter(this));
        btCancel.setText("Mégse");
        btCancel.addActionListener(new NumberDialog_btCancel_actionAdapter(this));
        jPanel1.setLayout(flowLayout1);
        jPanel2.setLayout(flowLayout2);
        flowLayout1.setAlignment(FlowLayout.CENTER);
        jPanel3.setLayout(flowLayout3);
        flowLayout3.setAlignment(FlowLayout.CENTER);
        flowLayout3.setVgap(10);
        flowLayout2.setAlignment(FlowLayout.CENTER);
        jLabel1.setText("Válassz egy számot!");
        cbNumber.setMaximumRowCount(10);
        getContentPane().add(panel1);
        panel1.add(jPanel1, BorderLayout.SOUTH);
        jPanel1.add(btSave, null);
        jPanel1.add(btCancel, null);
        panel1.add(jPanel2, BorderLayout.CENTER);
        jPanel2.add(cbNumber, null);
        panel1.add(jPanel3, BorderLayout.NORTH);
        jPanel3.add(jLabel1, null);
        cbNumber.setPreferredSize(
                new Dimension(50, cbNumber.getPreferredSize().height));

        addKeyListening();
    }

    //----------------------------------------------------------------------

    /**
     * Hozzáadja a komponensekhez az Escape figyelést
     */
    private void addKeyListening() {
        Vector components = new Vector();
        components.add(cbNumber);
        components.add(btCancel);
        components.add(btSave);

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
     * Lérehozza a kiválasztáshoz szükséges számokat
     */
    private Vector createNumbers() {
        Vector numbers = new Vector();
        for (int i = 1; i <= COUNT_OF_NUMBERED_GAMES; i++) {
            numbers.add(new Integer(i));
        }
        return numbers;
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
    public boolean showDialog() {
        pack();
        new WindowLocation(this, WindowLocation.CENTER);
        cbNumber.setSelectedItem(new Integer(1));
        cbNumber.requestFocus();
        dataModule.setDialogShowing(true);
        show();
        dataModule.setDialogShowing(false);
        return save;
    }

    //----------------------------------------------------------------------

    /**
     * Számozott játék kiválasztása
     */
    private void save() {
        dataModule.setGameNumber(((Integer) cbNumber.getSelectedItem()).intValue());
//        dataModule.setLastGameNumber(((Integer) cbNumber.getSelectedItem()).intValue());
        dataModule.loadNumberedGame();
        save = true;
        hide();
    }

    //----------------------------------------------------------------------

    /**
     * Nem volt mentés
     */
    private void cancel() {
        save = false;
        hide();
    }

    //----------------------------------------------------------------------

    void btSave_actionPerformed(ActionEvent e) {
        save();
    }

    void btCancel_actionPerformed(ActionEvent e) {
        cancel();
    }

    void this_windowClosing(WindowEvent e) {
        cancel();
    }

}

class NumberDialog_btSave_actionAdapter implements java.awt.event.ActionListener {
    NumberDialog adaptee;

    NumberDialog_btSave_actionAdapter(NumberDialog adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.btSave_actionPerformed(e);
    }
}

class NumberDialog_btCancel_actionAdapter implements java.awt.event.ActionListener {
    NumberDialog adaptee;

    NumberDialog_btCancel_actionAdapter(NumberDialog adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.btCancel_actionPerformed(e);
    }
}

class NumberDialog_this_windowAdapter extends java.awt.event.WindowAdapter {
    NumberDialog adaptee;

    NumberDialog_this_windowAdapter(NumberDialog adaptee) {
        this.adaptee = adaptee;
    }

    public void windowClosing(WindowEvent e) {
        adaptee.this_windowClosing(e);
    }
}











