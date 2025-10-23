import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.Iterator;

// класс для управления подземельем
// подземелье это список комнат которые мы проходим
public class Dungeon {
    private List<Room> rooms;

    private Map<String, Integer> playerRankings; // имя игрока -> количество побед

    // текущая комната которую мы проходим
    private int currentRoomIndex;
    
    public Dungeon() {

        this.rooms = new ArrayList<>();
        this.playerRankings = new HashMap<>();
        this.currentRoomIndex = 0;
    }
    
    public void addRoom(Room room) {
    
        rooms.add(room);
    }
    
    public Room getCurrentRoom() {
    
        if (currentRoomIndex >= 0 && currentRoomIndex < rooms.size()) {
            return rooms.get(currentRoomIndex);
        }
    
        return null;
    }
    
    public boolean moveToNextRoom() {
    
        if (currentRoomIndex < rooms.size() - 1) {
    
            currentRoomIndex++;
            return true;
        }
    
        return false;
    }
    


    public boolean hasMoreRooms() {
        return currentRoomIndex < rooms.size() - 1;
    }
    
    public void updatePlayerRanking(String playerName, int victories) {
        playerRankings.put(playerName, victories);
    }
    
    public Map<String, Integer> getPlayerRankings() {
        return playerRankings;
    }
    
    public Iterator<Room> getRoomIterator() {

        return rooms.iterator();
    }
    
    public int getCurrentRoomIndex() {

        return currentRoomIndex;
    }
    
    public int getTotalRooms() {

        return rooms.size();
    }
}
