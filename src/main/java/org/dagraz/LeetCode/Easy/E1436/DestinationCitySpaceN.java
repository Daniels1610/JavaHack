package org.dagraz.LeetCode.Easy.E1436;

import java.util.*;

/*
Status: AC
Runtime: 3ms | Beats 37.21%
Memory Usage: 44.45MB | Beats 5.08%
Time Complexity: O(n)
Space Complexity: O(n)
*/

public class DestinationCitySpaceN {

    public String findDestinationCity(List<List<String>> paths) {
        Set<String> ins = new HashSet<>(), outs = new HashSet<>();
        String destinationCity = "";

        for (List<String> path : paths) {
            ins.add(path.getLast());
            outs.add(path.getFirst());
        }

        for (String x : ins) {
            if (!outs.contains(x)) {
                destinationCity = x;
            }
        }
        return destinationCity;

    }

    public static void main(String[] args) {
        DestinationCitySpaceN s = new DestinationCitySpaceN();
        List<List<String>> paths = new ArrayList<>();
        int m = 3, n = 2;
        List<String> p1 = new ArrayList<>(); p1.add("London"); p1.add("New York");
        List<String> p2 = new ArrayList<>(); p2.add("New York"); p2.add("Lima");
        List<String> p3 = new ArrayList<>(); p3.add("Lima"); p3.add("Sao Paulo");

        paths.add(p1); paths.add(p2); paths.add(p3);

        System.out.println(s.findDestinationCity(paths));
    }

}
