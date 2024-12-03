package entities;

// TODO: this class extends Entity. It first shall call the constructor for the super class
// via the super keyword.  It has to in order to ensure that all of what is share with Entity exists before
// proeceeding.

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

import static utilz.Constants.PlayerConstants.*;

public class Player extends Entity {

    // TODO: Note: The animations currently exist in GamePanel.  They are finding a new home here
    // in Player.  I'm mostly moving the TODO's from GamePanel to Player.  If you have code move the appropriate code.
    // TODO: Note: many of the methods for the animations from GamePanel will come here as well.
    // TODO: Note there will be some changes double check!

    // TODO: Note.  I'll do the one below.  We need a 2d array to handle the table of sprite poses in player_sprites.png
    // This is a bit of an early topic, but its like a list that contains lists.  The first list if the row, the ones inside are the
    // columns.  This will handle the animations.
    private BufferedImage[][] animations;
    private int aniTick, aniIndex, aniSpeed = 25;
    private int playerAction = IDLE;
    private boolean moving = false;
    private boolean attacking = false;
    private boolean left = false;
    private boolean right = false;
    private boolean up = false;
    private boolean down = false;
    private float playerSpeed = 2.0f;

    public Player(float x, float y) {
        super(x, y);
        loadAnimations();
    }

    public void update(){
        updateAnimationTick();
        setAnimation();
        updatePos();
    }

    public void render(Graphics g){
        // TODO: Note:  and here is where the magic occurs. Basically when you move or perform an action
        // The playerActions are the rows of the player_sprite.png image.
        // The aniIndex is the column.  So when paintComponent is called by the thread it accesses these two variables
        // and uses them to chose the subImage from animations
        // and draws it at the locations and size.
        g.drawImage(animations[playerAction][aniIndex], (int) xDelta, (int) yDelta, 256, 160, null);
    }

    private void updateAnimationTick() {
        aniTick++;
        if (aniTick >= aniSpeed){
            aniTick = 0;
            aniIndex++;
            if (aniIndex >= GetSpriteAmount(playerAction)) {
                aniIndex = 0;
                if (attacking){
                    attacking = false;
                }
            }
        }
    }

    private void setAnimation(){
        int startAni = playerAction;
        if (moving) {
            playerAction = RUNNING;
        } else {
            playerAction = IDLE;
        }

        if (attacking) {
            playerAction = ATTACK_1;
        }

        if (startAni != playerAction) {
            resetAniTick();
        }
    }

    private void resetAniTick(){
        aniTick = 0;
        aniIndex = 0;
    }

    private void updatePos(){
        moving = false;
        if (left && !right) {
            x -= playerSpeed;
            moving = true;
        } else if (right = !left) {
            x += playerSpeed;
            moving = true;
        }
        if (up && !down) {
            y -= playerSpeed;
            moving = true;
        }
        if (down && !up){
            y += playerSpeed;
            moving = true;
        }

    }

    private void loadAnimations() {
        InputStream is = getClass().getResourceAsStream("/player_sprites.png");
        try {
            BufferedImage img = ImageIO.read(is);

            animations = new BufferedImage[9][6];  // TODO: note  We have 9 rows, 6 columns see how this 2D array works.  :)
            // TODO: Note:  We are going to loop through this 2d array we need a loop in a loop the outer one goes row by row.
            // when we land on a row we have to go left to right through the columns.
            for (int row = 0; row < animations.length; row++) {  // TODO: note:  the number of rows is the length of the array the first set brackets
                for (int col = 0; col < animations[row].length; col++) { // TODO: note:  once we hit a row its length animations[row].length is the column size.
                    animations[row][col] = img.getSubimage(row * 64, col * 40, 64, 40); // TODO: note:  the sprite
                    // width is 40 and its height is 64. The row number * height will move up and down. The col number * width goes left to right.
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void resetDirBooleans(){
        left = false;
        right = false;
        up = false;
        down = false;
    }

    public void setAttacking(boolean attacking){
        this.attacking = attacking;
    }

    public boolean isLeft(){
        return left;
    }

    public void setLeft(boolean left){
        this.left = left;
    }

    public boolean isUp(){
        return up;
    }

    public void setUp(boolean up){
        this.up = up;
    }

    public boolean isDown(){
        return down;
    }

    public void setDown(boolean down){
        this.down = down;
    }

    public boolean isRight(){
        return right;
    }

    public void setRight(boolean right){
        this.right = right;
    }

}
