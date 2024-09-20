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
        if (highwayCost >= hospitalCost) return (long) hospitalCost * n;
        int[] roots = new int[n + 1];
        int x, y, i, j, temp;
        for (int[] edge : cities) {
            x = edge[0];
            y = edge[1];
            i = x;
            while (roots[i] > 0) {
                i = roots[i];
            }

            j = y;
            while (roots[j] > 0) {
                j = roots[j];
            }

            // Path compression for x
            while (roots[x] > 0) {
                temp = x;
                x = roots[x];
                roots[temp] = i;
            }

            // Path compression for y
            while (roots[y] > 0) {
                temp = y;
                y = roots[y];
                roots[temp] = j;
            }

            if (roots[i] != roots[j] && i != j) {
                if (roots[j] < roots[i]) {
                    roots[j] += roots[i] - 1;
                    roots[i] = j;
                } else {
                    roots[i] += roots[j] - 1;
                    roots[j] = i;
                }
            }
        }

        int clusters = 0;

        for (int k = 0; k < roots.length; k++) {
            if (roots[k] == 0) clusters++;
        }

        return (long) clusters * hospitalCost + (long) (n-2) * highwayCost;
//        For each edge AB:
//        X = A
//        While city X is not its root:
//        X = roots[X]
//        While city A is not its root:
//        temp = roots[A]
//        roots[A] = X
//        A = temp
//
//        int x, a, b, temp;
//        for (int[] edge : cities) {
//            a = edge[0];
//            b = edge[1];
//            x = a;
//            while (x != roots[a]) x = roots[x];
//            while (a != roots[b]) {
//                temp = roots[a];
//                roots[a] = x;
//                a = temp;
//            }
//        }
////        // Find roots, R and S
////	        X = order(R)
////	        Y = order(S)
////	        if (X > Y)
////		        root[S] = R
////	        else
////		        root[R] = S
//        int r, s, one, two;
//        for (int[] edge : cities) {
//            a = edge[0];
//            b = edge[1];
//            x = a;
//            r = roo;
//        }

//        // Array to hold whether or not a specific town has access to a hospital yet
//        boolean[] hospitalAccess = new boolean[n + 1];
//
//        // Array of ArrayLists to map out all the cities and what towns they connect to
//        ArrayList<Integer>[] map = new ArrayList[n + 1];
//
//        // Filler for-loop to initialize array
//        for (int i = 0; i < n + 1; i++)
//            map[i] = new ArrayList<>();
//
//        // Variables for road entrances and exits
//        int start;
//        int end;
//
//        for (int[] road : cities) {
//            start = road[0];
//            end = road[1];
//            map[start].add(end);
//            map[end].add(start);
//        }
//
//        // Counter variables for later multiplication to find cost
//        int hospitals = 0;
//        int highways = 0;
//
//        int town;
//
//        for (int i = 1; i < n + 1; i++) {
//            // For any city that does not yet have hospital access, add a hospital
//            if (!hospitalAccess[i]) {
//                hospitals++;
//                // Queue to continually make sure that the connecting roads to complete clusters have hospital access
//                Queue<Integer> q = new LinkedList<>();
//                q.add(i);
//                while (!q.isEmpty()) {
//                    town = q.remove();
//                    if (!hospitalAccess[town])
//                        hospitalAccess[town] = true;
//                    for (int neighbor : map[town]) {
//                        // Builds highways for all the neighboring cities and then
//                        // adds each neighbor to the queue to look at their neighbors
//                        if (!hospitalAccess[neighbor]) {
//                            hospitalAccess[neighbor] = true;
//                            highways++;
//                            q.add(neighbor);
//                        }
//                    }
//                }
//            }
//        }

//        return (long) hospitals * hospitalCost + (long) highways * highwayCost;
    }
}
