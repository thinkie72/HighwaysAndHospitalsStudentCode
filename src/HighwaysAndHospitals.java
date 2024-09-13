import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Highways & Hospitals
 * A puzzle created by Zach Blick
 * for Adventures in Algorithms
 * at Menlo School in Atherton, CA
 * <p>
 * Completed by: Tyler Hinkie
 */

public class HighwaysAndHospitals {

    public static long cost(int n, int hospitalCost, int highwayCost, int cities[][]) {
        // Returns case from class where if hospitals cost <= highways then just build hospitals everywhere
        if (highwayCost >= hospitalCost)
            return (long) hospitalCost * n;

        // Array to hold whether or not a specific town has access to a hospital yet
        boolean[] hospitalAccess = new boolean[n + 1];

        // Array of ArrayLists to map out all the cities and what towns they connect to
        ArrayList<Integer>[] map = new ArrayList[n + 1];

        // Filler for-loop to initialize array
        for (int i = 0; i < n + 1; i++)
            map[i] = new ArrayList<>();

        // Variables for road entrances and exits
        int start;
        int end;

        for (int[] road : cities) {
            start = road[0];
            end = road[1];
            map[start].add(end);
            map[end].add(start);
        }

        // Counter variables for later multiplication to find cost
        int hospitals = 0;
        int highways = 0;

        int town;

        for (int i = 1; i < n + 1; i++) {
            // For any city that does not yet have hospital access, add a hospital
            if (!hospitalAccess[i]) {
                hospitals++;
                // Queue to continually make sure that the connecting roads to complete clusters have hospital access
                Queue<Integer> q = new LinkedList<>();
                q.add(i);
                while (!q.isEmpty()) {
                    town = q.remove();
                    if (!hospitalAccess[town])
                        hospitalAccess[town] = true;
                    for (int neighbor : map[town]) {
                        // Builds highways for all the neighboring cities and then
                        // adds each neighbor to the queue to look at their neighbors
                        if (!hospitalAccess[neighbor]) {
                            hospitalAccess[neighbor] = true;
                            highways++;
                            q.add(neighbor);
                        }
                    }
                }
            }
        }

        return (long) hospitals * hospitalCost + (long) highways * highwayCost;
    }
}
