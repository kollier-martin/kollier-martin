package Commands;

import Assets.Item;
import Assets.Player;

public class SearchCommand extends Command {
    private int counter;

    public SearchCommand() {
        super("Search");
    }

    /**
     * Searches the room for an obtainable item
     */
    @Override
    public boolean execute(Player player) {
        boolean end = false;

        if (player.getRoom().hasArti() && counter != 5) {
            System.out.println("You have found " + player.getRoom().artiName() + "" +
                    player.getRoom().artiDesc());
            System.out.println("");

            player.addToBag(new Item(player.getRoom().getArti().getName(), 1));

            player.getRoom().artiRem();

            counter++;
        } else if (counter <= 4) {
            System.out.println("There is no item here. Continue to lookaround.");
            System.out.println("");
        }

        if (counter == 5) {
            System.out.println("You have found the last artifact! Meet me at the Forbidden Path, north of the "
                    + "Magic Room. When you get there 'Search' for me.");
            System.out.println("");

            counter++;
        }

        if (counter == 6) {
            end = true;
        }

        return end;
    }
}
