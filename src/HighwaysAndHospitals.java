import java.util.ArrayList;
import java.util.Arrays;
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

    // Finds minimum cost to give hospital access to n cities given an array of roads between cities
    public static long cost(int n, int hospitalCost, int highwayCost, int cities[][]) {
        // Returns if case where the hospitals cost less, where the min cost is just build hospitals everywhere
        if (highwayCost >= hospitalCost) return (long) hospitalCost * n;
        // Map to hold roots and weight of tree if a root
        int[] roots = new int[n + 1];
        // Sets array elements equal to -1 for weight balancing (seemed more code efficient than Arrays.fill())
        for (int i = 1; i <= n; i++) {
            roots[i] = -1;
        }
        // Variables for all the roots and nodes on either side of the edge
        int start, end, startRoot, endRoot;
        // Counter to determine the number of clusters in a count-itself fashion
        int clusters = n;
        for (int[] possibleHighway : cities) {
            // Initializes start and end of edge
            start = possibleHighway[0];
            end = possibleHighway[1];

            // Uses helper function to find the root of the start and end of the edge
            startRoot = findRoot(start, roots);
            endRoot = findRoot(end, roots);

            // If they have the same root, then they don't need to be readded and combined
            if (startRoot != endRoot) {
                // One less node is its own root
                clusters--;

                // Adds smaller cluster onto the larger one, depending on which one is larger
                if (roots[startRoot] < roots[endRoot]) {
                    roots[endRoot] += roots[startRoot];
                    roots[startRoot] = endRoot;
                } else {
                    roots[startRoot] += roots[endRoot];
                    roots[endRoot] = startRoot;
                }
            }
        }

        // Calculates minimum cost to give hospital access to all cities
        return (long) hospitalCost * clusters + (long) highwayCost * (n - clusters);
    }

    // Finds the roots for a given node and uses path compression to flatten tree
    private static int findRoot(int x, int[] roots) {
        // Returns x if it's its own root
        if (roots[x] < 0) return x;
        // Path compression via recursive step
        roots[x] = findRoot(roots[x], roots);
        return roots[x];
    }
}
