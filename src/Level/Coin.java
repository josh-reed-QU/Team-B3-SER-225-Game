package Level;

import java.awt.image.*;

// Implements Coin ("coin.png" > Resources) entities (does so in the same way as the game implements Enemies and Power Ups)
// This file is a modified Enemy.java replication
// Interactions: Player.java, Camera.java, and Map.java
// Most of the changes to Camera were copy-and-paste from existing methods with minor modifications

// Note: When creating new instances of Coin ( & Supercoin, etc.), pass an Image Loader as the first argument

public class Coin extends MapEntity {

    private int value = 1; // Incrementation value for numCoins in Player [value of this coin type]

    public Coin(BufferedImage file, int x, int y)
    {
        super(file, (float) x, (float) y, (float) 0.4); // Casting integer arguments to floats here helped me create new instances more easily during testing

        // Also, I put in 0.4 as the scaling ratio because it seemed to look most appropriate compared to the size of the player's avatar
        // The scaling factor should probably be stored in a variable elsewhere instead of directly in the constructor,
            // But since it's the constructor (invoking explicitly in constructor is problematic),
            // I didn't want to spend the time figuring out how to implement that yet
            
	}

    @Override
    public void initialize() {
        super.initialize();
    }

    public void update(Player player) {
        super.update();
        if (intersects(player)) { touchedPlayer(player); }
    }

    // A subclass can override this method to specify what it does when it touches the player
    public void touchedPlayer(Player player) {
        player.addCoin(value); // Calls method in Player class to increment number of coins the player has collected by 1
        this.mapEntityStatus = MapEntityStatus.REMOVED; // Stop drawing graphic ("coin.png") on-screen
    }

}