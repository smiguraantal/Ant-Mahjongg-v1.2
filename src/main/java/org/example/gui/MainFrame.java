package org.example.gui;

import com.sun.java.swing.plaf.motif.MotifLookAndFeel;
import com.sun.java.swing.plaf.windows.WindowsLookAndFeel;
import org.example.entity.BackgroundProperties;
import org.example.entity.ColorTheme;
import org.example.entity.Constants;
import org.example.entity.DataModule;
import org.example.entity.GameNumberFormat;
import org.example.entity.GameState;
import org.example.entity.Location;
import org.example.entity.Style;
import org.example.entity.ThreeDimensionalEffect;
import org.example.entity.Time;
import org.example.entity.TimeFormat;
import org.example.factory.NumberedGameFactory;
import org.example.gui.dialog.AboutDialog;
import org.example.gui.dialog.BackgroundDialog;
import org.example.gui.dialog.NameDialog;
import org.example.gui.dialog.NumberDialog;
import org.example.gui.dialog.OpenGameDialog;
import org.example.gui.dialog.ResultDialog;
import org.example.gui.dialog.SaveGameDialog;
import org.example.gui.layout.Layout;
import org.example.gui.layout.MenuLayout;
import org.example.gui.manager.ImageIconManager;
import org.example.gui.manager.MessageManager;
import org.example.gui.panel.GamePanel;
import org.example.gui.popupmenu.StatusBarPopupMenu;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JToolBar;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.BevelBorder;
import javax.swing.border.Border;
import javax.swing.plaf.metal.MetalLookAndFeel;
import java.awt.AWTEvent;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentEvent;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowEvent;
import java.io.File;
import java.net.URL;
import java.util.GregorianCalendar;

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
 * Az alkalmazás főablaka
 */
public class MainFrame extends JFrame implements Constants, Location {

    /**
     * Adatmodul
     */
    private DataModule dataModule = DataModule.getDataModule();

    /**
     * Tábla
     */
    private GamePanel gamePanel;

    /**
     * Eredmények dialógus
     */
    private ResultDialog resultDialog = new ResultDialog(this);

    /**
     * Név bekérését végző dialógus
     */
    private NameDialog nameDialog = new NameDialog(this);

    /**
     * Szám bekérést végző dialógus
     */
    private NumberDialog numberDialog = new NumberDialog(this);

    /** Használati útmutató dialógus */
    //private UseDialog useDialog = new UseDialog(this);

    /**
     * Névjegy dialógus
     */
    private AboutDialog aboutDialog = new AboutDialog(this);

    /**
     * A mentés dialógus
     */
    private SaveGameDialog saveGameDialog = new SaveGameDialog(this);

    /**
     * A megnyitás dialógus
     */
    private OpenGameDialog openGameDialog = new OpenGameDialog(this);

    private BackgroundDialog backgroundDialog = new BackgroundDialog(this);

    /**
     * Az állapotsor helyi menüje
     */
    private StatusBarPopupMenu statusBarPopupMenu;

    ButtonGroup bgLayout = new ButtonGroup();
    ButtonGroup bgStyle = new ButtonGroup();
    ButtonGroup bgBackground = new ButtonGroup();
    ButtonGroup bgLookAndFeel = new ButtonGroup();
    ButtonGroup bgThreeDimensionalEffect = new ButtonGroup();
    ButtonGroup bgWindowLocation = new ButtonGroup();
    ButtonGroup bgMarking = new ButtonGroup();

    JPanel contentPane;
    JMenuBar menuBar = new JMenuBar();
    JMenu mGame = new JMenu();
    JMenuItem miExit = new JMenuItem();
    JMenu mHelp = new JMenu();
    JMenuItem miAbout = new JMenuItem();
    JToolBar toolBar = new JToolBar();
    JButton btNew = new JButton();
    JButton btRestart = new JButton();
    JButton btShuffle = new JButton();
    ImageIcon image1;
    ImageIcon image2;
    ImageIcon image3;
    BorderLayout borderLayout1 = new BorderLayout();
    JMenuItem miNew = new JMenuItem();
    JMenu mLayout = new JMenu();
    JMenuItem miRestart = new JMenuItem();
    JMenuItem miResults = new JMenuItem();
    JMenuItem miUse = new JMenuItem();
    JMenu mSettings = new JMenu();
    JMenu mActions = new JMenu();
    JMenuItem miShowPairs = new JMenuItem();
    JMenuItem miSwap = new JMenuItem();
    JMenuItem miShuffle = new JMenuItem();
    JMenuItem miXRay = new JMenuItem();
    JCheckBoxMenuItem miSounds = new JCheckBoxMenuItem();
    JMenuItem miOpen = new JMenuItem();
    JMenuItem miSave = new JMenuItem();
    JMenuItem miSaveas = new JMenuItem();
    JMenuItem miUndo = new JMenuItem();
    JMenuItem miRedo = new JMenuItem();
    JMenu miView = new JMenu();
    JCheckBoxMenuItem miStatusBar = new JCheckBoxMenuItem();
    JCheckBoxMenuItem miToolBar = new JCheckBoxMenuItem();
    JMenu mStyle = new JMenu();

    JRadioButtonMenuItem miBamboo = new JRadioButtonMenuItem();
    JRadioButtonMenuItem miGlass = new JRadioButtonMenuItem();
    JRadioButtonMenuItem miOrangeStone = new JRadioButtonMenuItem();
    JRadioButtonMenuItem miPaper = new JRadioButtonMenuItem();
    JRadioButtonMenuItem miWhiteStone = new JRadioButtonMenuItem();
    JRadioButtonMenuItem miWhite = new JRadioButtonMenuItem();
    JRadioButtonMenuItem miWood_1 = new JRadioButtonMenuItem();
    JRadioButtonMenuItem miBone = new JRadioButtonMenuItem();
    JRadioButtonMenuItem miGreyStone = new JRadioButtonMenuItem();
    JRadioButtonMenuItem miDarkGreyStone = new JRadioButtonMenuItem();
    JRadioButtonMenuItem miCardboard = new JRadioButtonMenuItem();
    JRadioButtonMenuItem miBrownStone = new JRadioButtonMenuItem();
    JRadioButtonMenuItem miBrick = new JRadioButtonMenuItem();
    JRadioButtonMenuItem miYellowMarble = new JRadioButtonMenuItem();
    JRadioButtonMenuItem miPurpleStone = new JRadioButtonMenuItem();
    JRadioButtonMenuItem miStone = new JRadioButtonMenuItem();
    JRadioButtonMenuItem miGold = new JRadioButtonMenuItem();
    JRadioButtonMenuItem miLeather = new JRadioButtonMenuItem();
    JRadioButtonMenuItem miLeatherGold = new JRadioButtonMenuItem();
    JRadioButtonMenuItem miLeatherSilver = new JRadioButtonMenuItem();
    JRadioButtonMenuItem miRedMarble = new JRadioButtonMenuItem();
    JRadioButtonMenuItem miSilver = new JRadioButtonMenuItem();
    JRadioButtonMenuItem miWood_2 = new JRadioButtonMenuItem();

    JPanel statusBar = new JPanel();
    BorderLayout borderLayout2 = new BorderLayout();
    JPanel pnInfo = new JPanel();
    JPanel jPanel2 = new JPanel();
    FlowLayout flowLayout1 = new FlowLayout();
    JPanel pnOpens = new JPanel();
    Border border1;
    JPanel pnTiles = new JPanel();
    JPanel pnTime = new JPanel();
    JLabel lbTime = new JLabel();
    JLabel jLabel2 = new JLabel();
    JLabel lbTiles = new JLabel();
    JLabel jLabel4 = new JLabel();
    JLabel lbOpens = new JLabel();
    JLabel jLabel6 = new JLabel();
    BorderLayout borderLayout3 = new BorderLayout();
    JPanel jPanel6 = new JPanel();
    Border border2;
    JLabel lbStatus = new JLabel();
    FlowLayout flowLayout2 = new FlowLayout();
    FlowLayout flowLayout3 = new FlowLayout();
    FlowLayout flowLayout4 = new FlowLayout();
    FlowLayout flowLayout5 = new FlowLayout();
    JButton btPairs = new JButton();
    JButton btSwap = new JButton();
    //JToggleButton btRule = new JToggleButton();
    JButton btXRay = new JButton();
    JButton btOpen = new JButton();
    JButton btSave = new JButton();
    JRadioButtonMenuItem miCross = new JRadioButtonMenuItem();
    JRadioButtonMenuItem miClassic = new JRadioButtonMenuItem();
    JRadioButtonMenuItem miDiamond = new JRadioButtonMenuItem();
    JRadioButtonMenuItem miFortress = new JRadioButtonMenuItem();
    JRadioButtonMenuItem miPyramid = new JRadioButtonMenuItem();
    JRadioButtonMenuItem miTemple = new JRadioButtonMenuItem();
    JRadioButtonMenuItem miSpaceShuttle = new JRadioButtonMenuItem();
    JRadioButtonMenuItem miTwin = new JRadioButtonMenuItem();
    JRadioButtonMenuItem miRugby = new JRadioButtonMenuItem();


    JRadioButtonMenuItem miStairs = new JRadioButtonMenuItem();
    JButton btUndo = new JButton();
    JButton btRedo = new JButton();
    JButton btPause = new JButton();
    JButton btUse = new JButton();
    JButton btAbout = new JButton();
    JButton btResults = new JButton();
    JButton btSaveas = new JButton();
    JMenu mLookAndFeel = new JMenu();
    JRadioButtonMenuItem miMotif = new JRadioButtonMenuItem();
    JRadioButtonMenuItem miMetal = new JRadioButtonMenuItem();
    JRadioButtonMenuItem miWindows = new JRadioButtonMenuItem();
    JMenu mTDE = new JMenu();
    JRadioButtonMenuItem miNorthEast = new JRadioButtonMenuItem();
    JRadioButtonMenuItem miNorthWest = new JRadioButtonMenuItem();
    JRadioButtonMenuItem miSouthEast = new JRadioButtonMenuItem();
    JRadioButtonMenuItem miSouthWest = new JRadioButtonMenuItem();

    JRadioButtonMenuItem miChessRook = new JRadioButtonMenuItem();
    JRadioButtonMenuItem miZodiacScorpio = new JRadioButtonMenuItem();
    JRadioButtonMenuItem miFivePyramids = new JRadioButtonMenuItem();
    JRadioButtonMenuItem miBoat = new JRadioButtonMenuItem();
    JRadioButtonMenuItem miChessQueen = new JRadioButtonMenuItem();
    JRadioButtonMenuItem miTileFighter = new JRadioButtonMenuItem();
    JRadioButtonMenuItem miZodiacLeo = new JRadioButtonMenuItem();
    JRadioButtonMenuItem miZodiacCapricorn = new JRadioButtonMenuItem();
    JRadioButtonMenuItem miScalesOfJustice = new JRadioButtonMenuItem();
    JRadioButtonMenuItem miChessPawn = new JRadioButtonMenuItem();
    JButton btNumberedGame = new JButton();
    JMenuItem miNumberedGame = new JMenuItem();
    JPanel pnGameNumber = new JPanel();
    FlowLayout flowLayout6 = new FlowLayout();
    JLabel lbGameNumber = new JLabel();
    JLabel jLabel3 = new JLabel();
    JButton btHelp = new JButton();
    JMenuItem miHelp = new JMenuItem();
    JMenu mWindowLocation = new JMenu();

    JRadioButtonMenuItem miWindowNorthWest = new JRadioButtonMenuItem();
    JRadioButtonMenuItem miWindowNorth = new JRadioButtonMenuItem();
    JRadioButtonMenuItem miWindowNorthEast = new JRadioButtonMenuItem();
    JRadioButtonMenuItem miWindowWest = new JRadioButtonMenuItem();
    JRadioButtonMenuItem miWindowCenter = new JRadioButtonMenuItem();
    JRadioButtonMenuItem miWindowSouthWest = new JRadioButtonMenuItem();
    JRadioButtonMenuItem miWindowSouth = new JRadioButtonMenuItem();
    JRadioButtonMenuItem miWindowSouthEast = new JRadioButtonMenuItem();
    JRadioButtonMenuItem miWindowEast = new JRadioButtonMenuItem();
    JRadioButtonMenuItem miDude = new JRadioButtonMenuItem();
    JPanel pnPenalty = new JPanel();
    FlowLayout flowLayout7 = new FlowLayout();
    JLabel lbPenalty = new JLabel();
    JLabel jLabel5 = new JLabel();
    JCheckBoxMenuItem miTilePalette = new JCheckBoxMenuItem();
    JRadioButtonMenuItem miWindBei = new JRadioButtonMenuItem();
    JRadioButtonMenuItem miWindDong = new JRadioButtonMenuItem();
    JRadioButtonMenuItem miWindNan = new JRadioButtonMenuItem();
    JRadioButtonMenuItem miWindXi = new JRadioButtonMenuItem();
    JRadioButtonMenuItem miBird = new JRadioButtonMenuItem();
    JRadioButtonMenuItem miChessBishop = new JRadioButtonMenuItem();
    JRadioButtonMenuItem miZodiacSagittarius = new JRadioButtonMenuItem();
    JRadioButtonMenuItem miZodiacTaurus = new JRadioButtonMenuItem();
    JMenu mMarkings = new JMenu();

    JRadioButtonMenuItem miSea = new JRadioButtonMenuItem();
    JRadioButtonMenuItem miDesert = new JRadioButtonMenuItem();
    JRadioButtonMenuItem miViolet = new JRadioButtonMenuItem();
    JRadioButtonMenuItem miGray = new JRadioButtonMenuItem();
    JRadioButtonMenuItem miBlue = new JRadioButtonMenuItem();
    JRadioButtonMenuItem miZodiacLibra = new JRadioButtonMenuItem();
    JRadioButtonMenuItem miChessKnight = new JRadioButtonMenuItem();
    JRadioButtonMenuItem miZodiacAries = new JRadioButtonMenuItem();
    JRadioButtonMenuItem miZodiacGemini = new JRadioButtonMenuItem();
    JRadioButtonMenuItem miABC = new JRadioButtonMenuItem();
    JRadioButtonMenuItem miAnchor = new JRadioButtonMenuItem();
    JRadioButtonMenuItem miCelticCross = new JRadioButtonMenuItem();
    JRadioButtonMenuItem miJudasPriest = new JRadioButtonMenuItem();
    JRadioButtonMenuItem miNeptune = new JRadioButtonMenuItem();
    JRadioButtonMenuItem miMounds = new JRadioButtonMenuItem();
    JMenuItem miPause = new JMenuItem();
    JRadioButtonMenuItem miPluto = new JRadioButtonMenuItem();
    JRadioButtonMenuItem miUranus = new JRadioButtonMenuItem();
    JRadioButtonMenuItem miInfinity = new JRadioButtonMenuItem();
    JRadioButtonMenuItem miSpaceStation = new JRadioButtonMenuItem();
    JRadioButtonMenuItem miPumpkin = new JRadioButtonMenuItem();
    JRadioButtonMenuItem miRose = new JRadioButtonMenuItem();
    JRadioButtonMenuItem miHorizon = new JRadioButtonMenuItem();
    JRadioButtonMenuItem miDaylight = new JRadioButtonMenuItem();


    JRadioButtonMenuItem miMoss = new JRadioButtonMenuItem();
    JRadioButtonMenuItem miMahogany = new JRadioButtonMenuItem();
    JRadioButtonMenuItem miBambooColorTheme = new JRadioButtonMenuItem();
    JRadioButtonMenuItem miChrome = new JRadioButtonMenuItem();

    JRadioButtonMenuItem miDuck = new JRadioButtonMenuItem();
    JRadioButtonMenuItem miFish = new JRadioButtonMenuItem();
    JRadioButtonMenuItem miZodiacAquarius = new JRadioButtonMenuItem();
    JRadioButtonMenuItem miZodiacCancer = new JRadioButtonMenuItem();
    JRadioButtonMenuItem miZodiacPisces = new JRadioButtonMenuItem();
    JRadioButtonMenuItem miZodiacVirgo = new JRadioButtonMenuItem();
    JRadioButtonMenuItem miChessKing = new JRadioButtonMenuItem();
    JRadioButtonMenuItem miCrown = new JRadioButtonMenuItem();
    JRadioButtonMenuItem miEagle = new JRadioButtonMenuItem();
    JRadioButtonMenuItem miGayle = new JRadioButtonMenuItem();
    JRadioButtonMenuItem miBambooLayout = new JRadioButtonMenuItem();
    JRadioButtonMenuItem miCancer = new JRadioButtonMenuItem();
    JRadioButtonMenuItem miCar = new JRadioButtonMenuItem();
    JRadioButtonMenuItem miLabyrinth = new JRadioButtonMenuItem();
    JRadioButtonMenuItem miSquare = new JRadioButtonMenuItem();
    JRadioButtonMenuItem miRedDragon = new JRadioButtonMenuItem();
    JRadioButtonMenuItem miStatue = new JRadioButtonMenuItem();
    JRadioButtonMenuItem miBridges = new JRadioButtonMenuItem();
    JRadioButtonMenuItem miRhombus = new JRadioButtonMenuItem();
    JRadioButtonMenuItem miSantaClaus = new JRadioButtonMenuItem();
    JRadioButtonMenuItem miCaravel = new JRadioButtonMenuItem();
    JRadioButtonMenuItem miStar = new JRadioButtonMenuItem();
    JRadioButtonMenuItem miPumpkinLayout = new JRadioButtonMenuItem();
    JRadioButtonMenuItem miWings = new JRadioButtonMenuItem();
    JRadioButtonMenuItem miWaves = new JRadioButtonMenuItem();

    JMenu mRule = new JMenu();
    JRadioButtonMenuItem miHorizontal = new JRadioButtonMenuItem();
    JRadioButtonMenuItem miVertical = new JRadioButtonMenuItem();
    JRadioButtonMenuItem miSimple = new JRadioButtonMenuItem();
    JMenuItem miBackground = new JMenuItem();


    //----------------------------------------------------------------------

    /**
     * Kontruktor
     */
    public MainFrame() {
        enableEvents(AWTEvent.WINDOW_EVENT_MASK);
        try {
            jbInit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //----------------------------------------------------------------------

    private void jbInit() throws Exception {
        setSize(800, 600);
        //setSize(Toolkit.getDefaultToolkit().getScreenSize());
        miStatusBar.setActionCommand("Állapotsor megjelenítése / elrejtése");
        miToolBar.setActionCommand("Eszköztár megjelenítése / elrejtése");
        this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        setResizable(false);
        contentPane = (JPanel) this.getContentPane();
        border1 = BorderFactory.createBevelBorder(BevelBorder.LOWERED);
        border2 = BorderFactory.createEmptyBorder(2, 0, 2, 0);
        contentPane.setLayout(borderLayout1);
        mGame.setMnemonic('J');
        mGame.setText("Játék");
        miExit.setActionCommand("Kilépés a Mahjongg-ból");
        miExit.setText("Kilépés");
        miExit.setAccelerator(javax.swing.KeyStroke.getKeyStroke(KeyEvent.VK_F4, KeyEvent.ALT_MASK, false));
        miExit.addActionListener(new MainFrame_miExit_ActionAdapter(this));
        mHelp.setMnemonic('S');
        mHelp.setText("Súgó");
        miAbout.setActionCommand("Információk a programról");
        miAbout.setText("Névjegy");
        miAbout.setAccelerator(javax.swing.KeyStroke.getKeyStroke('N', KeyEvent.CTRL_MASK, false));
        btNew.addActionListener(new MainFrame_btNew_actionAdapter(this));
        btNew.setToolTipText("Új játék");
        btNumberedGame.setToolTipText("Játék kiválasztása");
        btRestart.addActionListener(new MainFrame_btRestart_actionAdapter(this));
        btRestart.setToolTipText("Újrakezdés");
        btShuffle.addActionListener(new MainFrame_btShuffle_actionAdapter(this));
        btShuffle.setToolTipText("Keverés");
        //btRule.setToolTipText("Függőleges szabály");
        btHelp.setToolTipText("Segítség");
        toolBar.setFloatable(false);
        miNew.setActionCommand("Új játék kezdése");
        miNew.setText("Új");
        miNew.setAccelerator(javax.swing.KeyStroke.getKeyStroke(KeyEvent.VK_F2, 0, false));
        miNumberedGame.setAccelerator(javax.swing.KeyStroke.getKeyStroke(KeyEvent.VK_F3, 0, false));
        mLayout.setActionCommand("Elrendezés kiválasztása");
        mLayout.setText("Elrendezés");
        miRestart.setActionCommand("Aktuális játék újrakezdése");
        miRestart.setText("Újrakezdés");
        miRestart.setAccelerator(javax.swing.KeyStroke.getKeyStroke('R', KeyEvent.CTRL_MASK | KeyEvent.ALT_MASK, false));
        miResults.setActionCommand("Eredmények megjelenítése");
        miResults.setText("Eredmények");
        miResults.setAccelerator(javax.swing.KeyStroke.getKeyStroke('R', KeyEvent.CTRL_MASK, false));
        miUse.setActionCommand("Használati útmutató");
        miUse.setText("Használat");
        miUse.setAccelerator(javax.swing.KeyStroke.getKeyStroke(KeyEvent.VK_F1, 0, false));
        miUse.addActionListener(new MainFrame_miUse_actionAdapter(this));
        mSettings.setMnemonic('B');
        mSettings.setText("Beállítások");
        mActions.setMnemonic('M');
        mActions.setText("Műveletek");
        miShowPairs.setText("Párok");
        miSwap.setActionCommand("A kijelölt kő alulra küldése");
        miSwap.setText("Csere");
        miSwap.setAccelerator(javax.swing.KeyStroke.getKeyStroke('C', KeyEvent.CTRL_MASK, false));
        miShuffle.setActionCommand("Kövek keverése");
        miShuffle.setText("Keverés");
        miShuffle.setAccelerator(javax.swing.KeyStroke.getKeyStroke('S', KeyEvent.CTRL_MASK | KeyEvent.ALT_MASK, false));
        miXRay.setText("Takart kövek");
        miSounds.setActionCommand("Hangok engedélyezése / tiltása");
        miSounds.setText("Hangok");
        miOpen.setActionCommand("Játék megnyitása");
        miOpen.setText("Megnyitás");
        miOpen.setAccelerator(javax.swing.KeyStroke.getKeyStroke('O', KeyEvent.CTRL_MASK, false));
        miOpen.addActionListener(new MainFrame_miOpen_actionAdapter(this));
        miSave.setActionCommand("Játék elmentése");
        miSave.setText("Mentés");
        miSave.setAccelerator(javax.swing.KeyStroke.getKeyStroke('S', KeyEvent.CTRL_MASK, false));
        miSave.addActionListener(new MainFrame_miSave_actionAdapter(this));
        miSaveas.setActionCommand("Játék elmentése más néven");
        miSaveas.setText("Mentés másként");
        miSaveas.setAccelerator(javax.swing.KeyStroke.getKeyStroke('S', KeyEvent.CTRL_MASK | KeyEvent.ALT_MASK, false));
        miUndo.setRequestFocusEnabled(false);
        miUndo.setActionCommand("Utolsó művelet visszavonása");
        miUndo.setText("Visszavonás");
        miUndo.setAccelerator(javax.swing.KeyStroke.getKeyStroke('Z', KeyEvent.CTRL_MASK, false));
        miRedo.setActionCommand("Visszavont művelet ismételt elvégzése");
        miRedo.setText("Ismét");
        miRedo.setAccelerator(javax.swing.KeyStroke.getKeyStroke('Z', KeyEvent.CTRL_MASK | KeyEvent.SHIFT_MASK, false));
        miView.setMnemonic('N');
        miView.setText("Nézet");
        miStatusBar.setText("Állapotsor");
        miStatusBar.addActionListener(new MainFrame_miStatusBar_actionAdapter(this));
        miToolBar.setText("Eszköztár");
        miToolBar.addActionListener(new MainFrame_miToolBar_actionAdapter(this));
        mStyle.setActionCommand("Stílus kiválasztása");
        mStyle.setText("Stílus");
        miBamboo.setText("Bambusz");
        miGlass.setText("Üveg");
        miOrangeStone.setText("Sárga kő");
        miPaper.setText("Pergamen");
        miWhiteStone.setText("Homokkő");
        miWhite.setText("Műanyag");
        miWood_1.setText("Bükk");
        statusBar.setLayout(borderLayout2);
        jPanel2.setLayout(flowLayout1);
        pnInfo.setLayout(borderLayout3);
        pnOpens.setBorder(border1);
        pnOpens.setLayout(flowLayout5);
        pnTiles.setAlignmentY((float) 0.5);
        pnTiles.setBorder(border1);
        pnTiles.setLayout(flowLayout4);
        pnTime.setBorder(border1);
        pnTime.setLayout(flowLayout3);
        flowLayout1.setHgap(0);
        flowLayout1.setVgap(0);
        lbTime.setText("00:00");
        lbPenalty.setText("00:00");
        jLabel2.setText("Idő:");
        jLabel4.setText("Kövek:");
        jLabel6.setText("Párok:");
        jPanel6.setBorder(border1);
        jPanel6.setLayout(flowLayout2);
        flowLayout2.setAlignment(FlowLayout.LEFT);
        flowLayout2.setVgap(0);
        flowLayout3.setHgap(5);
        flowLayout3.setVgap(0);
        flowLayout4.setVgap(0);
        flowLayout5.setHgap(5);
        flowLayout5.setVgap(0);
        pnInfo.setBorder(null);
        btPairs.setText("Pairs");
        btSwap.addActionListener(new MainFrame_btSwap_actionAdapter(this));
        btXRay.setText("X-Ray");
        btXRay.addActionListener(new MainFrame_btXRay_actionAdapter(this));

        miCross.setText("Cross");
        miCross.addActionListener(new MainFrame_miCross_actionAdapter(this));
        miClassic.setText("Classic");
        miClassic.addActionListener(new MainFrame_miClassic_actionAdapter(this));
        miDiamond.setText("Diamond");
        miDiamond.addActionListener(new MainFrame_miDiamond_actionAdapter(this));
        miFortress.setText("Fortress");
        miFortress.addActionListener(new MainFrame_miFortress_actionAdapter(this));
        miPyramid.setText("Pyramid");
        miPyramid.addActionListener(new MainFrame_miPyramid_actionAdapter(this));
        miTemple.setText("Temple");
        miTemple.addActionListener(new MainFrame_miTemple_actionAdapter(this));
        miTemple.addActionListener(new MainFrame_miSmallDiamond_actionAdapter(this));
        miSpaceShuttle.setText("Space Shuttle");
        miSpaceShuttle.addActionListener(new MainFrame_miSpaceShuttle_actionAdapter(this));
        miTwin.setText("Twin");
        miTwin.addActionListener(new MainFrame_miTwin_actionAdapter(this));
        miRugby.addActionListener(new MainFrame_miRugby_actionAdapter(this));

        miBackground.setActionCommand("Háttér kiválasztása");
        miBackground.setAccelerator(javax.swing.KeyStroke.getKeyStroke('B', KeyEvent.CTRL_MASK, false));
        miRugby.setText("Rugby");
        miStairs.setText("Stairs");
        miStairs.addActionListener(new MainFrame_miStairs_actionAdapter(this));
        btAbout.addActionListener(new MainFrame_btAbout_actionAdapter(this));

        btResults.addActionListener(new MainFrame_btResults_actionAdapter(this));
        btOpen.setToolTipText("Megnyitás");
        btSave.setToolTipText("Mentés");
        btResults.setToolTipText("Eredmények");
        btUndo.setToolTipText("Visszavonás");
        btUndo.addActionListener(new MainFrame_btUndo_actionAdapter(this));
        btRedo.setToolTipText("Ismét");
        btRedo.addActionListener(new MainFrame_btRedo_actionAdapter(this));
        btPause.setToolTipText("Felfüggesztés");

        btUse.setToolTipText("Használat");
        btAbout.setToolTipText("Névjegy");
        mLookAndFeel.setActionCommand("Felület kiválasztása");
        mLookAndFeel.setText("Felület");
        miMotif.setText("CDE/Motif");
        miMotif.addActionListener(new MainFrame_miMotif_actionAdapter(this));
        miMetal.setText("Metal");
        miMetal.addActionListener(new MainFrame_miMetal_actionAdapter(this));
        miWindows.setText("Windows");
        miWindows.addActionListener(new MainFrame_miWindows_actionAdapter(this));
        miBone.setText("Csont");
        miBone.addActionListener(new MainFrame_miBone_actionAdapter(this));
        miBrick.setText("Tégla");
        miBrick.addActionListener(new MainFrame_miBrick_actionAdapter(this));
        miBrownStone.setText("Barna kő");
        miBrownStone.addActionListener(new MainFrame_miBrownStone_actionAdapter(this));
        miCardboard.setText("Karton");
        miCardboard.addActionListener(new MainFrame_miCardboard_actionAdapter(this));
        miDarkGreyStone.setText("Gránit");
        miDarkGreyStone.addActionListener(new MainFrame_miDarkGreyStone_actionAdapter(this));
        miGreyStone.setText("Szürke kő");
        miGreyStone.addActionListener(new MainFrame_miGrayStone_actionAdapter(this));
        miYellowMarble.setText("Sárga márvány");
        miYellowMarble.addActionListener(new MainFrame_miYellowMarble_actionAdapter(this));
        miPurpleStone.setText("Lila kő");
        miPurpleStone.addActionListener(new MainFrame_miPurpleStone_actionAdapter(this));
        miStone.setText("Drapp kő");
        miStone.addActionListener(new MainFrame_miStone_actionAdapter(this));
        miGold.setText("Arany");
        miGold.addActionListener(new MainFrame_miGold_actionAdapter(this));

        miLeather.setText("Bőr");
        miLeather.addActionListener(new MainFrame_miLeather_actionAdapter(this));
        miLeatherGold.setText("Bőr 2");
        miLeatherGold.addActionListener(new MainFrame_miLeatherGold_actionAdapter(this));
        miLeatherSilver.setText("Bőr 2");
        miLeatherSilver.addActionListener(new MainFrame_miLeatherSilver_actionAdapter(this));
        miRedMarble.setText("Vörös márvány");
        miRedMarble.addActionListener(new MainFrame_miRedMarble_actionAdapter(this));
        miSilver.setText("Ezüst");
        miSilver.addActionListener(new MainFrame_miSilver_actionAdapter(this));
        miWood_2.setText("Fenyő");
        miWood_2.addActionListener(new MainFrame_miWood_2_actionAdapter(this));

        mTDE.setText("Térhatás");
        mTDE.setActionCommand("Térhatás kiválasztása");
        miNorthEast.setText("Jobbra-fel");
        miNorthEast.addActionListener(new MainFrame_miNorthEast_actionAdapter(this));
        miNorthWest.setText("Balra-fel");
        miNorthWest.addActionListener(new MainFrame_miNorthWest_actionAdapter(this));
        miSouthEast.setText("Jobbra-Le");
        miSouthEast.addActionListener(new MainFrame_miSouthEast_actionAdapter(this));
        miSouthWest.setText("Balra-Le");
        miSouthWest.addActionListener(new MainFrame_miSouthWest_actionAdapter(this));

        miChessRook.setText("Chess-Rook");
        miChessRook.addActionListener(new MainFrame_miChessRook_actionAdapter(this));
        miZodiacScorpio.setText("Zodiac-Scorpio");
        miZodiacScorpio.addActionListener(new MainFrame_miZodiacScorpio_actionAdapter(this));
        miFivePyramids.setText("Five Pyramids");
        miFivePyramids.addActionListener(new MainFrame_miFivePyramids_actionAdapter(this));
        miBoat.setText("Boat");
        miBoat.addActionListener(new MainFrame_miBoat_actionAdapter(this));
        miChessQueen.setText("Chess-Queen");
        miChessQueen.addActionListener(new MainFrame_miQueen_actionAdapter(this));
        miTileFighter.setText("Tile Fighter");
        miTileFighter.addActionListener(new MainFrame_miTileFighter_actionAdapter(this));
        miNumberedGame.setText("Játék kiválasztása");
        miNumberedGame.addActionListener(new MainFrame_miNumberedGame_actionAdapter(this));
        pnGameNumber.setLayout(flowLayout6);
        flowLayout6.setVgap(0);
        jLabel3.setText("Játék:");
        pnGameNumber.setBorder(border1);
        lbGameNumber.setText("");
        lbStatus.setText(" ");
        btHelp.setText("");
        miHelp.setText("Segítség");
        miHelp.setAccelerator(javax.swing.KeyStroke.getKeyStroke('H', KeyEvent.CTRL_MASK, false));
        miHelp.addActionListener(new MainFrame_miHelp_actionAdapter(this));
        miZodiacLeo.setText("Zodiac-Leo");
        miZodiacLeo.addActionListener(new MainFrame_miZodiacLeo_actionAdapter(this));
        miZodiacCapricorn.setText("Zodiac-Capricorn");
        miZodiacCapricorn.addActionListener(new MainFrame_miZodiacCapricorn_actionAdapter(this));
        miScalesOfJustice.setText("Scales Of Justice");
        miScalesOfJustice.addActionListener(new MainFrame_miScalesOfJustice_actionAdapter(this));
        miChessPawn.setText("Chess-Pawn");
        miChessPawn.addActionListener(new MainFrame_miChessPawn_actionAdapter(this));
        mWindowLocation.setText("Ablak elhelyezése");
        mWindowLocation.setActionCommand("Az ablak ígazítása a kiválasztott helyre");
        miWindowNorthWest.setText("Bal-felső sarokban");
        miWindowNorthWest.addActionListener(new MainFrame_miWindowNortWest_actionAdapter(this));
        miWindowNorth.setText("Fent-középen");
        miWindowNorth.addActionListener(new MainFrame_miWindowNorth_actionAdapter(this));
        miWindowNorthEast.setText("Jobb-felső sarokban");
        miWindowNorthEast.addActionListener(new MainFrame_miWindowNorthEast_actionAdapter(this));
        miWindowWest.setText("Bal oldalon");
        miWindowWest.addActionListener(new MainFrame_miWindowWest_actionAdapter(this));
        miWindowCenter.setText("Középen");
        miWindowCenter.addActionListener(new MainFrame_miWindowCenter_actionAdapter(this));
        miWindowSouthWest.setText("Bal-alsó sarokban");
        miWindowSouthWest.addActionListener(new MainFrame_miWindowSouthWest_actionAdapter(this));
        miWindowSouth.setText("Lent-középen");
        miWindowSouth.addActionListener(new MainFrame_miWindowSouth_actionAdapter(this));
        miWindowSouthEast.setText("Jobb-alsó sarokban");
        miWindowSouthEast.addActionListener(new MainFrame_miWindowSouthEast_actionAdapter(this));
        miWindowEast.setText("Jobb oldalon");
        miWindowEast.addActionListener(new MainFrame_miWindowEast_actionAdapter(this));
        miDude.setText("Dude");
        miDude.addActionListener(new MainFrame_miDude_actionAdapter(this));

        pnPenalty.setLayout(flowLayout7);
        flowLayout7.setVgap(0);
        jLabel5.setText("Büntetés:");
        pnPenalty.setBorder(border1);
        miTilePalette.setText("Kőpaletta");
        miTilePalette.setActionCommand("Kőpaletta megjelenítése / elrejtése");
        miTilePalette.addActionListener(new MainFrame_miTilePalette_actionAdapter(this));
        miWindBei.setText("Wind-Bei");
        miWindBei.addActionListener(new MainFrame_miWindBei_actionAdapter(this));
        miWindDong.setText("Wind-Dong");
        miWindDong.addActionListener(new MainFrame_miWindDong_actionAdapter(this));
        miWindNan.setText("Wind-Nan");
        miWindNan.addActionListener(new MainFrame_miWindNan_actionAdapter(this));
        miWindXi.setText("Wind-Xi");
        miWindXi.addActionListener(new MainFrame_miWindXi_actionAdapter(this));
        miBird.setText("Bird");
        miBird.addActionListener(new MainFrame_miBird_actionAdapter(this));
        miChessBishop.setText("Chess-Bishop");
        miChessBishop.addActionListener(new MainFrame_miChessBishop_actionAdapter(this));
        miZodiacSagittarius.setText("Zodiac-Sagittarius");
        miZodiacSagittarius.addActionListener(new MainFrame_miZodiacSagittarius_actionAdapter(this));
        miZodiacTaurus.setText("Zodiac-Taurus");
        miZodiacTaurus.addActionListener(new MainFrame_miZodiacTaurus_actionAdapter(this));
        mMarkings.setActionCommand("A kővek mintázatának kiválasztása");
        mMarkings.setText("Mintázat");
        miSea.setText(SEA.getName());
        miSea.addActionListener(new MainFrame_miSea_actionAdapter(this));
        miDesert.setText(DESERT.getName());
        miDesert.addActionListener(new MainFrame_miDesert_actionAdapter(this));
        miViolet.setText(VIOLET_COLORED.getName());
        miViolet.addActionListener(new MainFrame_miViolet_actionAdapter(this));
        miGray.setText(GRAY.getName());
        miGray.addActionListener(new MainFrame_miGray_actionAdapter(this));
        miBlue.setText(BLUE.getName());
        miBlue.addActionListener(new MainFrame_miBlue_actionAdapter(this));
        miZodiacLibra.setText("Zodiac-Libra");
        miZodiacLibra.addActionListener(new MainFrame_miZodiacLibra_actionAdapter(this));
        miChessKnight.setText("Chess-Knight");
        miChessKnight.addActionListener(new MainFrame_miChessKnight_actionAdapter(this));
        miZodiacAries.setText("Zodiac-Aries");
        miZodiacAries.addActionListener(new MainFrame_miZodiacAries_actionAdapter(this));
        miZodiacGemini.setText("Zodiac-Gemini");
        miZodiacGemini.addActionListener(new MainFrame_miZodiacGemini_actionAdapter(this));
        miABC.setText("ABC");
        miABC.addActionListener(new MainFrame_miABC_actionAdapter(this));
        miAnchor.setText("Anchor");
        miAnchor.addActionListener(new MainFrame_miAnchor_actionAdapter(this));
        miCelticCross.setText("Celtic Cross");
        miCelticCross.addActionListener(new MainFrame_miCelticCross_actionAdapter(this));
        miJudasPriest.setText("Judas Priest");
        miJudasPriest.addActionListener(new MainFrame_miJudasPriest_actionAdapter(this));
        miNeptune.setText("Neptune");
        miNeptune.addActionListener(new MainFrame_miNeptune_actionAdapter(this));
        miMounds.setText("Mounds");
        miMounds.addActionListener(new MainFrame_miMounds_actionAdapter(this));
        miPause.setActionCommand("A játék felfüggesztése");
        miPause.setText("Felfüggesztés");
        miPause.setAccelerator(javax.swing.KeyStroke.getKeyStroke('P', KeyEvent.CTRL_MASK, false));
        miPause.addActionListener(new MainFrame_miPause_actionAdapter(this));
        miPluto.setText("Pluto");
        miPluto.addActionListener(new MainFrame_miPluto_actionAdapter(this));
        miUranus.setText("Uranus");
        miUranus.addActionListener(new MainFrame_miUranus_actionAdapter(this));
        miInfinity.setText("Infinity");
        miInfinity.addActionListener(new MainFrame_miInfinity_actionAdapter(this));
        miSpaceStation.setText("Space Station");
        miSpaceStation.addActionListener(new MainFrame_miSpaceStation_actionAdapter(this));
        miPumpkin.setText(PUMPKIN.getName());
        miPumpkin.addActionListener(new MainFrame_miPumpkin_actionAdapter(this));
        miRose.setText(ROSE.getName());
        miRose.addActionListener(new MainFrame_miRose_actionAdapter(this));
        miMoss.setText(MOSS.getName());
        miMoss.addActionListener(new MainFrame_miMoss_actionAdapter(this));
        miMahogany.setText(MAHOGANY.getName());
        miMahogany.addActionListener(new MainFrame_miMahogany_actionAdapter(this));
        miBambooColorTheme.setText(BAMBOO.getName());
        miBambooColorTheme.addActionListener(new MainFrame_miBambooColorTheme_actionAdapter(this));
        miChrome.setText(CHROME.getName());
        miChrome.addActionListener(new MainFrame_miChrome_actionAdapter(this));
        miHorizon.setText(HORIZON.getName());
        miHorizon.addActionListener(new MainFrame_miHorizon_actionAdapter(this));
        miDaylight.setText(DAYLIGHT.getName());
        miDaylight.addActionListener(new MainFrame_miDaylight_actionAdapter(this));

        miDuck.setText("Duck");
        miDuck.addActionListener(new MainFrame_miDuck_actionAdapter(this));
        miFish.setText("Fish");
        miFish.addActionListener(new MainFrame_miFish_actionAdapter(this));
        miZodiacAquarius.setText("Zodiac-Aquarius");
        miZodiacAquarius.addActionListener(new MainFrame_miZodiacAquarius_actionAdapter(this));
        miZodiacCancer.setText("Zodiac-Cancer");
        miZodiacCancer.addActionListener(new MainFrame_miZodiacCancer_actionAdapter(this));
        miZodiacPisces.setText("Zodiac-Pisces");
        miZodiacPisces.addActionListener(new MainFrame_miZodiacPisces_actionAdapter(this));
        miZodiacVirgo.setText("Zodiac-Virgo");
        miZodiacVirgo.addActionListener(new MainFrame_miZodiacVirgo_actionAdapter(this));
        miChessKing.setText("Chess-King");
        miChessKing.addActionListener(new MainFrame_miChessKing_actionAdapter(this));
        miCrown.setText("Crown");
        miCrown.addActionListener(new MainFrame_miCrown_actionAdapter(this));
        miEagle.setText("Eagle");
        miEagle.addActionListener(new MainFrame_miEagle_actionAdapter(this));
        miGayle.setText("Gayle");
        miGayle.addActionListener(new MainFrame_miGayle_actionAdapter(this));
        miBambooLayout.setText("Bamboo");
        miBambooLayout.addActionListener(new MainFrame_miBambooLayout_actionAdapter(this));
        miCancer.setText("Cancer");
        miCancer.addActionListener(new MainFrame_miCancer_actionAdapter(this));
        miCar.setText("Car");
        miCar.addActionListener(new MainFrame_miCar_actionAdapter(this));
        miLabyrinth.setText("Labyrinth");
        miLabyrinth.addActionListener(new MainFrame_miLabyrinth_actionAdapter(this));
        miSquare.setText("Square");
        miSquare.addActionListener(new MainFrame_miSquare_actionAdapter(this));
        miRedDragon.setText("Red Dragon");
        miRedDragon.addActionListener(new MainFrame_miRedDragon_actionAdapter(this));
        miStatue.setText("Statue");
        miStatue.addActionListener(new MainFrame_miStatue_actionAdapter(this));
        miBridges.setText("Bridges");
        miBridges.addActionListener(new MainFrame_miBridges_actionAdapter(this));
        miRhombus.setText("Rhombus");
        miRhombus.addActionListener(new MainFrame_miRhombus_actionAdapter(this));
        miSantaClaus.setText("Santa Claus");
        miSantaClaus.addActionListener(new MainFrame_miSantaClaus_actionAdapter(this));
        miCaravel.setText("Caravel");
        miCaravel.addActionListener(new MainFrame_miCaravel_actionAdapter(this));
        miStar.setText("Star");
        miStar.addActionListener(new MainFrame_miStar_actionAdapter(this));
        miPumpkinLayout.setText("Pumpkin");
        miPumpkinLayout.addActionListener(new MainFrame_miPumpkinLayout_actionAdapter(this));
        miWings.setText("Wings");
        miWings.addActionListener(new MainFrame_miWings_actionAdapter(this));
        miWaves.setText("Waves");
        miWaves.addActionListener(new MainFrame_miWaves_actionAdapter(this));

        mRule.setActionCommand("Szabály kiválasztása");
        mRule.setText("Szabály");
        miHorizontal.setText("Vízszintes");
        miHorizontal.setActionCommand("Vízszintes szabály");
        miHorizontal.addActionListener(new MainFrame_miHorizontal_actionAdapter(this));
        miVertical.setText("Függőleges");
        miVertical.setActionCommand("Függőleges szabály");
        miVertical.addActionListener(new MainFrame_miVertical_actionAdapter(this));
        miSimple.setText("Egyszerű");
        miSimple.setActionCommand("Egyszerű szabály");
        miSimple.addActionListener(new MainFrame_miSimple_actionAdapter(this));
        miBackground.setText("Háttér");
        miBackground.addActionListener(new MainFrame_miBg_actionAdapter(this));
        toolBar.add(btNew);
        toolBar.add(btNumberedGame);
        //toolBar.add(btRule);
        toolBar.add(btOpen);
        toolBar.add(btSave);
        //toolBar.add(btSaveas);
        toolBar.add(btResults);

        toolBar.addSeparator();

        toolBar.add(btRestart);
        toolBar.add(btPause);
        toolBar.add(btUndo);
        toolBar.add(btRedo);
        //toolBar.add(btPairs);
        toolBar.add(btSwap);
        //toolBar.add(btXRay);
        toolBar.add(btShuffle);
        toolBar.add(btHelp);

        toolBar.addSeparator();

        toolBar.add(btUse);
        toolBar.add(btAbout);

        contentPane.add(statusBar, BorderLayout.SOUTH);

        mGame.add(miNew);
        mGame.add(miNumberedGame);
        mGame.add(miOpen);
        mGame.add(miSave);
        mGame.addSeparator();
        mGame.add(mRule);
        mGame.add(mLayout);
        mGame.add(miResults);
        mGame.addSeparator();
        mGame.add(miExit);

        mHelp.add(miUse);
        mHelp.add(miAbout);

        menuBar.add(mGame);
        menuBar.add(mActions);
        menuBar.add(miView);
        menuBar.add(mSettings);
        menuBar.add(mHelp);

        this.setJMenuBar(menuBar);
        contentPane.add(toolBar, BorderLayout.NORTH);
        contentPane.add(gamePanel = new GamePanel());

        mLayout.add(miABC);
        mLayout.add(miAnchor);
        mLayout.add(miBambooLayout);
        mLayout.add(miBird);
        mLayout.add(miBoat);
        mLayout.add(miBridges);
        mLayout.add(miCancer);
        mLayout.add(miCar);
        mLayout.add(miCaravel);
        mLayout.add(miCelticCross);
        mLayout.add(miChessBishop);
        mLayout.add(miChessKing);
        mLayout.add(miChessKnight);
        mLayout.add(miChessPawn);
        mLayout.add(miChessQueen);
        mLayout.add(miChessRook);
        mLayout.add(miClassic);
        mLayout.add(miCross);
        mLayout.add(miCrown);
        mLayout.add(miDiamond);
        mLayout.add(miDuck);
        mLayout.add(miDude);
        mLayout.add(miEagle);
        mLayout.add(miFish);
        mLayout.add(miFivePyramids);
        mLayout.add(miFortress);
        mLayout.add(miGayle);
        mLayout.add(miInfinity);
        mLayout.add(miJudasPriest);
        mLayout.add(miLabyrinth);
        mLayout.add(miMounds);
        mLayout.add(miNeptune);
        mLayout.add(miPluto);
        mLayout.add(miPumpkinLayout);
        mLayout.add(miPyramid);
        mLayout.add(miRedDragon);
        mLayout.add(miRhombus);
        mLayout.add(miRugby);
        mLayout.add(miSantaClaus);
        mLayout.add(miScalesOfJustice);
        mLayout.add(miSpaceShuttle);
        mLayout.add(miSpaceStation);
        mLayout.add(miSquare);
        mLayout.add(miStairs);
        mLayout.add(miStar);
        mLayout.add(miStatue);
        mLayout.add(miTemple);
        mLayout.add(miTileFighter);
        mLayout.add(miTwin);
        mLayout.add(miUranus);
        mLayout.add(miWaves);
        mLayout.add(miWindBei);
        mLayout.add(miWindDong);
        mLayout.add(miWindNan);
        mLayout.add(miWindXi);
        mLayout.add(miWings);
        mLayout.add(miZodiacAries);
        mLayout.add(miZodiacAquarius);
        mLayout.add(miZodiacCancer);
        mLayout.add(miZodiacGemini);
        mLayout.add(miZodiacLibra);
        mLayout.add(miZodiacLeo);
        mLayout.add(miZodiacCapricorn);
        mLayout.add(miZodiacPisces);
        mLayout.add(miZodiacSagittarius);
        mLayout.add(miZodiacScorpio);
        mLayout.add(miZodiacTaurus);
        mLayout.add(miZodiacVirgo);

        mActions.add(miRestart);
        mActions.add(miPause);
        mActions.addSeparator();
        mActions.add(miUndo);
        mActions.add(miRedo);
        mActions.addSeparator();
        //mActions.add(miShowPairs);
        mActions.add(miSwap);
        mActions.add(miShuffle);
        mActions.add(miHelp);
        //mActions.add(miXRay);
        mSettings.add(mStyle);
        mSettings.add(mMarkings);
        mSettings.add(mTDE);
        mSettings.addSeparator();
        //mSettings.add(mBackground);
        mSettings.add(miBackground);
        //mSettings.add(mLookAndFeel);
        //mSettings.add(mWindowLocation);
        //mSettings.add(miSounds);
        miView.add(miToolBar);
        miView.add(miStatusBar);
        miView.add(miTilePalette);

        mStyle.add(miGold); // Arany
        mStyle.add(miBamboo); // Bambusz
        mStyle.add(miBrownStone); // Barna kő
        mStyle.add(miLeather); // Bőr
        mStyle.add(miWood_1); // Bükk
        mStyle.add(miBone); // Csont
        mStyle.add(miStone); // Drapp kő
        mStyle.add(miSilver); // Ezüst
        mStyle.add(miWood_2); // Fenyő
        mStyle.add(miDarkGreyStone); // Gránit
        mStyle.add(miWhiteStone); // Homokkő
        mStyle.add(miCardboard); // Karton
        mStyle.add(miPurpleStone); // Lila kő
        mStyle.add(miWhite); // Műanyag
        mStyle.add(miPaper); // Pergamen
        mStyle.add(miOrangeStone); // Sárga kő
        mStyle.add(miYellowMarble); // Sárga márvány
        mStyle.add(miGreyStone); // Szürke kő
        mStyle.add(miBrick); // Tégla
        mStyle.add(miGlass); // Üveg
        mStyle.add(miRedMarble); // Vörös márvány

        statusBar.add(pnInfo, BorderLayout.CENTER);
        pnInfo.add(jPanel6, BorderLayout.CENTER);
        jPanel6.add(lbStatus, null);
        statusBar.add(jPanel2, BorderLayout.EAST);
        jPanel2.add(pnGameNumber, null);
        pnGameNumber.add(jLabel3, null);
        pnGameNumber.add(lbGameNumber, null);
        jPanel2.add(pnTime, null);
        pnTime.add(jLabel2, null);
        pnTime.add(lbTime, null);
        jPanel2.add(pnPenalty, null);
        pnPenalty.add(jLabel5, null);
        pnPenalty.add(lbPenalty, null);
        jPanel2.add(pnTiles, null);
        pnTiles.add(jLabel4, null);
        pnTiles.add(lbTiles, null);
        jPanel2.add(pnOpens, null);
        pnOpens.add(jLabel6, null);
        pnOpens.add(lbOpens, null);
        btSwap.setToolTipText("Csere");
        btSaveas.setToolTipText("Mentés másként");
        mLookAndFeel.add(miMotif);
        mLookAndFeel.add(miMetal);
        mLookAndFeel.add(miWindows);

        miNew.setIcon(new ImageIconManager().createImageIcon("icons/new.gif"));
        miNumberedGame.setIcon(new ImageIconManager().createImageIcon("icons/numberedgame.gif"));
        mRule.setIcon(new ImageIconManager().createImageIcon("icons/rule.gif"));
        miOpen.setIcon(new ImageIconManager().createImageIcon("icons/open.gif"));
        miSave.setIcon(new ImageIconManager().createImageIcon("icons/save.gif"));
        miSaveas.setIcon(new ImageIconManager().createImageIcon("icons/saveas.gif"));
        mLayout.setIcon(new ImageIconManager().createImageIcon("icons/layout.gif"));
        miExit.setIcon(new ImageIconManager().createImageIcon("icons/exit.gif"));
        miResults.setIcon(new ImageIconManager().createImageIcon("icons/result.gif"));
        miRestart.setIcon(new ImageIconManager().createImageIcon("icons/restart.gif"));
        miPause.setIcon(new ImageIconManager().createImageIcon("icons/pause.gif"));
        miUndo.setIcon(new ImageIconManager().createImageIcon("icons/undo.gif"));
        miRedo.setIcon(new ImageIconManager().createImageIcon("icons/redo.gif"));
        miSwap.setIcon(new ImageIconManager().createImageIcon("icons/swap.gif"));
        miShuffle.setIcon(new ImageIconManager().createImageIcon("icons/shuffle.gif"));
        miHelp.setIcon(new ImageIconManager().createImageIcon("icons/help.gif"));
        //mStyle.setIcon(new ImageIcon("icons/style.gif"));
        //mBackground.setIcon(new ImageIcon("icons/background.gif"));
        miSounds.setIcon(new ImageIconManager().createImageIcon("icons/sound.gif"));
        mLookAndFeel.setIcon(new ImageIconManager().createImageIcon("icons/lookandfeel.gif"));
        miUse.setIcon(new ImageIconManager().createImageIcon("icons/help.png"));
        miAbout.setIcon(new ImageIconManager().createImageIcon("icons/about.gif"));

        btNew.setIcon(new ImageIconManager().createImageIcon("icons/new.gif"));
        btNumberedGame.setIcon(new ImageIconManager().createImageIcon("icons/numberedgame.gif"));
        btOpen.setIcon(new ImageIconManager().createImageIcon("icons/open.gif"));
        btSave.setIcon(new ImageIconManager().createImageIcon("icons/save.gif"));
        btSaveas.setIcon(new ImageIconManager().createImageIcon("icons/saveas.gif"));
        btResults.setIcon(new ImageIconManager().createImageIcon("icons/result.gif"));
        btRestart.setIcon(new ImageIconManager().createImageIcon("icons/restart.gif"));
        btUndo.setIcon(new ImageIconManager().createImageIcon("icons/undo.gif"));
        btRedo.setIcon(new ImageIconManager().createImageIcon("icons/redo.gif"));
        btPause.setIcon(new ImageIconManager().createImageIcon("icons/pause.gif"));
        btSwap.setIcon(new ImageIconManager().createImageIcon("icons/swap.gif"));
        btShuffle.setIcon(new ImageIconManager().createImageIcon("icons/shuffle.gif"));
        btHelp.setIcon(new ImageIconManager().createImageIcon("icons/help.gif"));
        btUse.setIcon(new ImageIconManager().createImageIcon("icons/help.png"));
        btAbout.setIcon(new ImageIconManager().createImageIcon("icons/about.gif"));

        miBamboo.addActionListener(new MainFrame_miBamboo_actionAdapter(this));
        miGlass.addActionListener(new MainFrame_miGlass_actionAdapter(this));
        miOrangeStone.addActionListener(new MainFrame_miOrangeStone_actionAdapter(this));
        miPaper.addActionListener(new MainFrame_miPaper_actionAdapter(this));
        miWhite.addActionListener(new MainFrame_miWhite_actionAdapter(this));
        miWhiteStone.addActionListener(new MainFrame_miWhiteStone_actionAdapter(this));
        miWood_1.addActionListener(new MainFrame_miWood_1_actionAdapter(this));

        btNew.setModel(miNew.getModel());
        btNumberedGame.setModel(miNumberedGame.getModel());
        btOpen.setModel(miOpen.getModel());
        btSave.setModel(miSave.getModel());
        btResults.setModel(miResults.getModel());
        btRestart.setModel(miRestart.getModel());
        btUndo.setModel(miUndo.getModel());
        btRedo.setModel(miRedo.getModel());
        btPause.setModel(miPause.getModel());
        btSwap.setModel(miSwap.getModel());
        btShuffle.setModel(miShuffle.getModel());
        btHelp.setModel(miHelp.getModel());
        btUse.setModel(miUse.getModel());
        btAbout.setModel(miAbout.getModel());

        bgLayout.add(miClassic);
        bgLayout.add(miCross);
        bgLayout.add(miDiamond);
        bgLayout.add(miFortress);
        bgLayout.add(miPyramid);
        bgLayout.add(miRugby);
        bgLayout.add(miTemple);
        bgLayout.add(miSpaceShuttle);
        bgLayout.add(miStairs);
        bgLayout.add(miTwin);
        bgLayout.add(miZodiacScorpio);
        bgLayout.add(miChessRook);
        bgLayout.add(miFivePyramids);
        bgLayout.add(miChessQueen);
        bgLayout.add(miBoat);
        bgLayout.add(miTileFighter);
        bgLayout.add(miChessPawn);
        bgLayout.add(miScalesOfJustice);
        bgLayout.add(miZodiacCapricorn);
        bgLayout.add(miZodiacLeo);
        bgLayout.add(miDude);
        bgLayout.add(miWindBei);
        bgLayout.add(miWindDong);
        bgLayout.add(miWindNan);
        bgLayout.add(miWindXi);
        bgLayout.add(miBird);
        bgLayout.add(miChessBishop);
        bgLayout.add(miZodiacSagittarius);
        bgLayout.add(miZodiacTaurus);
        bgLayout.add(miChessKnight);
        bgLayout.add(miZodiacLibra);
        bgLayout.add(miZodiacAries);
        bgLayout.add(miZodiacGemini);
        bgLayout.add(miABC);
        bgLayout.add(miAnchor);
        bgLayout.add(miCelticCross);
        bgLayout.add(miJudasPriest);
        bgLayout.add(miNeptune);
        bgLayout.add(miMounds);
        bgLayout.add(miPluto);
        bgLayout.add(miUranus);
        bgLayout.add(miInfinity);
        bgLayout.add(miSpaceStation);
        bgLayout.add(miDuck);
        bgLayout.add(miFish);
        bgLayout.add(miZodiacAquarius);
        bgLayout.add(miZodiacCancer);
        bgLayout.add(miZodiacPisces);
        bgLayout.add(miZodiacVirgo);
        bgLayout.add(miChessKing);
        bgLayout.add(miCrown);
        bgLayout.add(miEagle);
        bgLayout.add(miGayle);
        bgLayout.add(miBambooLayout);
        bgLayout.add(miCancer);
        bgLayout.add(miCar);
        bgLayout.add(miLabyrinth);
        bgLayout.add(miSquare);
        bgLayout.add(miRedDragon);
        bgLayout.add(miStatue);
        bgLayout.add(miBridges);
        bgLayout.add(miRhombus);
        bgLayout.add(miSantaClaus);
        bgLayout.add(miCaravel);
        bgLayout.add(miStar);
        bgLayout.add(miPumpkinLayout);
        bgLayout.add(miWings);
        bgLayout.add(miWaves);

        bgStyle.add(miBamboo);
        bgStyle.add(miGlass);
        bgStyle.add(miOrangeStone);
        bgStyle.add(miPaper);
        bgStyle.add(miWhite);
        bgStyle.add(miWhiteStone);
        bgStyle.add(miWood_1);
        bgStyle.add(miBone);
        bgStyle.add(miBrick);
        bgStyle.add(miBrownStone);
        bgStyle.add(miCardboard);
        bgStyle.add(miDarkGreyStone);
        bgStyle.add(miGreyStone);
        bgStyle.add(miYellowMarble);
        bgStyle.add(miPurpleStone);
        bgStyle.add(miStone);
        bgStyle.add(miGold);
        bgStyle.add(miLeather);
        bgStyle.add(miLeatherGold);
        bgStyle.add(miLeatherSilver);
        bgStyle.add(miRedMarble);
        bgStyle.add(miSilver);
        bgStyle.add(miWood_2);

        bgLookAndFeel.add(miMotif);
        bgLookAndFeel.add(miMetal);
        bgLookAndFeel.add(miWindows);

        bgThreeDimensionalEffect.add(miNorthEast);
        bgThreeDimensionalEffect.add(miNorthWest);
        bgThreeDimensionalEffect.add(miSouthEast);
        bgThreeDimensionalEffect.add(miSouthWest);

        bgWindowLocation.add(miWindowNorthWest);
        bgWindowLocation.add(miWindowNorth);
        bgWindowLocation.add(miWindowNorthEast);
        bgWindowLocation.add(miWindowWest);
        bgWindowLocation.add(miWindowCenter);
        bgWindowLocation.add(miWindowEast);
        bgWindowLocation.add(miWindowSouthWest);
        bgWindowLocation.add(miWindowSouth);
        bgWindowLocation.add(miWindowSouthEast);

        bgMarking.add(miBambooColorTheme); // Bambusz
        bgMarking.add(miHorizon); // Horizont
        bgMarking.add(miBlue); // Kék
        bgMarking.add(miChrome); // Króm
        bgMarking.add(miViolet); // Lila
        bgMarking.add(miMahogany); // Mahagóni
        bgMarking.add(miMoss); // Moha
        bgMarking.add(miDaylight); // Napfény
        bgMarking.add(miRose); // Rózsa
        bgMarking.add(miDesert); // Sivatag
        bgMarking.add(miGray); // Szürke
        bgMarking.add(miSea); // Tenger
        bgMarking.add(miPumpkin); // Tök


        mTDE.add(miNorthWest);
        mTDE.add(miSouthWest);
        mTDE.add(miNorthEast);
        mTDE.add(miSouthEast);

        mWindowLocation.add(miWindowNorthWest);
        mWindowLocation.add(miWindowNorth);
        mWindowLocation.add(miWindowNorthEast);
        mWindowLocation.add(miWindowWest);
        mWindowLocation.add(miWindowCenter);
        mWindowLocation.add(miWindowEast);
        mWindowLocation.add(miWindowSouthWest);
        mWindowLocation.add(miWindowSouth);
        mWindowLocation.add(miWindowSouthEast);

        mMarkings.add(miBambooColorTheme);
        mMarkings.add(miHorizon);
        mMarkings.add(miBlue);
        mMarkings.add(miChrome);
        mMarkings.add(miViolet);
        mMarkings.add(miMahogany);
        mMarkings.add(miMoss);
        mMarkings.add(miDaylight);
        mMarkings.add(miRose);
        mMarkings.add(miDesert);
        mMarkings.add(miGray);
        mMarkings.add(miSea);
        mMarkings.add(miPumpkin);


        mRule.add(miHorizontal);
        mRule.add(miVertical);
        mRule.add(miSimple);

        statusBar.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                if (e.getModifiers() == e.BUTTON3_MASK) { // jobb egérkattintás
                    statusBarPopupMenu.show(e.getComponent(), e.getX(), e.getY() - 100);
                }
            }
        });

        JPopupMenu pm = mLayout.getPopupMenu();
        pm.setLayout(new MenuLayout(0, 4));

        //JPopupMenu pm2 = mBackground.getPopupMenu();
        //pm2.setLayout(new MenuLayout(0, 2));

        setStatusBar();
        setTitle();
        dataModule.bindToTime(this);
        dataModule.setStatusLabel(lbStatus);
        statusBarPopupMenu = new StatusBarPopupMenu(this);
        dataModule.setNumberedGames(new NumberedGameFactory().readNumberedGames());

        this.addComponentListener(new MainFrame_this_componentAdapter(this));
    }

    //----------------------------------------------------------------------

    /**
     * Beállítja a komponensek értékei az adatmodulban lévő adatok alapján
     */
    public void settingMenuItems() {
        miClassic.setSelected(dataModule.getLayout().getName().equals("Classic"));
        miCross.setSelected(dataModule.getLayout().getName().equals("Cross"));
        miDiamond.setSelected(dataModule.getLayout().getName().equals("Diamond"));
        miFortress.setSelected(dataModule.getLayout().getName().equals("Fortress"));
        miPyramid.setSelected(dataModule.getLayout().getName().equals("Pyramid"));
        miRugby.setSelected(dataModule.getLayout().getName().equals("Rugby"));
        miSpaceShuttle.setSelected(dataModule.getLayout().getName().equals("Space Shuttle"));
        miStairs.setSelected(dataModule.getLayout().getName().equals("Stairs"));
        miTemple.setSelected(dataModule.getLayout().getName().equals("Temple"));
        miTwin.setSelected(dataModule.getLayout().getName().equals("Twin"));
        miChessRook.setSelected(dataModule.getLayout().getName().equals("Chess-Rook"));
        miFivePyramids.setSelected(dataModule.getLayout().getName().equals("Five Pyramids"));
        miZodiacScorpio.setSelected(dataModule.getLayout().getName().equals("Zodiac-Scorpio"));
        miChessQueen.setSelected(dataModule.getLayout().getName().equals("Chess-Queen"));
        miBoat.setSelected(dataModule.getLayout().getName().equals("Boat"));
        miTileFighter.setSelected(dataModule.getLayout().getName().equals("Tile Fighter"));
        miChessPawn.setSelected(dataModule.getLayout().getName().equals("Chess-Pawn"));
        miScalesOfJustice.setSelected(dataModule.getLayout().getName().equals("Scales Of Justice"));
        miZodiacCapricorn.setSelected(dataModule.getLayout().getName().equals("Zodiac-Capricorn"));
        miZodiacLeo.setSelected(dataModule.getLayout().getName().equals("Zodiac-Leo"));
        miDude.setSelected(dataModule.getLayout().getName().equals("Dude"));
        miWindBei.setSelected(dataModule.getLayout().getName().equals("Wind-Bei"));
        miWindDong.setSelected(dataModule.getLayout().getName().equals("Wind-Dong"));
        miWindNan.setSelected(dataModule.getLayout().getName().equals("Wind-Nan"));
        miWindXi.setSelected(dataModule.getLayout().getName().equals("Wind-Xi"));
        miBird.setSelected(dataModule.getLayout().getName().equals("Bird"));
        miChessBishop.setSelected(dataModule.getLayout().getName().equals("Chess-Bishop"));
        miZodiacSagittarius.setSelected(dataModule.getLayout().getName().equals("Zodiac-Sagittarius"));
        miZodiacTaurus.setSelected(dataModule.getLayout().getName().equals("Zodiac-Taurus"));
        miZodiacLibra.setSelected(dataModule.getLayout().getName().equals("Zodiac-Libra"));
        miChessKnight.setSelected(dataModule.getLayout().getName().equals("Chess-Knight"));
        miZodiacAries.setSelected(dataModule.getLayout().getName().equals("Zodiac-Aries"));
        miZodiacGemini.setSelected(dataModule.getLayout().getName().equals("Zodiac-Gemini"));
        miABC.setSelected(dataModule.getLayout().getName().equals("ABC"));
        miAnchor.setSelected(dataModule.getLayout().getName().equals("Anchor"));
        miCelticCross.setSelected(dataModule.getLayout().getName().equals("Celtic Cross"));
        miJudasPriest.setSelected(dataModule.getLayout().getName().equals("Judas Priest"));
        miNeptune.setSelected(dataModule.getLayout().getName().equals("Neptune"));
        miMounds.setSelected(dataModule.getLayout().getName().equals("Mounds"));
        miPluto.setSelected(dataModule.getLayout().getName().equals("Pluto"));
        miUranus.setSelected(dataModule.getLayout().getName().equals("Uranus"));
        miInfinity.setSelected(dataModule.getLayout().getName().equals("Infinity"));
        miSpaceStation.setSelected(dataModule.getLayout().getName().equals("Space Station"));
        miDuck.setSelected(dataModule.getLayout().getName().equals("Duck"));
        miFish.setSelected(dataModule.getLayout().getName().equals("Fish"));
        miZodiacAquarius.setSelected(dataModule.getLayout().getName().equals("Zodiac-Aquarius"));
        miZodiacCancer.setSelected(dataModule.getLayout().getName().equals("Zodiac-Cancer"));
        miZodiacPisces.setSelected(dataModule.getLayout().getName().equals("Zodiac-Pisces"));
        miZodiacVirgo.setSelected(dataModule.getLayout().getName().equals("Zodiac-Virgo"));
        miChessKing.setSelected(dataModule.getLayout().getName().equals("Chess-King"));
        miCrown.setSelected(dataModule.getLayout().getName().equals("Crown"));
        miEagle.setSelected(dataModule.getLayout().getName().equals("Eagle"));
        miGayle.setSelected(dataModule.getLayout().getName().equals("Gayle"));
        miBambooLayout.setSelected(dataModule.getLayout().getName().equals("Bamboo"));
        miCancer.setSelected(dataModule.getLayout().getName().equals("Cancer"));
        miCar.setSelected(dataModule.getLayout().getName().equals("Car"));
        miLabyrinth.setSelected(dataModule.getLayout().getName().equals("Labyrinth"));
        miSquare.setSelected(dataModule.getLayout().getName().equals("Square"));
        miRedDragon.setSelected(dataModule.getLayout().getName().equals("Red Dragon"));
        miStatue.setSelected(dataModule.getLayout().getName().equals("Statue"));
        miBridges.setSelected(dataModule.getLayout().getName().equals("Bridges"));
        miRhombus.setSelected(dataModule.getLayout().getName().equals("Rhombus"));
        miSantaClaus.setSelected(dataModule.getLayout().getName().equals("Santa Claus"));
        miCaravel.setSelected(dataModule.getLayout().getName().equals("Caravel"));
        miStar.setSelected(dataModule.getLayout().getName().equals("Star"));
        miPumpkinLayout.setSelected(dataModule.getLayout().getName().equals("Pumpkin"));
        miWings.setSelected(dataModule.getLayout().getName().equals("Wings"));
        miWaves.setSelected(dataModule.getLayout().getName().equals("Waves"));

        miHorizontal.setSelected(dataModule.getRule() == RULE_HORIZONTAL);
        miVertical.setSelected(dataModule.getRule() == RULE_VERTICAL);
        miSimple.setSelected(dataModule.getRule() == RULE_SIMPE);

        miToolBar.setSelected(dataModule.isToolBar());
        miStatusBar.setSelected(dataModule.isStatusBar());
        miTilePalette.setSelected(dataModule.getTilePaletteProperty().isVisible());

        miBamboo.setSelected(dataModule.getStyle().equals(STYLE_BAMBOO));
        miGlass.setSelected(dataModule.getStyle().equals(STYLE_GLASS));
        miOrangeStone.setSelected(dataModule.getStyle().equals(STYLE_ORANGE_STONE));
        miPaper.setSelected(dataModule.getStyle().equals(STYLE_PAPER));
        miWhite.setSelected(dataModule.getStyle().equals(STYLE_WHITE));
        miWhiteStone.setSelected(dataModule.getStyle().equals(STYLE_WHITE_STONE));
        miWood_1.setSelected(dataModule.getStyle().equals(STYLE_WOOD_1));
        miBone.setSelected(dataModule.getStyle().equals(STYLE_BONE));
        miBrick.setSelected(dataModule.getStyle().equals(STYLE_BRICK));
        miBrownStone.setSelected(dataModule.getStyle().equals(STYLE_BROWN_STONE));
        miCardboard.setSelected(dataModule.getStyle().equals(STYLE_CARDBOARD));
        miDarkGreyStone.setSelected(dataModule.getStyle().equals(STYLE_DARK_GREY_STONE));
        miGreyStone.setSelected(dataModule.getStyle().equals(STYLE_GREY_STONE));
        miYellowMarble.setSelected(dataModule.getStyle().equals(STYLE_YELLOW_MARBLE));
        miPurpleStone.setSelected(dataModule.getStyle().equals(STYLE_PURPLE_STONE));
        miStone.setSelected(dataModule.getStyle().equals(STYLE_STONE));
        miGold.setSelected(dataModule.getStyle().equals(STYLE_GOLD));
        miLeather.setSelected(dataModule.getStyle().equals(STYLE_LEATHER));
        miLeatherGold.setSelected(dataModule.getStyle().equals(STYLE_LEATHER_GOLD));
        miLeatherSilver.setSelected(dataModule.getStyle().equals(STYLE_LEATHER_SILVER));
        miRedMarble.setSelected(dataModule.getStyle().equals(STYLE_RED_MARBLE));
        miSilver.setSelected(dataModule.getStyle().equals(STYLE_SILVER));
        miWood_2.setSelected(dataModule.getStyle().equals(STYLE_WOOD_2));

        miSea.setSelected(dataModule.getColorTheme().equals(SEA));
        miDesert.setSelected(dataModule.getColorTheme().equals(DESERT));
        miViolet.setSelected(dataModule.getColorTheme().equals(VIOLET_COLORED));
        miGray.setSelected(dataModule.getColorTheme().equals(GRAY));
        miBlue.setSelected(dataModule.getColorTheme().equals(BLUE));
        miPumpkin.setSelected(dataModule.getColorTheme().equals(PUMPKIN));
        miRose.setSelected(dataModule.getColorTheme().equals(ROSE));
        miMoss.setSelected(dataModule.getColorTheme().equals(MOSS));
        miMahogany.setSelected(dataModule.getColorTheme().equals(MAHOGANY));
        miBambooColorTheme.setSelected(dataModule.getColorTheme().equals(BAMBOO));
        miChrome.setSelected(dataModule.getColorTheme().equals(CHROME));
        miHorizon.setSelected(dataModule.getColorTheme().equals(HORIZON));
        miDaylight.setSelected(dataModule.getColorTheme().equals(DAYLIGHT));


        miNorthEast.setSelected(dataModule.getThreeDimensionalEffect().equals(TDE_NORTH_EAST));
        miSouthEast.setSelected(dataModule.getThreeDimensionalEffect().equals(TDE_SOUTH_EAST));
        miNorthWest.setSelected(dataModule.getThreeDimensionalEffect().equals(TDE_NORTH_WEST));
        miSouthWest.setSelected(dataModule.getThreeDimensionalEffect().equals(TDE_SOUTH_WEST));

        miMotif.setSelected(dataModule.getLookAndFeel() == MOTIF_LOOK_AND_FEEL);
        miMetal.setSelected(dataModule.getLookAndFeel() == METAL_LOOK_AND_FEEL);
        miWindows.setSelected(dataModule.getLookAndFeel() == WINDOWS_LOOK_AND_FEEL);

        toolBar.setVisible(dataModule.isToolBar());
        statusBar.setVisible(dataModule.isStatusBar());

        miWindowNorthWest.setSelected(dataModule.getWindowLocation() == NORTH_WEST);
        miWindowNorth.setSelected(dataModule.getWindowLocation() == NORTH);
        miWindowNorthEast.setSelected(dataModule.getWindowLocation() == NORTH_EAST);
        miWindowWest.setSelected(dataModule.getWindowLocation() == WEST);
        miWindowCenter.setSelected(dataModule.getWindowLocation() == CENTER);
        miWindowEast.setSelected(dataModule.getWindowLocation() == EAST);
        miWindowSouthWest.setSelected(dataModule.getWindowLocation() == SOUTH_WEST);
        miWindowSouth.setSelected(dataModule.getWindowLocation() == SOUTH);
        miWindowSouthEast.setSelected(dataModule.getWindowLocation() == SOUTH_EAST);

        sensitiveMenuItem(miNew);
        sensitiveMenuItem(miNumberedGame);
        sensitiveMenuItem(miOpen);
        sensitiveMenuItem(miSave);
        sensitiveMenuItem(miSaveas);
        sensitiveMenuItem(mRule);
        sensitiveMenuItem(miHorizontal);
        sensitiveMenuItem(miVertical);
        sensitiveMenuItem(miSimple);
        sensitiveMenuItem(mLayout);
        sensitiveMenuItem(miClassic);
        sensitiveMenuItem(miCross);
        sensitiveMenuItem(miDiamond);
        sensitiveMenuItem(miFortress);
        sensitiveMenuItem(miPyramid);
        sensitiveMenuItem(miRugby);
        sensitiveMenuItem(miSpaceShuttle);
        sensitiveMenuItem(miStairs);
        sensitiveMenuItem(miTemple);
        sensitiveMenuItem(miTwin);
        sensitiveMenuItem(miZodiacScorpio);
        sensitiveMenuItem(miFivePyramids);
        sensitiveMenuItem(miChessRook);
        sensitiveMenuItem(miChessQueen);
        sensitiveMenuItem(miBoat);
        sensitiveMenuItem(miTileFighter);
        sensitiveMenuItem(miChessPawn);
        sensitiveMenuItem(miScalesOfJustice);
        sensitiveMenuItem(miZodiacCapricorn);
        sensitiveMenuItem(miZodiacLeo);
        sensitiveMenuItem(miDude);
        sensitiveMenuItem(miWindBei);
        sensitiveMenuItem(miWindDong);
        sensitiveMenuItem(miWindNan);
        sensitiveMenuItem(miWindXi);
        sensitiveMenuItem(miBird);
        sensitiveMenuItem(miChessBishop);
        sensitiveMenuItem(miZodiacSagittarius);
        sensitiveMenuItem(miZodiacTaurus);
        sensitiveMenuItem(miZodiacLibra);
        sensitiveMenuItem(miChessKnight);
        sensitiveMenuItem(miZodiacAries);
        sensitiveMenuItem(miZodiacGemini);
        sensitiveMenuItem(miABC);
        sensitiveMenuItem(miAnchor);
        sensitiveMenuItem(miCelticCross);
        sensitiveMenuItem(miJudasPriest);
        sensitiveMenuItem(miNeptune);
        sensitiveMenuItem(miMounds);
        sensitiveMenuItem(miPluto);
        sensitiveMenuItem(miUranus);
        sensitiveMenuItem(miInfinity);
        sensitiveMenuItem(miSpaceStation);
        sensitiveMenuItem(miDuck);
        sensitiveMenuItem(miFish);
        sensitiveMenuItem(miZodiacAquarius);
        sensitiveMenuItem(miZodiacCancer);
        sensitiveMenuItem(miZodiacPisces);
        sensitiveMenuItem(miZodiacVirgo);
        sensitiveMenuItem(miChessKing);
        sensitiveMenuItem(miCrown);
        sensitiveMenuItem(miEagle);
        sensitiveMenuItem(miGayle);
        sensitiveMenuItem(miBambooLayout);
        sensitiveMenuItem(miCancer);
        sensitiveMenuItem(miCar);
        sensitiveMenuItem(miLabyrinth);
        sensitiveMenuItem(miSquare);
        sensitiveMenuItem(miRedDragon);
        sensitiveMenuItem(miStatue);
        sensitiveMenuItem(miBridges);
        sensitiveMenuItem(miRhombus);
        sensitiveMenuItem(miSantaClaus);
        sensitiveMenuItem(miCaravel);
        sensitiveMenuItem(miStar);
        sensitiveMenuItem(miPumpkinLayout);
        sensitiveMenuItem(miWings);
        sensitiveMenuItem(miWaves);

        sensitiveMenuItem(miResults);
        sensitiveMenuItem(miExit);
        sensitiveMenuItem(miRestart);
        sensitiveMenuItem(miPause);
        sensitiveMenuItem(miUndo);
        sensitiveMenuItem(miRedo);
        sensitiveMenuItem(miSwap);
        sensitiveMenuItem(miShuffle);
        sensitiveMenuItem(miHelp);
        sensitiveMenuItem(miToolBar);
        sensitiveMenuItem(miStatusBar);
        sensitiveMenuItem(mStyle);

        sensitiveMenuItem(miBamboo);
        sensitiveMenuItem(miGlass);
        sensitiveMenuItem(miOrangeStone);
        sensitiveMenuItem(miPaper);
        sensitiveMenuItem(miWhite);
        sensitiveMenuItem(miWhiteStone);
        sensitiveMenuItem(miWood_1);
        sensitiveMenuItem(miBone);
        sensitiveMenuItem(miBrick);
        sensitiveMenuItem(miBrownStone);
        sensitiveMenuItem(miCardboard);
        sensitiveMenuItem(miDarkGreyStone);
        sensitiveMenuItem(miGreyStone);
        sensitiveMenuItem(miYellowMarble);
        sensitiveMenuItem(miPurpleStone);
        sensitiveMenuItem(miStone);
        sensitiveMenuItem(miGold);
        sensitiveMenuItem(miLeather);
        sensitiveMenuItem(miLeatherGold);
        sensitiveMenuItem(miLeatherSilver);
        sensitiveMenuItem(miRedMarble);
        sensitiveMenuItem(miSilver);
        sensitiveMenuItem(miWood_2);

        sensitiveMenuItem(mMarkings);
        sensitiveMenuItem(miSea);
        sensitiveMenuItem(miDesert);
        sensitiveMenuItem(miViolet);
        sensitiveMenuItem(miGray);
        sensitiveMenuItem(miBlue);
        sensitiveMenuItem(miPumpkin);
        sensitiveMenuItem(miRose);
        sensitiveMenuItem(miMoss);
        sensitiveMenuItem(miMahogany);
        sensitiveMenuItem(miBambooColorTheme);
        sensitiveMenuItem(miChrome);
        sensitiveMenuItem(miHorizon);
        sensitiveMenuItem(miDaylight);

        sensitiveMenuItem(miBackground);

        sensitiveMenuItem(mTDE);
        sensitiveMenuItem(miNorthEast);
        sensitiveMenuItem(miNorthWest);
        sensitiveMenuItem(miSouthEast);
        sensitiveMenuItem(miSouthWest);
        sensitiveMenuItem(mWindowLocation);
        sensitiveMenuItem(miWindowNorthWest);
        sensitiveMenuItem(miWindowNorth);
        sensitiveMenuItem(miWindowNorthEast);
        sensitiveMenuItem(miWindowWest);
        sensitiveMenuItem(miWindowCenter);
        sensitiveMenuItem(miWindowEast);
        sensitiveMenuItem(miWindowSouthWest);
        sensitiveMenuItem(miWindowSouth);
        sensitiveMenuItem(miWindowSouthEast);

        sensitiveMenuItem(miTilePalette);
        sensitiveMenuItem(miSounds);
        sensitiveMenuItem(mLookAndFeel);
        sensitiveMenuItem(miMotif);
        sensitiveMenuItem(miMetal);
        sensitiveMenuItem(miWindows);
        sensitiveMenuItem(miUse);
        sensitiveMenuItem(miAbout);

    }

    //----------------------------------------------------------------------

    /**
     * Új időt hoz létre, melyet el is indít
     */
    private void newTime(int time) {
        dataModule.getTime().stop();
        //dataModule.setTime(null);

        dataModule.setTime(new Time());
        dataModule.getTime().setTime(time);
        dataModule.bindToTime(this);
        dataModule.getTime().start();
    }

    //----------------------------------------------------------------------

    /**
     * Beállítja az idő címkéjét
     */
    public void setTimeLabel() {
        lbTime.setText(TimeFormat.format(dataModule.getTime().getTime()));
        lbPenalty.setText(TimeFormat.format(dataModule.getPenalty()));
    }

    //----------------------------------------------------------------------

    /**
     * Beállítja a "játék száma" címke értékét
     */
    public void setGameNumberLabel() {
        lbGameNumber.setText(GameNumberFormat.format(dataModule.getGameNumber()));
    }

    //----------------------------------------------------------------------

    /**
     * Beállítja a párok és a kövek címkéjét
     */
    public void refreshLabels() {
        lbOpens.setText("" + gamePanel.opens());
        lbTiles.setText("" + gamePanel.getTiles().size());
    }

    //----------------------------------------------------------------------

    /**
     * Beállítja az ikonok és a menüpontok engedélyezését
     */
    public void setComponents() {
        gamePanel.createOpenTileSelector();
        btSave.setEnabled(!gamePanel.getTiles().isEmpty());
        btSwap.setEnabled(gamePanel.swapAvailability());
        btUndo.setEnabled(!gamePanel.getUndo().isEmpty());
        btRedo.setEnabled(!gamePanel.getRedo().isEmpty());
        btHelp.setEnabled(!gamePanel.getOpenTileSelector().isEmpty());
        btPause.setEnabled(!gamePanel.getTiles().isEmpty());
        btShuffle.setEnabled(!gamePanel.getTiles().isEmpty() && dataModule.isShuffleable());
        dataModule.setShuffleable(true);
    }

    //----------------------------------------------------------------------

    /**
     * Frissíti a kőpalettát
     */
    public void clearTilePalette() {
        gamePanel.refreshTilePalette(null);
    }

    //----------------------------------------------------------------------

    /**
     * Bal kattintás történt valamelyik kövön, ezért fríssíteni kell
     * a komponenseket és a címkéket
     */
    public void leftClick() {
        setComponents();
        refreshLabels();
    }

    //----------------------------------------------------------------------

    /**
     * A játék végén, ha született rekord, akkor bekéri a játékos nevét
     * és megmutatja, hogy hol végzett, különben értesít, hogy vége a
     * játéknak.
     */
    public void endOfGame() {
        dataModule.getTime().stop();
        GregorianCalendar calendar = new GregorianCalendar(); // a rekord születésének pillanata
        setTimeLabel(); // ha egy másodpercen belül szerzek bűntetőpontokat és veszem le az utoltó két követ, akkor más jelenne meg az eredménytáblán, mint az idő label-eken.
        setComponents();
        if (dataModule.newRecord()) { // ha új rekord született
            if (nameDialog.showDialog(calendar)) // ha el lett mentve az eredmény
                resultDialog.showDialog(true);
        } else
            MessageManager.showInfoDialog(this, "Gratulálok!\n" +
                    "Új rekord azonban most nem született.\n");
    }

    //----------------------------------------------------------------------

    /**
     * A tábla helyett egy újat tesz fel és frissíti a gomb-, és
     * az állapotsort
     */
    private void newGame(GameState gameState) {
        dataModule.setNumberOfSelectedTiles(0);
        Rectangle rectangle = gamePanel.getBounds();
        contentPane.remove(gamePanel);

        if (dataModule.getGameNumber() != 0) // számozott játék
            dataModule.loadNumberedGame();

        if (gameState == null) { // nem betöltött játék
            contentPane.add(gamePanel = new GamePanel(this, rectangle, null));
            newTime(0);
            dataModule.setPenalty(0);
        } else { // betöltött játék
            contentPane.add(gamePanel = new GamePanel(this, rectangle, gameState));
            dataModule.setRule(gameState.getRule());
            dataModule.setPenalty(gameState.getPenalty());
            newTime(gameState.getTime());
        }

        dataModule.setPause(false);
        setPauseComponents();
        settingMenuItems();
        setComponents();
        refreshLabels();
        clearTilePalette();
        setTimeLabel();
        setGameNumberLabel();
        setTitle();

        pack();
    }

    //----------------------------------------------------------------------

    /**  */
    /**
     * Ha a kapott kinézet eltér az aktuális kinézettől, akkor az
     * alkalmazás összes komponense új megjelenítést kap.
     */
    private void changeLookAndFeel(int lookAndFeel) {
        int actualLookAndFeel = dataModule.getLookAndFeel();
        if (actualLookAndFeel != lookAndFeel) {
            try {
                if (lookAndFeel == WINDOWS_LOOK_AND_FEEL)
                    UIManager.setLookAndFeel(new WindowsLookAndFeel());
                if (lookAndFeel == METAL_LOOK_AND_FEEL)
                    UIManager.setLookAndFeel(new MetalLookAndFeel());
                if (lookAndFeel == MOTIF_LOOK_AND_FEEL)
                    UIManager.setLookAndFeel(new MotifLookAndFeel());
                SwingUtilities.updateComponentTreeUI(getRootPane());
                SwingUtilities.updateComponentTreeUI(toolBar);
                // a dialógusok frissítése
                //SwingUtilities.updateComponentTreeUI(howToUseDialog.getRootPane());
                //howToUseDialog.refreshTree(); // a fa ikonjai nem frissülnek maguktók
                SwingUtilities.updateComponentTreeUI(aboutDialog.getRootPane());
                SwingUtilities.updateComponentTreeUI(resultDialog.getRootPane());
                SwingUtilities.updateComponentTreeUI(nameDialog.getRootPane());

                dataModule.setLookAndFeel(lookAndFeel); // az új kinézet elmentése
                getRootPane().revalidate();
                getRootPane().repaint();
                pack();
            } catch (UnsupportedLookAndFeelException ex) {
                ex.printStackTrace();
            }
        }
    }

    //----------------------------------------------------------------------

    /**
     * Új játék a kiválasztott elrendezéssel
     */
    private void newLayout(Layout layout) {
        dataModule.setLayout(layout);
        dataModule.setGameNumber(0);
        newGame(null);
        setTitle();
    }

    //----------------------------------------------------------------------

    /**
     *
     */
    private void newRule(int rule) {
        dataModule.setRule(rule);
        dataModule.setGameNumber(0);
        newGame(null);
    }

    //----------------------------------------------------------------------

    /**
     * Új stílus
     */
    private void setStyle(Style style) {
        if (!dataModule.getStyle().equals(style)) {
            dataModule.setStyle(style);
            gamePanel.newStyle();
            setTitle();
        }
    }

    //----------------------------------------------------------------------

    /**
     * Új térhatás
     */
    private void newThreeDimensionalEffect(ThreeDimensionalEffect tde) {
        if (!dataModule.getThreeDimensionalEffect().equals(tde)) {
            dataModule.setThreeDimensionalEffect(tde);
            gamePanel.newThreeDimensionalEffect();
        }
    }

    //----------------------------------------------------------------------

    /**
     * Új ablak-elhelyezés
     */
    private void newWindowLocation(int location) {
        dataModule.setWindowLocation(location);
        new WindowLocation(this, location);
    }

    //----------------------------------------------------------------------

    /**
     * Új mintázat
     */
    private void newMarkings(ColorTheme colorTheme) {
        if (!dataModule.getColorTheme().equals(colorTheme)) {
            dataModule.setColorTheme(colorTheme);
            gamePanel.newMarkings();
        }
    }

    //----------------------------------------------------------------------

    /**
     * Beállítja az ablak címét
     */
    private void setTitle() {
        setTitle(PROGRAM +
                " - " +
                rule() +
                " szabály" +
                " / " +
                dataModule.getLayout().getName() +
                " / " +
                dataModule.getStyle().getName());
    }

    //----------------------------------------------------------------------

    /**
     *
     */
    private String rule() {
        if (dataModule.getRule() == RULE_HORIZONTAL)
            return "Vízszintes";
        if (dataModule.getRule() == RULE_VERTICAL)
            return "Függőleges";
        return "Egyszerű";
    }

    //----------------------------------------------------------------------

    /**
     * Érzékennyé teszi a menütételeket az egérmozgásra
     */
    public void sensitiveMenuItem(JMenuItem menuItem) {
        Sensitive.takeSensitive(menuItem);
    }

    //----------------------------------------------------------------------

    /**
     * Beállítja az állapotsor elemeinek láthatóságát
     */
    public void setStatusBar() {
        pnGameNumber.setVisible(dataModule.getStatusBarProperties().isGameNumber());
        pnTime.setVisible(dataModule.getStatusBarProperties().isTime());
        pnPenalty.setVisible(dataModule.getStatusBarProperties().isPenalty());
        pnTiles.setVisible(dataModule.getStatusBarProperties().isTiles());
        pnOpens.setVisible(dataModule.getStatusBarProperties().isOpens());
    }

    //----------------------------------------------------------------------

    /**
     * Kilépés, ha van megerősítés
     */
    public void exit() {
        if (MessageManager.showConfirmDialog(this, "Biztosan kilépsz a programból?"))
            System.exit(0);
    }

    //----------------------------------------------------------------------

    /**
     * Elvégzi a felfüggesztést, folytatást
     */
    public void pauseResume() {
        dataModule.setPause(!dataModule.isPause());

        if (dataModule.isPause())
            pause();
        else
            resume();

        setPauseComponents();
    }

    //----------------------------------------------------------------------

    /**
     * Beállítja a felfüggesztéssel kapcsolatban lévő komponensek állapotát
     */
    private void setPauseComponents() {
        miPause.setIcon(dataModule.isPause() ?
                new ImageIconManager().createImageIcon("icons/resume.gif") :
                new ImageIconManager().createImageIcon("icons/pause.gif"));
        btPause.setIcon(dataModule.isPause() ?
                new ImageIconManager().createImageIcon("icons/resume.gif") :
                new ImageIconManager().createImageIcon("icons/pause.gif"));
        btPause.setToolTipText(dataModule.isPause() ? "Folytatás" : "Felfüggesztés");
        miPause.setText(dataModule.isPause() ? "Folytatás" : "Felfüggesztés");
        miPause.setActionCommand(dataModule.isPause() ? "A játék folytatása" : "A játék felfüggesztése");

        gamePanel.getGamePanelPopupMenu().setPauseMenu();
    }

    //----------------------------------------------------------------------

    /**
     * Felfüggesztés
     */
    private void pause() {
        dataModule.getTime().stop();
        gamePanel.pauseResume(false);
        gamePanel.refreshTilePalette(null);

        miUndo.setEnabled(false);
        miRedo.setEnabled(false);
        miSwap.setEnabled(false);
        miShuffle.setEnabled(false);
        miHelp.setEnabled(false);
    }

    //----------------------------------------------------------------------

    /**
     * Folytatás
     */
    private void resume() {
        dataModule.getTime().start();
        gamePanel.pauseResume(true);
        setComponents();
    }

    //----------------------------------------------------------------------

    /**
     * Futtatja a kapott fájlt
     */
    public void open(String file) {
        String command;
        Runtime rt = Runtime.getRuntime();
        try {
            command = "start " + file;
            rt.exec(command);
        } catch (java.io.IOException ee) {
            try {
                command = "cmd /c start " + file;
                rt.exec(command);
            } catch (java.io.IOException eee) {
                System.out.println(eee);
            }
        }
    }

    //----------------------------------------------------------------------
    //----------------------------------------------------------------------
    //  Eseménykezelők

    //File | Exit action performed
    public void miExit_actionPerformed(ActionEvent e) {
        exit();
    }

    //Overridden so we can exit when window is closed
    protected void processWindowEvent(WindowEvent e) {
        super.processWindowEvent(e);
        if (e.getID() == WindowEvent.WINDOW_CLOSING) {
            exit();
        }
    }

    void btNew_actionPerformed(ActionEvent e) {
        dataModule.setGameNumber(0);
        newGame(null);
    }

    void btRestart_actionPerformed(ActionEvent e) {
        gamePanel.clearUndoRedo();
        gamePanel.removeAndDealTiles(dataModule.getPlaces(),
                dataModule.getValues());
        newTime(0);
        dataModule.setPenalty(0);
        dataModule.setPause(false);
        setPauseComponents();
        setComponents();
        refreshLabels();
        clearTilePalette();
        setTimeLabel();
    }

    void btShuffle_actionPerformed(ActionEvent e) {
        gamePanel.shuffle();
        //dataModule.getSounds().play(Sounds.BUBBLE);
        dataModule.addPenalty(PENALTY_SHUFFLE);
        refreshLabels();
        setComponents();
        clearTilePalette();
    }

    void miClassic_actionPerformed(ActionEvent e) {
        newLayout(CLASSIC_LAYOUT);
    }

    void miSpaceShuttle_actionPerformed(ActionEvent e) {
        newLayout(SPACE_SHUTTLE_LAYOUT);
    }

    void miCross_actionPerformed(ActionEvent e) {
        newLayout(CROSS_LAYOUT);
    }

    void miTwin_actionPerformed(ActionEvent e) {
        newLayout(TWIN_LAYOUT);
    }

    void miSmallDiamond_actionPerformed(ActionEvent e) {
    }

    void miTemple_actionPerformed(ActionEvent e) {
        newLayout(TEMPLE_LAYOUT);
    }

    void miDiamond_actionPerformed(ActionEvent e) {
        newLayout(DIAMOND_LAYOUT);
    }

    void miPyramid_actionPerformed(ActionEvent e) {
        newLayout(PYRAMID_LAYOUT);
    }

    void miStairs_actionPerformed(ActionEvent e) {
        newLayout(STAIRS_LAYOUT);
    }

    void miRugby_actionPerformed(ActionEvent e) {
        newLayout(RUGBY_LAYOUT);
    }

    void miFortress_actionPerformed(ActionEvent e) {
        newLayout(FORTRESS_LAYOUT);
    }

    void miChessRook_actionPerformed(ActionEvent e) {
        newLayout(CHESS_ROOK_LAYOUT);
    }

    void miZodiacScorpio_actionPerformed(ActionEvent e) {
        newLayout(ZODIAC_SCORPIO_LAYOUT);
    }

    void miFivePyramids_actionPerformed(ActionEvent e) {
        newLayout(FIVE_PYRAMIDS_LAYOUT);
    }

    void miQueen_actionPerformed(ActionEvent e) {
        newLayout(CHESS_QUEEN_LAYOUT);
    }

    void miBoat_actionPerformed(ActionEvent e) {
        newLayout(BOAT_LAYOUT);
    }

    void miTileFighter_actionPerformed(ActionEvent e) {
        newLayout(TILE_FIGHTER_LAYOUT);
    }

    void miChessPawn_actionPerformed(ActionEvent e) {
        newLayout(CHESS_PAWN_LAYOUT);
    }

    void miScalesOfJustice_actionPerformed(ActionEvent e) {
        newLayout(SCALES_OF_JUSTICE_LAYOUT);
    }

    void miZodiacLeo_actionPerformed(ActionEvent e) {
        newLayout(ZODIAC_LEO_LAYOUT);
    }

    void miZodiacCapricorn_actionPerformed(ActionEvent e) {
        newLayout(ZODIAC_CAPRICORN_LAYOUT);
    }

    void miDude_actionPerformed(ActionEvent e) {
        newLayout(DUDE_LAYOUT);
    }

    void miWindBei_actionPerformed(ActionEvent e) {
        newLayout(WIND_BEI_LAYOUT);
    }

    void miWindDong_actionPerformed(ActionEvent e) {
        newLayout(WIND_DONG_LAYOUT);
    }

    void miWindNan_actionPerformed(ActionEvent e) {
        newLayout(WIND_NAN_LAYOUT);
    }

    void miWindXi_actionPerformed(ActionEvent e) {
        newLayout(WIND_XI_LAYOUT);
    }

    void miChessBishop_actionPerformed(ActionEvent e) {
        newLayout(CHESS_BISHOP_LAYOUT);
    }

    void miBird_actionPerformed(ActionEvent e) {
        newLayout(BIRD_LAYOUT);
    }

    void miZodiacTaurus_actionPerformed(ActionEvent e) {
        newLayout(ZODIAC_TAURUS_LAYOUT);
    }

    void miZodiacSagittarius_actionPerformed(ActionEvent e) {
        newLayout(ZODIAC_SAGITTARIUS_LAYOUT);
    }

    void miZodiacLibra_actionPerformed(ActionEvent e) {
        newLayout(ZODIAC_LIBRA_LAYOUT);
    }

    void miChessKnight_actionPerformed(ActionEvent e) {
        newLayout(CHESS_KNIGHT_LAYOUT);
    }

    void miZodiacAries_actionPerformed(ActionEvent e) {
        newLayout(ZODIAC_ARIES_LAYOUT);
    }

    void miZodiacGemini_actionPerformed(ActionEvent e) {
        newLayout(ZODIAC_GEMINI_LAYOUT);
    }

    void miJudasPriest_actionPerformed(ActionEvent e) {
        newLayout(JUDAS_PRIEST_LAYOUT);
    }

    void miABC_actionPerformed(ActionEvent e) {
        newLayout(ABC_LAYOUT);
    }

    void miAnchor_actionPerformed(ActionEvent e) {
        newLayout(ANCHOR_LAYOUT);
    }

    void miCelticCross_actionPerformed(ActionEvent e) {
        newLayout(CELTIC_CROSS_LAYOUT);
    }

    void miNeptune_actionPerformed(ActionEvent e) {
        newLayout(NEPTUNE_LAYOUT);
    }

    void miMounds_actionPerformed(ActionEvent e) {
        newLayout(MOUNDS_LAYOUT);
    }

    void miPluto_actionPerformed(ActionEvent e) {
        newLayout(PLUTO_LAYOUT);
    }

    void miUranus_actionPerformed(ActionEvent e) {
        newLayout(URANUS_LAYOUT);
    }

    void miInfinity_actionPerformed(ActionEvent e) {
        newLayout(INFINITY_LAYOUT);
    }

    void miSpaceStation_actionPerformed(ActionEvent e) {
        newLayout(SPACE_STATION_LAYOUT);
    }

    void miDuck_actionPerformed(ActionEvent e) {
        newLayout(DUCK_LAYOUT);
    }

    void miFish_actionPerformed(ActionEvent e) {
        newLayout(FISH_LAYOUT);
    }

    void miZodiacAquarius_actionPerformed(ActionEvent e) {
        newLayout(ZODIAC_AQUARIUS_LAYOUT);
    }

    void miZodiacCancer_actionPerformed(ActionEvent e) {
        newLayout(ZODIAC_CANCER_LAYOUT);
    }

    void miZodiacPisces_actionPerformed(ActionEvent e) {
        newLayout(ZODIAC_PISCES_LAYOUT);
    }

    void miZodiacVirgo_actionPerformed(ActionEvent e) {
        newLayout(ZODIAC_VIRGO_LAYOUT);
    }

    void miChessKing_actionPerformed(ActionEvent e) {
        newLayout(CHESS_KING_LAYOUT);
    }

    void miCrown_actionPerformed(ActionEvent e) {
        newLayout(CROWN_LAYOUT);
    }

    void miEagle_actionPerformed(ActionEvent e) {
        newLayout(EAGLE_LAYOUT);
    }

    void miGayle_actionPerformed(ActionEvent e) {
        newLayout(GAYLE_LAYOUT);
    }

    void miBambooLayout_actionPerformed(ActionEvent e) {
        newLayout(BAMBOO_LAYOUT);
    }

    void miCancer_actionPerformed(ActionEvent e) {
        newLayout(CANCER_LAYOUT);
    }

    void miCar_actionPerformed(ActionEvent e) {
        newLayout(CAR_LAYOUT);
    }

    void miLabyrinth_actionPerformed(ActionEvent e) {
        newLayout(LABYRINTH_LAYOUT);
    }

    void miSquare_actionPerformed(ActionEvent e) {
        newLayout(SQUARE_LAYOUT);
    }

    void miRedDragon_actionPerformed(ActionEvent e) {
        newLayout(RED_DRAGON_LAYOUT);
    }

    void miStatue_actionPerformed(ActionEvent e) {
        newLayout(STATUE_LAYOUT);
    }

    void miBridges_actionPerformed(ActionEvent e) {
        newLayout(BRIDGES_LAYOUT);
    }

    void miRhombus_actionPerformed(ActionEvent e) {
        newLayout(RHOMBUS_LAYOUT);
    }

    void miSantaClaus_actionPerformed(ActionEvent e) {
        newLayout(SANTA_CLAUS_LAYOUT);
    }


    void miCaravel_actionPerformed(ActionEvent e) {
        newLayout(CARAVEL_LAYOUT);
    }

    void miStar_actionPerformed(ActionEvent e) {
        newLayout(STAR_LAYOUT);
    }

    void miPumpkinLayout_actionPerformed(ActionEvent e) {
        newLayout(PUMPKIN_LAYOUT);
    }

    void miWings_actionPerformed(ActionEvent e) {
        newLayout(WINGS_LAYOUT);
    }

    void miWaves_actionPerformed(ActionEvent e) {
        newLayout(WAVES_LAYOUT);
    }

    void miUse_actionPerformed(ActionEvent e) {
        //useDialog.showDialog();
        open(USE);
    }

    void miBamboo_actionPerformed(ActionEvent e) {
        setStyle(STYLE_BAMBOO);
    }

    void miGlass_actionPerformed(ActionEvent e) {
        setStyle(STYLE_GLASS);
    }

    void miOrangeStone_actionPerformed(ActionEvent e) {
        setStyle(STYLE_ORANGE_STONE);
    }

    void miPaper_actionPerformed(ActionEvent e) {
        setStyle(STYLE_PAPER);
    }

    void miWhite_actionPerformed(ActionEvent e) {
        setStyle(STYLE_WHITE);
    }

    void miWhiteStone_actionPerformed(ActionEvent e) {
        setStyle(STYLE_WHITE_STONE);
    }

    void miWood_1_actionPerformed(ActionEvent e) {
        setStyle(STYLE_WOOD_1);
    }

    void miBrick_actionPerformed(ActionEvent e) {
        setStyle(STYLE_BRICK);
    }

    void miBrownStone_actionPerformed(ActionEvent e) {
        setStyle(STYLE_BROWN_STONE);
    }

    void miCardboard_actionPerformed(ActionEvent e) {
        setStyle(STYLE_CARDBOARD);
    }

    void miDarkGreyStone_actionPerformed(ActionEvent e) {
        setStyle(STYLE_DARK_GREY_STONE);
    }

    void miGrayStone_actionPerformed(ActionEvent e) {
        setStyle(STYLE_GREY_STONE);
    }

    void miStone_actionPerformed(ActionEvent e) {
        setStyle(STYLE_STONE);
    }

    void miPurpleStone_actionPerformed(ActionEvent e) {
        setStyle(STYLE_PURPLE_STONE);
    }

    void miYellowMarble_actionPerformed(ActionEvent e) {
        setStyle(STYLE_YELLOW_MARBLE);
    }

    void miBone_actionPerformed(ActionEvent e) {
        setStyle(STYLE_BONE);
    }

    void miGold_actionPerformed(ActionEvent e) {
        setStyle(STYLE_GOLD);
    }

    void miLeather_actionPerformed(ActionEvent e) {
        setStyle(STYLE_LEATHER);
    }

    void miLeatherGold_actionPerformed(ActionEvent e) {
        setStyle(STYLE_LEATHER_GOLD);
    }

    void miLeatherSilver_actionPerformed(ActionEvent e) {
        setStyle(STYLE_LEATHER_SILVER);
    }

    void miRedMarble_actionPerformed(ActionEvent e) {
        setStyle(STYLE_RED_MARBLE);
    }

    void miSilver_actionPerformed(ActionEvent e) {
        setStyle(STYLE_SILVER);
    }

    void miWood_2_actionPerformed(ActionEvent e) {
        setStyle(STYLE_WOOD_2);
    }


    void btSwap_actionPerformed(ActionEvent e) {
        gamePanel.swapTiles();
        dataModule.addPenalty(PENALTY_SWAP);
        setComponents();
        refreshLabels();
        clearTilePalette();
    }

    void btXRay_actionPerformed(ActionEvent e) {

    }

    void miToolBar_actionPerformed(ActionEvent e) {
        dataModule.setToolBar(!dataModule.isToolBar());
        toolBar.setVisible(dataModule.isToolBar());
        pack();
    }

    void miStatusBar_actionPerformed(ActionEvent e) {
        dataModule.setStatusBar(!dataModule.isStatusBar());
        statusBar.setVisible(dataModule.isStatusBar());
        pack();
    }
  /*
  void miBackground_1_actionPerformed(ActionEvent e) {
    newPictureBackground(BACKGROUND_01);
  }

  void miBackground_2_actionPerformed(ActionEvent e) {
    newPictureBackground(BACKGROUND_02);
  }

  void miBackground_3_actionPerformed(ActionEvent e) {
    newPictureBackground(BACKGROUND_03);
  }

  void miBackground_4_actionPerformed(ActionEvent e) {
    newPictureBackground(BACKGROUND_04);
  }

  void miBackground_5_actionPerformed(ActionEvent e) {
    newPictureBackground(BACKGROUND_05);
  }

  void miBackground_6_actionPerformed(ActionEvent e) {
    newPictureBackground(BACKGROUND_06);
  }

  void miBackground_7_actionPerformed(ActionEvent e) {
    newPictureBackground(BACKGROUND_07);
  }

  void miBackground_8_actionPerformed(ActionEvent e) {
    newPictureBackground(BACKGROUND_08);
  }

  void miBackground_9_actionPerformed(ActionEvent e) {
    newPictureBackground(BACKGROUND_09);
  }

  void miBackground_10_actionPerformed(ActionEvent e) {
    newPictureBackground(BACKGROUND_10);
  }

  void miBackground_11_actionPerformed(ActionEvent e) {
    newPictureBackground(BACKGROUND_11);
  }

  void miBackground_12_actionPerformed(ActionEvent e) {
    newPictureBackground(BACKGROUND_12);
  }
*/

    void btAbout_actionPerformed(ActionEvent e) {
        aboutDialog.showDialog();
    }

    void btResults_actionPerformed(ActionEvent e) {
        resultDialog.showDialog(false);
    }

    void miMotif_actionPerformed(ActionEvent e) {
        changeLookAndFeel(MOTIF_LOOK_AND_FEEL);
    }

    void miMetal_actionPerformed(ActionEvent e) {
        changeLookAndFeel(METAL_LOOK_AND_FEEL);
    }

    void miWindows_actionPerformed(ActionEvent e) {
        changeLookAndFeel(WINDOWS_LOOK_AND_FEEL);
    }

    void btUndo_actionPerformed(ActionEvent e) {
        gamePanel.undo();
        //dataModule.getSounds().play(Sounds.UNDO);
        dataModule.addPenalty(PENALTY_UNDO);
        setComponents();
        refreshLabels();
        clearTilePalette();
    }

    void btRedo_actionPerformed(ActionEvent e) {
        gamePanel.redo();
        //dataModule.getSounds().play(Sounds.REDO);
        dataModule.addPenalty(PENALTY_REDO);
        setComponents();
        refreshLabels();
        clearTilePalette();
    }

    void miNorthEast_actionPerformed(ActionEvent e) {
        newThreeDimensionalEffect(TDE_NORTH_EAST);
    }

    void miNorthWest_actionPerformed(ActionEvent e) {
        newThreeDimensionalEffect(TDE_NORTH_WEST);
    }

    void miSouthEast_actionPerformed(ActionEvent e) {
        newThreeDimensionalEffect(TDE_SOUTH_EAST);
    }

    void miSouthWest_actionPerformed(ActionEvent e) {
        newThreeDimensionalEffect(TDE_SOUTH_WEST);
    }

    void miNumberedGame_actionPerformed(ActionEvent e) {
        if (numberDialog.showDialog()) {
            newGame(null);
        }
    }

    void miHelp_actionPerformed(ActionEvent e) {
        //dataModule.getSounds().play(Sounds.CHIRP);
        gamePanel.help();
        dataModule.addPenalty(PENALTY_HELP);
        btSwap.setEnabled(false); // itt kell letiltani, és nem a setComponents-et hívni
    }


    public JMenuItem getMiSwap() {
        return miSwap;
    }

    public JMenuItem getMiUndo() {
        return miUndo;
    }

    public JMenuItem getMiRedo() {
        return miRedo;
    }

    public JMenuItem getMiRestart() {
        return miRestart;
    }

    public JMenuItem getMiShuffle() {
        return miShuffle;
    }

    public JMenuItem getMiHelp() {
        return miHelp;
    }

    void miWindowNortWest_actionPerformed(ActionEvent e) {
        newWindowLocation(WindowLocation.NORTH_WEST);
    }

    void miWindowNorth_actionPerformed(ActionEvent e) {
        newWindowLocation(WindowLocation.NORTH);
    }

    void miWindowNorthEast_actionPerformed(ActionEvent e) {
        newWindowLocation(WindowLocation.NORTH_EAST);
    }

    void miWindowWest_actionPerformed(ActionEvent e) {
        newWindowLocation(WindowLocation.WEST);
    }

    void miWindowCenter_actionPerformed(ActionEvent e) {
        newWindowLocation(WindowLocation.CENTER);
    }

    void miWindowEast_actionPerformed(ActionEvent e) {
        newWindowLocation(WindowLocation.EAST);
    }

    void miWindowSouthWest_actionPerformed(ActionEvent e) {
        newWindowLocation(WindowLocation.SOUTH_WEST);
    }

    void miWindowSouth_actionPerformed(ActionEvent e) {
        newWindowLocation(WindowLocation.SOUTH);
    }

    void miWindowSouthEast_actionPerformed(ActionEvent e) {
        newWindowLocation(WindowLocation.SOUTH_EAST);
    }

    /**
     * fontos, hogy legyen mérete a játék panelnak, ezért megjelenéskor
     * már el lehet kérni az ideiglenesen feltett panel méreteit.
     */
    void this_componentShown(ComponentEvent e) {
        newGame(null);
        pack();
    }

    void miSave_actionPerformed(ActionEvent e) {
        saveGameDialog.showDialog();
    }

    public GamePanel getGamePanel() {
        return gamePanel;
    }

    void miOpen_actionPerformed(ActionEvent e) {
        GameState gameState = openGameDialog.showDialog();
        if (gameState != null) {
            dataModule.setLayout(gameState.getLayout());
            dataModule.setGameNumber(gameState.getGameNumber());
            dataModule.setPlaces(gameState.getAllPlaces());
            dataModule.setValues(gameState.getAllValues());
            newGame(gameState);
        }
    }

    void miTilePalette_actionPerformed(ActionEvent e) {
        gamePanel.changeTilePaletteVisibility();
    }

    public JPanel getStatusBar() {
        return statusBar;
    }

    void miSea_actionPerformed(ActionEvent e) {
        newMarkings(SEA);
    }

    void miDesert_actionPerformed(ActionEvent e) {
        newMarkings(DESERT);
    }

    void miViolet_actionPerformed(ActionEvent e) {
        newMarkings(VIOLET_COLORED);
    }

    void miGray_actionPerformed(ActionEvent e) {
        newMarkings(GRAY);
    }

    void miBlue_actionPerformed(ActionEvent e) {
        newMarkings(BLUE);
    }

    void miPumpkin_actionPerformed(ActionEvent e) {
        newMarkings(PUMPKIN);
    }

    void miRose_actionPerformed(ActionEvent e) {
        newMarkings(ROSE);
    }

    void miMoss_actionPerformed(ActionEvent e) {
        newMarkings(MOSS);
    }

    void miMahogany_actionPerformed(ActionEvent e) {
        newMarkings(MAHOGANY);
    }

    void miBambooColorTheme_actionPerformed(ActionEvent e) {
        newMarkings(BAMBOO);
    }

    void miChrome_actionPerformed(ActionEvent e) {
        newMarkings(CHROME);
    }

    void miHorizon_actionPerformed(ActionEvent e) {
        newMarkings(HORIZON);
    }

    void miDaylight_actionPerformed(ActionEvent e) {
        newMarkings(DAYLIGHT);
    }

    void miPause_actionPerformed(ActionEvent e) {
        pauseResume();
    }

    public JMenuItem getMiPause() {
        return miPause;
    }

    void miHorizontal_actionPerformed(ActionEvent e) {
        newRule(RULE_HORIZONTAL);
    }

    void miVertical_actionPerformed(ActionEvent e) {
        newRule(RULE_VERTICAL);
    }

    void miSimple_actionPerformed(ActionEvent e) {
        newRule(RULE_SIMPE);
    }
/*
  void miBackground_13_actionPerformed(ActionEvent e) {
    newTextureBackground(BACKGROUND_13);
  }

  void miBackground_14_actionPerformed(ActionEvent e) {
    newTextureBackground(BACKGROUND_14);
  }

  void miBackground_15_actionPerformed(ActionEvent e) {
    newTextureBackground(BACKGROUND_15);
  }

  void miBackground_16_actionPerformed(ActionEvent e) {
    newTextureBackground(BACKGROUND_16);
  }

  void miBackground_17_actionPerformed(ActionEvent e) {
    newTextureBackground(BACKGROUND_17);
  }

  void miBackground_18_actionPerformed(ActionEvent e) {
    newTextureBackground(BACKGROUND_18);
  }

  void miBackground_19_actionPerformed(ActionEvent e) {
    newTextureBackground(BACKGROUND_19);
  }

  void miBackground_20_actionPerformed(ActionEvent e) {
    newTextureBackground(BACKGROUND_20);

  }
*/

    void miBg_actionPerformed(ActionEvent e) {
        BackgroundProperties newBackgroundProperties =
                backgroundDialog.showDialog(dataModule.getBackgroundProperties());

        dataModule.setBackgroundProperties(newBackgroundProperties);
        gamePanel.loadImage();
        gamePanel.repaint();
    }


//----------------------------------------------------------------------
//----------------------------------------------------------------------
//----------------------------------------------------------------------
//----------------------------------------------------------------------
//----------------------------------------------------------------------
//----------------------------------------------------------------------
//----------------------------------------------------------------------
//----------------------------------------------------------------------

}


class MainFrame_miExit_ActionAdapter implements ActionListener {
    MainFrame adaptee;

    MainFrame_miExit_ActionAdapter(MainFrame adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.miExit_actionPerformed(e);
    }
}

class MainFrame_btNew_actionAdapter implements ActionListener {
    MainFrame adaptee;

    MainFrame_btNew_actionAdapter(MainFrame adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.btNew_actionPerformed(e);
    }
}

class MainFrame_btRestart_actionAdapter implements ActionListener {
    MainFrame adaptee;

    MainFrame_btRestart_actionAdapter(MainFrame adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.btRestart_actionPerformed(e);
    }
}

class MainFrame_btShuffle_actionAdapter implements ActionListener {
    MainFrame adaptee;

    MainFrame_btShuffle_actionAdapter(MainFrame adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.btShuffle_actionPerformed(e);
    }
}

class MainFrame_miUse_actionAdapter implements ActionListener {
    MainFrame adaptee;

    MainFrame_miUse_actionAdapter(MainFrame adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.miUse_actionPerformed(e);
    }
}

class MainFrame_miBamboo_actionAdapter implements ActionListener {
    MainFrame adaptee;

    MainFrame_miBamboo_actionAdapter(MainFrame adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.miBamboo_actionPerformed(e);
    }
}

class MainFrame_miGlass_actionAdapter implements ActionListener {
    MainFrame adaptee;

    MainFrame_miGlass_actionAdapter(MainFrame adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.miGlass_actionPerformed(e);
    }
}

class MainFrame_miOrangeStone_actionAdapter implements ActionListener {
    MainFrame adaptee;

    MainFrame_miOrangeStone_actionAdapter(MainFrame adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.miOrangeStone_actionPerformed(e);
    }
}

class MainFrame_miPaper_actionAdapter implements ActionListener {
    MainFrame adaptee;

    MainFrame_miPaper_actionAdapter(MainFrame adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.miPaper_actionPerformed(e);
    }
}

class MainFrame_miWhite_actionAdapter implements ActionListener {
    MainFrame adaptee;

    MainFrame_miWhite_actionAdapter(MainFrame adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.miWhite_actionPerformed(e);
    }
}

class MainFrame_miWhiteStone_actionAdapter implements ActionListener {
    MainFrame adaptee;

    MainFrame_miWhiteStone_actionAdapter(MainFrame adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.miWhiteStone_actionPerformed(e);
    }
}

class MainFrame_miWood_1_actionAdapter implements ActionListener {
    MainFrame adaptee;

    MainFrame_miWood_1_actionAdapter(MainFrame adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.miWood_1_actionPerformed(e);
    }
}

class MainFrame_btSwap_actionAdapter implements ActionListener {
    MainFrame adaptee;

    MainFrame_btSwap_actionAdapter(MainFrame adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.btSwap_actionPerformed(e);
    }
}

class MainFrame_btXRay_actionAdapter implements ActionListener {
    MainFrame adaptee;

    MainFrame_btXRay_actionAdapter(MainFrame adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.btXRay_actionPerformed(e);
    }
}

class MainFrame_miClassic_actionAdapter implements ActionListener {
    MainFrame adaptee;

    MainFrame_miClassic_actionAdapter(MainFrame adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.miClassic_actionPerformed(e);
    }
}

class MainFrame_miCross_actionAdapter implements ActionListener {
    MainFrame adaptee;

    MainFrame_miCross_actionAdapter(MainFrame adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.miCross_actionPerformed(e);
    }
}

class MainFrame_miDiamond_actionAdapter implements ActionListener {
    MainFrame adaptee;

    MainFrame_miDiamond_actionAdapter(MainFrame adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.miDiamond_actionPerformed(e);
    }
}

class MainFrame_miFortress_actionAdapter implements ActionListener {
    MainFrame adaptee;

    MainFrame_miFortress_actionAdapter(MainFrame adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.miFortress_actionPerformed(e);
    }
}

class MainFrame_miPyramid_actionAdapter implements ActionListener {
    MainFrame adaptee;

    MainFrame_miPyramid_actionAdapter(MainFrame adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.miPyramid_actionPerformed(e);
    }
}

class MainFrame_miSmallDiamond_actionAdapter implements ActionListener {
    MainFrame adaptee;

    MainFrame_miSmallDiamond_actionAdapter(MainFrame adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.miSmallDiamond_actionPerformed(e);
    }
}

class MainFrame_miSpaceShuttle_actionAdapter implements ActionListener {
    MainFrame adaptee;

    MainFrame_miSpaceShuttle_actionAdapter(MainFrame adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.miSpaceShuttle_actionPerformed(e);
    }
}

class MainFrame_miTwin_actionAdapter implements ActionListener {
    MainFrame adaptee;

    MainFrame_miTwin_actionAdapter(MainFrame adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.miTwin_actionPerformed(e);
    }
}

class MainFrame_miToolBar_actionAdapter implements ActionListener {
    MainFrame adaptee;

    MainFrame_miToolBar_actionAdapter(MainFrame adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.miToolBar_actionPerformed(e);
    }
}

class MainFrame_miStatusBar_actionAdapter implements ActionListener {
    MainFrame adaptee;

    MainFrame_miStatusBar_actionAdapter(MainFrame adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.miStatusBar_actionPerformed(e);
    }
}
/*
class MainFrame_miBackground_1_actionAdapter implements java.awt.event.ActionListener {
  MainFrame adaptee;

  MainFrame_miBackground_1_actionAdapter(MainFrame adaptee) {
    this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
    adaptee.miBackground_1_actionPerformed(e);
  }
}

class MainFrame_miBackground_2_actionAdapter implements java.awt.event.ActionListener {
  MainFrame adaptee;

  MainFrame_miBackground_2_actionAdapter(MainFrame adaptee) {
    this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
    adaptee.miBackground_2_actionPerformed(e);
  }
}

class MainFrame_miBackground_3_actionAdapter implements java.awt.event.ActionListener {
  MainFrame adaptee;

  MainFrame_miBackground_3_actionAdapter(MainFrame adaptee) {
    this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
    adaptee.miBackground_3_actionPerformed(e);
  }
}

class MainFrame_miBackground_4_actionAdapter implements java.awt.event.ActionListener {
  MainFrame adaptee;

  MainFrame_miBackground_4_actionAdapter(MainFrame adaptee) {
    this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
    adaptee.miBackground_4_actionPerformed(e);
  }
}

class MainFrame_miBackground_5_actionAdapter implements java.awt.event.ActionListener {
  MainFrame adaptee;

  MainFrame_miBackground_5_actionAdapter(MainFrame adaptee) {
    this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
    adaptee.miBackground_5_actionPerformed(e);
  }
}

class MainFrame_miBackground_6_actionAdapter implements java.awt.event.ActionListener {
  MainFrame adaptee;

  MainFrame_miBackground_6_actionAdapter(MainFrame adaptee) {
    this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
    adaptee.miBackground_6_actionPerformed(e);
  }
}

class MainFrame_miBackground_7_actionAdapter implements java.awt.event.ActionListener {
  MainFrame adaptee;

  MainFrame_miBackground_7_actionAdapter(MainFrame adaptee) {
    this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
    adaptee.miBackground_7_actionPerformed(e);
  }
}

class MainFrame_miBackground_8_actionAdapter implements java.awt.event.ActionListener {
  MainFrame adaptee;

  MainFrame_miBackground_8_actionAdapter(MainFrame adaptee) {
    this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
    adaptee.miBackground_8_actionPerformed(e);
  }
}

class MainFrame_miBackground_9_actionAdapter implements java.awt.event.ActionListener {
  MainFrame adaptee;

  MainFrame_miBackground_9_actionAdapter(MainFrame adaptee) {
    this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
    adaptee.miBackground_9_actionPerformed(e);
  }
}
*/

class MainFrame_miRugby_actionAdapter implements ActionListener {
    MainFrame adaptee;

    MainFrame_miRugby_actionAdapter(MainFrame adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.miRugby_actionPerformed(e);
    }
}

class MainFrame_miStairs_actionAdapter implements ActionListener {
    MainFrame adaptee;

    MainFrame_miStairs_actionAdapter(MainFrame adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.miStairs_actionPerformed(e);
    }
}

class MainFrame_btAbout_actionAdapter implements ActionListener {
    MainFrame adaptee;

    MainFrame_btAbout_actionAdapter(MainFrame adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.btAbout_actionPerformed(e);
    }
}

class MainFrame_btResults_actionAdapter implements ActionListener {
    MainFrame adaptee;

    MainFrame_btResults_actionAdapter(MainFrame adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.btResults_actionPerformed(e);
    }
}

class MainFrame_miTemple_actionAdapter implements ActionListener {
    MainFrame adaptee;

    MainFrame_miTemple_actionAdapter(MainFrame adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.miTemple_actionPerformed(e);
    }
}

class MainFrame_miMotif_actionAdapter implements ActionListener {
    MainFrame adaptee;

    MainFrame_miMotif_actionAdapter(MainFrame adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.miMotif_actionPerformed(e);
    }
}

class MainFrame_miMetal_actionAdapter implements ActionListener {
    MainFrame adaptee;

    MainFrame_miMetal_actionAdapter(MainFrame adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.miMetal_actionPerformed(e);
    }
}

class MainFrame_miWindows_actionAdapter implements ActionListener {
    MainFrame adaptee;

    MainFrame_miWindows_actionAdapter(MainFrame adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.miWindows_actionPerformed(e);
    }
}

class MainFrame_btUndo_actionAdapter implements ActionListener {
    MainFrame adaptee;

    MainFrame_btUndo_actionAdapter(MainFrame adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.btUndo_actionPerformed(e);
    }
}

class MainFrame_btRedo_actionAdapter implements ActionListener {
    MainFrame adaptee;

    MainFrame_btRedo_actionAdapter(MainFrame adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.btRedo_actionPerformed(e);
    }
}

class MainFrame_miBrick_actionAdapter implements ActionListener {
    MainFrame adaptee;

    MainFrame_miBrick_actionAdapter(MainFrame adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.miBrick_actionPerformed(e);
    }
}

class MainFrame_miBrownStone_actionAdapter implements ActionListener {
    MainFrame adaptee;

    MainFrame_miBrownStone_actionAdapter(MainFrame adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.miBrownStone_actionPerformed(e);
    }
}

class MainFrame_miCardboard_actionAdapter implements ActionListener {
    MainFrame adaptee;

    MainFrame_miCardboard_actionAdapter(MainFrame adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.miCardboard_actionPerformed(e);
    }
}

class MainFrame_miDarkGreyStone_actionAdapter implements ActionListener {
    MainFrame adaptee;

    MainFrame_miDarkGreyStone_actionAdapter(MainFrame adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.miDarkGreyStone_actionPerformed(e);
    }
}

class MainFrame_miGrayStone_actionAdapter implements ActionListener {
    MainFrame adaptee;

    MainFrame_miGrayStone_actionAdapter(MainFrame adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.miGrayStone_actionPerformed(e);
    }
}

class MainFrame_miStone_actionAdapter implements ActionListener {
    MainFrame adaptee;

    MainFrame_miStone_actionAdapter(MainFrame adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.miStone_actionPerformed(e);
    }
}

class MainFrame_miPurpleStone_actionAdapter implements ActionListener {
    MainFrame adaptee;

    MainFrame_miPurpleStone_actionAdapter(MainFrame adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.miPurpleStone_actionPerformed(e);
    }
}

class MainFrame_miYellowMarble_actionAdapter implements ActionListener {
    MainFrame adaptee;

    MainFrame_miYellowMarble_actionAdapter(MainFrame adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.miYellowMarble_actionPerformed(e);
    }
}

class MainFrame_miBone_actionAdapter implements ActionListener {
    MainFrame adaptee;

    MainFrame_miBone_actionAdapter(MainFrame adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.miBone_actionPerformed(e);
    }
}

class MainFrame_miNorthEast_actionAdapter implements ActionListener {
    MainFrame adaptee;

    MainFrame_miNorthEast_actionAdapter(MainFrame adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.miNorthEast_actionPerformed(e);
    }
}

class MainFrame_miNorthWest_actionAdapter implements ActionListener {
    MainFrame adaptee;

    MainFrame_miNorthWest_actionAdapter(MainFrame adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.miNorthWest_actionPerformed(e);
    }
}

class MainFrame_miSouthEast_actionAdapter implements ActionListener {
    MainFrame adaptee;

    MainFrame_miSouthEast_actionAdapter(MainFrame adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.miSouthEast_actionPerformed(e);
    }
}

class MainFrame_miSouthWest_actionAdapter implements ActionListener {
    MainFrame adaptee;

    MainFrame_miSouthWest_actionAdapter(MainFrame adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.miSouthWest_actionPerformed(e);
    }
}

class MainFrame_miChessRook_actionAdapter implements ActionListener {
    MainFrame adaptee;

    MainFrame_miChessRook_actionAdapter(MainFrame adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.miChessRook_actionPerformed(e);
    }
}

class MainFrame_miZodiacScorpio_actionAdapter implements ActionListener {
    MainFrame adaptee;

    MainFrame_miZodiacScorpio_actionAdapter(MainFrame adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.miZodiacScorpio_actionPerformed(e);
    }
}

class MainFrame_miFivePyramids_actionAdapter implements ActionListener {
    MainFrame adaptee;

    MainFrame_miFivePyramids_actionAdapter(MainFrame adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.miFivePyramids_actionPerformed(e);
    }
}

class MainFrame_miQueen_actionAdapter implements ActionListener {
    MainFrame adaptee;

    MainFrame_miQueen_actionAdapter(MainFrame adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.miQueen_actionPerformed(e);
    }
}

class MainFrame_miBoat_actionAdapter implements ActionListener {
    MainFrame adaptee;

    MainFrame_miBoat_actionAdapter(MainFrame adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.miBoat_actionPerformed(e);
    }
}

class MainFrame_miTileFighter_actionAdapter implements ActionListener {
    MainFrame adaptee;

    MainFrame_miTileFighter_actionAdapter(MainFrame adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.miTileFighter_actionPerformed(e);
    }
}

class MainFrame_miNumberedGame_actionAdapter implements ActionListener {
    MainFrame adaptee;

    MainFrame_miNumberedGame_actionAdapter(MainFrame adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.miNumberedGame_actionPerformed(e);
    }
}

class MainFrame_miHelp_actionAdapter implements ActionListener {
    MainFrame adaptee;

    MainFrame_miHelp_actionAdapter(MainFrame adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.miHelp_actionPerformed(e);
    }
}


class MainFrame_miChessPawn_actionAdapter implements ActionListener {
    MainFrame adaptee;

    MainFrame_miChessPawn_actionAdapter(MainFrame adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.miChessPawn_actionPerformed(e);
    }
}

class MainFrame_miScalesOfJustice_actionAdapter implements ActionListener {
    MainFrame adaptee;

    MainFrame_miScalesOfJustice_actionAdapter(MainFrame adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.miScalesOfJustice_actionPerformed(e);
    }
}

class MainFrame_miZodiacLeo_actionAdapter implements ActionListener {
    MainFrame adaptee;

    MainFrame_miZodiacLeo_actionAdapter(MainFrame adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.miZodiacLeo_actionPerformed(e);
    }
}

class MainFrame_miZodiacCapricorn_actionAdapter implements ActionListener {
    MainFrame adaptee;

    MainFrame_miZodiacCapricorn_actionAdapter(MainFrame adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.miZodiacCapricorn_actionPerformed(e);
    }
}

class MainFrame_miWindowNortWest_actionAdapter implements ActionListener {
    MainFrame adaptee;

    MainFrame_miWindowNortWest_actionAdapter(MainFrame adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.miWindowNortWest_actionPerformed(e);
    }
}

class MainFrame_miWindowNorth_actionAdapter implements ActionListener {
    MainFrame adaptee;

    MainFrame_miWindowNorth_actionAdapter(MainFrame adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.miWindowNorth_actionPerformed(e);
    }
}

class MainFrame_miWindowNorthEast_actionAdapter implements ActionListener {
    MainFrame adaptee;

    MainFrame_miWindowNorthEast_actionAdapter(MainFrame adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.miWindowNorthEast_actionPerformed(e);
    }
}

class MainFrame_miWindowWest_actionAdapter implements ActionListener {
    MainFrame adaptee;

    MainFrame_miWindowWest_actionAdapter(MainFrame adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.miWindowWest_actionPerformed(e);
    }
}

class MainFrame_miWindowCenter_actionAdapter implements ActionListener {
    MainFrame adaptee;

    MainFrame_miWindowCenter_actionAdapter(MainFrame adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.miWindowCenter_actionPerformed(e);
    }
}

class MainFrame_miWindowSouthWest_actionAdapter implements ActionListener {
    MainFrame adaptee;

    MainFrame_miWindowSouthWest_actionAdapter(MainFrame adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.miWindowSouthWest_actionPerformed(e);
    }
}

class MainFrame_miWindowSouth_actionAdapter implements ActionListener {
    MainFrame adaptee;

    MainFrame_miWindowSouth_actionAdapter(MainFrame adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.miWindowSouth_actionPerformed(e);
    }
}

class MainFrame_miWindowSouthEast_actionAdapter implements ActionListener {
    MainFrame adaptee;

    MainFrame_miWindowSouthEast_actionAdapter(MainFrame adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.miWindowSouthEast_actionPerformed(e);
    }
}

class MainFrame_miWindowEast_actionAdapter implements ActionListener {
    MainFrame adaptee;

    MainFrame_miWindowEast_actionAdapter(MainFrame adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.miWindowEast_actionPerformed(e);
    }
}

class MainFrame_this_componentAdapter extends java.awt.event.ComponentAdapter {
    MainFrame adaptee;

    MainFrame_this_componentAdapter(MainFrame adaptee) {
        this.adaptee = adaptee;
    }

    public void componentShown(ComponentEvent e) {
        adaptee.this_componentShown(e);
    }
}

class MainFrame_miSave_actionAdapter implements ActionListener {
    MainFrame adaptee;

    MainFrame_miSave_actionAdapter(MainFrame adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.miSave_actionPerformed(e);
    }
}

class MainFrame_miDude_actionAdapter implements ActionListener {
    MainFrame adaptee;

    MainFrame_miDude_actionAdapter(MainFrame adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.miDude_actionPerformed(e);
    }
}

class MainFrame_miOpen_actionAdapter implements ActionListener {
    MainFrame adaptee;

    MainFrame_miOpen_actionAdapter(MainFrame adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.miOpen_actionPerformed(e);
    }
}
/*
class MainFrame_miBackground_10_actionAdapter implements java.awt.event.ActionListener {
  MainFrame adaptee;

  MainFrame_miBackground_10_actionAdapter(MainFrame adaptee) {
    this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
    adaptee.miBackground_10_actionPerformed(e);
  }
}

class MainFrame_miBackground_11_actionAdapter implements java.awt.event.ActionListener {
  MainFrame adaptee;

  MainFrame_miBackground_11_actionAdapter(MainFrame adaptee) {
    this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
    adaptee.miBackground_11_actionPerformed(e);
  }
}

class MainFrame_miBackground_12_actionAdapter implements java.awt.event.ActionListener {
  MainFrame adaptee;

  MainFrame_miBackground_12_actionAdapter(MainFrame adaptee) {
    this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
    adaptee.miBackground_12_actionPerformed(e);
  }
}
*/

class MainFrame_miTilePalette_actionAdapter implements ActionListener {
    MainFrame adaptee;

    MainFrame_miTilePalette_actionAdapter(MainFrame adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.miTilePalette_actionPerformed(e);
    }
}

class MainFrame_miWindBei_actionAdapter implements ActionListener {
    MainFrame adaptee;

    MainFrame_miWindBei_actionAdapter(MainFrame adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.miWindBei_actionPerformed(e);
    }
}

class MainFrame_miWindDong_actionAdapter implements ActionListener {
    MainFrame adaptee;

    MainFrame_miWindDong_actionAdapter(MainFrame adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.miWindDong_actionPerformed(e);
    }
}

class MainFrame_miWindNan_actionAdapter implements ActionListener {
    MainFrame adaptee;

    MainFrame_miWindNan_actionAdapter(MainFrame adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.miWindNan_actionPerformed(e);
    }
}

class MainFrame_miWindXi_actionAdapter implements ActionListener {
    MainFrame adaptee;

    MainFrame_miWindXi_actionAdapter(MainFrame adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.miWindXi_actionPerformed(e);
    }
}

class MainFrame_miChessBishop_actionAdapter implements ActionListener {
    MainFrame adaptee;

    MainFrame_miChessBishop_actionAdapter(MainFrame adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.miChessBishop_actionPerformed(e);
    }
}

class MainFrame_miBird_actionAdapter implements ActionListener {
    MainFrame adaptee;

    MainFrame_miBird_actionAdapter(MainFrame adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.miBird_actionPerformed(e);
    }
}

class MainFrame_miZodiacTaurus_actionAdapter implements ActionListener {
    MainFrame adaptee;

    MainFrame_miZodiacTaurus_actionAdapter(MainFrame adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.miZodiacTaurus_actionPerformed(e);
    }
}

class MainFrame_miZodiacSagittarius_actionAdapter implements ActionListener {
    MainFrame adaptee;

    MainFrame_miZodiacSagittarius_actionAdapter(MainFrame adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.miZodiacSagittarius_actionPerformed(e);
    }
}

class MainFrame_miSea_actionAdapter implements ActionListener {
    MainFrame adaptee;

    MainFrame_miSea_actionAdapter(MainFrame adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.miSea_actionPerformed(e);
    }
}

class MainFrame_miDesert_actionAdapter implements ActionListener {
    MainFrame adaptee;

    MainFrame_miDesert_actionAdapter(MainFrame adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.miDesert_actionPerformed(e);
    }
}

class MainFrame_miViolet_actionAdapter implements ActionListener {
    MainFrame adaptee;

    MainFrame_miViolet_actionAdapter(MainFrame adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.miViolet_actionPerformed(e);
    }
}

class MainFrame_miGray_actionAdapter implements ActionListener {
    MainFrame adaptee;

    MainFrame_miGray_actionAdapter(MainFrame adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.miGray_actionPerformed(e);
    }
}

class MainFrame_miBlue_actionAdapter implements ActionListener {
    MainFrame adaptee;

    MainFrame_miBlue_actionAdapter(MainFrame adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.miBlue_actionPerformed(e);
    }
}

class MainFrame_miZodiacLibra_actionAdapter implements ActionListener {
    MainFrame adaptee;

    MainFrame_miZodiacLibra_actionAdapter(MainFrame adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.miZodiacLibra_actionPerformed(e);
    }
}

class MainFrame_miChessKnight_actionAdapter implements ActionListener {
    MainFrame adaptee;

    MainFrame_miChessKnight_actionAdapter(MainFrame adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.miChessKnight_actionPerformed(e);
    }
}

class MainFrame_miZodiacAries_actionAdapter implements ActionListener {
    MainFrame adaptee;

    MainFrame_miZodiacAries_actionAdapter(MainFrame adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.miZodiacAries_actionPerformed(e);
    }
}

class MainFrame_miZodiacGemini_actionAdapter implements ActionListener {
    MainFrame adaptee;

    MainFrame_miZodiacGemini_actionAdapter(MainFrame adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.miZodiacGemini_actionPerformed(e);
    }
}

class MainFrame_miJudasPriest_actionAdapter implements ActionListener {
    MainFrame adaptee;

    MainFrame_miJudasPriest_actionAdapter(MainFrame adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.miJudasPriest_actionPerformed(e);
    }
}

class MainFrame_miABC_actionAdapter implements ActionListener {
    MainFrame adaptee;

    MainFrame_miABC_actionAdapter(MainFrame adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.miABC_actionPerformed(e);
    }
}

class MainFrame_miAnchor_actionAdapter implements ActionListener {
    MainFrame adaptee;

    MainFrame_miAnchor_actionAdapter(MainFrame adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.miAnchor_actionPerformed(e);
    }
}

class MainFrame_miCelticCross_actionAdapter implements ActionListener {
    MainFrame adaptee;

    MainFrame_miCelticCross_actionAdapter(MainFrame adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.miCelticCross_actionPerformed(e);
    }
}

class MainFrame_miNeptune_actionAdapter implements ActionListener {
    MainFrame adaptee;

    MainFrame_miNeptune_actionAdapter(MainFrame adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.miNeptune_actionPerformed(e);
    }
}

class MainFrame_miMounds_actionAdapter implements ActionListener {
    MainFrame adaptee;

    MainFrame_miMounds_actionAdapter(MainFrame adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.miMounds_actionPerformed(e);
    }
}

class MainFrame_miPause_actionAdapter implements ActionListener {
    MainFrame adaptee;

    MainFrame_miPause_actionAdapter(MainFrame adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.miPause_actionPerformed(e);
    }
}


class MainFrame_miPluto_actionAdapter implements ActionListener {
    MainFrame adaptee;

    MainFrame_miPluto_actionAdapter(MainFrame adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.miPluto_actionPerformed(e);
    }
}

class MainFrame_miUranus_actionAdapter implements ActionListener {
    MainFrame adaptee;

    MainFrame_miUranus_actionAdapter(MainFrame adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.miUranus_actionPerformed(e);
    }
}

class MainFrame_miInfinity_actionAdapter implements ActionListener {
    MainFrame adaptee;

    MainFrame_miInfinity_actionAdapter(MainFrame adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.miInfinity_actionPerformed(e);
    }
}

class MainFrame_miSpaceStation_actionAdapter implements ActionListener {
    MainFrame adaptee;

    MainFrame_miSpaceStation_actionAdapter(MainFrame adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.miSpaceStation_actionPerformed(e);
    }
}

class MainFrame_miPumpkin_actionAdapter implements ActionListener {
    MainFrame adaptee;

    MainFrame_miPumpkin_actionAdapter(MainFrame adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.miPumpkin_actionPerformed(e);
    }
}

class MainFrame_miRose_actionAdapter implements ActionListener {
    MainFrame adaptee;

    MainFrame_miRose_actionAdapter(MainFrame adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.miRose_actionPerformed(e);
    }
}

class MainFrame_miDuck_actionAdapter implements ActionListener {
    MainFrame adaptee;

    MainFrame_miDuck_actionAdapter(MainFrame adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.miDuck_actionPerformed(e);
    }
}

class MainFrame_miFish_actionAdapter implements ActionListener {
    MainFrame adaptee;

    MainFrame_miFish_actionAdapter(MainFrame adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.miFish_actionPerformed(e);
    }
}

class MainFrame_miZodiacAquarius_actionAdapter implements ActionListener {
    MainFrame adaptee;

    MainFrame_miZodiacAquarius_actionAdapter(MainFrame adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.miZodiacAquarius_actionPerformed(e);
    }
}

class MainFrame_miZodiacCancer_actionAdapter implements ActionListener {
    MainFrame adaptee;

    MainFrame_miZodiacCancer_actionAdapter(MainFrame adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.miZodiacCancer_actionPerformed(e);
    }
}

class MainFrame_miZodiacPisces_actionAdapter implements ActionListener {
    MainFrame adaptee;

    MainFrame_miZodiacPisces_actionAdapter(MainFrame adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.miZodiacPisces_actionPerformed(e);
    }
}

class MainFrame_miZodiacVirgo_actionAdapter implements ActionListener {
    MainFrame adaptee;

    MainFrame_miZodiacVirgo_actionAdapter(MainFrame adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.miZodiacVirgo_actionPerformed(e);
    }
}

class MainFrame_miChessKing_actionAdapter implements ActionListener {
    MainFrame adaptee;

    MainFrame_miChessKing_actionAdapter(MainFrame adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.miChessKing_actionPerformed(e);
    }
}

class MainFrame_miCrown_actionAdapter implements ActionListener {
    MainFrame adaptee;

    MainFrame_miCrown_actionAdapter(MainFrame adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.miCrown_actionPerformed(e);
    }
}

class MainFrame_miEagle_actionAdapter implements ActionListener {
    MainFrame adaptee;

    MainFrame_miEagle_actionAdapter(MainFrame adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.miEagle_actionPerformed(e);
    }
}

class MainFrame_miGayle_actionAdapter implements ActionListener {
    MainFrame adaptee;

    MainFrame_miGayle_actionAdapter(MainFrame adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.miGayle_actionPerformed(e);
    }
}

class MainFrame_miBambooLayout_actionAdapter implements ActionListener {
    MainFrame adaptee;

    MainFrame_miBambooLayout_actionAdapter(MainFrame adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.miBambooLayout_actionPerformed(e);
    }
}

class MainFrame_miCancer_actionAdapter implements ActionListener {
    MainFrame adaptee;

    MainFrame_miCancer_actionAdapter(MainFrame adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.miCancer_actionPerformed(e);
    }
}

class MainFrame_miCar_actionAdapter implements ActionListener {
    MainFrame adaptee;

    MainFrame_miCar_actionAdapter(MainFrame adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.miCar_actionPerformed(e);
    }
}

class MainFrame_miLabyrinth_actionAdapter implements ActionListener {
    MainFrame adaptee;

    MainFrame_miLabyrinth_actionAdapter(MainFrame adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.miLabyrinth_actionPerformed(e);
    }
}

class MainFrame_miSquare_actionAdapter implements ActionListener {
    MainFrame adaptee;

    MainFrame_miSquare_actionAdapter(MainFrame adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.miSquare_actionPerformed(e);
    }
}

class MainFrame_miRedDragon_actionAdapter implements ActionListener {
    MainFrame adaptee;

    MainFrame_miRedDragon_actionAdapter(MainFrame adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.miRedDragon_actionPerformed(e);
    }
}

class MainFrame_miStatue_actionAdapter implements ActionListener {
    MainFrame adaptee;

    MainFrame_miStatue_actionAdapter(MainFrame adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.miStatue_actionPerformed(e);
    }
}

class MainFrame_miGold_actionAdapter implements ActionListener {
    MainFrame adaptee;

    MainFrame_miGold_actionAdapter(MainFrame adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.miGold_actionPerformed(e);
    }
}

class MainFrame_miLeather_actionAdapter implements ActionListener {
    MainFrame adaptee;

    MainFrame_miLeather_actionAdapter(MainFrame adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.miLeather_actionPerformed(e);
    }
}

class MainFrame_miLeatherGold_actionAdapter implements ActionListener {
    MainFrame adaptee;

    MainFrame_miLeatherGold_actionAdapter(MainFrame adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.miLeatherGold_actionPerformed(e);
    }
}

class MainFrame_miLeatherSilver_actionAdapter implements ActionListener {
    MainFrame adaptee;

    MainFrame_miLeatherSilver_actionAdapter(MainFrame adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.miLeatherSilver_actionPerformed(e);
    }
}

class MainFrame_miRedMarble_actionAdapter implements ActionListener {
    MainFrame adaptee;

    MainFrame_miRedMarble_actionAdapter(MainFrame adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.miRedMarble_actionPerformed(e);
    }
}

class MainFrame_miSilver_actionAdapter implements ActionListener {
    MainFrame adaptee;

    MainFrame_miSilver_actionAdapter(MainFrame adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.miSilver_actionPerformed(e);
    }
}

class MainFrame_miWood_2_actionAdapter implements ActionListener {
    MainFrame adaptee;

    MainFrame_miWood_2_actionAdapter(MainFrame adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.miWood_2_actionPerformed(e);
    }
}

class MainFrame_miHorizontal_actionAdapter implements ActionListener {
    MainFrame adaptee;

    MainFrame_miHorizontal_actionAdapter(MainFrame adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.miHorizontal_actionPerformed(e);
    }
}

class MainFrame_miVertical_actionAdapter implements ActionListener {
    MainFrame adaptee;

    MainFrame_miVertical_actionAdapter(MainFrame adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.miVertical_actionPerformed(e);
    }
}

class MainFrame_miSimple_actionAdapter implements ActionListener {
    MainFrame adaptee;

    MainFrame_miSimple_actionAdapter(MainFrame adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.miSimple_actionPerformed(e);
    }
}

class MainFrame_miBridges_actionAdapter implements ActionListener {
    MainFrame adaptee;

    MainFrame_miBridges_actionAdapter(MainFrame adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.miBridges_actionPerformed(e);
    }
}

class MainFrame_miRhombus_actionAdapter implements ActionListener {
    MainFrame adaptee;

    MainFrame_miRhombus_actionAdapter(MainFrame adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.miRhombus_actionPerformed(e);
    }
}

class MainFrame_miSantaClaus_actionAdapter implements ActionListener {
    MainFrame adaptee;

    MainFrame_miSantaClaus_actionAdapter(MainFrame adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.miSantaClaus_actionPerformed(e);
    }
}

class MainFrame_miCaravel_actionAdapter implements ActionListener {
    MainFrame adaptee;

    MainFrame_miCaravel_actionAdapter(MainFrame adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.miCaravel_actionPerformed(e);
    }
}

class MainFrame_miStar_actionAdapter implements ActionListener {
    MainFrame adaptee;

    MainFrame_miStar_actionAdapter(MainFrame adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.miStar_actionPerformed(e);
    }
}

class MainFrame_miPumpkinLayout_actionAdapter implements ActionListener {
    MainFrame adaptee;

    MainFrame_miPumpkinLayout_actionAdapter(MainFrame adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.miPumpkinLayout_actionPerformed(e);
    }
}

class MainFrame_miWings_actionAdapter implements ActionListener {
    MainFrame adaptee;

    MainFrame_miWings_actionAdapter(MainFrame adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.miWings_actionPerformed(e);
    }
}
/*
class MainFrame_miBackground_13_actionAdapter implements java.awt.event.ActionListener {
  MainFrame adaptee;

  MainFrame_miBackground_13_actionAdapter(MainFrame adaptee) {
    this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
    adaptee.miBackground_13_actionPerformed(e);
  }
}

class MainFrame_miBackground_14_actionAdapter implements java.awt.event.ActionListener {
  MainFrame adaptee;

  MainFrame_miBackground_14_actionAdapter(MainFrame adaptee) {
    this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
    adaptee.miBackground_14_actionPerformed(e);
  }
}

class MainFrame_miBackground_15_actionAdapter implements java.awt.event.ActionListener {
  MainFrame adaptee;

  MainFrame_miBackground_15_actionAdapter(MainFrame adaptee) {
    this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
    adaptee.miBackground_15_actionPerformed(e);
  }
}

class MainFrame_miBackground_16_actionAdapter implements java.awt.event.ActionListener {
  MainFrame adaptee;

  MainFrame_miBackground_16_actionAdapter(MainFrame adaptee) {
    this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
    adaptee.miBackground_16_actionPerformed(e);
  }
}

class MainFrame_miBackground_17_actionAdapter implements java.awt.event.ActionListener {
  MainFrame adaptee;

  MainFrame_miBackground_17_actionAdapter(MainFrame adaptee) {
    this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
    adaptee.miBackground_17_actionPerformed(e);
  }
}

class MainFrame_miBackground_18_actionAdapter implements java.awt.event.ActionListener {
  MainFrame adaptee;

  MainFrame_miBackground_18_actionAdapter(MainFrame adaptee) {
    this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
    adaptee.miBackground_18_actionPerformed(e);
  }
}

class MainFrame_miBackground_19_actionAdapter implements java.awt.event.ActionListener {
  MainFrame adaptee;

  MainFrame_miBackground_19_actionAdapter(MainFrame adaptee) {
    this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
    adaptee.miBackground_19_actionPerformed(e);
  }
}

class MainFrame_miBackground_20_actionAdapter implements java.awt.event.ActionListener {
  MainFrame adaptee;

  MainFrame_miBackground_20_actionAdapter(MainFrame adaptee) {
    this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
    adaptee.miBackground_20_actionPerformed(e);
  }
}
*/

class MainFrame_miMoss_actionAdapter implements ActionListener {
    MainFrame adaptee;

    MainFrame_miMoss_actionAdapter(MainFrame adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.miMoss_actionPerformed(e);
    }
}

class MainFrame_miMahogany_actionAdapter implements ActionListener {
    MainFrame adaptee;

    MainFrame_miMahogany_actionAdapter(MainFrame adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.miMahogany_actionPerformed(e);
    }
}

class MainFrame_miBambooColorTheme_actionAdapter implements ActionListener {
    MainFrame adaptee;

    MainFrame_miBambooColorTheme_actionAdapter(MainFrame adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.miBambooColorTheme_actionPerformed(e);
    }
}

class MainFrame_miChrome_actionAdapter implements ActionListener {
    MainFrame adaptee;

    MainFrame_miChrome_actionAdapter(MainFrame adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.miChrome_actionPerformed(e);
    }
}

class MainFrame_miHorizon_actionAdapter implements ActionListener {
    MainFrame adaptee;

    MainFrame_miHorizon_actionAdapter(MainFrame adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.miHorizon_actionPerformed(e);
    }
}

class MainFrame_miDaylight_actionAdapter implements ActionListener {
    MainFrame adaptee;

    MainFrame_miDaylight_actionAdapter(MainFrame adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.miDaylight_actionPerformed(e);
    }
}

class MainFrame_miBg_actionAdapter implements ActionListener {
    MainFrame adaptee;

    MainFrame_miBg_actionAdapter(MainFrame adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.miBg_actionPerformed(e);
    }
}

class MainFrame_miWaves_actionAdapter implements ActionListener {
    MainFrame adaptee;

    MainFrame_miWaves_actionAdapter(MainFrame adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.miWaves_actionPerformed(e);
    }
}

