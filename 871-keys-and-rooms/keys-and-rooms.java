import java.util.*;

class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int n = rooms.size();
        Set<Integer> visited = new HashSet<>();
        Queue<Integer> keys = new LinkedList<>();
        
        visited.add(0); // Start with room 0
        keys.addAll(rooms.get(0)); // Add keys from room 0
        
        while (!keys.isEmpty()) {
            int room = keys.poll();
            if (!visited.contains(room)) {
                visited.add(room);
                keys.addAll(rooms.get(room)); // Add keys from the current room
            }
        }
        
        return visited.size() == n; // Return true if all rooms are visited
    }
}
