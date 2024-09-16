package org.example.entity;

import org.example.gui.layout.ABCLayout;
import org.example.gui.layout.AnchorLayout;
import org.example.gui.layout.BambooLayout;
import org.example.gui.layout.BirdLayout;
import org.example.gui.layout.BoatLayout;
import org.example.gui.layout.BridgesLayout;
import org.example.gui.layout.CancerLayout;
import org.example.gui.layout.CarLayout;
import org.example.gui.layout.CaravelLayout;
import org.example.gui.layout.CelticCrossLayout;
import org.example.gui.layout.ChessBishopLayout;
import org.example.gui.layout.ChessKingLayout;
import org.example.gui.layout.ChessKnightLayout;
import org.example.gui.layout.ChessPawnLayout;
import org.example.gui.layout.ChessQueenLayout;
import org.example.gui.layout.ChessRookLayout;
import org.example.gui.layout.ClassicLayout;
import org.example.gui.layout.CrossLayout;
import org.example.gui.layout.CrownLayout;
import org.example.gui.layout.DiamondLayout;
import org.example.gui.layout.DuckLayout;
import org.example.gui.layout.DudeLayout;
import org.example.gui.layout.EagleLayout;
import org.example.gui.layout.FishLayout;
import org.example.gui.layout.FivePyramidsLayout;
import org.example.gui.layout.FortressLayout;
import org.example.gui.layout.GayleLayout;
import org.example.gui.layout.InfinityLayout;
import org.example.gui.layout.JudasPriestLayout;
import org.example.gui.layout.LabyrinthLayout;
import org.example.gui.layout.Layout;
import org.example.gui.layout.MoundsLayout;
import org.example.gui.layout.NeptuneLayout;
import org.example.gui.layout.PlutoLayout;
import org.example.gui.layout.PumpkinLayout;
import org.example.gui.layout.PyramidLayout;
import org.example.gui.layout.RedDragonLayout;
import org.example.gui.layout.RhombusLayout;
import org.example.gui.layout.RugbyLayout;
import org.example.gui.layout.SantaClausLayout;
import org.example.gui.layout.ScalesOfJusticeLayout;
import org.example.gui.layout.SpaceShuttleLayout;
import org.example.gui.layout.SpaceStationLayout;
import org.example.gui.layout.SquareLayout;
import org.example.gui.layout.StairsLayout;
import org.example.gui.layout.StarLayout;
import org.example.gui.layout.StatueLayout;
import org.example.gui.layout.TempleLayout;
import org.example.gui.layout.TileFighterLayout;
import org.example.gui.layout.TwinLayout;
import org.example.gui.layout.UranusLayout;
import org.example.gui.layout.WavesLayout;
import org.example.gui.layout.WindBeiLayout;
import org.example.gui.layout.WindDongLayout;
import org.example.gui.layout.WindNanLayout;
import org.example.gui.layout.WindXiLayout;
import org.example.gui.layout.WingsLayout;
import org.example.gui.layout.ZodiacAquariusLayout;
import org.example.gui.layout.ZodiacAriesLayout;
import org.example.gui.layout.ZodiacCancerLayout;
import org.example.gui.layout.ZodiacCapricornLayout;
import org.example.gui.layout.ZodiacGeminiLayout;
import org.example.gui.layout.ZodiacLeoLayout;
import org.example.gui.layout.ZodiacLibraLayout;
import org.example.gui.layout.ZodiacPiscesLayout;
import org.example.gui.layout.ZodiacSagittariusLayout;
import org.example.gui.layout.ZodiacScorpioLayout;
import org.example.gui.layout.ZodiacTaurusLayout;
import org.example.gui.layout.ZodiacVirgoLayout;

import java.awt.Color;

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
 * Konstansadatok
 */
public interface Constants {

    /**
     * Egység a méretezéshez
     */
    public static final int UNIT = 9;

    /**
     * Egy kő szélessége egységben megadva
     */
    public static final int TILE_WIDTH = 4;

    /**
     * Egy kő magassága egységben megadva
     */
    public static final int TILE_HEIGHT = 5;

    /**
     * Eltolás a térhatáshoz
     */
    public static final int TILE_TRANSLATE = 6;

    /**
     * A kőpaletta rétegszáma
     */
    public static final Integer TILE_PALETTE_LAYER = new Integer(10000);

    /**
     * Az animációk rétegszáma
     */
    public static final Integer ANIMATION_LAYER = new Integer(10001);

    /**
     * Az egy kupacon elhelyezhető kövek maximális száma
     */
    public static final int MAX_PACK_SIZE = 5;

    /**
     * Számozott játékok száma elrendezésenként
     */
    public static final int COUNT_OF_NUMBERED_GAMES = 10;

    /**
     * A színátmenetes kitöltéshez használt konstans, mely a kitöltendő
     * komponens szélességére utal
     */
    public static final float GRADIENT_WIDTH = -1;

    /**
     * A színátmenetes kitöltéshez használt konstans, mely a kitöltendő
     * komponens magasságára utal
     */
    public static final float GRADIENT_HEIGHT = -2;

    /**
     * Elrendezések
     */
    public static final Layout CLASSIC_LAYOUT = new ClassicLayout();
    public static final Layout CROSS_LAYOUT = new CrossLayout();
    public static final Layout DIAMOND_LAYOUT = new DiamondLayout();
    public static final Layout FORTRESS_LAYOUT = new FortressLayout();
    public static final Layout PYRAMID_LAYOUT = new PyramidLayout();
    public static final Layout RUGBY_LAYOUT = new RugbyLayout();
    public static final Layout SPACE_SHUTTLE_LAYOUT = new SpaceShuttleLayout();
    public static final Layout STAIRS_LAYOUT = new StairsLayout();
    public static final Layout TEMPLE_LAYOUT = new TempleLayout();
    public static final Layout TWIN_LAYOUT = new TwinLayout();
    public static final Layout CHESS_ROOK_LAYOUT = new ChessRookLayout();
    public static final Layout FIVE_PYRAMIDS_LAYOUT = new FivePyramidsLayout();
    public static final Layout ZODIAC_SCORPIO_LAYOUT = new ZodiacScorpioLayout();
    public static final Layout CHESS_QUEEN_LAYOUT = new ChessQueenLayout();
    public static final Layout BOAT_LAYOUT = new BoatLayout();
    public static final Layout TILE_FIGHTER_LAYOUT = new TileFighterLayout();
    public static final Layout CHESS_PAWN_LAYOUT = new ChessPawnLayout();
    public static final Layout SCALES_OF_JUSTICE_LAYOUT = new ScalesOfJusticeLayout();
    public static final Layout ZODIAC_CAPRICORN_LAYOUT = new ZodiacCapricornLayout();
    public static final Layout ZODIAC_LEO_LAYOUT = new ZodiacLeoLayout();
    public static final Layout DUDE_LAYOUT = new DudeLayout();
    public static final Layout WIND_BEI_LAYOUT = new WindBeiLayout();
    public static final Layout WIND_DONG_LAYOUT = new WindDongLayout();
    public static final Layout WIND_NAN_LAYOUT = new WindNanLayout();
    public static final Layout WIND_XI_LAYOUT = new WindXiLayout();
    public static final Layout BIRD_LAYOUT = new BirdLayout();
    public static final Layout CHESS_BISHOP_LAYOUT = new ChessBishopLayout();
    public static final Layout ZODIAC_SAGITTARIUS_LAYOUT = new ZodiacSagittariusLayout();
    public static final Layout ZODIAC_TAURUS_LAYOUT = new ZodiacTaurusLayout();
    public static final Layout ZODIAC_LIBRA_LAYOUT = new ZodiacLibraLayout();
    public static final Layout CHESS_KNIGHT_LAYOUT = new ChessKnightLayout();
    public static final Layout ZODIAC_ARIES_LAYOUT = new ZodiacAriesLayout();
    public static final Layout ZODIAC_GEMINI_LAYOUT = new ZodiacGeminiLayout();
    public static final Layout ABC_LAYOUT = new ABCLayout();
    public static final Layout ANCHOR_LAYOUT = new AnchorLayout();
    public static final Layout CELTIC_CROSS_LAYOUT = new CelticCrossLayout();
    public static final Layout JUDAS_PRIEST_LAYOUT = new JudasPriestLayout();
    public static final Layout NEPTUNE_LAYOUT = new NeptuneLayout();
    public static final Layout MOUNDS_LAYOUT = new MoundsLayout();
    public static final Layout PLUTO_LAYOUT = new PlutoLayout();
    public static final Layout URANUS_LAYOUT = new UranusLayout();
    public static final Layout INFINITY_LAYOUT = new InfinityLayout();
    public static final Layout SPACE_STATION_LAYOUT = new SpaceStationLayout();
    public static final Layout DUCK_LAYOUT = new DuckLayout();
    public static final Layout FISH_LAYOUT = new FishLayout();
    public static final Layout ZODIAC_AQUARIUS_LAYOUT = new ZodiacAquariusLayout();
    public static final Layout ZODIAC_CANCER_LAYOUT = new ZodiacCancerLayout();
    public static final Layout ZODIAC_PISCES_LAYOUT = new ZodiacPiscesLayout();
    public static final Layout ZODIAC_VIRGO_LAYOUT = new ZodiacVirgoLayout();
    public static final Layout CHESS_KING_LAYOUT = new ChessKingLayout();
    public static final Layout CROWN_LAYOUT = new CrownLayout();
    public static final Layout EAGLE_LAYOUT = new EagleLayout();
    public static final Layout GAYLE_LAYOUT = new GayleLayout();
    public static final Layout BAMBOO_LAYOUT = new BambooLayout();
    public static final Layout CANCER_LAYOUT = new CancerLayout();
    public static final Layout CAR_LAYOUT = new CarLayout();
    public static final Layout LABYRINTH_LAYOUT = new LabyrinthLayout();
    public static final Layout SQUARE_LAYOUT = new SquareLayout();
    public static final Layout RED_DRAGON_LAYOUT = new RedDragonLayout();
    public static final Layout STATUE_LAYOUT = new StatueLayout();
    public static final Layout BRIDGES_LAYOUT = new BridgesLayout();
    public static final Layout SANTA_CLAUS_LAYOUT = new SantaClausLayout();
    public static final Layout RHOMBUS_LAYOUT = new RhombusLayout();
    public static final Layout STAR_LAYOUT = new StarLayout();
    public static final Layout CARAVEL_LAYOUT = new CaravelLayout();
    public static final Layout WINGS_LAYOUT = new WingsLayout();
    public static final Layout PUMPKIN_LAYOUT = new PumpkinLayout();
    public static final Layout WAVES_LAYOUT = new WavesLayout();

    /**
     * Az elrendezéseke összefogó tömb
     */
    public static final Layout[] LAYOUTS = {
            ABC_LAYOUT,
            ANCHOR_LAYOUT,
            BAMBOO_LAYOUT,
            BIRD_LAYOUT,
            BOAT_LAYOUT,
            BRIDGES_LAYOUT,
            CANCER_LAYOUT,
            CAR_LAYOUT,
            CARAVEL_LAYOUT,
            CELTIC_CROSS_LAYOUT,
            CHESS_BISHOP_LAYOUT,
            CHESS_KING_LAYOUT,
            CHESS_KNIGHT_LAYOUT,
            CHESS_QUEEN_LAYOUT,
            CHESS_PAWN_LAYOUT,
            CHESS_ROOK_LAYOUT,
            CLASSIC_LAYOUT,
            CROSS_LAYOUT,
            CROWN_LAYOUT,
            DIAMOND_LAYOUT,
            DUCK_LAYOUT,
            DUDE_LAYOUT,
            EAGLE_LAYOUT,
            FISH_LAYOUT,
            FIVE_PYRAMIDS_LAYOUT,
            FORTRESS_LAYOUT,
            GAYLE_LAYOUT,
            INFINITY_LAYOUT,
            JUDAS_PRIEST_LAYOUT,
            LABYRINTH_LAYOUT,
            MOUNDS_LAYOUT,
            NEPTUNE_LAYOUT,
            PLUTO_LAYOUT,
            PUMPKIN_LAYOUT,
            PYRAMID_LAYOUT,
            RED_DRAGON_LAYOUT,
            RHOMBUS_LAYOUT,
            RUGBY_LAYOUT,
            SCALES_OF_JUSTICE_LAYOUT,
            SPACE_SHUTTLE_LAYOUT,
            SPACE_STATION_LAYOUT,
            SANTA_CLAUS_LAYOUT,
            SQUARE_LAYOUT,
            STAIRS_LAYOUT,
            STAR_LAYOUT,
            STATUE_LAYOUT,
            TEMPLE_LAYOUT,
            TILE_FIGHTER_LAYOUT,
            TWIN_LAYOUT,
            URANUS_LAYOUT,
            WAVES_LAYOUT,
            WIND_BEI_LAYOUT,
            WIND_DONG_LAYOUT,
            WIND_NAN_LAYOUT,
            WIND_XI_LAYOUT,
            WINGS_LAYOUT,
            ZODIAC_ARIES_LAYOUT,
            ZODIAC_AQUARIUS_LAYOUT,
            ZODIAC_CANCER_LAYOUT,
            ZODIAC_CAPRICORN_LAYOUT,
            ZODIAC_GEMINI_LAYOUT,
            ZODIAC_LEO_LAYOUT,
            ZODIAC_LIBRA_LAYOUT,
            ZODIAC_PISCES_LAYOUT,
            ZODIAC_SAGITTARIUS_LAYOUT,
            ZODIAC_SCORPIO_LAYOUT,
            ZODIAC_TAURUS_LAYOUT,
            ZODIAC_VIRGO_LAYOUT
    };

    /**
     * Elrendezés nevek
     */
    public static final String[] LAYOUT_NAMES = {
            ABC_LAYOUT.getName(),
            ANCHOR_LAYOUT.getName(),
            BAMBOO_LAYOUT.getName(),
            BIRD_LAYOUT.getName(),
            BOAT_LAYOUT.getName(),
            BRIDGES_LAYOUT.getName(),
            CANCER_LAYOUT.getName(),
            CAR_LAYOUT.getName(),
            CARAVEL_LAYOUT.getName(),
            CELTIC_CROSS_LAYOUT.getName(),
            CHESS_BISHOP_LAYOUT.getName(),
            CHESS_KING_LAYOUT.getName(),
            CHESS_KNIGHT_LAYOUT.getName(),
            CHESS_QUEEN_LAYOUT.getName(),
            CHESS_PAWN_LAYOUT.getName(),
            CHESS_ROOK_LAYOUT.getName(),
            CLASSIC_LAYOUT.getName(),
            CROSS_LAYOUT.getName(),
            CROWN_LAYOUT.getName(),
            DIAMOND_LAYOUT.getName(),
            DUCK_LAYOUT.getName(),
            DUDE_LAYOUT.getName(),
            EAGLE_LAYOUT.getName(),
            FISH_LAYOUT.getName(),
            FIVE_PYRAMIDS_LAYOUT.getName(),
            FORTRESS_LAYOUT.getName(),
            GAYLE_LAYOUT.getName(),
            INFINITY_LAYOUT.getName(),
            JUDAS_PRIEST_LAYOUT.getName(),
            LABYRINTH_LAYOUT.getName(),
            MOUNDS_LAYOUT.getName(),
            NEPTUNE_LAYOUT.getName(),
            PLUTO_LAYOUT.getName(),
            PUMPKIN_LAYOUT.getName(),
            PYRAMID_LAYOUT.getName(),
            RED_DRAGON_LAYOUT.getName(),
            RHOMBUS_LAYOUT.getName(),
            RUGBY_LAYOUT.getName(),
            SANTA_CLAUS_LAYOUT.getName(),
            SCALES_OF_JUSTICE_LAYOUT.getName(),
            SPACE_SHUTTLE_LAYOUT.getName(),
            SPACE_STATION_LAYOUT.getName(),
            SQUARE_LAYOUT.getName(),
            STAIRS_LAYOUT.getName(),
            STAR_LAYOUT.getName(),
            STATUE_LAYOUT.getName(),
            TEMPLE_LAYOUT.getName(),
            TILE_FIGHTER_LAYOUT.getName(),
            TWIN_LAYOUT.getName(),
            URANUS_LAYOUT.getName(),
            WAVES_LAYOUT.getName(),
            WIND_BEI_LAYOUT.getName(),
            WIND_DONG_LAYOUT.getName(),
            WIND_NAN_LAYOUT.getName(),
            WIND_XI_LAYOUT.getName(),
            WINGS_LAYOUT.getName(),
            ZODIAC_ARIES_LAYOUT.getName(),
            ZODIAC_AQUARIUS_LAYOUT.getName(),
            ZODIAC_CANCER_LAYOUT.getName(),
            ZODIAC_CAPRICORN_LAYOUT.getName(),
            ZODIAC_GEMINI_LAYOUT.getName(),
            ZODIAC_LEO_LAYOUT.getName(),
            ZODIAC_LIBRA_LAYOUT.getName(),
            ZODIAC_PISCES_LAYOUT.getName(),
            ZODIAC_SAGITTARIUS_LAYOUT.getName(),
            ZODIAC_SCORPIO_LAYOUT.getName(),
            ZODIAC_TAURUS_LAYOUT.getName(),
            ZODIAC_VIRGO_LAYOUT.getName()
    };

    /**
     * A források könyvtára
     */
    public static final String RESOURCE_PATH = "/";

    /**
     * A háttér fajtája
     */
    public static final int BACKGROUND_PICTURE = 0;
    public static final int BACKGROUND_TEXTURE = 1;
    public static final int BACKGROUND_GRADIENT = 2;

    /**
     * Hátterek
     */
    public static final Background BACKGROUND_01 =
            new Background("backgrounds/toboz.jpg",
                    "Toboz");

    public static final Background BACKGROUND_02 =
            new Background("backgrounds/grandcanyon.jpg",
                    "Grand Canyon");

    public static final Background BACKGROUND_03 =
            new Background("backgrounds/fenyo.jpg",
                    "Alkony");

    public static final Background BACKGROUND_04 =
            new Background("backgrounds/mountains.jpg",
                    "Hegyek");

    public static final Background BACKGROUND_05 =
            new Background("backgrounds/eg.jpg",
                    "Felhők");

    public static final Background BACKGROUND_06 =
            new Background("backgrounds/level.jpg",
                    "Levél");

    public static final Background BACKGROUND_08 =
            new Background("backgrounds/sunset.jpg",
                    "Naplemente");

    public static final Background BACKGROUND_09 =
            new Background("backgrounds/tube.jpg",
                    "Tölcsér");

    public static final Background BACKGROUND_10 =
            new Background("backgrounds/shell.jpg",
                    "Csillag");

    public static final Background BACKGROUND_11 =
            new Background("backgrounds/estuary.jpg",
                    "Vízvilág");

    public static final Background BACKGROUND_12 =
            new Background("backgrounds/autumn.jpg",
                    "Ősz");

    public static final Background BACKGROUND_24 =
            new Background("backgrounds/colorado.jpg",
                    "Colorado");

    public static final Background BACKGROUND_26 =
            new Background("backgrounds/road.jpg",
                    "Út");

    public static final Background BACKGROUND_28 =
            new Background("backgrounds/spirit.jpg",
                    "Szikla");


    public static final Background BACKGROUND_13 =
            new Background("backgrounds/blanket.jpg",
                    "Flanell");

    public static final Background BACKGROUND_14 =
            new Background("backgrounds/minta.jpg",
                    "Minta");

    public static final Background BACKGROUND_15 =
            new Background("backgrounds/brick.jpg",
                    "Tégla");

    public static final Background BACKGROUND_16 =
            new Background("backgrounds/canvas.jpg",
                    "Vászon");

    public static final Background BACKGROUND_17 =
            new Background("backgrounds/bluemosaic.jpg",
                    "Kék mozaik");

    public static final Background BACKGROUND_18 =
            new Background("backgrounds/brown.jpg",
                    "Tengerfenék");

    public static final Background BACKGROUND_19 =
            new Background("backgrounds/giraffe.jpg",
                    "Zsiráf");

    public static final Background BACKGROUND_20 =
            new Background("backgrounds/sponge.jpg",
                    "Szivacs");

    public static final Background BACKGROUND_21 =
            new Background("backgrounds/greymosaic.jpg",
                    "Szürke mozaik");

    public static final Background BACKGROUND_22 =
            new Background("backgrounds/rock.jpg",
                    "Terméskő");

    public static final Background BACKGROUND_23 =
            new Background("backgrounds/textile.jpg",
                    "Szövet");


    public static final Background BACKGROUND_25 =
            new Background("backgrounds/water.jpg",
                    "Víz");

    public static final Background BACKGROUND_27 =
            new Background("backgrounds/net.jpg",
                    "Háló");


    /**
     * A kép háttereket összefogó tömb
     */
    public static final Background[] PICTURES = {
            BACKGROUND_03, // Alkony
            BACKGROUND_24, // Colorado
            BACKGROUND_10, // Csillag
            BACKGROUND_05, // Felhők
            //BACKGROUND_02, // Grand Canyon
            BACKGROUND_04, // Hegyek
            BACKGROUND_06, // Levél
            BACKGROUND_08, // Naplemente
            BACKGROUND_12, // Ősz
            BACKGROUND_28, // Szikla
            BACKGROUND_01, // Toboz
            BACKGROUND_09, // Tölcsér
            BACKGROUND_26, // Út
            BACKGROUND_11 // Vízvilág
    };

    /**
     * A textúra háttereket összefogó tömb
     */
    public static final Background[] TEXTURES = {
            BACKGROUND_13, // Flanell
            BACKGROUND_27, // Háló
            BACKGROUND_17, // Kék mozaik
            BACKGROUND_14, // Minta
            BACKGROUND_20, // Szivacs
            BACKGROUND_23, // Szövet
            BACKGROUND_21, // Szürke mozaik
            BACKGROUND_18, // Tengerfenék
            BACKGROUND_22, // Terméskő
            BACKGROUND_15, // Tégla
            BACKGROUND_16, // Vászon
            BACKGROUND_25, // Víz
            BACKGROUND_19 // Zsiráf
    };


    /**
     * Animációk
     */
    public static final int NO_ANIMATION = -1;
    public static final int ANIMATION_NIGHT_SKY = 0;

    /**
     * A négjegy dialógusban használt kép
     */
    public static final String ABOUT_IMAGE = "images/about.png";

    /**
     * Stílusok
     */
    public static final Style STYLE_BAMBOO =
            new Style("Bambusz",
                    "images/bamboo_1.png",
                    "images/bamboo_2.png");

    public static final Style STYLE_GLASS =
            new Style("Üveg",
                    "images/glass_1.png",
                    "images/glass_2.png");

    public static final Style STYLE_ORANGE_STONE =
            new Style("Sárga kő",
                    "images/orange_stone_1.png",
                    "images/orange_stone_2.png");

    public static final Style STYLE_PAPER =
            new Style("Pergamen",
                    "images/paper_1.png",
                    "images/paper_2.png");

    public static final Style STYLE_WHITE_STONE =
            new Style("Homokkő",
                    "images/white_stone_1.png",
                    "images/white_stone_2.png");

    public static final Style STYLE_WHITE =
            new Style("Műanyag",
                    "images/white_1.png",
                    "images/white_2.png");

    public static final Style STYLE_WOOD_1 =
            new Style("Bükk",
                    "images/wood_1_1.png",
                    "images/wood_1_2.png");

    public static final Style STYLE_BONE =
            new Style("Csont",
                    "images/bone_1.png",
                    "images/bone_2.png");

    public static final Style STYLE_BRICK =
            new Style("Tégla",
                    "images/brick_1.png",
                    "images/brick_2.png");

    public static final Style STYLE_BROWN_STONE =
            new Style("Banra kő",
                    "images/brown_stone_1.png",
                    "images/brown_stone_2.png");

    public static final Style STYLE_CARDBOARD =
            new Style("Karton",
                    "images/cardboard_1.png",
                    "images/cardboard_2.png");

    public static final Style STYLE_DARK_GREY_STONE =
            new Style("Gránit",
                    "images/dark_grey_stone_1.png",
                    "images/dark_grey_stone_2.png");

    public static final Style STYLE_GREY_STONE =
            new Style("Szürke kő",
                    "images/grey_stone_1.png",
                    "images/grey_stone_2.png");

    public static final Style STYLE_YELLOW_MARBLE =
            new Style("Sárga márvány",
                    "images/yellow_marble_1.png",
                    "images/yellow_marble_2.png");

    public static final Style STYLE_PURPLE_STONE =
            new Style("Lila kő",
                    "images/purple_stone_1.png",
                    "images/purple_stone_2.png");

    public static final Style STYLE_STONE =
            new Style("Drapp kő",
                    "images/stone_1.png",
                    "images/stone_2.png");

    public static final Style STYLE_GOLD =
            new Style("Arany",
                    "images/gold_1.png",
                    "images/gold_2.png");

    public static final Style STYLE_LEATHER =
            new Style("Bőr",
                    "images/leather_1.png",
                    "images/leather_2.png");

    public static final Style STYLE_LEATHER_GOLD =
            new Style("Leather Gold",
                    "images/leather_gold_1.png",
                    "images/leather_gold_2.png");

    public static final Style STYLE_LEATHER_SILVER =
            new Style("Leather Silver",
                    "images/leather_silver_1.png",
                    "images/leather_silver_2.png");

    public static final Style STYLE_RED_MARBLE =
            new Style("Vörös márvány",
                    "images/red_marble_1.png",
                    "images/red_marble_2.png");

    public static final Style STYLE_SILVER =
            new Style("Ezüst",
                    "images/silver_1.png",
                    "images/silver_2.png");

    public static final Style STYLE_WOOD_2 =
            new Style("Fenyő",
                    "images/wood_2_1.png",
                    "images/wood_2_2.png");


    /**
     * A kinézet lehetséges értékei
     */
    public static final int WINDOWS_LOOK_AND_FEEL = 100;
    public static final int METAL_LOOK_AND_FEEL = 101;
    public static final int MOTIF_LOOK_AND_FEEL = 102;

    /**
     * A szabályok lehetséges értékei
     */
    public static final int RULE_HORIZONTAL = 0;
    public static final int RULE_VERTICAL = 1;
    public static final int RULE_SIMPE = 2;

    /**
     * Térhatások
     */
    public static final ThreeDimensionalEffect TDE_NORTH_EAST =
            new ThreeDimensionalEffect(ThreeDimensionalEffect.NORTH_EAST);
    public static final ThreeDimensionalEffect TDE_SOUTH_EAST =
            new ThreeDimensionalEffect(ThreeDimensionalEffect.SOUTH_EAST);
    public static final ThreeDimensionalEffect TDE_NORTH_WEST =
            new ThreeDimensionalEffect(ThreeDimensionalEffect.NORTH_WEST);
    public static final ThreeDimensionalEffect TDE_SOUTH_WEST =
            new ThreeDimensionalEffect(ThreeDimensionalEffect.SOUTH_WEST);

    /**
     * A program neve, verziószáma
     */
    public static final String PROGRAM = "Ant-Mahjongg v1.2";

    /**
     * Büntetés
     */
    public static final int MAX_PENALTY = 3600 * 100; // századmásodpercekben
    public static final int PENALTY_SHUFFLE = 30;
    public static final int PENALTY_SWAP = 20;
    public static final int PENALTY_UNDO = 10;
    public static final int PENALTY_REDO = 10;
    public static final int PENALTY_HELP = 30;
    public static final int PENALTY_RULE = 60;

    /** Színsémák */
    /**
     * Zöld
     */
    public static final ColorTheme SEA = new ColorTheme(
            "Tenger",
            new Color(44, 78, 71),
            new Color(136, 192, 184));

    /**
     * Lila
     */
    public static final ColorTheme VIOLET_COLORED = new ColorTheme(
            "Lila",
            new Color(102, 102, 153),
            new Color(204, 204, 255));

    /**
     * Világoskék
     */
    public static final ColorTheme BLUE = new ColorTheme(
            "Kék",
            new Color(0, 64, 128),
            new Color(166, 189, 223));
    //new Color(193, 214, 230));

    /**
     * Szürke
     */
    public static final ColorTheme GRAY = new ColorTheme(
            "Szürke",
            new Color(79, 101, 125),
            new Color(193, 204, 217));

    /**
     * Barna
     */
    public static final ColorTheme DESERT = new ColorTheme(
            "Sivatag",
            new Color(120, 96, 88),
            new Color(216, 208, 200));

    /**
     * Tök
     */
    public static final ColorTheme PUMPKIN = new ColorTheme(
            "Tök",
            new Color(215, 165, 47),
            new Color(245, 234, 207));

    /**
     * Rózsa
     */
    public static final ColorTheme ROSE = new ColorTheme(
            "Rózsa",
            new Color(159, 96, 112),
            new Color(231, 216, 220));

    /**
     * Windows-os szürke
     */
    public static final ColorTheme WINDOWS_GRAY = new ColorTheme(
            "Windows Gray",
            new Color(113, 111, 100),
            new Color(236, 233, 216));

    /**
     * Metal-os szürke
     */
    public static final ColorTheme METAL_GRAY = new ColorTheme(
            "Metal Gray",
            new Color(102, 102, 102),
            new Color(204, 204, 204));

    /**
     * Borland-os szürke
     */
    public static final ColorTheme BORLAND_GRAY = new ColorTheme(
            "Borland Gray",
            new Color(102, 102, 102),
            new Color(212, 208, 200));

    /**
     * Moha
     */
    public static final ColorTheme MOSS = new ColorTheme(
            "Moha",
            new Color(21, 107, 19),
            new Color(221, 235, 207));

    /**
     * Mahagóni
     */
    public static final ColorTheme MAHOGANY = new ColorTheme(
            "Mahagóni",
            new Color(102, 48, 18),
            new Color(214, 177, 156));

    /**
     * Bambusz
     */
    public static final ColorTheme BAMBOO = new ColorTheme(
            "Bambusz",
            new Color(130, 86, 0),
            new Color(255, 168, 0));

    /**
     * Króm
     */
    public static final ColorTheme CHROME = new ColorTheme(
            "Króm",
            new Color(127, 127, 127),
            new Color(255, 255, 255));

    /**
     * Horizont
     */
    public static final ColorTheme HORIZON = new ColorTheme(
            "Horizont",
            new Color(85, 38, 28),
            new Color(220, 235, 245));

    /**
     * Napfény
     */
    public static final ColorTheme DAYLIGHT = new ColorTheme(
            "Napfény",
            new Color(94, 158, 255),
            new Color(255, 235, 250));

    /**
     * Színsémákat összefogó tömb
     */
    public static final ColorTheme[] COLOR_THEMES = {
            BAMBOO, // bambusz
            HORIZON, // horizont
            BLUE, // kék
            CHROME, // króm
            VIOLET_COLORED, // lila
            MAHOGANY, // mahagóni
            MOSS, // moha
            DAYLIGHT, // napfény
            ROSE, // rózsa
            DESERT, // sivatag
            GRAY, // szürke
            SEA, // tenger
            PUMPKIN // tök
    };

    /**
     * Hangok útvonala
     */
    public static final String SOUND_BUBBLE = "sounds/bubble.au";
    public static final String SOUND_CHIRP = "sounds/chirp.au";
    public static final String SOUND_UNDO = "sounds/bubble.au";
    public static final String SOUND_REDO = "sounds/bubble.au";

    /**
     * A súgófájl elérési útja
     */
//    public static final String USE = "doc/mahjonggframe.html";
    public static final String USE = "src/main/resources/doc/mahjonggframe.html";


    /**
     * Kék foreground-os címke
     */
    public static final Color BLUE_LABEL = new Color(0, 64, 128);

    /**
     * Színátmenetek
     */
    public static final Gradient GRADIENT_01 =
            new Gradient(GRADIENT_WIDTH,
                    0f,
                    GRADIENT_WIDTH,
                    GRADIENT_HEIGHT);

    public static final Gradient GRADIENT_02 =
            new Gradient(0f,
                    GRADIENT_HEIGHT,
                    GRADIENT_WIDTH,
                    GRADIENT_HEIGHT);

    public static final Gradient GRADIENT_03 =
            new Gradient(GRADIENT_WIDTH,
                    GRADIENT_HEIGHT,
                    GRADIENT_WIDTH,
                    0f);

    public static final Gradient GRADIENT_04 =
            new Gradient(GRADIENT_WIDTH,
                    GRADIENT_HEIGHT,
                    0f,
                    GRADIENT_HEIGHT);

    public static final Gradient GRADIENT_05 =
            new Gradient(0f,
                    0f,
                    GRADIENT_WIDTH,
                    GRADIENT_HEIGHT);

    public static final Gradient GRADIENT_06 =
            new Gradient(GRADIENT_WIDTH,
                    GRADIENT_HEIGHT,
                    0f,
                    0f);

    public static final Gradient GRADIENT_07 =
            new Gradient(0f,
                    GRADIENT_HEIGHT,
                    GRADIENT_WIDTH,
                    0f);

    public static final Gradient GRADIENT_08 =
            new Gradient(GRADIENT_WIDTH,
                    0f,
                    0f,
                    GRADIENT_HEIGHT);
}














