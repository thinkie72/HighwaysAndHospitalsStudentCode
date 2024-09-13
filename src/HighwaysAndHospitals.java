import java.util.ArrayList;

/**
 * Highways & Hospitals
 * A puzzle created by Zach Blick
 * for Adventures in Algorithms
 * at Menlo School in Atherton, CA
 *
 * Completed by: Tyler Hinkie
 *
 */

public class HighwaysAndHospitals {

    public static long cost(int n, int hospitalCost, int highwayCost, int cities[][]) {
        if (highwayCost >= hospitalCost) {
            return (long) hospitalCost * n;
        }

        boolean[] hospitalAccess = new boolean[n + 1];
        int m = cities.length;
        int two = cities[0].length;

        ArrayList<Integer>[] map = new ArrayList[n];

        for (int i = 0; i < n; i++) {
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
        int roads = 0;

        for (int i = 0; i < map.length; i++) {
            if (!map[i].isEmpty() && !hospitalAccess[i]) {
                hospitalAccess[i] = true;
                hospitals++;
                for (int j = 0; j < map[i].size(); j++) {
                    hospitalAccess[map[i].get(j)] = true;
                    roads++;
                }
            }
        }

        return
            // Traverse through array to map out roads
            // Make a hospital for each cluster
            // Make roads for each cluster to connect to the hospital
        return 0;
    }
}
