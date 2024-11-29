package org.dagraz.LeetCode.Easy.E1436;

import java.util.*;

/*
Status: AC
Runtime: 2ms | Beats 100.00%
Memory Usage: 43.68MB | Beats 20.76%
Time Complexity: O(n)
Space Complexity: O(n)
*/

public class DestinationCity {

    public String findDestinationCity(List<List<String>> paths) {
        Map<String, String> cities = new HashMap<>();
        Stack<String> cstack = new Stack<>();
        String originCity = paths.getFirst().getFirst();

        for (List<String> path : paths) {
            cities.put(path.getFirst(), path.getLast());
        }

        cstack.push(originCity);
        while (!cstack.empty()) {
            String curr_city = cstack.pop();
            if (!cities.containsKey(curr_city)) {
                return curr_city;
            }
            String next_city = cities.get(curr_city);
            cstack.push(next_city);
        }
        return originCity;
    }

    public static void main(String[] args) {
        DestinationCity s = new DestinationCity();
        List<List<String>> paths = new ArrayList<>();
        int m = 3, n = 2;
        List<String> p1 = new ArrayList<>(); p1.add("London"); p1.add("New York");
        List<String> p2 = new ArrayList<>(); p2.add("New York"); p2.add("Lima");
        List<String> p3 = new ArrayList<>(); p3.add("Lima"); p3.add("Sao Paulo");

        paths.add(p1); paths.add(p2); paths.add(p3);

        System.out.println(s.findDestinationCity(paths));
    }

}
