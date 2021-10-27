package Maps;

import Enemies.BugEnemy;
import Enemies.DinosaurEnemy;
import Engine.ImageLoader;
import EnhancedMapTiles.EndLevelBox;
import EnhancedMapTiles.HorizontalMovingPlatform;
import GameObject.Rectangle;
import Level.*;
import NPCs.Walrus;
import Tilesets.CommonTileset;
import Utils.Direction;
import Utils.Point;

import java.util.ArrayList;




/*
All imports for adding Coin to this level
// Needs to be fixed obviously, this is just a quick solution
*/

import java.awt.image.BufferedImage;

import javax.imageio.*;
import java.io.*;

/*
*/

public class LevelOne extends Map {

    public LevelOne() {
        super("test_map.txt", new CommonTileset(), new Point(1, 11));
    }

    @Override
    public ArrayList<Enemy> loadEnemies() {
        ArrayList<Enemy> enemies = new ArrayList<>();
        enemies.add(new BugEnemy(getPositionByTileIndex(15, 13), Direction.LEFT));
        enemies.add(new DinosaurEnemy(getPositionByTileIndex(19, 5).addY(2), getPositionByTileIndex(22, 5).addY(2), Direction.RIGHT));
        return enemies;
    }

    // Add coin to level one to test
    public ArrayList<Coin> loadCoins() {
        ArrayList<Coin> coins = new ArrayList<>();
    
        try
        {
            BufferedImage image = new BufferedImage(ImageIO.read(new File("coin.png")).getWidth(null), ImageIO.read(new File("coin.png")).getHeight(null), BufferedImage.TYPE_INT_ARGB);
            coins.add(new Coin(image, 10, 10));
        }
        catch (IOException e) { System.exit(0); }


        return coins;
    }

    @Override
    public ArrayList<EnhancedMapTile> loadEnhancedMapTiles() {
        ArrayList<EnhancedMapTile> enhancedMapTiles = new ArrayList<>();

        enhancedMapTiles.add(new HorizontalMovingPlatform(
                ImageLoader.load("GreenPlatform.png"),
                getPositionByTileIndex(24, 8),
                getPositionByTileIndex(27, 8),
                TileType.JUMP_THROUGH_PLATFORM,
                3,
                new Rectangle(0, 6,16,8),
                Direction.RIGHT
        ));

        enhancedMapTiles.add(new EndLevelBox(
                getPositionByTileIndex(32, 11)
        ));

        return enhancedMapTiles;
    }

    @Override
    public ArrayList<NPC> loadNPCs() {
        ArrayList<NPC> npcs = new ArrayList<>();

        npcs.add(new Walrus(getPositionByTileIndex(30, 14).subtract(new Point(0, 13)), this));

        return npcs;
    }
}