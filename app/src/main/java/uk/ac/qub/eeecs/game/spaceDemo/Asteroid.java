package uk.ac.qub.eeecs.game.spaceDemo;

import java.util.Random;

import uk.ac.qub.eeecs.gage.world.GameScreen;
import uk.ac.qub.eeecs.gage.world.Sprite;

/**
 * Simple asteroid
 *
 * Note: See the course documentation for extension/refactoring stories
 * for this class.
 *
 * @version 1.0
 */
public class Asteroid extends SpaceEntity {

    // /////////////////////////////////////////////////////////////////////////
    // Properties
    // /////////////////////////////////////////////////////////////////////////

    /**
     * Default size for the asteroid
     */
    private static final float DEFAULT_RADIUS = 20;

    private static final float MIN_SIZE = 20.0f;
    private static final float MAX_SIZE =200.0f;


    // /////////////////////////////////////////////////////////////////////////
    // Constructors
    // /////////////////////////////////////////////////////////////////////////

    /**
     * Create an asteroid
     *
     * @param startX     x location of the asteroid
     * @param startY     y location of the asteroid
     * @param gameScreen Gamescreen to which asteroid belongs
     */
    public Asteroid(float startX, float startY, GameScreen gameScreen) {
        super(startX, startY, DEFAULT_RADIUS*2.0f, DEFAULT_RADIUS*2.0f, null, gameScreen);

        Random random = new Random();
        float size = ((random.nextFloat()*(MAX_SIZE-MIN_SIZE))+MIN_SIZE);

        this.setWidth(size);
        this.setHeight(size);

        String spriteImg;

        if(size<100)
        {
             spriteImg = "Asteroid" + (random.nextInt(2) + 1);
        }
        else
        {
             spriteImg = "Asteroid" + (random.nextInt(2) + 3);
        }


            mBitmap = gameScreen.getGame().getAssetManager()
                    .getBitmap(spriteImg);


        mRadius = size/2;
        mMass = 1000.0f;

        angularVelocity = random.nextFloat() * 240.0f - 20.0f;

    }
}
