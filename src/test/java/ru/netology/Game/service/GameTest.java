package ru.netology.Game.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class GameTest {
    Game game = new Game();
    Player player1 = new Player(1, "Player1", 10);
    Player player2 = new Player(2, "Player2", 100);
    Player player3 = new Player(3, "Player3", 1000);
    Player player4 = new Player(4, "Player4", 1000);

    @Test
    public void roundIfSecondPlayerStronger() {
        game.register(player1);
        game.register(player2);
        int actual = game.round(player1.getName(), player2.getName());
        int expected = 2;
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void roundIfFirstPlayerStronger() {
        game.register(player3);
        game.register(player2);
        int actual = game.round(player3.getName(), player2.getName());
        int expected = 1;
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void ifForcesEqual() {
        game.register(player3);
        game.register(player4);
        int actual = game.round(player3.getName(), player4.getName());
        int expected = 0;
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void setter() {
        player3.setName("Player31");
        player3.setId(33);
        player3.setStrength(1111);
        Assertions.assertEquals(player3.getName(), "Player31");
        Assertions.assertEquals(player3.getStrength(), 1111);
        Assertions.assertEquals(player3.getId(), 33);
    }

    @Test
    public void ifFirstPlayer1NotRegistered() {
        game.register(player4);
        Assertions.assertThrows(NotRegisteredException.class, () -> {
            game.round(player3.getName(), player4.getName());
        });
    }

    @Test
    public void ifSecondPlayer1NotRegistered() {
        game.register(player3);
        Assertions.assertThrows(NotRegisteredException.class, () -> {
            game.round(player3.getName(), player4.getName());
        });

    }
}


