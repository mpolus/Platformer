package utilz;

public class Constants {
    // TODO: Nothing to do on this one, just something to read and learn from.
    // You can organize Constants into categories by using static inner classes.
    // That way to access a constant you can say Constants.Direction.LEFT, etc.
    public static class Directions {
        public static final int Left = 0;
        public static final int UP = 1;
        public static final int RIGHT = 2;
        public static final int DOWN = 3;


    }

    public static class PlayerConstants {
        public static final int IDLE = 0;
        public static final int RUNNING = 1;
        public static final int JUMP = 2;
        public static final int FALLING = 3;
        public static final int GROUND = 4;
        public static final int HIT = 5;
        public static final int ATTACK_1 = 6;
        public static final int ATTACK_JUMP_1 = 7;
        public static final int ATTACK_JUMP_2 = 8;


        public static int GetSpriteAmount(int player_action){
            // TODO: Note:  the cases without a return are meant to fall through to the first one with a return.
            // not a mistake.
            switch(player_action) {
                case RUNNING:
                    return 6;
                case IDLE:
                    return 5;
                case HIT:
                    return 4;
                case JUMP:
                case ATTACK_1:
                case ATTACK_JUMP_1:
                case ATTACK_JUMP_2:
                    return 3;
                case GROUND:
                    return 2;
                case FALLING:
                default:
                    return 1;
            }
        }
    }
}