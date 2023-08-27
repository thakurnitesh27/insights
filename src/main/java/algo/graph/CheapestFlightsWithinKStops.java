package algo.graph;

import java.util.*;

public class CheapestFlightsWithinKStops {

    public static void main(String[] args) {

        int[][] arr = new int[][]{
                {0, 1, 100}, {1, 2, 100}, {2, 0, 100}, {1, 3, 600}, {2, 3, 200}
        };

        System.out.println(new CheapestFlightsWithinKStops().findCheapestPrice(4, arr, 0, 3, 1));
        System.out.println(new CheapestFlightsWithinKStops().findCheapestPrice(4, arr, 0, 3, 2));


        arr = new int[][]{
                {1, 2, 10}, {2, 0, 7}, {1, 3, 8}, {4, 0, 10}, {3, 4, 2}, {4, 2, 10}, {0, 3, 3}, {3, 1, 6}, {2, 4, 5}};

        System.out.println(new CheapestFlightsWithinKStops().findCheapestPrice(5, arr, 0, 4, 1));


        arr = new int[][]{
                {0, 1, 100}, {0, 2, 100}, {0, 3, 10}, {1, 2, 100}, {1, 4, 10}, {2, 1, 10}, {2, 3, 100}, {2, 4, 100}, {3, 2, 10}, {3, 4, 100}};


        System.out.println(new CheapestFlightsWithinKStops().findCheapestPrice(5, arr, 0, 4, 3));
        arr = new int[][]{

                {0, 1, 1}, {0, 2, 5}, {1, 2, 1}, {2, 3, 1}
        };


        System.out.println(new CheapestFlightsWithinKStops().findCheapestPrice(4, arr, 0, 3, 1));
    }

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {

        List<int[]>[] adjacencyList = getAdjacencyList(n, flights);
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{src, 0});

        int[][] visited = new int[n][k + 1];

        for (int i = 0; i < visited.length; i++)
            Arrays.fill(visited[i], Integer.MAX_VALUE);

        visited[src][0] = 0;

        int minCost = Integer.MAX_VALUE;

        while (!queue.isEmpty()) {

            int[] details = queue.poll();
            int stopIndex = details[0];
            int stopCount = details[1];

            if (stopCount > k) {
                continue;
            }
            int cost = visited[stopIndex][stopCount];
            stopCount++;

            for (int[] adjIndexes : adjacencyList[stopIndex]) {

                if (adjIndexes[0] == dst) {
                    minCost = Math.min(minCost, cost + adjIndexes[1]);
                } else if (stopCount <= k) {
                    if (cost + adjIndexes[1] < visited[adjIndexes[0]][stopCount]) {
                        visited[adjIndexes[0]][stopCount] = cost + adjIndexes[1];
                        queue.add(new int[]{adjIndexes[0], stopCount});
                    }
                }
            }

        }

        return minCost == Integer.MAX_VALUE ? -1 : minCost;

    }

    private List<int[]>[] getAdjacencyList(int n, int[][] flights) {

        List<int[]>[] adjacencyList = new List[n];

        for (int i = 0; i < adjacencyList.length; i++) {
            adjacencyList[i] = new ArrayList<>();
        }
        for (int i = 0; i < flights.length; i++) {
            int[] details = flights[i];
            adjacencyList[details[0]].add(new int[]{details[1], details[2]});
        }

        return adjacencyList;
    }
}
