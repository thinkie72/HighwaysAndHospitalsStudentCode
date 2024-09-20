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

    public static long cost(int n, int hospitalCost, int highwayCost, int cities[][]) {
        if (highwayCost >= hospitalCost) return (long) hospitalCost * n;
        int[] roots = new int[n + 1];
        int a, b, x, temp;
        int clusters = n;
        for (int i = 0; i < cities.length; i++) {
            a = cities[i][0];
            b = cities[i][1];
            while (roots[a] > -1) a = roots[a];
            while (roots[b] > -1) b = roots[b];
            x = a;
            while (roots[x] > -1) x = roots[x];
            while (roots[a] > -1) {
                temp = roots[a];
                roots[a] = x;
                a = temp;
            }
            // Find roots, R and S
//            X = order(R)
//            Y = order(S)
//            if (X > Y)
//                root[S] = R
//            else
//                root[R] = S
        }



        return (long) hospitalCost * clusters + (long) highwayCost * (n - clusters);
    }
}
