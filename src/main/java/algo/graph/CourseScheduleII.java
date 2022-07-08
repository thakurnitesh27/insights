package algo.graph;

import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/problems/course-schedule-ii/
public class CourseScheduleII {
    public static void main(String[] args) {
        print(new CourseScheduleII().findOrder(4, new int[][]{{1, 0}, {2, 0}, {3, 1}, {3, 2}}));
        // int[][] course = new int[][]{{1, 0}, {2, 0}, {3, 1}, {3, 2}};
        print((new CourseScheduleII().findOrder(3, new int[][]{{0, 1}, {0, 2}, {1, 2}})));
        print((new CourseScheduleII().findOrder(2, new int[][]{{0, 1}, {1, 0}})));

    }

    private static void print(int[] arr) {
        if (arr == null || arr.length == 0) {
            System.out.println("No response");
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
        }
        System.out.println();
    }

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<Integer>[] adjacencyList = new List[numCourses];
        for (int[] dependency : prerequisites) {
            if (adjacencyList[dependency[0]] == null) {
                List<Integer> list = new ArrayList<>();
                list.add(dependency[1]);
                adjacencyList[dependency[0]] = list;
            } else {
                adjacencyList[dependency[0]].add(dependency[1]);
            }
        }
        // for (int i = 0; i < numCourses; i++) {
        List<Integer> ans = new ArrayList<>();
        if (getCourseOrder(adjacencyList, numCourses, 0, ans)) {
            return getArray(ans);
        }
        // }
        return new int[0];

    }

    private int[] getArray(List<Integer> list) {
        int[] ans = new int[list.size()];

        for (int i = 0; i < list.size(); i++) {
            ans[i] = list.get(i);
        }
        return ans;
    }

    boolean getCourseOrder(List<Integer>[] adjacencyList, int numCourse, int currentCourse, List<Integer> ans) {

        int[] color = new int[numCourse];
        boolean areEdgesOrdered = dfs(adjacencyList, color, currentCourse, ans);


        for (int i = 0; i < numCourse; i++) {
            if (i == currentCourse) {
                continue;
            }
            if (color[i] == 0) {
                areEdgesOrdered = areEdgesOrdered && dfs(adjacencyList, color, i, ans);
            } else if (adjacencyList[i] != null) {
                return false;
            }
            if (!areEdgesOrdered) {
                return false;
            }

        }
        return areEdgesOrdered;

    }

    boolean dfs(List<Integer>[] adjacencyList, int[] color, int index, List<Integer> ans) {


        List<Integer> dependency = adjacencyList[index];
        color[index] = 1;
        if (dependency != null && dependency.size() > 0) {
            for (int i : dependency) {
                if (color[i] == 0) {
                    if (!dfs(adjacencyList, color, i, ans)) {
                        return false;
                    } else if (color[i] == 1)
                        return false;
                } else if (color[i] == 1) {
                    return false;
                }
            }
        }
        adjacencyList[index] = null;
        color[index] = 2;
        ans.add(index);
        return true;
    }
}
