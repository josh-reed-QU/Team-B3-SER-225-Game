package Collectables;

import java.awt.image.*;

import java.util.Timer;
import java.util.TimerTask;

import Level.Collectable;
import Level.MapEntityStatus;
import Level.Player;

import Utils.Point;

public class SpeedBoost extends Collectable {

    protected Timer tmr;

    public SpeedBoost(BufferedImage file, int x, int y)
    {
        super(file, x, y, 0.3f); // Since not subclass of Coin, needs to directly pass scaling factor float argument to parent
	}

    // Can use tile location instead of pixel location when creating
    public SpeedBoost(BufferedImage file, Point location)
    {
        super(file, (int) location.x, (int) location.y, 0.3f);
    }

    @Override
    public void initialize() {
        super.initialize();
    }

    public void update(Player player) {
        super.update();
        if (intersects(player)) { touchedPlayer(player); }
    }

    public void touchedPlayer(Player player) {
        player.setSpeed((float) (player.getSpeed() * 2.3));
        this.mapEntityStatus = MapEntityStatus.REMOVED;
        tmr = new Timer();
        tmr.schedule(new TimerTask() {
            @Override
            public void run() {
                player.setSpeed((float) (player.getSpeed() / 2.3));
            }
        }, 10000);
    }

}