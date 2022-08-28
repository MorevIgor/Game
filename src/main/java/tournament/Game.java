package tournament;

import java.util.ArrayList;

public class Game {

    private ArrayList<Player> players = new ArrayList<>();
    //private Player[] result = new Player[0];

    public void register(Player player) {
        players.add(player);
    }

    public int round(String playerName1, String playerName2) {

        if (findById(playerName1) == null) {
            throw new NotRegisteredException("Player with name: " + playerName1 + " not registry");
        }
        if (findById(playerName2) == null) {
            throw new NotRegisteredException("Player with name: " + playerName2 + " not registry");
        }
        Player player1 = null;
        Player player2 = null;
        for (Player player : players) {
            if (player.getName().equals(playerName1)) {
                player1 = player;
            }
            if (player.getName().equals(playerName2)) {
                player2 = player;
            }
        }

        if (player1.getStrength() == player2.getStrength()) {
            return 0;
        } else if (player1.getStrength() > player2.getStrength()) {
            return 1;
        } else {
            return 2;
        }
    }

    public Player findById(String name) {
        Player result = null;
        for (Player player : players) {
            if (player.getName() == name) {
                result = player;
            }
        }
        return result;
    }
}
