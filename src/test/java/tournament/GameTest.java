package tournament;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class GameTest {

    private Game round = new Game();

    Player player1 = new Player(1, "Player1", 5);
    Player player2 = new Player(2, "Player2", 4);
    Player player3 = new Player(3, "Player3", 6);
    Player player4 = new Player(4, "Player4", 5);

    @Test
    public void addPlayer() { // Регистрация игрока

        round.register(player1);


        int[] expected = {1, 5};
        int[] actual = {player1.getId(), player1.getStrength()};

        Assertions.assertArrayEquals(expected, actual);

        String[] expected1 = {"Player1"};
        String[] actual1 = {player1.getName()};

        Assertions.assertArrayEquals(expected1, actual1);
    }

    @Test
    public void roundPlayer1Win() {

        round.register(player1);
        round.register(player2);

        int expected = 1;
        int actual = round.round(player1.name, player2.name);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void roundPlayer2Win() {
        round.register(player1);
        round.register(player3);

        int expected = 2;
        int actual = round.round(player1.name, player3.name);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void roundPlayersEqual() {
        round.register(player1);
        round.register(player4);

        int expected = 0;
        int actual = round.round(player1.name, player4.name);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void playerNotRegistry() {
        round.register(player1);
        round.register(player3);

        Assertions.assertThrows(NotRegisteredException.class, () -> {
            round.round(player2.name, player3.name);
        });
    }

    @Test
    public void playerNotRegistry2() {
        round.register(player1);
        round.register(player3);

        Assertions.assertThrows(NotRegisteredException.class, () -> {
            round.round(player1.name, player4.name);
        });
    }

    @Test
    public void creatPlayer() {
        Player player5 = new Player(0, "", 0);

        player5.setId(5);
        player5.setName("Player5");
        player5.setStrength(6);

        int[] expected = {5, 6};
        int[] actual = {player5.getId(), player5.getStrength()};

        Assertions.assertArrayEquals(expected, actual);

        String expected1 = "Player5";
        String actual1 = player5.getName();

        Assertions.assertEquals(expected1, actual1);
    }
}
