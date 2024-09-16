package org.example.gui.panel;

import com.borland.jbcl.layout.*;
import org.example.entity.Constants;
import org.example.entity.DataModule;
import org.example.entity.Record;
import org.example.entity.TimeFormat;
import org.example.entity.TopTen;
import org.example.gui.RecordLabel;

import javax.swing.JPanel;
import javax.swing.UIManager;
import java.awt.FlowLayout;

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
 * A rekordok adatait tartalmazó panel
 */
public class RecordPanel extends JPanel implements Constants {

    /**
     * Adatmodul
     */
    private DataModule dataModule = DataModule.getDataModule();

    /**
     * helyezések
     */
    private RecordLabel[] numbers = new RecordLabel[10];
    /**
     * nevek
     */
    private RecordLabel[] names = new RecordLabel[10];
    /**
     * időeredmények
     */
    private RecordLabel[] times = new RecordLabel[10];
    /**
     * bűntetések
     */
    private RecordLabel[] penalties = new RecordLabel[10];
    /**
     * dátumok
     */
    private RecordLabel[] dates = new RecordLabel[10];

    JPanel pnNumber = new JPanel();
    JPanel pnName = new JPanel();
    JPanel pnTime = new JPanel();
    JPanel pnPenalty = new JPanel();
    JPanel pnDate = new JPanel();

    VerticalFlowLayout verticalFlowLayout1 = new VerticalFlowLayout();
    VerticalFlowLayout verticalFlowLayout2 = new VerticalFlowLayout();
    VerticalFlowLayout verticalFlowLayout3 = new VerticalFlowLayout();
    VerticalFlowLayout verticalFlowLayout4 = new VerticalFlowLayout();
    VerticalFlowLayout verticalFlowLayout5 = new VerticalFlowLayout();

    FlowLayout flowLayout1 = new FlowLayout();

    //----------------------------------------------------------------------

    /**
     * Konstruktor
     */
    public RecordPanel() {
        try {
            jbInit();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    //----------------------------------------------------------------------

    void jbInit() throws Exception {
        this.setLayout(flowLayout1);
        pnNumber.setLayout(verticalFlowLayout1);
        pnTime.setLayout(verticalFlowLayout2);
        pnName.setLayout(verticalFlowLayout3);
        pnPenalty.setLayout(verticalFlowLayout4);
        pnDate.setLayout(verticalFlowLayout5);
        verticalFlowLayout3.setHgap(5);
        flowLayout1.setHgap(0);
        this.add(pnNumber, null);
        this.add(pnName, null);
        this.add(pnTime, null);
        this.add(pnPenalty, null);
        this.add(pnDate, null);

        pnNumber.add(new RecordLabel(" ", RecordLabel.RIGHT, 25, false, false));
        pnName.add(new RecordLabel("Név", RecordLabel.CENTER, 150, false, false));
        pnTime.add(new RecordLabel("Játékidő", RecordLabel.CENTER, 70, false, false));
        pnPenalty.add(new RecordLabel("Büntetés", RecordLabel.CENTER, 70, false, false));
        pnDate.add(new RecordLabel("Dátum / Idő", RecordLabel.CENTER, 135, false, false));

        for (int i = 0; i < 10; i++) {
            RecordLabel label = null;
            pnNumber.add(label = new RecordLabel(" " + (i + 1) + ".", RecordLabel.RIGHT, 20, false, false));
            numbers[i] = label;
            pnName.add(label = new RecordLabel(" ", RecordLabel.LEFT, 150, true, true));
            names[i] = label;
            pnTime.add(label = new RecordLabel(" ", RecordLabel.CENTER, 70, true, true));
            times[i] = label;
            pnPenalty.add(label = new RecordLabel(" ", RecordLabel.CENTER, 70, true, true));
            penalties[i] = label;
            pnDate.add(label = new RecordLabel(" ", RecordLabel.CENTER, 130, true, true));
            dates[i] = label;
        }
    }

    //----------------------------------------------------------------------

    /**
     * Kiválasztja (más színnel jelöli) az éppen született rekordot
     */
    public void selectActualRecord() {
        for (int i = 10 - 1; i >= 0; i--) {
            if (names[i].getText().equals(dataModule.getLastRecord().getPlayer()) &&
                    times[i].getText().equals(TimeFormat.format(dataModule.getLastRecord().getTime())) &&
                    penalties[i].getText().equals(TimeFormat.format(dataModule.getLastRecord().getPenalty())) &&
                    dates[i].getText().equals(dataModule.getLastRecord().getDateToString())) {
                numbers[i].setBackground(UIManager.getColor("List.selectionBackground"));
                numbers[i].setForeground(UIManager.getColor("List.selectionForeground"));
                break;
            }
        }
    }

    //----------------------------------------------------------------------

    /**
     * Törli a rekord kijelöltségét
     */
    public void clearActualRecordSelection() {
        for (int i = 0; i < 10; i++) {
            numbers[i].setBackground(UIManager.getColor("Label.background"));
            numbers[i].setForeground(UIManager.getColor("Label.foreground"));
        }
    }

    //----------------------------------------------------------------------

    /**
     * Törli az összes rekorderedményt
     */
    public void clearRecords() {
        for (int i = 0; i < 10; i++) {
            names[i].setText("");
            times[i].setText("");
            penalties[i].setText("");
            dates[i].setText("");
        }
    }

    //----------------------------------------------------------------------

    /**
     * Beállítja a rekordokat a kapott legjobb tíz szerint
     */
    public void setRecords(TopTen topTen) {
        clearRecords();
        clearActualRecordSelection();
        for (int i = 0; i < topTen.size(); i++) {
            Record record = (Record) topTen.getRecord(i);
            names[i].setText(record.getPlayer());
            times[i].setText(TimeFormat.format(record.getTime()));
            penalties[i].setText(TimeFormat.format(record.getPenalty()));
            dates[i].setText(record.getDateToString());
        }

    }
}











