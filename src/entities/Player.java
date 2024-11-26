package entities;

// TODO: this class extends Entity. It first shall call the constructor for the super class
// via the super keyword.  It has to in order to ensure that all of what is share with Entity exists before
// proeceeding.

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

public class Player extends Entity {

    // TODO: Note: The animations currently exist in GamePanel.  They are finding a new home here
    // in Player.  I'm mostly moving the TODO's from GamePanel to Player.  If you have code move the appropriate code.
    // TODO: Note: many of the methods for the animations from GamePanel will come here as well.
    // TODO: Note there will be some changes double check!

    // TODO: Note.  I'll do the one below.  We need a 2d array to handle the table of sprite poses in player_sprites.png
    // This is a bit of an early topic, but its like a list that contains lists.  The first list if the row, the ones inside are the
    // columns.  This will handle the animations.
    private BufferedImage[][] animations;
    // TODO: These new fields are just private
    // TODO: create an int named aniTick, aniIndex, and aniSpeed and initialize aniSpeed to 25;
    // TODO: create an int named playerAction and initialize to IDLE (this comes from the Constants file imported above)
    // TODO: create a boolean named moving and initialize to false.
    // TODO: create a boolean named attacking and initialize to false.
    // TODO: create boolean's named left, up, right, and down
    // TODO: create a float named playerSpeed and initialize to 2.0f;

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
        // TODO: Note: this is more or less the clock for the animations.  It handles the pose cycle
        // TODO: add 1 to aniTick with ++
        // TODO: if aniTick >= aniSpeed.
        // TODO: The rest of this method is all in the if block started at previous line.
        // TODO: set aniTick to 0
        // TODO: add 1 to aniIndex with ++
        // TODO: if aniIndex >= GetSpriteAmount(playerAction)
        // TODO: inside this if statement set aniIndex to 0
        // TODO: set attacking to false;
        // TODO: This is easy to mess up.  You'll have an if in and if at the end of the day.
    }

    private void setAnimation(){
        // TODO: create an int named startAni and initialize to playerAction;
        // TODO: if moving set playerAction to RUNNING
        // TODO: else set playerAction to IDLE

        // TODO: if attacking set playerAction to ATTACK_1;
        // TODO: if startAni is not equal to playerAction call resetAniTick()
    }

    private void resetAniTick(){
        // TODO: set aniTick to 0;
        // TODO: set aniIndex to 0;
    }

    private void updatePos(){
        // TODO: set moving to false
        // TODO: if (left and not right)
        // subtract playerSpeed from x
        // set moving to true
        // TODO: else if (right and not left)
        // add playerSpeed to x
        // set moving to true
        // TODO: if up and not down
        // subtract playerSpeed from y
        // set moving to true
        // TODO: if (down and not up)
        // add playerSeed to y
        // set moving to true
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
        //TODO: set left, right, up and down to false
    }

    public void setAttacking(boolean attacking){
        // TODO: set the attacking field to the attacking parameter.
    }

    public boolean isLeft(){
        // TODO: return the left fields value.
    }

    public void setLeft(boolean left){
        // TODO: set the left field to the left parameter
    }

    // TODO: repeat is and set for Up, Down, and Right just like we did in the last 2 methods.

}
