package Graph;
import java.util.*;

public class CourseScheduleII {
    public static void main(String[] args) {
        int[][] courses = new int[][] {
                {1, 0}, {2, 0}, {3, 1}, {3, 2}
        };

        System.out.println(Arrays.toString(findOrder(4, courses)));
    }

    public static int[] findOrder(int numCourses, int[][] prerequisites) {
        Queue<Integer> queue = new LinkedList<>();

        Map<Integer, Integer> inMap = constructInMap(prerequisites);
        Map<Integer, List<Integer>> outMap = constructOutMap(prerequisites);

        for (int i = 0; i < numCourses; i++) {
            if (inMap.getOrDefault(i, 0) == 0) {
                queue.add(i);
            }
        }

        List<Integer> result = new ArrayList<>();

        while(!queue.isEmpty()) {
            int courseNum = queue.poll();
            result.add(courseNum);

            for (int nextCourseNum : outMap.getOrDefault(courseNum, new ArrayList<>())) {
                inMap.put(nextCourseNum, inMap.get(nextCourseNum) - 1);

                if (inMap.get(nextCourseNum) == 0) {
                    queue.add(nextCourseNum);
                }
            }
        }

        if (result.size() == numCourses) {
            int[] array = new int[result.size()];

            for(int i = 0; i < result.size(); i++) {
                array[i] = result.get(i);
            }

            return array;
        }

        return new int[0];

    }

    private static Map<Integer, Integer> constructInMap(int[][] prerequisites) {
        Map<Integer, Integer> inMap = new HashMap<>();

        for (int[] prerequisite : prerequisites) {
            inMap.put(prerequisite[0], inMap.getOrDefault(prerequisite[0], 0) + 1);
        }

        return inMap;
    }

    private static Map<Integer, List<Integer>> constructOutMap(int[][] prerequisites) {
        Map<Integer, List<Integer>> outMap = new HashMap<>();

        for (int[] prerequisite : prerequisites) {
            outMap.putIfAbsent(prerequisite[1], new ArrayList<>());
            outMap.get(prerequisite[1]).add(prerequisite[0]);
        }

        return outMap;
    }
}
