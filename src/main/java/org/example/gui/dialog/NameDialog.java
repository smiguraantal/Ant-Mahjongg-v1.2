package org.example.gui.dialog;

import org.example.entity.DataModule;
import org.example.gui.MainFrame;
import org.example.gui.WindowLocation;
import org.example.gui.manager.MessageManager;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.UIManager;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowEvent;
import java.util.GregorianCalendar;
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
 * A rekorder nevét bekérő dialógus
 */
public class NameDialog extends JDialog {

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

    /**
     * A rekord születésének pillanata
     */
    private GregorianCalendar calendar;

    JPanel panel1 = new JPanel();
    BorderLayout borderLayout1 = new BorderLayout();
    JPanel jPanel1 = new JPanel();
    JButton btSave = new JButton();
    JButton btCancel = new JButton();
    FlowLayout flowLayout1 = new FlowLayout();
    JPanel jPanel2 = new JPanel();
    FlowLayout flowLayout2 = new FlowLayout();
    JLabel jLabel1 = new JLabel();
    JTextField tfName = new JTextField();
    JPanel jPanel3 = new JPanel();
    JTextArea jTextArea1 = new JTextArea();
    FlowLayout flowLayout3 = new FlowLayout();

    //----------------------------------------------------------------------

    /**
     * Konstruktor
     */
    public NameDialog(MainFrame mainFrame) {
        super(mainFrame, "Új rekord", true);
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
        this.addWindowListener(new NameDialog_this_windowAdapter(this));
        panel1.setLayout(borderLayout1);
        btSave.setText("Mentés");
        btSave.addActionListener(new NameDialog_btSave_actionAdapter(this));
        btCancel.setText("Mégse");
        btCancel.addActionListener(new NameDialog_btCancel_actionAdapter(this));
        jPanel1.setLayout(flowLayout1);
        jPanel2.setLayout(flowLayout2);
        jLabel1.setText("Név:");
        tfName.setText("");
        tfName.setColumns(20);
        tfName.addKeyListener(new NameDialog_tfName_keyAdapter(this));
        flowLayout2.setAlignment(FlowLayout.LEFT);
        flowLayout1.setAlignment(FlowLayout.CENTER);
        jTextArea1.setBackground(UIManager.getColor("Panel.background"));
        jTextArea1.setEnabled(false);
        jTextArea1.setAlignmentX((float) 0.5);
        jTextArea1.setDisabledTextColor(UIManager.getColor("TextArea.foreground"));
        jTextArea1.setEditable(false);
        jTextArea1.setText("Gratulálok!\n\n" +
                "Eredményed a tíz legjobb között van. Amennyiben szeretnél felkerülni az eredménytáblára, add meg a neved!");
        jTextArea1.setColumns(30);
        jTextArea1.setLineWrap(true);
        jTextArea1.setTabSize(8);
        jTextArea1.setWrapStyleWord(true);
        jPanel3.setLayout(flowLayout3);
        flowLayout3.setAlignment(FlowLayout.LEFT);
        flowLayout3.setVgap(10);
        getContentPane().add(panel1);
        panel1.add(jPanel1, BorderLayout.SOUTH);
        jPanel1.add(btSave, null);
        jPanel1.add(btCancel, null);
        panel1.add(jPanel2, BorderLayout.CENTER);
        jPanel2.add(jLabel1, null);
        jPanel2.add(tfName, null);
        panel1.add(jPanel3, BorderLayout.NORTH);
        jPanel3.add(jTextArea1, null);

        jTextArea1.setFont((Font) UIManager.get("Label.font"));

        addKeyListening();
    }

    //----------------------------------------------------------------------

    /**
     * Hozzáadja a komponensekhez az Escape figyelést
     */
    private void addKeyListening() {
        Vector components = new Vector();
        components.add(tfName);
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
    public boolean showDialog(GregorianCalendar calendar) {
        this.calendar = calendar;
        pack();
        new WindowLocation(this, WindowLocation.CENTER);
        tfName.setText(dataModule.getLastRecord().getPlayer());
        tfName.selectAll();
        tfName.requestFocus();
        tfName.selectAll();
        dataModule.setDialogShowing(true);
        show();
        tfName.selectAll();
        tfName.requestFocus();
        tfName.selectAll();
        dataModule.setDialogShowing(false);
        return save;
    }

    //----------------------------------------------------------------------

    /**
     * Ha jó a kitöltés, menti a rekordot
     */
    private void save() {
        if (tfName.getText().trim().equals("")) {
            MessageManager.showInfoDialog(this, "A név nincs kitöltve!");
            tfName.requestFocus();
            tfName.setText("");
        } else {
            dataModule.addRecord(tfName.getText().trim(), calendar);
            save = true;
            hide();
        }
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

    void tfName_keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_ENTER) {
            save();
        }
    }
}

class NameDialog_btSave_actionAdapter implements java.awt.event.ActionListener {
    NameDialog adaptee;

    NameDialog_btSave_actionAdapter(NameDialog adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.btSave_actionPerformed(e);
    }
}

class NameDialog_btCancel_actionAdapter implements java.awt.event.ActionListener {
    NameDialog adaptee;

    NameDialog_btCancel_actionAdapter(NameDialog adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.btCancel_actionPerformed(e);
    }
}

class NameDialog_this_windowAdapter extends java.awt.event.WindowAdapter {
    NameDialog adaptee;

    NameDialog_this_windowAdapter(NameDialog adaptee) {
        this.adaptee = adaptee;
    }

    public void windowClosing(WindowEvent e) {
        adaptee.this_windowClosing(e);
    }
}

class NameDialog_tfName_keyAdapter extends KeyAdapter {
    NameDialog adaptee;

    NameDialog_tfName_keyAdapter(NameDialog adaptee) {
        this.adaptee = adaptee;
    }

    public void keyPressed(KeyEvent e) {
        adaptee.tfName_keyPressed(e);
    }
}










