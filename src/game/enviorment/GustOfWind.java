package game.enviorment;

import edu.monash.fit2099.engine.positions.Ground;
import edu.monash.fit2099.engine.positions.Location;
import game.enemy.*;
import game.utils.RandomNumberGenerator;

/**
 * A class that represents GustOfWind.
 * Created by:
 * @author Lim Jun Yi
 * Modified by: Lim Jun Yi
 * @see Ground
 */
public class GustOfWind extends Ground {

    private final int MIDPOINTX = 38; // the X midpoint of the map
    private final int MIDPOINTY = 12; // the Y midpoint of the map
    private EnemyFactory enemyFactory; // the factory to create the enemies

    /**
     * Constructor.
     *
     */
    public GustOfWind() {
        super('&');
    }

    /**
     * GustOfWind can also experience the joy of time.
     * @param location The location of the Ground
     */
    public void tick(Location location) {

        if (location.x() > this.MIDPOINTX && location.y() < this.MIDPOINTY) {
            if (RandomNumberGenerator.getRandomInt(1, 100) <= 27 && !location.containsAnActor()) {
                enemyFactory = new NorthEastEnemiesFactory();
                enemyFactory.createLandType(location);
            }
        }
        else if (location.x() < this.MIDPOINTX && location.y() < this.MIDPOINTY){
            if (RandomNumberGenerator.getRandomInt(1, 100) <= 27 && !location.containsAnActor()) {
                enemyFactory = new NorthWestEnemiesFactory();
                enemyFactory.createLandType(location);
            }
        }
        else if (location.x() < this.MIDPOINTX && location.y() > this.MIDPOINTY){
            if (RandomNumberGenerator.getRandomInt(1, 100) <= 27 && !location.containsAnActor()) {
                enemyFactory = new SouthWestEnemiesFactory();
                enemyFactory.createLandType(location);
            }
        }
        else {
            if (RandomNumberGenerator.getRandomInt(1, 100) <= 27 && !location.containsAnActor()) {
                enemyFactory = new SouthEastEnemiesFactory();
                enemyFactory.createLandType(location);
            }
        }
    }

}
