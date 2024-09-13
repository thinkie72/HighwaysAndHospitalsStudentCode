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
        if (highwayCost >= hospitalCost) {
            return (long) hospitalCost * n;
        }

        boolean[] hospitalAccess = new boolean[n + 1];

        ArrayList<Integer>[] map = new ArrayList[n + 1];

        for (int i = 0; i < n + 1; i++) {
            map[i] = new ArrayList<>();
        }

        int start;
        int end;

        for (int[] road : cities) {
            start = road[0];
            end = road[1];
            map[start].add(end);
            map[end].add(start);
        }

        int hospitals = 0;
        int highways = 0;
        int town;

        for (int i = 1; i < n + 1; i++) {
            if (!hospitalAccess[i]) {
                hospitals++;
                Queue<Integer> q = new LinkedList<>();
                q.add(i);
                while (!q.isEmpty()) {
                    town = q.remove();
                    if (!hospitalAccess[town]) {
                        hospitalAccess[town] = true;
                    }
                    for (int neighbor : map[town]) {
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
