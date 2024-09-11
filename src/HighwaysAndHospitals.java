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
            return (int) (hospitalCost * n);
        }

        int m = cities.length;

        for (int i = 0; i < m; i++) {
            // Traverse through array to map out roads
            // Make a hospital for each cluster
            // Make roads for each cluster to connect to the hospital
        }
        return 0;
    }
}
