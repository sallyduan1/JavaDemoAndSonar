package Controllers;

import Model.Player;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class  FakePlayers {
    private static Map<Integer , Player> players = new HashMap<Integer , Player>();
    private static Integer  idIndex = 0;

    //populate initial players
    static {
        Player a = new Player( 1, "Sally", "A very consistent player", 40, 3.5);
        players.put(1, a);
        Player b = new Player(2,  "Lisa", "Aggressive at the net", 45, 4.0);
        players.put(2, b);
        Player c = new Player(3, "Mario", "bunch of awesome", 52, 4.5);
        players.put(3, c);
        Player d = new Player(4, "Anna", "Well trained and young", 13, 4.0);
        players.put(4, d);
        Player e= new Player(5, "David", "eager and hungry", 16, 4.5);
        players.put(5, e);
    }

    public static List<Player> list() {
        return new ArrayList<Player>(players.values());
    }

    public static Player create(Player player) {
        idIndex += idIndex;
        player.setId(idIndex);
        players.put(idIndex, player);
        return player;
    }

    public static Player get(Integer id) {
        return players.get(id);
    }

    public static Player update(Integer  id, Player player) {
        players.put(id, player);
        return player;
    }

    public static Player delete(Integer id) {
        return players.remove(id);
    }
}
