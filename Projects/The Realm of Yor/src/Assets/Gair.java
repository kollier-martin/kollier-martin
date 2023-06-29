package Assets;

import Main.Game;

public class Gair extends Monster {
    public Gair() {
        /** Final Boss of the dungeon */
        super("Gair", 150, 15, 23);

        System.out.println("*ROAR* So you have returned " + Game.player.getName()
                + ". I have long awaited your awakening from your slumber. I see you have those artifacts that I got rid of long"
                + " ago.\nDo you think these can stop me?! HAHAHA. No not even a dent shall be placed in me.\nThis time I'll "
                + "finish the job. COME AND FACE ME!\n");
    }
}
